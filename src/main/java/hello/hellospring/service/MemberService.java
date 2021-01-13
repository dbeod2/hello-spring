package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;

public class MemberService {

  private final MemberRepository repository = new MemoryMemberRepository();

  public Long join(Member member) {
    validate(member);
    repository.save(member);
    return member.getId();
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
