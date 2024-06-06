package telran.java52.book.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import telran.java52.book.dto.BookDto;
import telran.java52.book.service.BookService;

@RestController
@RequiredArgsConstructor
public class BookController {

	final BookService bookService;

	@PostMapping("/book")
	public boolean addBook(@RequestBody BookDto bookDto) {
		return bookService.addBook(bookDto);
	}

	@GetMapping("/book/{isbn}")
	public BookDto findBookByIsbn(@PathVariable String isbn) {
		return bookService.findBookByIsbn(isbn);
	}

	public BookDto removeBook(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	public BookDto updateBookTitle(String isbn, String newTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	public BookDto[] findBooksByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}
}
