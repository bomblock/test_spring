package newtest.test.repository;

import newtest.test.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.JsonPathAssertions;

import java.awt.*;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;

class MemoryMemberRepositoryTest {

    MemberRepository repository = new MemoryMemberRepository();
    //todo Test를 쓰면 기존에 있던 메서드를 테스트 해줄수 있다.
    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //todo Assertions.assertArrayEquals(member, result); 값을 쓰고 실패하면 null 이 오도록 만든다.
        Assertions.assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //todo repository.findByName("spring1");
        Optional<Member> result = Optional.of(repository.findByName("Spring1").get());

        assertThat(result).isEqualTo(member1);

    }

    private JsonPathAssertions assertThat(Optional<Member> result) {

    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member
    }
}
