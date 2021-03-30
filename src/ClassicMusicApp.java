import java.util.Arrays;

public class ClassicMusicApp {
    public static void main(String[] args) {
        String[] classicMusicArray = {
                "1) - Mozart - Serenade No. 13 for strings in G Major",
                "2) - Beethoven - Für Elise",
                "3) - Puccini - O mio babbino caro",
                "4) - J.S. Bach - Toccata and Fugue in D Minor",
                "5) - Beethoven - Symphony No.5 in C minor"
        };

        Arrays
                .stream(classicMusicArray)
                .map(music -> music.split("-"))
                .forEach(composerAndMusic -> System.out.println(composerAndMusic[0] + "\tComposer:\t"+composerAndMusic[1]+"\t music: "+composerAndMusic[2]));


    }
}
