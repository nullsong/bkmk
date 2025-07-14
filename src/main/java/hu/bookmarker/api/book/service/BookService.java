package hu.bookmarker.api.book.service;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import hu.bookmarker.api.book.mapper.IBookMapper;
import hu.bookmarker.api.book.model.BookDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final IBookMapper iBookMapper;
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${naver.clientId}")
    private String ID;

    @Value("${naver.clientPw}")
    private String PW;

    @Value("${naver.apiUrl}")
    private String SEARCH_API_URL;

    /**
     * 도서 정보 조회
     */
    public BookDTO getBookInfo(BookDTO reqDto) {
        return iBookMapper.selectBookInfo(reqDto);
    }

    /**
     * 도서 정보 조회
     */
    public BookDTO createBookInfo(BookDTO reqDto) {
        //1. db에서 책 존재 여부 확인
        BookDTO bookDto = iBookMapper.selectBookInfo(reqDto);

        // 2. 없을 경우에 insert
        if (bookDto == null) {
            iBookMapper.insertBookInfo(reqDto);
            return reqDto;
        }
        return bookDto;
    }

    /**
     * 도서 정보 조회 (네이버 api)
     */
    public List<BookDTO> getBooks(BookDTO reqDto){
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", ID);
        headers.set("X-Naver-Client-Secret", PW);
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        String keyword = reqDto.getKeyword();
        String encoded = UriUtils.encode(keyword, StandardCharsets.UTF_8);
        String url = SEARCH_API_URL + "?query=" + encoded;

        URI requestUri = URI.create(url);

        ResponseEntity<String> response = restTemplate.exchange(requestUri, HttpMethod.GET, new HttpEntity<String>(headers), String.class);

        List<BookDTO> result = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode items = mapper.readTree(response.getBody()).get("items");

            for (JsonNode node : items) {
                BookDTO dto = new BookDTO();

                String data = node.get("pubdate").asText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                LocalDate localDate = LocalDate.parse(data, formatter);

                dto.setTitle(node.get("title").asText());
                dto.setAuthor(node.get("author").asText());
                dto.setPublisher(node.get("publisher").asText());
                dto.setPublishedDate(localDate);
                dto.setIsbn(node.get("isbn").asText());
                dto.setImage(node.get("image").asText());
                dto.setDescription(node.get("description").asText());
                result.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}