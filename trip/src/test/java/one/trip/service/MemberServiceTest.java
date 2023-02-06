package one.trip.service;

import one.trip.domain.Member;
import one.trip.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }
    @Test
    public void 회원가입() throws  Exception{
        //given(회원 정보 주어짐)
        Member member = new Member();
        member.setId("회원 아이디 정보");
        member.setPw("회원 비번 정보");

        //when(join메소드 사용)
        Long saveIdx = memberService.join(member);

        //then(저장소에 저장된 값 비교)
        Member findMember = memberRepository.findByIdx(saveIdx).get();
        assertEquals(member.getId(), findMember.getId());
    }
}
