package bridge;

import org.assertj.core.api.AssertProvider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class JunitTest {


    @Nested
    @DisplayName("중첩 테스트")
    class TestExample {

        @Nested
        @DisplayName("입력 테스트")
        class input {
            @Test
            @DisplayName("정상 입력")
            void valid_input() {
                assertThat((AssertProvider<Integer>) () -> new InputView().readBridgeSize("3"))
                        .compareTo(3);
            }
            @Test
            @DisplayName("비정상 입력")
            void invalid_input() {
                assertThatThrownBy(() -> new InputView().readBridgeSize("2"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]");
            }
        }

    }


}
