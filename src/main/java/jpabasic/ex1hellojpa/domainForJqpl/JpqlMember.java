package jpabasic.ex1hellojpa.domainForJqpl;

import javax.persistence.*;

@Entity
@NamedQuery(
        name = "JpqlMember.findByUserName",
        query = "select m from JpqlMember m where m.username = :username"
)
public class JpqlMember {
    @Id
    @GeneratedValue
    @Column(name = "JpqlMember_ID")
    private Long id;

    private String username;

    private int age ;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "JpqlTeam_ID")
    private JpqlTeam team;

    @Enumerated(EnumType.STRING)
    private MemberType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public JpqlTeam getTeam() {
        return team;
    }

    public void setTeam(JpqlTeam team) {
        this.team = team;
    }
}
