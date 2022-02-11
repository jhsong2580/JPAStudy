package jpabasic.ex1hellojpa.domain4;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Album4 extends Item4{
    private String artist;
    private String etc;
}
