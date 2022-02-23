package lotto_game.controller;

import lotto_game.service.LottoManager;
import lotto_game.util.LottoStatistic;
import lotto_game.domain.LottoResult;
import lotto_game.domain.LottoTicket;
import lotto_game.domain.WinningNumbers;
import lotto_game.view.InputView;
import lotto_game.view.OutputView;

public class LottoController {

    public void run() {
        LottoManager lottoManager = new LottoManager();

        // 구입 금액 입력
        int purchaseMoney = InputView.inputPrice();

        // 로또 티켓 생성
        LottoTicket lottoTicket = lottoManager.makeLottoTicket(purchaseMoney);

        // 로또 티켓 정보 출력
        OutputView.printCountOfLotto(lottoTicket);
        OutputView.printLottoNumbers(lottoTicket);

        // 당첨 번호, 보너스 번호 입력
        InputView.removeBlank();
        String winNumbers = InputView.inputWinNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        // 로또 당첨 번호 객체 생성
        WinningNumbers winningNumbers = lottoManager.makeWinningNumbers(winNumbers, bonusNumber);

        // 로또 티켓의 당첨 결과값이 담긴 객체 생성
        LottoResult lottoResult = lottoManager.makeLottoResult(lottoTicket, winningNumbers);

        // 통계 처리
        LottoStatistic lottoStatistics = new LottoStatistic();
        int rate = lottoStatistics.calculateProfitRate(lottoResult, purchaseMoney);

        // 통계 출력
        OutputView.printProfitRate(rate, lottoResult.getResultMap());
        InputView.close();
    }
}
