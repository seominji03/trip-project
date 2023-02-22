package one.trip.controller;

import one.trip.domain.Member;
import one.trip.service.MemberService;
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

    //회원가입 폼으로 이동과 값 저장
    @GetMapping(value = "/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setId(form.getId());
        member.setPw(form.getPw());

        memberService.join(member);

        return "redirect:/";
    }
    //로그인 폼으로 이동
    @GetMapping(value = "/members/login")
    public String loginForm(){ return "members/loginForm";}

    @PostMapping(value= "/members/login")
    public String login(MemberForm form){
        memberService.login(form);
        return "redirect:/";
    }

}
