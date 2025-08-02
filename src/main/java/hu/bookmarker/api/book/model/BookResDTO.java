package hu.bookmarker.api.book.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResDTO {
    private List<BookDTO> bookList;
    private String keyword;
    private int start; 
    private int total;
}
