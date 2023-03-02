import java.util.ArrayList;
import java.util.List;

public class Translator {

    public void translate(String text){

        List<Integer> notas = new ArrayList<>();

        double MIN_VOL = 0.1D;
        double MAX_VOL = 1.0D;
        int MIN_OCTAVE = 0;
        int MAX_OCTAVE = 9;
        double volumePercent = MIN_VOL;

        int octave = MIN_OCTAVE;

        for(int i=0; i<text.length(); i++){
            char c = text.charAt(i);
            int offsetOctave = 12*octave;

            switch (c){
                case ' ':
                    volumePercent = volumePercent * 2;
                    break;
                case 'C': //DÓ
                    notas.add(12+offsetOctave);
                    break;
                case 'D': //RÉ;
                    notas.add(14+offsetOctave);
                    break;
                case 'E': //MI
                    notas.add(16+offsetOctave);
                    break;
                case 'F': //FA
                    notas.add(17+offsetOctave);
                    break;
                case 'G': //SOL
                    notas.add(19+offsetOctave);
                    break;
                case 'A': //LA
                    notas.add(21+offsetOctave);
                    break;
                case 'B': //SI
                    notas.add(23+offsetOctave);
                    break;
                case '?':
                    octave = octave + 1;
                    break;
                case '.':
                    octave = octave + 1;
                    break;
            }

            if (octave > MAX_OCTAVE){
                octave = MIN_OCTAVE;
            }

        }

        if (volumePercent > MAX_VOL){
            volumePercent = MIN_VOL;
        }

        int instrumento = 1 ;

        System.out.println("Volume: " + volumePercent);
        System.out.println("Oitava: " + octave);
        System.out.println("Notas: " + notas);
        System.out.println("Instrumento: " + instrumento);

        new MidiPlayer(notas, instrumento, volumePercent);
    }

}
