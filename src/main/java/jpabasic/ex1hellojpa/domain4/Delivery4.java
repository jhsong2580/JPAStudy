package jpabasic.ex1hellojpa.domain4;

import javax.persistence.*;

@Entity
public class Delivery4 {
    @Id
    @GeneratedValue
    @Column(name = "DELIVERY4_ID")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "ORDER4_ID")
    private Order4 order4;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private OrderStatus4 DeliveryStatus;

}
