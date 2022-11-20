package bridge;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.AssertProvider;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class JunitTest extends IoTest{


    @Nested
    @DisplayName("중첩 테스트")
    class TestExample {

        @Nested
        @DisplayName("입력 테스트")
        class input {
            @ParameterizedTest
            @ValueSource(strings = {"3" , "20"})
            @DisplayName("정상 입력")
            void valid_input(String input) {
                SystemIn(input);
                assertThat((AssertProvider<Integer>) () -> new InputView().readBridgeSize())
                        .compareTo(3);
            }
            @ParameterizedTest
            @ValueSource(strings = {"2" , "21" , "200" , "안녕하세요" , "1j"})
            @DisplayName("비정상 입력")
            void invalid_input(String input) {
                SystemIn(input);
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

        @Nested
        @DisplayName("출력 테스트")
        class output {
            @Test
            @DisplayName("정상 출력")
            void valid_input() {
                System.out.println("정상");
            }
        }

    }




}
