package hu.bookmarker.api.review.service;

import org.springframework.stereotype.Service;

import hu.bookmarker.api.review.mapper.IReviewMapper;
import hu.bookmarker.api.review.model.ReviewDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final IReviewMapper iReviewMapper;

    /**
     * 나의 리뷰 조회 
     */
    public ReviewDTO getMyReview(ReviewDTO reqDto) {
        return iReviewMapper.selectMyReview(reqDto);
    }
}
