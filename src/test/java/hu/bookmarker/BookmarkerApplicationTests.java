package hu.bookmarker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hu.bookmarker.api.book.model.BookDTO;
import hu.bookmarker.api.book.service.BookService;

@SpringBootTest
class BookmarkerApplicationTests {

	@Autowired
	BookService ss;

	@Test
	void contextLoads() {
	}

	@Test
	@DisplayName("Service Test")
	public void test() {
		BookDTO dto = BookDTO.builder().keyword("토지").build();
		ss.getBooks(dto);
	}
}
