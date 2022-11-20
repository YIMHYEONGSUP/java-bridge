package bridge;

import java.util.List;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicReference;

import static bridge.GameMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /*
     * 게임 시작 메세지 출력
     * */
    public void startMessage() {
        System.out.println(START_GAME.message());
    }

    /*
    * 다리 길이 입력 안내 문구 출력
    * */
    public void inputBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE.message());
    }

    /*
    * 입력 받은 다리길이 출력
    * */
    public void inputtedBridgeSize(int bridgeSize) {
        System.out.println(bridgeSize);
    }

    /*
    * 이동할 칸 입력 안내 문구 출력
    * */
    public void inputToMove() {
        System.out.println(INPUT_TO_MOVE.message());
    }
    public void inputtedToMove(String move) {
        System.out.println(move);
    }
    /*
    * 게임 재시작/종료 탐색 안내 문구 출력
    * */
    public void inputReGame() {
        System.out.println(INPUT_REGAME.message());
    }






    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge , int index) {
        String up = "[";
        String down = "[";

        for (int i = 0; i < index; i++) {
            String square = bridge.get(i);

            if (square.equals("U")) {
                up += " O ";
                down += "   ";
            }

            if (square.equals("D")) {
                down += " O ";
                up += "   ";
            }

            if (index >= 2 && i < index-1) {
                up += "|";
                down += "|";
            }
        }

        up += "]";
        down += "]";

        System.out.println(up);
        System.out.println(down);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
