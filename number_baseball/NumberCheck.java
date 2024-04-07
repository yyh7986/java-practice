package chap3.number_baseball;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class NumberCheck {
    List<Integer> answerNum = new ArrayList<>();
    Random rand = new Random();
    public void generateAnsNum(){
        for (int i = 0; i < 3; i++) {
            answerNum.add(rand.nextInt(9) + 1);
            for (int j = 0; j < i; j++) {
                if (answerNum.get(i).equals(answerNum.get(j))) {
                    answerNum.remove(i);
                    i--;
                }
            }
        }
    }
    public void printAnsNum(){
        for (Integer i : answerNum) {
            System.out.print(i);
        }
        System.out.println();
    }

    public boolean checkNumber(List<Integer> numberList) {
        int strike = 0, ball = 0, out = 0;
        for (int i = 0; i < answerNum.size(); i++) {
            if (answerNum.get(i).equals(numberList.get(i))) {
                strike++;
                continue;
            }else if(answerNum.contains(numberList.get(i))){
                ball++;
                continue;
            }else{
                out++;
            }
        }
        if (strike == 3) {
            System.out.println("정답입니다!");
            return true;
        } else {
            System.out.printf("%d스트라이크 %d볼 %d아웃%n", strike, ball, out);
            return false;
        }
    }
}
