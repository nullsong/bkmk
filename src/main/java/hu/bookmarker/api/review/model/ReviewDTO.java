package hu.bookmarker.api.review.model;

import hu.bookmarker.api.book.model.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private int reviewId;
    private String userId;
    private int bookSrno;
    private int reviewRating;
    private String reviewText;
    private String regDtm;
    private String modDtm;
    
    private String title;
    private String isbn;
    private String image;
    private BookDTO bookInfo;
}
