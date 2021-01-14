package hello.hellospring;

import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;


@Configuration
public class SpringConfig {

  private final EntityManager entityManager;

  public SpringConfig(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Bean
  public MemberRepository memberRepository() {
    return new JpaMemberRepository(entityManager);
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }
}
