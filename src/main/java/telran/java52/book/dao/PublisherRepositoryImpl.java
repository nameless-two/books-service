package telran.java52.book.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import telran.java52.book.dto.exception.EntityNotFoundException;
import telran.java52.book.model.Author;
import telran.java52.book.model.Book;
import telran.java52.book.model.Publisher;

@Repository
public class PublisherRepositoryImpl implements PublisherRepository {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<String> findPublishersByAuthor(String authorName) {
		Author author = em.find(Author.class, authorName);
		if (author == null)
			throw new EntityNotFoundException();
		Set<Book> books = author.getBooks();
		List<String> publishers = books.stream().map(Book::getPublisher).map(Publisher::getPublisherName).toList();
		return publishers;
	}

	@Override
	public Stream<Publisher> findDistinctByBooksAuthorsName(String authorName) {
		Author author = em.find(Author.class, authorName);
		if (author == null)
			throw new EntityNotFoundException();
		Set<Book> books = author.getBooks();
		return books.stream().map(Book::getPublisher).distinct();
	}

	@Override
	public Optional<Publisher> findById(String publisher) {
		return Optional.ofNullable(em.find(Publisher.class, publisher));
	}

//	@Transactional
	@Override
	public Publisher save(Publisher publisher) {
		em.persist(publisher);
//		em.merge(publisher);
		return publisher;
	}

}
