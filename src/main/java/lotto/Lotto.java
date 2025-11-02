package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lotto.Model.ErrorMessages;
import lotto.Model.WinningLotto;
import lotto.Model.LottoRank;

public class Lotto {
    private final List<Integer> numbers;

    public static final int COST = 1000;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
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

    public LottoRank compareWithWinningLotto(WinningLotto winningLotto) {
        List<Integer> firstPrizeNumbers = winningLotto.getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();
        int numberMatchCount = getMatchCount(firstPrizeNumbers);
        return getLottoRank(bonusNumber, numberMatchCount);
    }

    private int getMatchCount(List<Integer> firstPrizeNumbers) {
        Set<Integer> common = new HashSet<>(this.numbers);
        common.retainAll(firstPrizeNumbers);
        return common.size();
    }

    private LottoRank getLottoRank(int bonusNumber, int numberMatchCount) {
        if (numberMatchCount == 6)
            return LottoRank.First;
        if (numberMatchCount == 5 && checkIfMatchBonusNumber(bonusNumber))
            return LottoRank.Second;
        if (numberMatchCount == 5 && !checkIfMatchBonusNumber(bonusNumber))
            return LottoRank.Third;
        if (numberMatchCount == 4)
            return LottoRank.Fourth;
        if (numberMatchCount == 3)
            return LottoRank.Fifth;
        return LottoRank.Lose;
    }
}
