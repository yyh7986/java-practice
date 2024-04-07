package chap3.number_baseball;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GameMenu {
    Scanner sc = new Scanner(System.in);
    private int count;
    NumberCheck numberCheck = new NumberCheck();
    public void mainMenu(){
        numberCheck.generateAnsNum();
        System.out.println("숫자 야구를 시작합니다. 컴퓨터가 생성한 3자리의 숫자를 맞춰보세요.");
        System.out.println("===== Play Ball =====");
        numberCheck.printAnsNum();
        boolean isHomerun = false;
        while (!isHomerun) {
            System.out.print(++count + "번째 시도 : ");
            isHomerun = checkNumber(sc.nextInt());
        }
    }

    public boolean checkNumber(int userNum) {
        List<Integer> userNumList = new ArrayList<>();
        int firstDigit = userNum / 100;
        int secondDigit = (userNum - (firstDigit * 100)) / 10;
        int thirdDigit = userNum - (firstDigit * 100) - (secondDigit * 10);
        userNumList.add(firstDigit);
        userNumList.add(secondDigit);
        userNumList.add(thirdDigit);

        return numberCheck.checkNumber(userNumList);
    }
}
