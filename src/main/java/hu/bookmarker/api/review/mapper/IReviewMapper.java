package hu.bookmarker.api.review.mapper;

import java.util.List;

import hu.bookmarker.api.review.model.ReviewDTO;
import hu.bookmarker.api.review.model.ReviewRatingDTO;

public interface IReviewMapper {
    
    /**
     * 나의 리뷰 조회 
     * @param reqDto
     * @return
     */
    ReviewDTO selectMyReview(ReviewDTO reqDto);

    /**
     * 리뷰 목록 조회
     * @param reqDto
     * @return
     */
    List<ReviewDTO> selectReviews(ReviewDTO reqDto);

    /**
     * 나의 리뷰 등록
     * @param reqDto
     * @return
     */
    int insertMyReview(ReviewDTO reqDto);

    /**
     * 나의 리뷰 수정
     * @param reqDto
     * @return
     */
    int updateMyReview(ReviewDTO reqDto);

    /**
     * 나의 리뷰 삭제
     * @param reqDto
     * @return
     */
    int deleteMyReview(ReviewDTO reqDto);

    /**
     * 나의 별점 조회 
     * @param reqDto
     * @return
     */
    List<ReviewRatingDTO> selectMyRating(ReviewDTO reqDto);
}
