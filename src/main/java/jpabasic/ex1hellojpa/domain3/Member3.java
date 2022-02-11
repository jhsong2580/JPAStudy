package jpabasic.ex1hellojpa.domain3;

import jpabasic.ex1hellojpa.domain4.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@SequenceGenerator(
        name = "MEMBER3_SEQ_GENERATOR",
        allocationSize = 50,
        initialValue = 1
)
public class Member3 extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "MEMBER3_SEQ_GENERATOR")
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;
    private String city;
    private String street;
    private String zipcode;

    @OneToMany(targetEntity = Orders3.class,mappedBy = "member3")
    private List<Orders3> orders3s = new ArrayList<>();


}
