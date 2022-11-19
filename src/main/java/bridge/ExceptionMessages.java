package bridge;

public enum ExceptionMessages {

    INVALID_BRIDGE_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.") ,
    INVALID_MOVE("[ERROR] 이동할 수 있는 칸은 U 또는 D 입니다.") ,
    INVALID_REGAME("[ERROR] 재시작은 R 종료는 Q를 입력해주세요.");

    private String message;

    ExceptionMessages(final String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

}
