package jpabasic.ex1hellojpa.domain;

import javax.persistence.*;

@Entity
@Table(name = "item")
@SequenceGenerator(
        name = "ITEM_SEQ_GENERATOR",
        initialValue = 1,
        sequenceName = "ITEM_SEQ",
        allocationSize = 50
)
public class Item {
    @Id
    @Column(name = "ITEM_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ITEM_SEQ_GENERATOR")
    private Long id;


    private String name;

    private int price;

    @Column(name ="STOCKQUANTITY")
    private int stockQuantity;


}
