package hu.bookmarker.api.book.mapper;

import hu.bookmarker.api.book.model.BookDTO;

public interface IBookMapper {

    /**
     * 도서 정보 조회
     * @param reqDto
     * @return
     */
    public BookDTO selectBookInfo(BookDTO reqDto);
}
