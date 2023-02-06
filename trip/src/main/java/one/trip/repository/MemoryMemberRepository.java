package one.trip.repository;

import one.trip.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    //회원의 정보를 store에 map 형태로 저장
    public Member save(Member member) {
        member.setIdx(++sequence);
        store.put(member.getIdx(), member);
        return member;
    }

    @Override
    public Optional<Member> findByIdx(Long idx) {
        return Optional.ofNullable(store.get(idx));
    }

    @Override
    public Optional<Member> findById(String id) {
        return store.values().stream()
                .filter(member -> member.getId().equals(id))
                .findAny();
    }
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
