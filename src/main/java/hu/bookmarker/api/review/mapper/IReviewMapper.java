package hu.bookmarker.api.review.mapper;

import hu.bookmarker.api.review.model.ReviewDTO;

public interface IReviewMapper {
    
    /**
     * 나의 리뷰 조회 
     * @param reqDto
     * @return
     */
    ReviewDTO selectMyReview(ReviewDTO reqDto);

        
    /**
     * 나의 리뷰 등록
     * @param reqDto
     * @return
     */
    int insertMyReview(ReviewDTO reqDto);
}
