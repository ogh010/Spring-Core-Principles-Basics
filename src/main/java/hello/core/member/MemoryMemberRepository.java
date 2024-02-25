package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    // 저장소
    private static Map<Long,Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put((member.getId()),member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
// 데이터베이스 확정이 안나서 메모리멤버리포지터리 !

