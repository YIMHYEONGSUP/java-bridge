package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현


        List<String> bridge = settingGame();

        runGame(bridge);

    }

    private static void runGame(List<String> bridge ) {
        InputView input = new InputView();
        OutputView outputView = new OutputView();
        int index = 0;
        int tryCount = 1;

        while (true) {
            outputView.inputToMove();
            BridgeGame bridgeGame = new BridgeGame();
            String move = input.readMoving();
            outputView.inputtedToMove(move);
            boolean checkSquare = bridgeGame.move(bridge, move, index++);

            String reGame = "";
            // 칸 움직이기
            if (! checkSquare) {
                outputView.inputReGame();
                reGame = input.readGameCommand();
            }

            if(reGame.equals("R")){
                index = 0;
                tryCount++;
            }

            // 움직인 칸 출력
            if (index >= 1) {
//                System.out.println(bridge.subList(0, index));
                outputView.printMap(bridge , index);
            }

            if (reGame.equals("Q") || index == bridge.size()) {
                break;
            }


        }

        System.out.println("최종 게임 결과");
        outputView.printMap(bridge , index);

        if (index == bridge.size()) {
            System.out.println("게임 성공 여부 : 성공");
        }
        if (index < bridge.size()) {
            System.out.println("게임 성공 여부 : 실패");
        }
        System.out.println("총 시도한 횟수 : " + tryCount);
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
