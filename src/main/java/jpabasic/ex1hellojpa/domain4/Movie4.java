package jpabasic.ex1hellojpa.domain4;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Movie4 extends Item4{
    private String director;
    private String actor;
}
