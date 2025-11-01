package lotto.View;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Console.*;

public class InputView {

    String getPurchaseAmount() {
        System.out.println("구매 금액을 입력해주세요.");
        return Console.readLine();
    }

    String getFirstPrizeNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
        return Console.readLine();
    }

    String getBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        return Console.readLine();
    }

}
