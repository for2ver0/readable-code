package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudyCafeSeatPassTest {

    @DisplayName("시간 단위 이용권은 사물함을 사용할 수 없다.")
    @Test
    void hourly_pass_type_cannot_use_locker() {
        // given
        StudyCafePassType passType = StudyCafePassType.HOURLY;
        int duration = 0;
        int price = 0;
        double discountRate = 0;

        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(passType, duration, price, discountRate);

        // when
        boolean lockerAvailable = studyCafeSeatPass.cannotUseLocker();

        // then
        Assertions.assertTrue(lockerAvailable);
    }

    @DisplayName("주 단위 이용권은 사물함을 사용할 수 없다.")
    @Test
    void weekly_pass_type_cannot_use_locker() {
        // given
        StudyCafePassType passType = StudyCafePassType.WEEKLY;
        int duration = 0;
        int price = 0;
        double discountRate = 0;

        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(passType, duration, price, discountRate);

        // when
        boolean lockerAvailable = studyCafeSeatPass.cannotUseLocker();

        // then
        Assertions.assertTrue(lockerAvailable);
    }

    @DisplayName("고정석 이용권만 사물함을 사용할 수 있다.")
    @Test
    void fixed_pass_type_can_use_locker() {
        // given
        StudyCafePassType passType = StudyCafePassType.FIXED;
        int duration = 0;
        int price = 0;
        double discountRate = 0;

        StudyCafeSeatPass studyCafeSeatPass = StudyCafeSeatPass.of(passType, duration, price, discountRate);

        // when
        boolean lockerNotAvailable = studyCafeSeatPass.cannotUseLocker();

        // then
        Assertions.assertFalse(lockerNotAvailable);
    }

}