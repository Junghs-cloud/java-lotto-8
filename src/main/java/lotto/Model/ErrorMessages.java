package lotto.Model;

import lotto.Lotto;

public class ErrorMessages {
    public final static String INPUT_NOT_INT = "[ERROR] 입력 값은 정수여야 합니다.";
    public final static String INPUT_NOT_DIVIDE_LOTTO_COST = "[ERROR] 입력 값은 1000으로 나누어 떨어져야 합니다.";
    public final static String INPUT_NOT_BETWEEN_LOTTO_NUM = "[ERROR] 로또 번호는 1부터 45 사이의 값이어야 합니다.";
    public final static String INPUT_DUPLICATE_WITH_WINNING_LOTTO = "[ERROR] 보너스 번호가 로또 번호와 중복입니다.";
    public final static String INPUT_NUMBERS_DUPLICATED = "[ERROR] 로또 번호는 중복되지 않아야 합니다.";
    public final static String NUMBERS_SIZE_NOT_VALIDATE = "[ERROR] 로또 번호는 6개여야 합니다.";
}
