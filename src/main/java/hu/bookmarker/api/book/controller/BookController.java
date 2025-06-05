package hu.bookmarker.api.book.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import hu.bookmarker.api.book.model.BookDTO;
import hu.bookmarker.api.book.service.BookService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping (value = "/book", produces = "application/json")
public class BookController {

    private final BookService bookService;

    @GetMapping("/")
    public List<BookDTO> getBooks(@RequestParam(required = true, name = "keyword") final String keyword) {
        log.info("*** getBooks : {} ***", keyword);
        BookDTO reqDto = BookDTO.builder().keyword(keyword).build();
        return bookService.getBooks(reqDto);
    }

    @GetMapping("/info")
    public BookDTO getBookInfo(@RequestParam(required = true, name = "bookSrno") final Integer bookSrno
                             , @RequestParam(required = true, name = "isbn") final String isbn) {
        log.info("*** getBookInfo : {} ***", bookSrno);
        BookDTO reqDto = BookDTO.builder().bookSrno(bookSrno).isbn(isbn).build();
        return bookService.getBookInfo(reqDto);
    }
}
