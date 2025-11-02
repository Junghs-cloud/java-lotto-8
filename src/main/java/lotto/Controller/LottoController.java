package lotto.Controller;

import lotto.View.InputView;
import lotto.Model.*;
import lotto.View.*;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final List<Lotto> releasedLottos = new ArrayList<Lotto>();


    public void execute() {
        int purchaseAmount = getPurchaseInput();
        int lottoAmount = purchaseAmount / Lotto.COST;
    }

    private int getPurchaseInput() {
        while (true) {
            try {
                String purchaseAmount = inputView.getPurchaseAmount();
                return Integer.parseInt(purchaseAmount);
            } catch (IllegalArgumentException exception) {
                System.out.println("[ERROR] 입력 값은 정수여야 합니다.");
            }
        }
    }
}
