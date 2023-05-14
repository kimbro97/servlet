package hello.servlet.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

//    @AfterEach
//    void afterEach() {
//        memberRepository.clearStore();
//    }

    @Test
    void save() {
        // given 이런게 주어졌을때
        Member member = new Member("kim", 20);

        // when 이런걸 실행했을때
        Member savedMember = memberRepository.save(member);
        // then 결과는 이거여야해
        Member findMember = memberRepository.findById(savedMember.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        // given 이런게 주어졌을때
        Member member1 = new Member("kim", 20);
        Member member2 = new Member("kim2", 20);
        memberRepository.save(member1);
        memberRepository.save(member2);
        // when 이런걸 실행했을때
        List<Member> members = memberRepository.findAll();
        // then 결과는 이거여야해
        assertThat(members.size()).isEqualTo(2);
        assertThat(members).contains(member1, member2);
    }
}