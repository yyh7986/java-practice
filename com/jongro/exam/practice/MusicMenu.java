package chap3.com.jongro.exam.practice;

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
            System.out.println("4. 가수 이름으로 검색");
            System.out.println("5. 제목으로 검색");
            System.out.println("6. 곡 정보 수정");
            System.out.println("7. 곡 삭제");
            System.out.println("0. 프로그램 종료");

            System.out.print("메뉴 선택 :");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    addMusic();
                    break;
                case 2:
                    selectList();
                    break;
                case 3:
                    sortList();
                    break;
                case 4:
                    searchList("가수이름");
                    break;
                case 5:
                    searchList("노래제목");
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
                    System.out.println("잘못 입력하셨습니다. 번호를 다시 입력해주세요.");
                    break;
            }
        }
    }

    public void addMusic() {
        System.out.println("===== 노래 추가 =====");
        System.out.print("가수 입력 :");
        String artistName = sc.nextLine();
        System.out.print("제목 입력 :");
        String title = sc.nextLine();

        musicManager.addList(artistName, title);
    }

    public void selectList() {
        if (isListEmpty()) return;
        for (MusicDTO music : musicManager.selectList()) {
            System.out.println(music);
        }
    }

    public void sortList() {
        if (isListEmpty()) return;
        boolean isMenuValid = true;
        List<MusicDTO> musicList = musicManager.selectList();
        List<MusicDTO> sortList = new ArrayList<>(musicList);
        do {
            System.out.println("===== 정렬 메뉴 =====");
            System.out.println("1. 가수이름 오름차순 정렬");
            System.out.println("2. 노래제목 오름차순 정렬");
            System.out.println("3. 가수이름 내림차순 정렬");
            System.out.println("4. 노래제목 내림차순 정렬");
            System.out.println("0. 메뉴로 돌아가기");
            System.out.print("메뉴 선택 :");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    sortList.sort(new AscArtist());
                    System.out.println("===== 가수이름 오름차순으로 정렬 =====");
                    break;
                case 2:
                    sortList.sort(new AscTitle());
                    System.out.println("===== 노래제목 오름차순으로 정렬 =====");
                    break;
                case 3:
                    sortList.sort(new DescArtist());
                    System.out.println("===== 가수이름 내림차순으로 정렬 =====");
                    break;
                case 4:
                    sortList.sort(new Comparator<MusicDTO>() {
                        @Override
                        public int compare(MusicDTO o1, MusicDTO o2) {
                            return o2.getTitle().compareTo(o1.getTitle());
                        }
                    });
                    System.out.println("===== 노래제목 내림차순으로 정렬 =====");
                    break;
                case 0:
                    System.out.println("메인메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다. 번호를 다시 입력해주세요.");
                    isMenuValid = false;
                    break;
            }
        } while (!isMenuValid);
        for (MusicDTO music : sortList) {
            System.out.println(music);
        }
    }

    public void searchList(String searchType) {
        if (isListEmpty()) return;
        System.out.println("===== " + searchType + "으로 검색 =====");
        System.out.print(searchType + " 입력 :");
        musicManager.searchMusic(searchType.equals("가수이름") ? "artist" : "title", sc.nextLine());
    }

    public void updateMusic() {
        if (isListEmpty()) return;
        System.out.println("===== 곡 정보 수정 ====");
        System.out.print("수정할 곡의 id :");
        int updateId = sc.nextInt();
        sc.nextLine();
        if (!isIdValid(updateId)) {
            System.out.println("수정할 곡을 찾지 못했습니다.");
            return;
        }
        System.out.print("수정할 가수이름 :");
        String updateArtist = sc.nextLine();
        System.out.print("수정할 노래제목 :");
        String updateTitle = sc.nextLine();

        musicManager.updateList(updateId, updateArtist, updateTitle);
    }

    public void removeMusic() {
        if (isListEmpty()) return;
        System.out.println("===== 노래 삭제 =====");
        System.out.print("삭제할 노래의 id :");
        int id = sc.nextInt();
        sc.nextLine();
        if (!isIdValid(id)) {
            System.out.println("삭제할 곡을 찾지 못했습니다.");
            return;
        }
        musicManager.removeMusic(id);
    }

    public boolean isListEmpty() {
        if (musicManager.musicList.isEmpty()) {
            System.out.println("목록이 존재하지 않습니다.");
            return true;
        }
        return false;
    }

    public boolean isIdValid(int id) {
        for (MusicDTO music : musicManager.musicList) {
            if (music.getId() == id) return true;
        }
        return false;
    }
}
