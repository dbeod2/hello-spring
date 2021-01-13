package hello.hellospring.domain;

public class Member {

  private Long memberId;
  private String name;

  private Member(String name) {
    this.name = name;
  }

  public static Member of(String name) {
    return new Member(name);
  }
  public Long getMemberId() {
    return memberId;
  }

  public void setMemberId(Long memberId) {
    this.memberId = memberId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
