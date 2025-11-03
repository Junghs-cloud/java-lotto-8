# 로또

## 체크 리스트

- [x] 입력 받기
    - [x] 구입 금액 입력
    - [x] 당첨 번호 입력
    - [x] 보너스 번호 입력
    - [x] 예외 상황 발생 시 에러 문구 출력하고 다시 시도
        - [x] 구입 금액이 1000원으로 나누어 떨어지지 않는 경우
        - [x] 구입 금액이 숫자가 아닌 경우
        - [x] 당첨 번호가 숫자가 아닌 경우
        - [x] 입력 받은 당첨 번호가 6개가 아닌 경우
        - [x] 보너스 번호가 숫자가 아닌 경우
        - [x] 보너스 번호가 로또 번호와 중복되는 경우
        - [x] 보너스 번호가 1부터 45 사이의 값이 아닌 경우
- [x] 로또 클래스 구현
    - [x] 중복된 값이 없어야 함
    - [x] 번호는 1부터 45 사이의 값이어야 함
- [x] 결과 출력하기
    - [x] 로또를 발행하고 수량과 번호 출력하기
    - [x] 당첨 내역 출력하기
    - [x] 수익률 출력하기

## 파일 구조

        📁lotto
        │
        │  🗒️Application.java
        │  🗒️Lotto.java
        │  
        ├─📁Controller
        │       🗒️LottoController.java
        │      
        ├─📁Model
        │       🗒️ErrorMessages.java
        │       🗒️InputValidater.java
        │       🗒️LottoRank.java
        │       🗒️LottoResultAnnouncer.java
        │       🗒️RandomLottoMaker.java
        │       🗒️WinningLotto.java
        │      
        └─📁View
                🗒️InputView.java
                🗒️OutputView.java



- Application.java: 전체 프로그램을 실행시킨다.
- LottoController.java: InputView를 이용하여 사용자의 입력을 받고 모델들을 이용하여 값을 구한다. 이후 OutputView에게 해당 값을 전달하여 답을 출력하도록 한다.


<br/>

- ErrorMessages.java: 에러 메시지를 저장하는 클래스
- InputValidater.java: 입력을 검증하는 클래스
- LottoRank.java: 로또가 몇등인지 알려주는 enum 클래스
- LottoResultAnnouncer.java: 발행한 로또와 당첨번호를 확인하여 몇등인지 확인 후, 수익률을 계산한다.
- RandomLottoMaker.java: 랜덤으로 6자리 숫자를 골라 로또를 발행한다.
- WinningLotto.java: 당첨번호를 저장하는 클래스


<br/>

- InputView.java: 입력을 담당한다.
- OutputView.java: 결과를 출력한다.