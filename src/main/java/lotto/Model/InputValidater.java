package lotto.Model;
import lotto.Lotto;

import java.util.List;

public class InputValidater {

    public static void validatePurchaseAmount(String purchaseAmount) {
        try {
            int purchase = Integer.parseInt(purchaseAmount);
            if (purchase % Lotto.COST != 0) {
                throw new IllegalArgumentException(ErrorMessages.INPUT_NOT_DIVIDE_LOTTO_COST);
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_NOT_INT);
        }
    }

    public static void validateFirstPrizeNumbers(List<String> lottoNumbers) {
        boolean allNumeric = lottoNumbers.stream().allMatch(InputValidater::isNumeric);
        if (!allNumeric) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_NOT_INT);
        }
    }

    public static void validateBonusNumber(Lotto firstPrizeLotto, String rawBonusNumber) {
        if (!isNumeric(rawBonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_NOT_INT);
        }
        int bonusNumber = Integer.parseInt(rawBonusNumber);
        if (bonusNumber < Lotto.MIN_VALUE || bonusNumber > Lotto.MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_NOT_BETWEEN_LOTTO_NUM);
        }
        if (firstPrizeLotto.checkIfMatchBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_DUPLICATE_WITH_WINNING_LOTTO);
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