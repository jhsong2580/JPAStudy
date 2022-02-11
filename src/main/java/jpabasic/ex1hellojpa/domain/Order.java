package jpabasic.ex1hellojpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@SequenceGenerator(
        name = "ORDERS_SEQ_GENERATOR",
        initialValue = 1,
        allocationSize = 50,
        sequenceName = "ORDERS_SEQ"
)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ORDERS_SEQ_GENERATOR")
    @Column(name = "ORDER_ID")
    private Long id;

//    @Column(nullable = false,name = "member_id")
//    private Member member;
    @ManyToOne(targetEntity = Member.class)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(targetEntity = OrderItem.class,mappedBy ="order" )
    private List<OrderItem> orderItems = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Column(insertable = true,updatable = false,name = "orderdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);

    }

}
