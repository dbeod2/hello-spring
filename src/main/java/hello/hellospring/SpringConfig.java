package hello.hellospring;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class SpringConfig {

  @Autowired
  private DataSource dataSource;

  @Bean
  public MemberRepository memberRepository() {
    return new JdbcMemberRepository(dataSource);
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }
}
