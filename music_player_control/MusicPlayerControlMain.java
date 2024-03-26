package chap3.music_player_control;

import java.util.Scanner;

public class MusicPlayerControlMain {
    public static void main(String[] args) {
        boolean isRun = true;
        MusicPlayerContoller control = new MusicPlayerContoller();
        while (isRun) {
            System.out.println("==================== 메뉴를 선택하세요 ====================");
            System.out.println("1.전원ON | 2.전원OFF | 3.볼륨UP | 4.볼륨DOWN | 5.상태확인");
            System.out.println("==================  (컨트롤러 종료 : 0)  ==================");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            switch(option) {
                case 1:
                    control.on();
                    break;
                case 2:
                    control.off();
                    break;
                case 3:
                    control.volumeUp();
                    break;
                case 4:
                    control.volumeDown();
                    break;
                case 5:
                    control.showStatus();
                    break;
                case 0:
                    System.out.println("컨트롤러를 종료합니다.");
                    isRun = false;
                    break;
                default:
                    System.out.println("올바른 메뉴를 입력하세요.");
            }

        }

    }
}
