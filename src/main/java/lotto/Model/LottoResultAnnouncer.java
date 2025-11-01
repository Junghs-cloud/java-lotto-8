package lotto.Model;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResultAnnouncer {
    private List<Lotto> releasedLottos;
    private WinningLotto winningLotto;

    public LottoResultAnnouncer(List<Lotto> releasedLottos, WinningLotto winningLotto) {
        this.releasedLottos = releasedLottos;
        this.winningLotto = winningLotto;
    }

    public Map<LottoRank, Integer> getLottoRankResults() {
        List<LottoRank> lottoRankResults = new ArrayList<>();
        for (Lotto lotto: releasedLottos)
                lottoRankResults.add(lotto.compareWithWinningLotto(winningLotto));
        return lottoRankResults.stream().collect(Collectors.groupingBy(e -> e, Collectors.summingInt(e -> 1)));
    }
}
