package one.trip.service;

import one.trip.controller.MemberForm;
import one.trip.domain.Member;
import one.trip.repository.JdbcTemplateMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
@Service
public class MemberService {

    private final JdbcTemplateMemberRepository jdbcTemplateMemberRepository;
    @Autowired
    public MemberService(JdbcTemplateMemberRepository jdbcTemplateMemberRepository) {
        this.jdbcTemplateMemberRepository = jdbcTemplateMemberRepository;
    }

    //회원가입
    public Long join(Member member){
        jdbcTemplateMemberRepository.save(member);
        return member.getIdx();
    }

    //로그인
    //세션에 저장하는거 아직 못함
    @RequestMapping(method= RequestMethod.POST)
    public void login(MemberForm form){
        //HttpServletRequest request;
        Optional<Member> check =jdbcTemplateMemberRepository.findById(form.getId());
        if(check.isPresent()) {
            System.out.println("로그인 성공");
            //HttpSession session = request.getSession();
        }
    }

    //전체 회원 조희
    public List<Member> findMembers(){
        return jdbcTemplateMemberRepository.findAll();
    }
    //한 회원 조희
    public Optional<Member> findOne(Long memberIdx){
        return jdbcTemplateMemberRepository.findByIdx(memberIdx);
    }
}
