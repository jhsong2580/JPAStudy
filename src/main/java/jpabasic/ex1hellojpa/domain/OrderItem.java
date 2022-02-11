package jpabasic.ex1hellojpa.domain;

import javax.persistence.*;
import java.util.LongSummaryStatistics;

@Entity
@Table(name = "order_item_id")
@SequenceGenerator(
        name = "ORDER_ITEM_SEQ_GENERATOR",
        sequenceName = "ORDER_ITEM_SEQ",
        initialValue = 1,
        allocationSize = 50
)
public class OrderItem {
    @Id
    @Column(name = "ORDER_ITEM_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="ORDER_ITEM_SEQ_GENERATOR" )
    private Long id;


    @ManyToOne(targetEntity = Order.class)
    @JoinColumn(name = "ORDER_ID")
    private Order order;


    @ManyToOne(targetEntity = Item.class)
    @JoinColumn(name = "ITEM_ID")
    private Item item;


    private int orderPrice;

    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
