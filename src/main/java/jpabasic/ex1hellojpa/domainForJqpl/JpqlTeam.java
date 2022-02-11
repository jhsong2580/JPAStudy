package jpabasic.ex1hellojpa.domainForJqpl;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class JpqlTeam {
    @Id
    @GeneratedValue
    @Column(name = "JpqlTeam_ID")
    private long id;

    private String name;

    @OneToMany(mappedBy = "team",fetch =FetchType.LAZY,orphanRemoval = true)
    private List<JpqlMember> jpqlMemberList = new ArrayList<>();


}
