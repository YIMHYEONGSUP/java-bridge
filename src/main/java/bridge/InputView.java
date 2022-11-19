package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = Console.readLine();
        validationBridgeSize(input);
        return Integer.parseInt(input);
    }

    /**
    * 입력받은 다리 길이 검증.
    * 조건 : 한자리 또는 두자리 숫자 , 3 이상 20 이하 의 숫자
    * 정상 : 입력 받은 문자열 숫자로 변환 후 출력
    * 비정상 : IllegalArgumentException 반환 , 에러메세지 '[ERROR]' 출력
    * */
    private void validationBridgeSize(String input) {
        if (! Pattern.matches("\\d?\\d", input)) {
            System.out.println(ExceptionMessages.INVALID_BRIDGE_SIZE.message());
            throw new IllegalArgumentException("[ERROR]");
        }
        int bridgeSize = Integer.parseInt(input);
        if (bridgeSize > 20 || bridgeSize < 3) {
            System.out.println(ExceptionMessages.INVALID_BRIDGE_SIZE.message());
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        if (validationMove(input)) {
            return input;
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    private boolean validationMove(String input) {
        if (input.equals("U") || input.equals("D")) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
