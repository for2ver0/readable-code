package cleancode.studycafe.tobe.model.pass;

import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
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

    @DisplayName("좌석 이용권과 사물함 이용권의 이용권 타입과 기간이 동일하다.")
    @Test
    void The_type_and_duration_of_the_seat_pass_and_the_locker_pass_are_same() {
        // given
        StudyCafePassType seatPassType = StudyCafePassType.HOURLY;
        int seatDuration = 4;
        int seatPrice = 0;
        double discountRate = 0;

        StudyCafePassType lockerPassType = StudyCafePassType.HOURLY;
        int lockerDuration = 4;
        int lockerPrice = 0;

        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(seatPassType, seatDuration, seatPrice, discountRate);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(lockerPassType, lockerDuration, lockerPrice);

        // when
        boolean sameDurationType = seatPass.isSameDurationType(lockerPass);

        // then
        Assertions.assertTrue(sameDurationType);
    }

    @DisplayName("좌석 이용권과 사물함 이용권의 타입은 동일하나 기간은 다르다.")
    @Test
    void The_type_of_the_seat_pass_and_the_locker_pass_are_same_but_the_duration_is_not() {
        // given
        StudyCafePassType seatPassType = StudyCafePassType.HOURLY;
        int seatDuration = 4;
        int seatPrice = 0;
        double discountRate = 0;

        StudyCafePassType lockerPassType = StudyCafePassType.HOURLY;
        int lockerDuration = 12;
        int lockerPrice = 0;

        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(seatPassType, seatDuration, seatPrice, discountRate);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(lockerPassType, lockerDuration, lockerPrice);

        // when
        boolean differentDurationType = seatPass.isSameDurationType(lockerPass);

        // then
        Assertions.assertFalse(differentDurationType);
    }

    @DisplayName("좌석 이용권과 사물함 이용권의 타입은 다르나 기간은 동일하다.")
    @Test
    void The_type_and_duration_of_the_seat_pass_and_the_locker_pass_are_different() {
        // given
        StudyCafePassType seatPassType = StudyCafePassType.HOURLY;
        int seatDuration = 4;
        int seatPrice = 0;
        double discountRate = 0;

        StudyCafePassType lockerPassType = StudyCafePassType.WEEKLY;
        int lockerDuration = 4;
        int lockerPrice = 0;

        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(seatPassType, seatDuration, seatPrice, discountRate);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(lockerPassType, lockerDuration, lockerPrice);

        // when
        boolean differentDurationType = seatPass.isSameDurationType(lockerPass);

        // then
        Assertions.assertFalse(differentDurationType);
    }

    @DisplayName("좌석 이용권과 사물함 이용권의 이용권 타입과 기간이 다르다.")
    @Test
    void The_type_of_the_seat_pass_and_the_locker_pass_are_diff_but_the_duration_is_same() {
        // given
        StudyCafePassType seatPassType = StudyCafePassType.HOURLY;
        int seatDuration = 4;
        int seatPrice = 0;
        double discountRate = 0;

        StudyCafePassType lockerPassType = StudyCafePassType.WEEKLY;
        int lockerDuration = 12;
        int lockerPrice = 0;

        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(seatPassType, seatDuration, seatPrice, discountRate);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(lockerPassType, lockerDuration, lockerPrice);

        // when
        boolean differentDurationType = seatPass.isSameDurationType(lockerPass);

        // then
        Assertions.assertFalse(differentDurationType);
    }

}