package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

  MemoryMemberRepository repository = new MemoryMemberRepository();

  Member member;

  @BeforeEach
  public void setup() {
    member = Member.of("hahah");
  }

  @Test
  @DisplayName("회원 정보 저장")
  public void save() {
    //when
    repository.save(member);

    //then
    Optional<Member> memberResult = repository.findById(member.getId());
    assertThat(member).isEqualTo(memberResult.get());
  }

  @Test
  @DisplayName("회원 이름 검색")
  public void findByName() {
    repository.save(member);

    //given
    Member member1 = Member.of("hhhh");

    //when
    repository.save(member1);

    //then
    Optional<Member> memberResult = repository.findByName("hhhh");
    assertThat(member1.getName()).isEqualTo(memberResult.get().getName());
  }

  @Test
  @DisplayName("회원 전체 검색")
  public void findAll() {
    repository.save(member);

    Member member1 = Member.of("hhhh111111");
    member1.setName("hhhh111111");
    repository.save(member1);

    Member member2 = Member.of("hello");
    member2.setName("hello");
    repository.save(member2);


    List<Member> members = repository.findAll();
    assertThat(3).isEqualTo(members.size());
  }

}
