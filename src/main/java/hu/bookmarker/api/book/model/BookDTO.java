package hu.bookmarker.api.book.model;

import java.time.LocalDate;

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
    private LocalDate publishedDate;
    private String isbn;
    private String image;
    private String description;
}
