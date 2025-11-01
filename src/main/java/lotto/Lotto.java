package lotto;

import java.util.Collections;
import java.util.List;

import lotto.Model.ErrorMessages;
import lotto.Model.InputValidater;

public class Lotto {
    private final List<Integer> numbers;

    public static final int COST = 1000;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessages.NUMBERS_SIZE_NOT_VALIDATE);
        }
        if (Collections.min(numbers) < MIN_VALUE || Collections.max(numbers) > MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_NOT_BETWEEN_LOTTO_NUM);
        }
        boolean hasDuplicated = numbers.stream().distinct().count() != numbers.size();
        if (hasDuplicated) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_NUMBERS_DUPLICATED);
        }
    }

    public boolean checkIfMatchBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
