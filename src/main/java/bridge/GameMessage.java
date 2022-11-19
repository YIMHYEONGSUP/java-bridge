package bridge;

public enum GameMessage {

    START_GAME("다리 건너기 게임을 시작합니다.") ,
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요.") ,
    INPUT_TO_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)") ,
    INPUT_REGAME("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)") ,
    RESULT("최종 게임 결과") ,
    SUCCESS("게임 성공 여부: 성공") ,
    FAIL("게임 성공 여부: 실패") ,
    TRY_COUNT("총 시도한 횟수:");

    private String message;

    GameMessage(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

}
