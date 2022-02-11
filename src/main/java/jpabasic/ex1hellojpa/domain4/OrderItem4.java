package jpabasic.ex1hellojpa.domain4;

import javax.persistence.*;

@Entity
public class OrderItem4 extends  BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "ORDERITEM4_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM4_ID")
    private Item4 item;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER4_ID")
    private Order4 order4;

    private int orderPrice;

    private int count;


}
