package lotto.Controller;

import lotto.View.InputView;
import lotto.Model.*;
import lotto.View.*;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final List<Lotto> releasedLottos = new ArrayList<Lotto>();

    private final static String LOTTO_SPLIT_DELIMITER = ",";

    public void execute() {
        int purchaseAmount = getPurchaseInput();
        int lottoAmount = purchaseAmount / Lotto.COST;
        Lotto firstPrizeLotto = getFirstPrizeLotto();
    }

    private int getPurchaseInput() {
        while (true) {
            try {
                String purchaseAmount = inputView.getPurchaseAmount();
                //검증
                return Integer.parseInt(purchaseAmount);
            } catch (IllegalArgumentException exception) {
                System.out.println("[ERROR] 입력 값은 정수여야 합니다.");
            }
        }
    }

    private Lotto getFirstPrizeLotto() {
        while (true) {
            try {
                String inputWinningLotto = inputView.getFirstPrizeNumbers();
                String[] rawLottoNumbers = inputWinningLotto.split(LOTTO_SPLIT_DELIMITER);
                //검증
                IntStream rawLottoNumbersStream = Arrays.stream(rawLottoNumbers).mapToInt(Integer::parseInt);
                List<Integer> lottoNumbers = rawLottoNumbersStream.boxed().toList();
                return new Lotto(lottoNumbers);
            } catch (IllegalArgumentException exception) {
                System.out.println("[ERROR] 입력 값은 정수여야 합니다.");
            }
        }
    }
}
