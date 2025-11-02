package lotto.Model;

import lotto.Lotto;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.round;

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

    public double calculateTotalRateOfReturn(Map<LottoRank, Integer> lottoRankResults) {
        long totalWinningPrize = 0L;
        List<LottoRank> a = new ArrayList<>(lottoRankResults.keySet());
        List<Integer> b = lottoRankResults.values().stream().toList();
        for (int i = 0; i < lottoRankResults.size(); i++) {
            totalWinningPrize += a.get(i).getWinnings() * (long) b.get(i);
        }
        return getTotalRateOfReturn(totalWinningPrize, releasedLottos.size());
    }

    private double getTotalRateOfReturn(long totalWinningPrize, int lottoAmount){
        double rawTotalRateOfReturn = (double) totalWinningPrize / ((double) (lottoAmount * Lotto.COST)) * 100;
        return (round(rawTotalRateOfReturn * 100.0) / 100.0);
    }
}
