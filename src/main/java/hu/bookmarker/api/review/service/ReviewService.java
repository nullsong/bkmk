package hu.bookmarker.api.review.service;

import org.springframework.stereotype.Service;

import hu.bookmarker.api.book.model.BookDTO;
import hu.bookmarker.api.book.service.BookService;
import hu.bookmarker.api.review.mapper.IReviewMapper;
import hu.bookmarker.api.review.model.ReviewDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewService {

    private final IReviewMapper iReviewMapper;
    private final BookService bookService;

    /**
     * 나의 리뷰 조회 
     */
    public ReviewDTO getMyReview(ReviewDTO reqDto) {
        return iReviewMapper.selectMyReview(reqDto);
    }

    /**
     * 나의 리뷰 저장
     */
    public int createMyReview(ReviewDTO reqDto) {
        // 도서 정보 조회
        BookDTO bDto = reqDto.getBookInfo();
        BookDTO resDto = bookService.createBookInfo(bDto);
        reqDto.setBookSrno(resDto.getBookSrno());

        return iReviewMapper.insertMyReview(reqDto);
    }
}