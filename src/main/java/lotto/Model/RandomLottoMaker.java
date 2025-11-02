package lotto.Model;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomLottoMaker {

    public static List<Lotto> makeLottos(List<Lotto> lottos, int count) {
        for (int i=1;i<=count;i++) {
            lottos.add(makeLotto());
        }
        return lottos;
    }

    private static Lotto makeLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

}
