package lotto.View;

import lotto.Lotto;
import lotto.Model.LottoRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OutputView {


    public void printLottos(List<Lotto> releasedLottos) {
        System.out.println(releasedLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto: releasedLottos) {
            //System.out.println(lotto.getNumbers().toString());
        }
        System.out.println();
    }


    /*
    public void printLottoResults(Map<LottoRank, Integer> lottoRankResults, double totalRateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");
        List<LottoRank> printOrder = Arrays.asList(LottoRank.Fifth, LottoRank.Fourth, LottoRank.Third, LottoRank.Second, LottoRank.First);
        for (LottoRank lottoRank: printOrder)
            printEachLottoRankResult(lottoRankResults, lottoRank);
        String formattedTotalRateOfReturn = formatWithCommas(totalRateOfReturn);
        System.out.println("총 수익률은 " + formattedTotalRateOfReturn+ "%입니다.");
    }

    private String formatWithCommas(double totalRateOfReturn) {
        return String.format(String.valueOf(totalRateOfReturn));
    }

    private void printEachLottoRankResult(Map<LottoRank, Integer> lottoRankResults, LottoRank lottoRankToPrint) {
        int count = lottoRankResults.getOrDefault(lottoRankToPrint, 0);
        System.out.println(lottoRankToPrint.getDescription() + " - " + count+"개");
    }

     */

}