package com.ll.gramgram.boundedContext.likeablePerson.repository;

import com.ll.gramgram.boundedContext.likeablePerson.entity.LikeablePerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikeablePersonRepository extends JpaRepository<LikeablePerson, Long> {
    List<LikeablePerson> findByFromInstaMemberId(Long fromInstaMemberId);
    List<LikeablePerson> findByToInstaMemberUsername(String toInstaMemberUsername);

    List<LikeablePerson> findByToInstaMember_username(String username);
    // JPA 함수에서 언더바를 사용하면 관련 엔티티의 필드까지 검색 조건으로 활용할 수 있음

    LikeablePerson findByFromInstaMemberIdAndToInstaMember_username(long fromInstaMemberId, String username);
}
