package one.trip.repository;

import one.trip.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        //given(회원정보 전달)
        Member member = new Member();
        member.setId("firstId");

        //when(repository에 저장할떄)
        repository.save(member);

        //then(저장한 값 확인)
        Member result = repository.findByIdx(member.getIdx()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findById(){
        //given(회원1,2 두명 생성)
        Member member1 = new Member();
        member1.setId("FirstId");
        member1.setPw("FirstPw");
        repository.save(member1);

        Member member2 = new Member();
        member2.setId("SecondId");
        member2.setPw("SecondPw");
        repository.save(member2);

        //when(회원1 저장)
        Member result = repository.findById("FirstId").get();

        //then(저장된 회원1과 회원1 비교)
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        //given(회원 1,2 정보 전달)
        Member member1 = new Member();
        member1.setId("FirstId");
        member1.setPw("FirstPw");
        repository.save(member1);

        Member member2 = new Member();
        member2.setId("SecondId");
        member2.setPw("SecondPw");
        repository.save(member2);

        //when(저장)
        List<Member> result = repository.findAll();

        //then(두개가 저장되었는지 확인)
        assertThat(result.size()).isEqualTo(2);
    }
}
