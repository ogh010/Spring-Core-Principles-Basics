package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 애플리케이션의 구성 정보를 설정하는 AppConfig 클래스
@Configuration // 설정정보
public class AppConfig {

    // 회원 서비스 빈을 생성하는 메서드
    @Bean // @Bean 을 붙이면 스프링 컨테이너에 등록이 됨
    public MemberService memberService(){
        // MemberServiceImpl 객체를 생성하여 반환함
        // 회원 저장소 구현체를 주입함
        return new MemberServiceImpl(memberRepository());
    }

    // 주문 서비스 빈을 생성하는 메서드
    @Bean
    public OrderService orderService(){
        // OrderServiceImpl 객체를 생성하여 반환함
        // 회원 저장소 구현체와 할인 정책 구현체를 주입함
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 회원 저장소 빈을 생성하는 메서드
    @Bean
    public MemberRepository memberRepository(){
        // MemoryMemberRepository 객체를 생성하여 반환함
        return new MemoryMemberRepository();
    }

    // 할인 정책 빈을 생성하는 메서드
    @Bean
    public DiscountPolicy discountPolicy(){
        // FixDiscountPolicy 객체를 생성하여 반환함
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
