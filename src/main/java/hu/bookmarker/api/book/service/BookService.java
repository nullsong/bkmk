package hu.bookmarker.api.book.service;

import org.springframework.stereotype.Service;

import hu.bookmarker.api.book.mapper.IBookMapper;
import hu.bookmarker.api.book.model.BookDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {

    private final IBookMapper iBookMapper;

    /**
     * 도서 정보 조회
     */
    public BookDTO getBookInfo(BookDTO reqDto) {
        return iBookMapper.selectBookInfo(reqDto);
    }
}