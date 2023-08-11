import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String artist;
    private String name;
    private List<Song> songs;

    public Album() {
    }

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    // functionalities on the album

    public boolean findSong(String title) {
        for (Song song: songs) {
            if(song.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    //add song
    public String addSongToAlbum(String title, double duration) {
        if (findSong(title) == false) {
            //add
            Song song = new Song(title,duration);
            this.songs.add(song);
            return "Song Successfully added";
        }

        return "Song Already Exists";
    }

    //add to playlist from album
    public String addToPlayListFromAlbum(String title, LinkedList<Song> playList) {

            for(Song song: this.songs) {
                if (song.getTitle().equals(title)) {
                    playList.add(song);
                    return "Song added to playlist";
                }
            }


        return "Song doesn't exist in the album";
    }

    /**
     * polymorphism - method overloading
     * @param songNo
     * @param playList
     * @return
     */
    public String addToPlayListFromAlbum(int songNo, LinkedList<Song> playList) {
        int index = songNo - 1;
        //if the song exists on the album then only we add
        if (index >= 0 && index<songs.size()) {
            playList.add(songs.get(index));
            return "Song added to Playlist";
        }

        return "Incorrect song number!!";
    }
}
