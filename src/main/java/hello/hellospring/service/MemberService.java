package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MemberService {

  private final MemberRepository repository;

  @Autowired
  public MemberService(MemberRepository repository) {
    this.repository = repository;
  }

  @Transactional
  public Long join(Member member) {
    Long start = System.currentTimeMillis();
    try {
      validate(member);
      repository.save(member);
      return member.getId();
    } finally {
      Long finish = System.currentTimeMillis();
      Long timeMs = finish - start;
      System.out.println("join : " + timeMs + "ms");

    }
  }

  public Member get(Long id) {
    return repository.findById(id).get();
  }

  public List<Member> getAll() {
    return repository.findAll();
  }

  private void validate(Member member) {
    repository.findByName(member.getName())
            .ifPresent(m -> {
              throw new IllegalStateException("이미 존재하는 회원입니다.");
            });
  }
}
