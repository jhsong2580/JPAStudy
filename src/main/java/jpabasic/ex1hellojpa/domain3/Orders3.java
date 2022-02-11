package jpabasic.ex1hellojpa.domain3;

import javax.persistence.*;
import java.util.Date;

@Entity
@SequenceGenerator(
        name = "ORDERS3_SEQ_GENERATOR"
)
public class Orders3 {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ORDERS3_SEQ_GENERATOR")
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne(targetEntity = Member3.class)
    @JoinColumn(name = "MEMBER_ID")
    private Member3 member3;

    @OneToOne(targetEntity = Delivery3.class)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery3 delivery;


    @Temporal(TemporalType.TIMESTAMP)
    private Date orderdate;

    @Enumerated(EnumType.STRING)
    private OrderStatus3 status;
}
