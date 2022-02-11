package jpabasic.ex1hellojpa.domainForJqpl;

import javax.persistence.*;

@Entity

public class JpqlOrder {
    @Id
    @GeneratedValue
    @Column(name = "JpqlOrder_ID")
    private long id ;

    private int orderAmount;

    private int count;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "JpqlMember_ID")
    private JpqlMember member;

    @Embedded
    private JpqlAddress address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JpqlProduct_ID")
    private JpqlProduct product;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public JpqlMember getMember() {
        return member;
    }

    public void setMember(JpqlMember member) {
        this.member = member;
    }

    public JpqlAddress getAddress() {
        return address;
    }

    public void setAddress(JpqlAddress address) {
        this.address = address;
    }

    public JpqlProduct getProduct() {
        return product;
    }

    public void setProduct(JpqlProduct product) {
        this.product = product;
    }
}
