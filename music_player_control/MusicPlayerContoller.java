package chap3.music_player_control;

public class MusicPlayerContoller {
    int volume = 0;
    boolean isOn = false;

    void on(){
        if(isOn){
            System.out.println("이미 전원이 켜져 있습니다. 볼륨 : " + volume);
        }else{
            System.out.println("음악 플레이어 ON");
            isOn = true;
        }
    }

    void off(){
        if(!isOn){
            System.out.println("이미 전원이 꺼져 있습니다.");
        }else{
            System.out.println("음악 플레이어 OFF");
            isOn = false;
        }
    }

    void volumeUp(){
        if(!isOn){
            System.out.println("음악 플레이어 전원이 꺼져 있습니다.");
        }else if(volume == 10) {
            System.out.println("최대 볼륨입니다. 볼륨 : " + volume);
        }else{
            System.out.println("볼륨 UP, 볼륨 : " + ++volume);
        }
    }

    void volumeDown(){
        if(!isOn){
            System.out.println("음악 플레이어 전원이 꺼져 있습니다.");
        }else if(volume == 0) {
            System.out.println("볼륨이 0입니다.");
        }else{
            System.out.println("볼륨 DOWN, 볼륨 : " + --volume);
        }
    }

    void showStatus(){
        if(isOn){
            System.out.println("Now Playing, 볼륨 : " + volume);
        }else{
            System.out.println("전원이 꺼져 있습니다.");
        }
    }
}
