package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafeSeatPassesTest {

    @DisplayName("좌석 이용권 중에서 주어진 이용권 타입과 동일한 타입의 좌석 이용권을 찾는다.")
    @Test
    void find_seat_passes_of_the_same_type_as_the_given_pass_type() {
        // given
        StudyCafeSeatPass givenPass1 = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 0, 0, 0.0);
        StudyCafeSeatPass givenPass2 = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 0, 0, 0.0);
        StudyCafeSeatPass givenPass3 = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 0, 0, 0.0);
        StudyCafeSeatPass givenPass4 = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 1, 2000, 0.0);
        StudyCafeSeatPass givenPass5 = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 2, 200000, 0.0);
        StudyCafeSeatPass givenPass6 = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 12, 20000, 0.05);

        List<StudyCafeSeatPass> passes = new ArrayList<>();
        passes.add(givenPass1);
        passes.add(givenPass2);
        passes.add(givenPass3);
        passes.add(givenPass4);
        passes.add(givenPass5);
        passes.add(givenPass6);

        StudyCafeSeatPasses seatPasses = StudyCafeSeatPasses.of(passes);

        StudyCafePassType givenPassType = StudyCafePassType.HOURLY;

        // when
        List<StudyCafeSeatPass> result = seatPasses.findPassBy(givenPassType);

        // then
        assertThat(result.get(0)).isEqualTo(givenPass3);
        assertThat(result.get(1)).isEqualTo(givenPass4);
        assertThat(result.get(2)).isEqualTo(givenPass6);
    }

}