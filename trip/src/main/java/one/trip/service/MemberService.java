package one.trip.service;

import one.trip.domain.Member;
import one.trip.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //회원가입
    public Long join(Member member){
        memberRepository.save(member);
        return member.getIdx();
    }

    //전체 회원 조희
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    //한 회원 조희
    public Optional<Member> findOne(Long memberIdx){
        return memberRepository.findByIdx(memberIdx);
    }
}
