package net.szymonsawicki.persistence;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class BookEntity extends PanacheEntity {
  @JsonbProperty public String title;

  public void setTitle(String title) {
    this.title = title;
  }
}
