package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassOrderTest {

    @DisplayName("주문한 이용권의 할인 금액을 계산한다.")
    @Test
    void calculate_the_discount_price_of_the_pass_order() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 4, 500000, 0.05);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 4, 20000);

        StudyCafePassOrder passOrder = StudyCafePassOrder.of(seatPass, lockerPass);

        // when
        int discountPrice = passOrder.getDiscountPrice();

        // then
        assertThat(discountPrice).isEqualTo(25000);
    }

}