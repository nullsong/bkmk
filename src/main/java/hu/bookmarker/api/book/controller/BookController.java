package hu.bookmarker.api.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import hu.bookmarker.api.book.model.BookDTO;
import hu.bookmarker.api.book.service.BookService;

@RestController
@RequiredArgsConstructor
@RequestMapping (value = "/book", produces = "application/json")
public class BookController {
    
    private final BookService bookService;

    @GetMapping("/info")
    public BookDTO getBookInfo(@RequestParam(required = true, name = "bookSrno") final Integer bookSrno) {

        BookDTO reqDto = BookDTO.builder().bookSrno(bookSrno).build();
        return bookService.getBookInfo(reqDto);
    }
}
