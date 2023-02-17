package newtest.test.repository;

import newtest.test.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }
//todo null이 반환될 가능성이 있으면 Optional 값을 넣어서 null 값이 반환되는 걸 방지하고 값을 넣어줄수 있다.
    //todo filter 에서 람다식을 써줘서 값을 리스트 중에서 끝까지 대입하게 만들어준다.
    // 마지막 값을 다 넣어준후 식이 제대로 작동하는지 보려면 test 코드를 작성해준다.
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
