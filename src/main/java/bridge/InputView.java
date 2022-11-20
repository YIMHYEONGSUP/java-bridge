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
        try {
            validationBridgeSize(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            readBridgeSize();
        }
        return Integer.parseInt(input);
    }

    private boolean validationBridgeSize(String input) throws IllegalArgumentException{
        if (validationBridgeSizeType(input) ){
            if (validationBridgeSizeRange(input)) {
                return true;
            }
        }
        throw new IllegalArgumentException();
    }

    private boolean validationBridgeSizeRange(String input) {
        int bridgeRange = Integer.parseInt(input);
        if (bridgeRange >= 3 && bridgeRange <= 20) {
            return true;
        }
        return false;
    }

    private boolean validationBridgeSizeType(String input) {
        if (Pattern.matches("\\d?\\d", input)) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input = Console.readLine();
        try {
            validationMoving(input);
        } catch (IllegalArgumentException e) {
            readMoving();
            System.out.println("[ERROR]");
        }
        return input;
    }

    private boolean validationMoving(String input) throws IllegalArgumentException{
        if (input.equals("U") || input.equals("D")) {
            return true;
        }
        throw new IllegalArgumentException();
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = Console.readLine();
        try {
            validationReGame(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            readGameCommand();
        }
        return input;
    }

    private boolean validationReGame(String input) {
        if (input.equals("R") || input.equals("Q")) {
            return true;
        }
        return false;
    }
}