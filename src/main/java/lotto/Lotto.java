package lotto;

import java.util.List;

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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public boolean checkIfMatchBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
