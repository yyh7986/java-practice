package chap3.com.jongro.exam.uses;

import java.util.ArrayList;
import java.util.List;

public class MusicManager {
    List<MusicDTO> musicList = new ArrayList<>();

    public void addList(String artist, String title) {
        musicList.add(new MusicDTO(artist, title));
    }

    public List<MusicDTO> selectList(){
        return musicList;
    }

    public void searchMusic(String searchType, String searchWord) {
        List<MusicDTO> searchList = new ArrayList<>();
        for (MusicDTO music : musicList) {
            switch(searchType) {
                case "artist" -> {
                    if (music.getArtist().contains(searchWord)) {
                        searchList.add(music);
                    }
                }
                case "title" -> {
                    if (music.getTitle().contains(searchWord)) {
                        searchList.add(music);
                    }
                }
                default -> System.out.println("검색 기준을 정확히 입력하세요.");
            }
        }

        if (searchList.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            for (MusicDTO music : searchList) {
                System.out.println(music);
            }
        }
    }

    public void updateMusic(int id, String artist, String title) {
        boolean isSuccess = false;
        for (MusicDTO music : musicList) {
            if (music.getId() == id) {
                music.setArtist(artist);
                music.setTitle(title);
                System.out.println("성공적으로 수정되었습니다.");
                isSuccess = true;
                return;
            }
        }
        if (!isSuccess) {
            System.out.println("수정할 곡을 찾지 못했습니다.");
        }
    }

    public void removeMusic(int id) {
        boolean isValidId = false;
        for (MusicDTO music : musicList) {
            if (music.getId() == id) {
                musicList.remove(music);
                isValidId = true;
                System.out.println(music.getArtist() + "의 " + music.getTitle() + "을 목록에서 삭제했습니다.");
                return;
            }
        }
        if (!isValidId) {
            System.out.println("id를 다시 입력하세요.");
        }

    }
}
