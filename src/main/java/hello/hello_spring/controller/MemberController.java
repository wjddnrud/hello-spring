package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired  // 의존성 주입 방식중 생성자 주입 방식을 권장
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
