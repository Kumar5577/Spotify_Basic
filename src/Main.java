import java.util.*;

public class Main {
   static  Scanner sc = new Scanner(System.in);
    public static List<Album> albums = new ArrayList<>();

    public static void main(String[] args) {


        Album album1 = new Album("Moosa", "DSP");
        album1.addSongToAlbum("honey1", 4.05);
        album1.addSongToAlbum("LastRide", 5.5);
        album1.addSongToAlbum("So High", 3.05);

        Album album2 = new Album("Thaman songs", "Thaman");
        album2.addSongToAlbum("Jai Balayya", 3.5);
        album2.addSongToAlbum("Ranjithamey", 4.5);
        album2.addSongToAlbum("Jimmyki popnu", 4.1);

        albums.add(album2);
        albums.add(album1);

        System.out.println(album1.findSong("Ranjithamey"));

        System.out.println(album2.findSong("Ranjithamey"));

        LinkedList<Song> MyPlayList = new LinkedList<>();
        album1.addToPlaylistFromAlbum("Jai Balayya", MyPlayList);
        album2.addToPlaylistFromAlbum(3, MyPlayList);
        album1.addToPlaylistFromAlbum(2, MyPlayList);
        album2.addToPlaylistFromAlbum("Ranjithamey", MyPlayList);

        play(MyPlayList);


    }
    public static void play(LinkedList<Song> playlist){
        ListIterator<Song> itr = playlist.listIterator();
        boolean isForward = false;


        if(playlist.size()>0){
            System.out.println("currently playing: ");
            System.out.println(itr.next());
            isForward = true;
        }
        else
            System.out.println("PlayList is Empty");
        System.out.println("Select Your Choice");
        printMenu();
        boolean quit = false;

        while(!quit){
            int choice = sc.nextInt();
        switch(choice) {
            case 1:
                if(isForward==false){
                    itr.next();
                    isForward = true;
                }
                if (itr.hasNext())
                    System.out.println(itr.next());
                else {
                    System.out.println("You have reached the end of the playlist");
                    isForward = false;
                }
                break;
            case 2:
                if(isForward==true){
                    itr.previous();
                    isForward = false;
                }
                if (itr.hasPrevious())
                    System.out.println(itr.previous());
                else {
                    System.out.println("You are at Starting of the playlist");
                    isForward = true;
                }
                break;
            case 3:
                    if(isForward){
                        if(itr.hasPrevious()) {
                            System.out.println(itr.previous());
                            isForward = false;
                        }
                    }
                    else{
                        if(itr.hasNext()) {
                            System.out.println(itr.next());
                            isForward = true;
                        }
                        else{
                            System.out.println("Song is not present");
                        }
                    }

                break;
            case 4:
                printMenu();
                break;
            case 5:
                break;
            case 6:
                printSongs(playlist);
                break;
            case 7:
                quit = true;
                break;
        }
        }
    }
    public static void printSongs(LinkedList<Song> playlist){
        for(Song song : playlist){
            System.out.println(song);

        }
        return;
    }
    public static void printMenu(){

        System.out.println("1 - Play next song");
        System.out.println("2 - Play previous song");
        System.out.println("3 - Repeat the current song");
        System.out.println("4 - show menu again");
        System.out.println("5 - Delete the Current song");
        System.out.println("6 - Print all the songs in plalist");
        System.out.println("7 - Exit");
        return;
    }
}