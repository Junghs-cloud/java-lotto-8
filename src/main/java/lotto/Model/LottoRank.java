package lotto.Model;

public enum LottoRank {
    First("6개 일치 (2,000,000,000원)", 2000000000),
    Second("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    Third("5개 일치 (1,500,000원)", 1500000),
    Fourth("4개 일치 (50,000원)", 50000),
    Fifth("3개 일치 (5,000원)", 5000),
    Lose("낙첨", 0);

    private final String description;
    private final int winnings;

    LottoRank(String description, int winnings) {
        this.description = description;
        this.winnings = winnings;
    }

    public String getDescription() {
        return this.description;
    }

    public int getWinnings() {
        return this.winnings;
    }
}
