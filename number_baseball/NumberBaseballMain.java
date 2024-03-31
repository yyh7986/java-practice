package chap3.number_baseball;

import java.util.Arrays;
import java.util.Scanner;

public class NumberBaseballMain {
    public static void main(String[] args) {
        // 랜덤숫자 생성
        // 1~9 숫자 생성
        int[] numbers = new int[9];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        // 9개의 숫자배열 순서 섞기
        for (int i = 0; i < 100; i++) {
            int randNum = (int) (Math.random() * 9);
            int temp = numbers[0];
            numbers[0] = numbers[randNum];
            numbers[randNum] = temp;
        }
        // 섞인 숫자배열에서 순서대로 3개 뽑기
        int[] answerNum = new int[3];
        for (int i = 0; i < answerNum.length; i++){
            answerNum[i] = numbers[i];
        }
        System.out.println(Arrays.toString(answerNum));
        // 유저숫자 입력

        boolean isGameOver = false;
        Scanner input = new Scanner(System.in);
        int strike = 0;
        int ball = 0;
        int out = 0;
        System.out.println("숫자야구를 시작합니다. 3자리 숫자를 맞춰보세요");
        while(!isGameOver){
            System.out.print("3자리의 숫자를 입력하세요(중복없음) > ");
            String userNum = input.nextLine();

            // 테스트
            System.out.println("userNum = " + userNum);
            System.out.println("userNum.charAt(0) = " + userNum.charAt(0));

            strike += checkStrike(answerNum, userNum);
            ball += checkBall(answerNum, userNum);
            if (strike == 3) {
                System.out.println("정답입니다!");
                isGameOver = true;
                break;
            }else{
                System.out.printf("%d스트라이크 %d볼%n", strike, ball);
            }
            strike = 0;
            ball = 0;
        }
    }

    public static int checkStrike(int[] answerArr, String userArr){
        int strikeCount = 0;
        for (int i = 0; i < answerArr.length; i++) {
            if (answerArr[i] == userArr.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
    public static int checkBall(int[] answerArr, String userArr){
        int ballCount = 0;

        for (int i = 0; i < answerArr.length; i++) {
            for (int j = 0; j < answerArr.length; j++) {
                if(userArr.charAt(i) == answerArr[j]){
                    if (i == j) {
                        continue;
                    }
                    ballCount++;
                }
            }
        }

        return ballCount;
    }


    /*public static void makeRandomNumbers() {
        // 왜 아무것도 출력이 안될때가 있는지 모르겠음
        int[] answerNumbers = new int[3];
        for (int i = 0; i < answerNumbers.length; i++) {
            answerNumbers[i] = (int) (Math.random() * 9) + 1;
            for (int j = 0; j < i; j++) {
                if (answerNumbers[j] == answerNumbers[i]) {
                    i--;
                    return;
                }
            }
        }
        System.out.print(Arrays.toString(answerNumbers));
    }*/
}