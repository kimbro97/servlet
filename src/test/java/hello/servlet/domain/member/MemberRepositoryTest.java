package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void setUp() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member("kimbro97", 27);
        Member saveMember = memberRepository.save(member);
        Member findmember = memberRepository.findById(saveMember.getId());
        assertThat(saveMember).isEqualTo(findmember);
    }

    @Test
    void findAll() {
        Member member1 = new Member("kimbro97", 27);
        Member member2 = new Member("kimbro97", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);
        List<Member> members = memberRepository.findAll();

        assertThat(members).hasSize(2);
        assertThat(members).contains(member1, member2);


    }
}