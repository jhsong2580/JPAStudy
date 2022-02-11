package jpabasic.ex1hellojpa.domain4;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "ITEM4_TYPE")
abstract public class Item4 extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "ITEM4_ID")
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

}
