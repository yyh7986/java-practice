package chap3.com.jongro.exam.uses;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MusicMenu {
    Scanner sc = new Scanner(System.in);
    MusicManager musicManager = new MusicManager();
    public void mainMenu() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("========== 메뉴 ==========");
            System.out.println("1. 곡 추가");
            System.out.println("2. 곡 전체 조회");
            System.out.println("3. 정렬하여 조회");
            System.out.println("4. 가수명으로 검색");
            System.out.println("5. 제목으로 검색");
            System.out.println("6. 곡 정보 수정");
            System.out.println("7. 곡 삭제");
            System.out.println("0. 프로그램 종료");

            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();
            // nextInt()로 정수를 입력한 후 엔터를 입력하면 buffer에 \n 개행문자가 남아있기 때문에 nextLine()으로 제거
            sc.nextLine();

            switch(menu) {
                case 1:
                    addList();
                    break;
                case 2:
                    selectList();
                    break;
                case 3:
                    sortList();
                    break;
                case 4:
                    searchMusic("artist");
                    break;
                case 5:
                    searchMusic("title");
                    break;
                case 6:
                    updateMusic();
                    break;
                case 7:
                    removeMusic();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("잘못 선택하셨습니다. 번호를 다시 입력해주세요.");
                    break;
            }

        }
    }
    public void addList() {
        System.out.println("===== 곡 추가 =====");
        System.out.print("가수 입력 : ");
        String artistName = sc.nextLine();
        System.out.print("제목 입력 : ");
        String title = sc.nextLine();

        musicManager.addList(artistName, title);
    }

    public void selectList() {
        System.out.println("===== 곡 전체 조회 =====");
        List<MusicDTO> musicList = musicManager.selectList();

        if (musicList.isEmpty()) {
            System.out.println("목록이 존재하지 않습니다.");
            return;
        }

        for (MusicDTO music : musicList) {
            System.out.println(music);
        }
    }

    public void sortList(){
        boolean isValidNumber = true;
        List<MusicDTO> musicList = musicManager.selectList();
        do {
            System.out.println("===== 정렬 메뉴 =====");
            System.out.println("1. 가수명 오름차순 정렬");
            System.out.println("2. 곡명 오름차순 정렬");
            System.out.println("3. 가수명 내림차순 정렬");
            System.out.println("4. 곡명 내림차순 정렬");
            System.out.println("0. 메뉴로 돌아가기");
            System.out.print("메뉴 선택 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            List<MusicDTO> sortList = new ArrayList<>();
            sortList.addAll(musicList);
            switch(menu) {
                case 1:
                    sortList.sort(new AscArtist());
                    break;
                case 2:
                    sortList.sort(new AscTitle());
                    break;
                case 3:
                    sortList.sort(new DscArtist());
                    break;
                case 4:
                    sortList.sort(new Comparator<MusicDTO>() {
                        @Override
                        public int compare(MusicDTO o1, MusicDTO o2) {
                            return o2.getTitle().compareTo(o1.getTitle());
                        }
                    });
                    System.out.println("4번 선택");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못 선택하셨습니다. 번호를 다시 입력해주세요.");
                    isValidNumber = false;
                    break;
            }
            for (MusicDTO music : sortList) {
                System.out.println(music);
            }
        } while (!isValidNumber);

    }

    public void searchMusic(String searchType){
        if (musicManager.musicList.isEmpty()) {
            System.out.println("목록이 존재하지 않습니다.");
            return;
        }
        if (searchType.equals("artist")) {
            System.out.println("===== 가수명으로 검색 =====");
            System.out.print("가수명 입력 : ");
        } else if (searchType.equals("title")) {
            System.out.println("===== 제목으로 검색 =====");
            System.out.print("제목 입력 :");
        } /*else {
             예외처리로 구현해보기
        }*/
        musicManager.searchMusic(searchType, sc.nextLine());
    }
    private void updateMusic() {
        System.out.println("===== 곡 정보 수정 =====");
        System.out.print("수정할 곡의 id : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("수정할 가수명 : ");
        String artist = sc.nextLine();
        System.out.print("수정할 제목 : ");
        String title = sc.nextLine();

        musicManager.updateMusic(id, artist, title);
    }
    private void removeMusic() {
        System.out.println("===== 곡 삭제 =====");
        System.out.print("삭제할 곡의 id : ");
        int removeId = sc.nextInt();
        musicManager.removeMusic(removeId);
    }
}
