package jpabasic.ex1hellojpa.domainForJqpl;

public class JpqlMemberDTO {
    private String username;
    private int age ;

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

    public JpqlMemberDTO(String username, int age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "JpqlMemberDTO{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
