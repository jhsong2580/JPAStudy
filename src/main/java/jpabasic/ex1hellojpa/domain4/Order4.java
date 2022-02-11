package jpabasic.ex1hellojpa.domain4;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Order4 extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "ORDER4_ID")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER4_ID")
    private Member4 member4;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus4 status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member4 getMember4() {
        return member4;
    }

    public void setMember4(Member4 member4) {
        this.member4 = member4;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus4 getStatus() {
        return status;
    }

    public void setStatus(OrderStatus4 status) {
        this.status = status;
    }

    public Delivery4 getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery4 delivery) {
        this.delivery = delivery;
    }

    @OneToOne(targetEntity = Delivery4.class,mappedBy = "order4",fetch = FetchType.LAZY)
    private Delivery4 delivery;
}
