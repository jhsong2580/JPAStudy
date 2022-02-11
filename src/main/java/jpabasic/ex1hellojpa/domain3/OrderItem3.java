package jpabasic.ex1hellojpa.domain3;

import jpabasic.ex1hellojpa.domain.Item;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "ORDERITEM3_SEQ_GENERATOR"
)
public class OrderItem3 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ORDERITEM3_SEQ_GENERATOR")
    @Column(name = "ORDER_ITEM_ID")
    private long id;

    @ManyToOne(targetEntity = Orders3.class)
    @JoinColumn(name = "ORDER_ID")
    private Orders3 orders3;

    @ManyToOne(targetEntity = Item3.class)
    @JoinColumn(name = "ITEM_ID")
    private Item3 item3;

    private int orderprice;

    private int count;

}
