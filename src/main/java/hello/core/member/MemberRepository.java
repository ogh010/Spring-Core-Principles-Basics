package hello.core.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);

}
// 인터페이스를 만들면 구현체를 만들어야한다
