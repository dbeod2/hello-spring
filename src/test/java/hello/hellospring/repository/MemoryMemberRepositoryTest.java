package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

  private MemoryMemberRepository repository = new MemoryMemberRepository();

  Member member = new Member();

  @BeforeEach
  public void setup() {
    member.setName("hahaha");
  }

  @Test
  @DisplayName("회원 정보 저장")
  public void save() {
    repository.save(member);

    Optional<Member> memberResult = repository.findById(member.getId());
    assertThat(member).isEqualTo(memberResult.get());
  }

  @Test
  @DisplayName("회원 이름 검색")
  public void findByName() {
    Member member1 = new Member();
    member1.setName("hhhh");
    repository.save(member);
    repository.save(member1);

    Optional<Member> memberResult = repository.findByName("hhhh");
    assertThat(member1.getName()).isEqualTo(memberResult.get().getName());
  }

  @Test
  @DisplayName("회원 전체 검색")
  public void findAll() {
    Member member1 = new Member();
    member1.setName("hhhh111111");

    Member member2 = new Member();
    member2.setName("hello");
    repository.save(member);
    repository.save(member1);
    repository.save(member2);


    List<Member> members = repository.findAll();
    assertThat(3).isEqualTo(members.size());
  }

}
