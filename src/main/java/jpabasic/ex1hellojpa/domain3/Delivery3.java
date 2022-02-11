package jpabasic.ex1hellojpa.domain3;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "DELIVERY3_SEQ_GENERATOR"
)
public class Delivery3 {
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "DELIVERY3_SEQ_GENERATOR"
    )
    @Id
    @Column(name = "DELIVERY_ID")
    private Long id;

    private String city;
    private String zipcode;

    @Enumerated(EnumType.STRING)
    private OrderStatus3 status;

}
