package telran.java52.book.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import telran.java52.book.model.Book;

public interface BookRepository extends JpaRepository<Book, String> {
	
	@Query("select b from Book b join b.authors a where a.id = :author")
	List<Book> findBooksByAuthor(String author);
	
	@Query("select b from Book b where b.publisher.id = :publisher")
	List<Book> findBooksByPublisher(String publisher);
	
	@Query("select p from Publisher p join Author a on a.id = :author")
	String[] findPublishersByAuthor(String author);

}
