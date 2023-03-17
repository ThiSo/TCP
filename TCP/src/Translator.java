
public class Translator {

    public void translate(String text){

        int[] notas = new int[text.length()];

        double MIN_VOL = 0.1D;
        double MAX_VOL = 2.0D;
        int MIN_OCTAVE = 0;
        int MAX_OCTAVE = 9;
        double volumePercent = MIN_VOL;
        double newPercent = volumePercent;
        int instrumento = 1;
        boolean hastoPlay = false;

        int octave = MIN_OCTAVE;

        for(int i=0; i<text.length(); i++){
            char c = text.charAt(i);
            char prevC = text.charAt(Math.max(0, i-1));
            int offsetOctave = 12*octave;
            hastoPlay = false;

            switch (c){
                case ' ':
                    volumePercent = volumePercent * 2;
                    newPercent = volumePercent;
                    hastoPlay = false;
                    break;
                case 'C': //DÓ
                    notas[i] = 12+offsetOctave;
                    hastoPlay = true;
                    break;
                case 'D': //RÉ;
                	notas[i] = 14+offsetOctave;
                	hastoPlay = true;
                    break;
                case 'E': //MI
                	notas[i] = 16+offsetOctave;
                	hastoPlay = true;
                    break;
                case 'F': //FA
                	notas[i] = 17+offsetOctave;
                	hastoPlay = true;
                    break;
                case 'G': //SOL
                	notas[i] = 19+offsetOctave;
                	hastoPlay = true;
                    break;
                case 'A': //LA
                	notas[i] = 21+offsetOctave;
                	hastoPlay = true;
                    break;
                case 'B': //SI
                	notas[i] = 23+offsetOctave;
                	hastoPlay = true;
                    break;
                case '?':
                    octave = octave + 1;
                    hastoPlay = false;
                    break;
                case '.':
                    octave = octave + 1;
                    hastoPlay = false;
                    break;
                case '!':
                	instrumento = 114;
                	hastoPlay = false;
                	break;
                case '\n':
                	instrumento = 15;
                	hastoPlay = false;
                	break;
                case ';':
                	instrumento = 76;
                	hastoPlay = false;
                	break;
                case ',':
                	instrumento = 20;
                	hastoPlay = false;
                	break;
                case 'O', 'o', 'I', 'i', 'U', 'u':
                	instrumento = 7;
                	hastoPlay = false;
                	break;
                case '1','2','3','4','5','6','7','8','9':
                	instrumento = instrumento + c - 48;		//subtração de 48 para transformar de ASCII em dígito
                	hastoPlay = false;
                	break;
                default:
                	switch(prevC) {							//Teste se deve repetir nota anterior
	                	case 'C': //DÓ
	                        notas[i] = 12+offsetOctave;
	                        hastoPlay = true;
	                        break;
	                    case 'D': //RÉ;
	                    	notas[i] = 14+offsetOctave;
	                    	hastoPlay = true;
	                        break;
	                    case 'E': //MI
	                    	notas[i] = 16+offsetOctave;
	                    	hastoPlay = true;
	                        break;
	                    case 'F': //FA
	                    	notas[i] = 17+offsetOctave;
	                    	hastoPlay = true;
	                        break;
	                    case 'G': //SOL
	                    	notas[i] = 19+offsetOctave;
	                    	hastoPlay = true;
	                        break;
	                    case 'A': //LA
	                    	notas[i] = 21+offsetOctave;
	                    	hastoPlay = true;
	                        break;
	                    case 'B': //SI
	                    	notas[i] = 23+offsetOctave;
	                    	hastoPlay = true;
	                        break;
	                    default:
	                    	newPercent = volumePercent;
	                    	volumePercent = 0;
	                    	break;
                	}
                	break;
                		     	
            }
  
            volumePercent = newPercent;
            if (volumePercent > MAX_VOL){
                volumePercent = MIN_VOL;
            }
                        
            if (octave > MAX_OCTAVE){
                octave = MIN_OCTAVE;
            }
            
            if (hastoPlay == true) {
            	new MidiPlayer(notas[i], instrumento, volumePercent);
            }        

        }
        
        System.out.println("Volume: " + volumePercent);
        System.out.println("Oitava: " + octave);
        System.out.println("Instrumento: " + instrumento);
        System.out.print("Notas: "); 
        for(int i=0; i<text.length(); i++){
        	System.out.print(notas[i]+", ");
        }

    }

}
