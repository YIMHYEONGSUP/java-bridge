package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<String> bridge = settingGame();
        int[] result = startGame(bridge);
        printResult(bridge , result);
    }

    private static void printResult(List<String> bridge , int[] result) {
        printSuccessOrFail(bridge , result);
        if (result[1] == bridge.size()) {
            System.out.println("게임 성공 여부 : 성공");
        }
        if (result[1] < bridge.size()) {
            System.out.println("게임 성공 여부 : 실패");
        }
        System.out.println("총 시도한 횟수 : " + result[0]);
    }

    private static void printSuccessOrFail(List<String> bridge , int[] result) {
        OutputView outputView = new OutputView();
        System.out.println("최종 게임 결과");
        outputView.printMap(bridge , result[0]);
    }

    private static int[] startGame(List<String> bridge) {
        int count = 1;
        int result = 0;
        while (true) {
            result = runGame(bridge);
            if (result == bridge.size()) {
                break;
            }
            if (finishGame(result)) {
                break;
            }
            count++;
        }
        return new int[] {count , result};
    }

    private static boolean finishGame(int result) {
        inputReGame();
        String reGame = ReGame();
        if (reGame.equals("Q")) {
            return true;
        }
        return false;
    }

    private static String ReGame() {
        InputView inputView = new InputView();
        return inputView.readGameCommand();
    }

    private static void inputReGame() {
        OutputView outputView = new OutputView();
        outputView.inputReGame();
    }

    private static int runGame(List<String> bridge) {
        BridgeGame bridgeGame = new BridgeGame();
        int index = 0;
        while (true) {
            String move = move();
            boolean square = bridgeGame.move(bridge, move, index++);
            printMove(bridge , index);
            String reGame = invalidSquare(square);
            if(reGame.equals("R")){
                index = 0;
            }
            if (reGame.equals("Q") || index == bridge.size()) {
                break;
            }
        }
        return index;
    }

    private static String invalidSquare(boolean square) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        if (!square) {
            outputView.inputReGame();
            return inputView.readGameCommand();
        }
        return "";
    }

    private static void printMove(List<String> bridge , int index) {
        OutputView outputView = new OutputView();
        // 움직인 칸 출력
        if (index >= 1) {
            outputView.printMap(bridge , index);
        }
    }

    private static String move() {
        printInputMove();
        String move = inputMove();
        inputtedMove(move);
        return move;
    }

    private static void inputtedMove(String move) {
        OutputView outputView = new OutputView();
        outputView.inputtedToMove(move);
    }

    private static void printInputMove() {
        OutputView outputView = new OutputView();
        outputView.inputToMove();
    }

    private static String inputMove() {
        InputView inputView = new InputView();
        String move = inputView.readMoving();
        return move;
    }

    private static List<String> settingGame() {
        OutputView outputView = new OutputView();
        outputView.startMessage();
        outputView.inputBridgeSize();
        InputView input = new InputView();
        int bridgeSize = input.readBridgeSize();
        outputView.inputtedBridgeSize(bridgeSize);
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
