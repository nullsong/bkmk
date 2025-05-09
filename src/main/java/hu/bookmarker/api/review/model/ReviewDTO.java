package hu.bookmarker.api.review.model;

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
    private int userId;
    private int bookSrno;
    private int reviewRating;
    private String reviewText;
    private String regDtm;
    private String modDtm;
}
