package hu.bookmarker.api.review.service;

import java.util.List;

import org.springframework.stereotype.Service;

import hu.bookmarker.api.book.model.BookDTO;
import hu.bookmarker.api.book.service.BookService;
import hu.bookmarker.api.review.mapper.IReviewMapper;
import hu.bookmarker.api.review.model.ReviewDTO;
import hu.bookmarker.api.review.model.ReviewRatingDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final IReviewMapper reviewMapper;
    private final BookService bookService;

    /**
     * 나의 리뷰 조회 
     */
    public ReviewDTO getMyReview(ReviewDTO reqDto) {
        return reviewMapper.selectMyReview(reqDto);
    }

    /**
     * 리뷰 목록 조회
     */
    public List<ReviewDTO> getReviews(ReviewDTO reqDto) {
        return reviewMapper.selectReviews(reqDto);
    }

    /**
     * 나의 리뷰 저장
     */
    public int createMyReview(ReviewDTO reqDto) {
        // 도서 정보 조회
        BookDTO bDto = reqDto.getBookInfo();
        BookDTO resDto = bookService.createBookInfo(bDto);
        reqDto.setIsbn(resDto.getIsbn());

        return reviewMapper.insertMyReview(reqDto);
    }

    /**
     * 나의 리뷰 수정
     */
    public int modifyMyReview(ReviewDTO reqDto) {
        return reviewMapper.updateMyReview(reqDto);
    }

    /**
     * 나의 리뷰 삭제
     */
    public int removeMyReview(ReviewDTO reqDto) {
        return reviewMapper.deleteMyReview(reqDto);
    }

    /**
     * 나의 별점 조회
     */
    public List<ReviewRatingDTO> getMyRating(ReviewDTO reqDto) {
        return reviewMapper.selectMyRating(reqDto);
    }
}