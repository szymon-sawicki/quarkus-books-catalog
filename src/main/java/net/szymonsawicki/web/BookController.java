package net.szymonsawicki.web;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import net.szymonsawicki.application.BookService;
import net.szymonsawicki.persistence.BookEntity;

@Path("/books")
public class BookController {
  @Inject BookService bookService;

  @POST
  @Produces(MediaType.TEXT_PLAIN)
  public String createBook(BookEntity bookEntity) {
    bookService.addBook(bookEntity);
    return "Book added";
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public List<BookEntity> findAllBooks() {
    return bookService.findAllBooks();
  }
}