package hello.hello_spring.controller;

import hello.hello_spring.domain.Member;
import hello.hello_spring.dto.MemberDto;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired  // 의존성 주입 방식중 생성자 주입 방식을 권장
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String newMember(Model model, MemberDto memberDto) {
        Member member = new Member();
        member.setName(memberDto.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> memberList = memberService.findMembers();
        model.addAttribute("members", memberList);

        return "members/memberList";
    }
}
