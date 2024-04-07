package chap3.com.jongro.exam.uses;

import java.util.Comparator;

public class DscArtist implements Comparator<MusicDTO> {
    @Override
    public int compare(MusicDTO o1, MusicDTO o2) {
        return o2.getArtist().compareTo(o1.getArtist());
    }
}
