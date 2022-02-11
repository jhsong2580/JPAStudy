package jpabasic.ex1hellojpa.domain4;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class Book4 extends Item4 {
    private String author;
    private String isbn;
}
