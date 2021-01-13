package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {

  MemberService memberService;

  Member member;

  @BeforeEach
  public void setup() {
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
    memberService = new MemberService(memoryMemberRepository);

    member = Member.of("yura");
  }

  @Test
  @DisplayName("회원 가입")
  public void join() {
    Long memberId = memberService.join(member);
    System.out.println(memberId);
  }

  @Test
  @DisplayName("이름 중복 오류")
  public void nameDuplicateException() {
    Member member1 = Member.of("yura");
    assertThrows(IllegalStateException.class,
            () -> memberService.join(member1))
            .getMessage();
  }

  @Test
  @DisplayName("회원 전체검색")
  public void memberAll() {
    Member member1 = Member.of("yy");
    memberService.join(member1);
    Member member2 = Member.of("yua");
    memberService.join(member2);
    Member member3 = Member.of("rara");
    memberService.join(member3);

    List<Member> memberList = memberService.getAll();
    assertThat(4).isEqualTo( memberList.size());
  }

}
