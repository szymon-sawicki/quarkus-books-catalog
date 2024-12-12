package net.szymonsawicki.application;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import net.szymonsawicki.persistence.BookEntity;
import net.szymonsawicki.persistence.BookRepository;

@ApplicationScoped
public class BookService {
  @Inject BookRepository bookRepository;

  @Transactional
  public boolean addBook(BookEntity bookEntity) {
    bookRepository.persist(bookEntity);
    return bookRepository.isPersistent(bookEntity);
  }

  public List<BookEntity> findAllBooks() {
    return bookRepository.findAll().stream().toList();
  }
}
