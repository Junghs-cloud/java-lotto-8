package lotto.View;

import lotto.Lotto;

import java.util.List;

public class OutputView {

    public void printLottos(List<Lotto> releasedLottos) {
        System.out.println(STR."\{releasedLottos.size()}개를 구매했습니다.");
        for (Lotto lotto: releasedLottos) {
            System.out.println(lotto.getNumbers().toString());
        }
        System.out.println();
    }
}
