public class Translator {

    public void translate(String text){

        double volumePercent = 0.1D;

        for(int i=0; i<text.length(); i++){
            char c = text.charAt(i);

            switch (c){
                case '+':
                    volumePercent = volumePercent * 2;
                    break;
                case '-':
                    volumePercent = volumePercent / 2;
                    break;
            }

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
