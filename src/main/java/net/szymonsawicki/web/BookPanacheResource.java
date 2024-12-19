package net.szymonsawicki.web;

import java.awt.print.Book;
import java.util.List;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.DELETE;
import net.szymonsawicki.persistence.BookEntity;

@ResourceProperties(hal = true, path = "books-panache")
public interface BookPanacheResource extends PanacheEntityResource<BookEntity, Long> {

  @RolesAllowed("admin")
  @DELETE
  boolean delete(Long id);

  @PermitAll
  List<Book> findById(Long id);
}
