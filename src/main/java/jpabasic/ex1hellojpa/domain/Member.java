package jpabasic.ex1hellojpa.domain;

import lombok.Getter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity // JPA가 loading될때 JPA를 사용하는 Class라고 인식
@Table(name = "Member") //
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ",
        initialValue = 1,allocationSize = 1
)

public class Member {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR") //oracle이면 sequensce..
    //Identity : Mysql Autoincrement
    @Column(name = "MEMBER_ID")
    private long id;

    @Column(name = "NAME")
    private String username;

//    //Member n, Team 1
//    @ManyToOne(targetEntity = Team.class) //무슨관계인지
//    @JoinColumn(name = "TEAM_ID") //join 은 어디컬럼으로하는지.
//    private Team team;

    private String city;

    private String street;

    private String zipcode;

    @OneToMany(mappedBy = "member",targetEntity = Order.class)
    private List<Order> orders = new ArrayList<>();

//
//    private Integer age;
//
//    @Enumerated(EnumType.ORDINAL)
//    private RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    @Lob
//    private String description;

}
