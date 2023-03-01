public class Translator {

    public void translate(String text){

        double MIN_VOL = 0.1D;
        double MAX_VOL = 1.0D;
        double volumePercent = MIN_VOL;

        for(int i=0; i<text.length(); i++){
            char c = text.charAt(i);

            switch (c){
                case ' ':
                    volumePercent = volumePercent * 2;
                    break;
            }

        }

        if (volumePercent > MAX_VOL){
            volumePercent = MIN_VOL;
        }

        System.out.println(volumePercent);

        // -----------------------------------------------------
        // Protótipo: para funcionar o programa preliminarmente
        // DÓ, RÉ, MI, FÁ, SOL, LÁ, SI, DÓ (uma oitava acima)
        // -----------------------------------------------------
        int notas[] = {60, 62, 64, 65, 67, 69, 71, 72, 72, 71, 69, 67, 65, 64, 62, 60};
        int instrumento = 125;

        new MidiPlayer(notas, instrumento, volumePercent);

    }

}
