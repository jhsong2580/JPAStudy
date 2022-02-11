package jpabasic.ex1hellojpa.domain3;

import jpabasic.ex1hellojpa.domain4.BaseEntity;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "ITEM3_SEQ_GENERATOR"
)
public class Item3 extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ITEM3_SEQ_GENERATOR")
    @Column(name = "ITEM_ID")
    private Long id;

    private int price;

    private int stockquantity;

}
