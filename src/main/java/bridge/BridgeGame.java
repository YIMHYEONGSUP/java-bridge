package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(List<String> bridge , String move , int index) {
        if (! validationMove(move)) {
            throw new IllegalArgumentException("[ERROR]");
        }
        String now = bridge.get(index);
        if (now.equals(move)) {
            return true;
        }
        return false;
    }

    private boolean validationMove(String move) {
        if (move.equals("U") || move.equals("D")) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String reGame) {
        if (reGame.equals("R")) {
            return true;
        }
        return false;
    }
}
