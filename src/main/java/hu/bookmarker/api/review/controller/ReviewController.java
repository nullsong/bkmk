package hu.bookmarker.api.review.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.bookmarker.api.review.model.ReviewDTO;
import hu.bookmarker.api.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping (value = "/review", produces = "application/json")
public class ReviewController {
    
    private final ReviewService reviewService;

    @GetMapping("/")
    public ReviewDTO getMyReview(@RequestBody final ReviewDTO reqDto){
        log.info("*** getMyReview *** ");
        ReviewDTO reviewDto = ReviewDTO.builder()
                                    .userId(reqDto.getUserId())
                                    .bookSrno(reqDto.getBookSrno()).build();
        return reviewService.getMyReview(reviewDto);
    }

    @PostMapping("/")
    public int createMyReview(@RequestBody final ReviewDTO reqDto) {
        log.info("*** createMyReview *** ");
        ReviewDTO reviewDto = ReviewDTO.builder()
                                    .userId(1)
                                    .reviewRating(reqDto.getReviewRating())
                                    .reviewText("aaaa")
                                    .bookInfo(reqDto.getBookInfo())
                                    .build();
        return reviewService.createMyReview(reviewDto);

    }
}
