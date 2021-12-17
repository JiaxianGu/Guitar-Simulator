import edu.princeton.cs.algs4.StdAudio;
import es.datastructur.synthesizer.GuitarString;
public class GuitarHero {
    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/";


    public static void main(String[] args) {
        GuitarString[] strings = new GuitarString[37];
        for (int i = 0; i < 37; i += 1) {
            strings[i] = new GuitarString(440 * Math.pow(2, ((double)i - 24) / 12));
        }
//        System.out.println(keyboard.indexOf("s"));

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int keyIndex = keyboard.indexOf(key);
                if (keyIndex == -1){
                    continue;
                }
                strings[keyIndex].pluck();
            }
            double sample = 0;
            for (int i = 0; i < strings.length; i += 1) {
                sample += strings[i].sample();
            }
            StdAudio.play(sample);

            for (int i = 0; i < strings.length; i += 1) {
                strings[i].tic();
            }
        }
    }
}
