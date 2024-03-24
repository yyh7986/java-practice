package lotto;

import java.util.Arrays;

public class LottoNumberGenerator {
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            LottoNumberGenerator.lottoNumberGenerate();
        }
    }
    public static void lottoNumberGenerate(){
        // 공 45개 생성
        int[] ball = new int[45];
        for (int i = 0; i < ball.length; i++) {
            ball[i] = i + 1;
        }

        // 공 섞기 (랜덤한 공을 첫번째 공과 교체)
        for(int i = 0; i < 365; i++){
            int randNum = (int)(Math.random() * ball.length);
            int temp = ball[0];
            ball[0] = ball[randNum];
            ball[randNum] = temp;
        }

        // 섞인 공들 중 앞에서 6개 뽑기
        int[] lottoNumbers = new int[6];
        System.arraycopy(ball, 0, lottoNumbers, 0, lottoNumbers.length);
        System.out.println(Arrays.toString(lottoNumbers));

        // 오름차순 정렬
        /*for (int i = 1; i < lottoNumbers.length; i++) {
            for (int j = 0; j < i; j++) {
                if(lottoNumbers[j] > lottoNumbers[i]){
                    int temp = lottoNumbers[j];
                    lottoNumbers[j] = lottoNumbers[i];
                    lottoNumbers[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(lottoNumbers));*/

        // 버블정렬
        for (int i = 0; i < lottoNumbers.length - 1; i++) {
            boolean changed = false;

            for (int j = 0; j < lottoNumbers.length - 1 - i; j++) {
                if(lottoNumbers[j] > lottoNumbers[j + 1]){
                    int temp = lottoNumbers[j];
                    lottoNumbers[j] = lottoNumbers[j + 1];
                    lottoNumbers[j + 1] = temp;
                    changed = true;
                }
            }
        }
        System.out.println(Arrays.toString(lottoNumbers));
    }
}
