package chap3.music_player_control;

import java.util.Scanner;

public class MusicPlayerControlMain {
    public static void main(String[] args) {
        boolean isRun = true;
        boolean isOn = false;
        int volume = 0;

        while (isRun) {
            System.out.println("==================== 메뉴를 선택하세요 ====================");
            System.out.println("1.전원ON | 2.전원OFF | 3.볼륨UP | 4.볼륨DOWN | 5.상태확인");
            System.out.println("==================  (컨트롤러 종료 : 0)  ==================");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();
            switch(option) {
                case 1:
                    if(isOn){
                        System.out.println("이미 전원이 켜져 있습니다. 볼륨 : " + volume);
                        break;
                    }else{
                        System.out.println("음악 플레이어 ON");
                        isOn = true;
                        break;
                    }
                case 2:
                    if(!isOn){
                        System.out.println("이미 전원이 꺼져 있습니다.");
                        break;
                    }else{
                        System.out.println("음악 플레이어 OFF");
                        isOn = false;
                        break;
                    }
                case 3:
                    if(!isOn){
                        System.out.println("음악 플레이어 전원이 꺼져 있습니다.");
                        break;
                    }else if(volume == 10) {
                        System.out.println("최대 볼륨입니다. 볼륨 : " + volume);
                        break;
                    }else{
                        System.out.println("볼륨 UP, 볼륨 : " + ++volume);
                        break;
                    }
                case 4:
                    if(!isOn){
                        System.out.println("음악 플레이어 전원이 꺼져 있습니다.");
                        break;
                    }else if(volume == 0){
                        System.out.println("현재 볼륨이 0입니다.");
                        break;
                    }else{
                        System.out.println("볼륨 DOWN, 볼륨 : " + --volume);
                        break;
                    }
                case 5:
                    if(isOn){
                        System.out.println("Now Playing, 볼륨 : " + volume);
                        break;
                    }else{
                        System.out.println("전원이 꺼져 있습니다.");
                        break;
                    }
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
