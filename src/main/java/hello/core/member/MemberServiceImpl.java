package hello.core.member;

public class MemberServiceImpl implements MemberService{
    // 회원을 찾으려면 리포지토리가 필요하다
    // new MemoryMemberRepository(); 구현객체를 넣어줘야한다.
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        // join에서 save를 호출하면 오버라이드된 MemberRepository(인터페이스)가 아니라
        // MemoryMemberRepository(구현체)의 save가 호출된다
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberID) {
        return memberRepository.findById(memberID);
    }
}
