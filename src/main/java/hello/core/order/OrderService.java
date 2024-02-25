package hello.core.order;

public interface OrderService {
    // 주문서비스 역할 보면 (회원 id, 상품명 , 상품가격)을 파라미터로 넘기면
    // 주문결과를 반환한다!!
    // * 주문 도메인 협력, 역할, 책임
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
