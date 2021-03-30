import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ClassicMusicApp {
    public static void main(String[] args) {
        String[] classicMusicArray = {
                "Mozart - Serenade No. 13 for strings in G Major",
                "Beethoven - Für Elise",
                "Puccini - O mio babbino caro",
                "J.S. Bach - Toccata and Fugue in D Minor",
                "Beethoven - Symphony No.5 in C minor"
        };

        String[] classicMusicArrayV2 = {
                "1) - Mozart - Serenade No. 13 for strings in G Major",
                "2) - Beethoven - Für Elise",
                "3) - Puccini - O mio babbino caro",
                "4) - J.S. Bach - Toccata and Fugue in D Minor",
                "5) - Beethoven - Symphony No.5 in C minor"
        };

        // TODO:
                // 1- use streams: convert array to stream

        Stream<String> classicMusicStream = Arrays.stream(classicMusicArray);

                // 2- map: convert every music string to music + index of the music
                     /**   "1) Mozart - Serenade No. 13 for strings in G Major",
                                "2) Beethoven - Für Elise",
                                "3) Puccini - O mio babbino caro",
                                "4) J.S. Bach - Toccata and Fugue in D Minor",
                                "5) Beethoven - Symphony No.5 in C minor" */
        AtomicInteger counter = new AtomicInteger(0);

        Stream<String> musicStreamWithOrder = classicMusicStream.map(music -> counter.incrementAndGet() + ": " + music);


                // 3- map one more convert string to String[][3] with 2D ..
                      /**  "1)", "Mozart", "Serenade No. 13 for strings in G Major",
                                "2)", "Beethoven", "Für Elise",
                                "3)", "Puccini", "O mio babbino caro",
                                "4)", "J.S. Bach", "Toccata and Fugue in D Minor",
                                "5)", "Beethoven", "Symphony No.5 in C minor"   */

        Stream<String[]> splittedMusicStream = musicStreamWithOrder.map(music -> {
            String[] splittedArray = music.split("-");
            String firstPart = splittedArray[0];
            String third = splittedArray[1];

            String[] splitedFirstPartArray =firstPart.split(":");
            String first = splitedFirstPartArray[0];
            String secod = splitedFirstPartArray[1];

            String[] fullSplit = { first, secod, third};
            return fullSplit;
        });

                // 4- print every music in the stream

        splittedMusicStream.forEach(splittedMusic -> System.out.println(Arrays.toString(splittedMusic)));


        System.out.println("---------ALL TASK---------");

        Arrays
                .stream(classicMusicArray)
                .map(music -> counter.incrementAndGet() + ": " + music)
                .map(music -> {
                    String[] splittedArray = music.split("-");
                    String firstPart = splittedArray[0];
                    String third = splittedArray[1];

                    String[] splitedFirstPartArray =firstPart.split(":");
                    String first = splitedFirstPartArray[0];
                    String secod = splitedFirstPartArray[1];

                    String[] fullSplit = { first, secod, third};
                    return fullSplit;
                })
                .forEach(splittedMusic -> System.out.println(Arrays.toString(splittedMusic)));



        System.out.println("--------ALL TASK style Bill-------------");

        Arrays
                .stream(classicMusicArrayV2)
                .map(music -> music.split("-"))
                .forEach(composerAndMusic -> System.out.println(composerAndMusic[0] + "\tComposer:\t"+composerAndMusic[1]+"\t music: "+composerAndMusic[2]));


    }
}
