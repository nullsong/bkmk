package hu.bookmarker.api.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import hu.bookmarker.api.book.model.BookDTO;
import hu.bookmarker.api.book.model.BookResDTO;
import hu.bookmarker.api.book.model.BookSearchDTO;
import hu.bookmarker.api.book.service.BookService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping (value = "/book", produces = "application/json")
public class BookController {

    private final BookService bookService;

    @GetMapping("/")
    public BookResDTO getBooks(@RequestParam(required = true, name = "keyword") final String keyword
                             , @RequestParam(required = true, name = "start") final int start) {
        log.info("*** getBooks : {} {} ***", keyword, start);
        BookSearchDTO reqDto = BookSearchDTO.builder().keyword(keyword).start(start).build();
        return bookService.getBooks(reqDto);
    }

    @GetMapping("/info")
    public BookDTO getBookInfo(@RequestParam(required = true, name = "isbn") final String isbn) {
        log.info("*** getBookInfo : {} ***", isbn);
        BookDTO reqDto = BookDTO.builder().isbn(isbn).build();
        return bookService.getBookInfo(reqDto);
    }
}
