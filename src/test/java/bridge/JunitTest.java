package bridge;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.AssertProvider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class JunitTest {


    @Nested
    @DisplayName("중첩 테스트")
    class TestExample {

        @Nested
        @DisplayName("입력 테스트")
        class input {
            @ParameterizedTest
            @DisplayName("정상 입력")
            void valid_input() {
                assertThat((AssertProvider<Integer>) () -> new InputView().readBridgeSize())
                        .compareTo(3);
            }
            @Test
            @DisplayName("비정상 입력")
            void invalid_input() {
                assertThatThrownBy(() -> new InputView().readBridgeSize())
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("[ERROR]");
            }
        }

        @Nested
        @DisplayName("기능 테스트")
        class logic {
            @Test
            @DisplayName("다리 생성")
            void generate_bridge() {
                assertThat((AssertProvider<BridgeMaker>) () ->
                        new BridgeMaker(() ->
                                new BridgeRandomNumberGenerator().generate())).makeBridge(6);
            }
        }


    }


}
