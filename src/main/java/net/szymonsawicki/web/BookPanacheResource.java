package net.szymonsawicki.web;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;
import net.szymonsawicki.persistence.BookEntity;

@ResourceProperties(hal = true, path = "books-panache")
public interface BookPanacheResource extends PanacheEntityResource<BookEntity, Long> {}
