package chap3.com.jongro.exam.practice;

import java.util.ArrayList;
import java.util.List;

public class MusicManager {
    List<MusicDTO> musicList = new ArrayList<>();

    public void addList(String artistName, String songTitle) {  // 노래 추가
        musicList.add(new MusicDTO(artistName, songTitle));
    }

    public List<MusicDTO> selectList(){     // 목록 조회
        return musicList;
    }

    public void searchMusic(String searchType, String searchWord){  // 검색 기준, 검색할 단어를 파라미터로 받음
        List<MusicDTO> searchList = new ArrayList<>();
        for (MusicDTO music : musicList) {
            // 검색 기준이 artist인지 title인지?
            String type = searchType.equals("artist") ? music.getArtist() : music.getTitle();
            if (type.contains(searchWord)) {
                searchList.add(music);
            }
        }
        if (!searchList.isEmpty()) {
            for (MusicDTO music : searchList) {
                System.out.println(music);
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
    }

    public void updateList(int id, String artist, String title) {
        MusicDTO updateMusic = new MusicDTO(id, artist, title);
        for (MusicDTO music : musicList) {
            if (music.getId() == id) {
                music.setArtist(artist);
                music.setTitle(title);
                System.out.println("성공적으로 수정되었습니다.");
                return;
            }
        }
    }

    public void removeMusic(int id) {
        for (MusicDTO music : musicList) {
            if (music.getId() == id) {
                musicList.remove(music);
                System.out.println("성공적으로 삭제 되었습니다.");
                return;
            }
        }
    }
}
