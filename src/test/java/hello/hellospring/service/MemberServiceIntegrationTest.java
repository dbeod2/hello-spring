package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

  @Autowired
  MemberService memberService;

  @ParameterizedTest
  @DisplayName("회원가입")
  @ValueSource(strings = "yura")
  public void 회원가입(String name) {
    Member member = Member.of(name);

    Long id = memberService.join(member);

    Member findMember = memberService.get(id);
    assertThat(member.getName()).isEqualTo(findMember.getName());
  }
}
