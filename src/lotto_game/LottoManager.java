package lotto_game;

import lotto_game.view.InputView;
import lotto_game.view.OutputView;

public class LottoManager {
    public void createLottos() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoStatistics statistics = new LottoStatistics();

        Lottos lottos = new Lottos(inputView.inputPrice() / 1000);
        outputView.printLottoSize(lottos);
        outputView.printLottos(lottos);

        outputView.printIncomeRate(statistics.IncomeRate(inputView.inputWinNumber(), lottos),
                statistics.winCount());
    }

}
