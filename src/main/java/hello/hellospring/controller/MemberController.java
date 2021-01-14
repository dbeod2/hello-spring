package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.model.MemberForm;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

  private final MemberService memberService;

  @Autowired
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("/members")
  public String getAll(Model model) {
    model.addAttribute("members", memberService.getAll());
    return "members/memberList";
  }

  @GetMapping("/members/new")
  public String createForm() {
    return "members/createMemberForm";
  }

  @PostMapping("/members/new")
  public String save(MemberForm memberForm) {
    Member member = Member.of(memberForm.getName());
    memberService.join(member);
    return "redirect:/";
  }
}
