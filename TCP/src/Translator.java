import java.util.ArrayList;
import java.util.List;

public class Translator {

    public void translate(String text){

        List<Integer> notas = new ArrayList<>();

        double MIN_VOL = 0.1D;
        double MAX_VOL = 1.0D;
        double volumePercent = MIN_VOL;

        for(int i=0; i<text.length(); i++){
            char c = text.charAt(i);

            switch (c){
                case ' ':
                    volumePercent = volumePercent * 2;
                    break;
                case 'C': //DÓ
                    notas.add(24);
                    break;
                case 'D': //RÉ;
                    notas.add(26);
                    break;
                case 'E': //MI
                    notas.add(28);
                    break;
                case 'F': //FA
                    notas.add(29);
                    break;
                case 'G': //SOL
                    notas.add(31);
                    break;
                case 'A': //LA
                    notas.add(33);
                    break;
                case 'B': //SI
                    notas.add(35);
                    break;
            }

        }

        if (volumePercent > MAX_VOL){
            volumePercent = MIN_VOL;
        }

        System.out.println(volumePercent);
        System.out.println(notas);

        int instrumento = 1 ;

        new MidiPlayer(notas, instrumento, volumePercent);
    }

}
