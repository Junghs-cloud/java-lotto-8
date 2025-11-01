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

import static lotto.Model.InputValidater.validatePurchaseAmount;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final List<Lotto> releasedLottos = new ArrayList<Lotto>();

    private final static String LOTTO_SPLIT_DELIMITER = ",";

    public void execute() {
        int purchaseAmount = getPurchaseInput();
        int lottoAmount = purchaseAmount / Lotto.COST;
        Lotto firstPrizeLotto = getFirstPrizeLotto();
        int bonusNumber = getBonusNumber(firstPrizeLotto);
    }

    private int getPurchaseInput() {
        while (true) {
            try {
                String purchaseAmount = inputView.getPurchaseAmount();
                InputValidater.validatePurchaseAmount(purchaseAmount);
                return Integer.parseInt(purchaseAmount);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private Lotto getFirstPrizeLotto() {
        while (true) {
            try {
                String inputWinningLotto = inputView.getFirstPrizeNumbers();
                String[] rawLottoNumbers = inputWinningLotto.split(LOTTO_SPLIT_DELIMITER);
                InputValidater.validateFirstPrizeNumbers(List.of(rawLottoNumbers));
                IntStream rawLottoNumbersStream = Arrays.stream(rawLottoNumbers).mapToInt(Integer::parseInt);
                List<Integer> lottoNumbers = rawLottoNumbersStream.boxed().toList();
                return new Lotto(lottoNumbers);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private int getBonusNumber(Lotto firstPrizeLotto) {
        while (true) {
            try {
                String inputBonusNumber = inputView.getBonusNumber();
                InputValidater.validateBonusNumber(firstPrizeLotto, inputBonusNumber);
                return Integer.parseInt(inputBonusNumber);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
