package jpabasic.ex1hellojpa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;


    public Long getId() {
        return id;
    }
//
//    @OneToMany(targetEntity = Member.class,mappedBy = "team") //mappedBy : Member에 foreignkey로 걸려있는 변수명
//    /*
//    * mappedBy
//    *   Member에 foreignkey로 걸려있는 변수명
//    *   양방관계에서, mappedBy를 쓰는 쪽이 주인이 아니다.
//    *   보통 외래키가 있는 곳을 주인으로 정한다.
//    *   mappedby걸려있는 column은 오직 조회만 가능하다. (members에 값을 update해도 DB에 들어가지 않는다.)
//    *   즉 foreign Key가 양방향 mapping 관계에서 주인을 가지는게 보통 관례
//    * */
//    private List<Member> members = new ArrayList<>();
//

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private String name;

    public Team() {
    }
}
