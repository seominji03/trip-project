package one.trip.repository;

import one.trip.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);

    Optional<Member> findByIdx(Long idx);
    Optional<Member> findById(String id);
    List<Member> findAll();
}
