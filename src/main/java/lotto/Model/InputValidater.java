package lotto.Model;
import lotto.Lotto;

import java.util.List;

public class InputValidater {
    final static String INPUT_NOT_INT = "[ERROR] 입력 값은 정수여야 합니다.";
    final static String INPUT_NOT_DIVIDE_LOTTO_COST = STR."[ERROR] 입력 값은 \{Lotto.COST}로 나누어 떨어져야 합니다.";
    final static String INPUT_NOT_BETWEEN_LOTTO_NUM = STR."[ERROR] 로또 번호는 \{Lotto.MIN_VALUE}부터 \{Lotto.MAX_VALUE} 사이의 값이어야 합니다.";
    final static String INPUT_DUPLICATE_WITH_WINNING_LOTTO = "[ERROR] 보너스 번호가 로또 번호와 중복입니다.";

    public static void validatePurchaseAmount(String purchaseAmount) {
        try {
            int purchase = Integer.parseInt(purchaseAmount);
            if (purchase % Lotto.COST != 0) {
                throw new IllegalArgumentException(INPUT_NOT_DIVIDE_LOTTO_COST);
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_NOT_INT);
        }
    }

    public static void validateFirstPrizeNumbers(List<String> lottoNumbers) {
        boolean allNumeric = lottoNumbers.stream().allMatch(InputValidater::isNumeric);
        if (!allNumeric) {
            throw new IllegalArgumentException(INPUT_NOT_INT);
        }
    }

    public static void validateBonusNumber(Lotto firstPrizeLotto, String rawBonusNumber) {
        if (!isNumeric(rawBonusNumber)) {
            throw new IllegalArgumentException(INPUT_NOT_INT);
        }
        int bonusNumber = Integer.parseInt(rawBonusNumber);
        if (bonusNumber < Lotto.MIN_VALUE || bonusNumber > Lotto.MAX_VALUE) {
            throw new IllegalArgumentException(INPUT_NOT_BETWEEN_LOTTO_NUM);
        }
        if (firstPrizeLotto.checkIfMatchBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_WITH_WINNING_LOTTO);
        }
    }

    private static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}