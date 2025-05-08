package hu.bookmarker.api.book.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private int bookSrno;           
    private String title;
    private String author;
    private String publisher;
    private String publishedDate;
    private String isbn;
    private String regDtm;
}
