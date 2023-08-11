import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //System.out.println("Hello world!");

        Album arijitAlbum = new Album("Arijit Singh","Arijit's Album");
        Album alanAlbum = new Album("Alan Walker", "Walker's Album");

        arijitAlbum.addSongToAlbum("Kesaria", 3.5);
        arijitAlbum.addSongToAlbum("tum kya mile",4.2);
        arijitAlbum.addSongToAlbum("Lal Ishq",3.4);

        alanAlbum.addSongToAlbum("Faded",3.6);
        alanAlbum.addSongToAlbum("Alone",4.1);
        alanAlbum.addSongToAlbum("Darkside",2.5);

        LinkedList<Song> myPlayList = new LinkedList<>();

        System.out.println(arijitAlbum.addToPlayListFromAlbum("Kesaria",myPlayList));
        System.out.println(arijitAlbum.addToPlayListFromAlbum(2,myPlayList));

        System.out.println(arijitAlbum.addToPlayListFromAlbum(6,myPlayList));

        System.out.println(alanAlbum.addToPlayListFromAlbum("Alone",myPlayList));
        System.out.println(alanAlbum.addToPlayListFromAlbum(3,myPlayList));

        play(myPlayList);
    }

    private static void play(LinkedList<Song> myPlayList) {

        if(myPlayList.size() == 0) {
            System.out.println("Your PlayList is empty");
            return;
        }
        ListIterator<Song> itr = myPlayList.listIterator();
        System.out.println("Now Playing: " + itr.next());
        boolean wasNext = true;  //to check if the last button press was next or prev

        Scanner sc = new Scanner(System.in);
        printMenu();

        boolean quit = false;
        while(!quit){
            System.out.println("Please enter your choice");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    printMenu();
                    break;
                case 2: //Play next
                    if (!wasNext) {
                        itr.next(); // if the last button is prev then we need to call next
                        //twice to call the correct song
                        wasNext=true;
                    }
                    if(!itr.hasNext()){
                        System.out.println("You have reached the end of the playlist");
                    }
                    else{
                        System.out.println("Currently playing: "+itr.next());
                        wasNext=true;
                    }
                    break;
                case 3:
                    if (wasNext){
                        itr.previous(); // if last press was next then we need to call prev
                        //twice
                        wasNext=false;
                    }
                    if(!itr.hasPrevious()){
                        System.out.println("You are the start of the playlist");
                    }
                    else{
                        System.out.println("Currently playing: "+itr.previous());
                        wasNext=false;
                    }
                    break;
                case 4:
                    if (wasNext) {
                        System.out.println("Currently Playing: "+itr.previous());
                        wasNext=false;
                    }
                    else {
                        System.out.println("Currently Playing: " + itr.next());
                        wasNext = true;
                    }
                    break;
                case 5:
                    break;
                case 6:
                    printSongs(myPlayList);
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong choice. Please select again");
            }
        }
        return;
    }

    private static void printSongs(LinkedList<Song> myPlayList) {

        for(Song song: myPlayList){
            System.out.println(song);
        }
        return;
    }

    private static void printMenu() {
        System.out.println("1. Show the Menu");
        System.out.println("2. Play Next song");
        System.out.println("3. Play Previous song");
        System.out.println("4. Play Current Song again");
        System.out.println("5. Delete Current song from playlist");
        System.out.println("6. Print all songs in playlist");
        System.out.println("7. Quit app");
    }
}