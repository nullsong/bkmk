package hu.bookmarker.api.review.mapper;

import hu.bookmarker.api.review.model.ReviewDTO;

public interface IReviewMapper {
    
    /**
     * 나의 리뷰 조회 
     * @param reqDto
     * @return
     */
    public ReviewDTO selectMyReview(ReviewDTO reqDto);
}
