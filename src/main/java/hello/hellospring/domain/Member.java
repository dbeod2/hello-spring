package hello.hellospring.domain;

public class Member {

  private Long id;
  private String name;

  public Member() {
  }

  private Member(String name) {
    this.name = name;
  }

  public static Member of(String name) {
    return new Member(name);
  }
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
