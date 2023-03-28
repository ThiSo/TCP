package Music;
import javax.sound.midi.*;

/* Classe que possui um método que trabalha
 * com a conversão do texto em notas musicais, mas não
 * toca a música propriamente dita */

public class Converter {
	
	/* Método que cria a sequência de notas, com base
	 * no array de inteiros recebido da função anterior */
	
	public static Sequence createMidiSequence(String textInput) throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
		
		final int MIN_OCTAVE = 0;
		final int MAX_OCTAVE = 9;
		int octave = MIN_OCTAVE;
		final int defaultVolume = 25;
		int volume = defaultVolume;
		int instrument = 1;
		int[] noteArray = new int[textInput.length()];
		
		final int Dó = 12;
		final int Ré = 14;
		final int Mí = 16;
		final int Fá = 17;
		final int Sól = 19;
		final int Lá = 21;
		final int Sí = 23;
		
		final int hapsichord = 6;
		final int tubularBells = 14;
		final int churchOrgan = 19;
		final int panFlute = 75;
		final int agogo = 113;
		final int silence = 123;
		
		MidiEvent event;
		boolean lastValueIsNote = false;
		 
		/* A sequência musical será enviada para uma track,
		 * onde as notas serão adicionadas por meio de eventos*/
				
	    Sequence sequence = new Sequence(Sequence.PPQ, 2); 
	    Track track = sequence.createTrack();
	    
	    
	    /* Faz a validação de todos os caracteres presentes no texto
	     * e cria um evento para cada caractere. Este evento pode definir o som
	     * que cada caractere faz, o instrumento sendo tocado, a velocidade
	     * de reprodução, o valor da oitava e por quanto tempo o som
	     * deve ser tocado. Algumas precauções devem ser tomadas para garantir
	     * que a nota é a correta e está de acordo com a definição. */
	    
	    for (int i = 0; i < textInput.length(); i++) {
	    		    	
	    	int offsetOctave = 12*octave;
	    	char character = textInput.charAt(i);
	    	
	        switch(character) {
	        	case ' ':	// Aumenta volume
	        		lastValueIsNote = false;
		        	if(volume >= 100) {
	        			volume = defaultVolume;
	        		}
	        		else {
	        			volume = volume * 2;
	        		}
	        		event = new MidiEvent(new ShortMessage(ShortMessage.CONTINUE), i);
	    	        track.add(event);
	    	        break;
	        	case 'A': 	// Nota = Lá
	        		lastValueIsNote = true;
	        		noteArray[i] = Lá + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);
	    	        event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, noteArray[i], volume), i+1);
	    	        track.add(event);
	    	        break;
	        	case 'B': 	// Nota = Sí
	        		lastValueIsNote = true;
	        		noteArray[i] = Sí + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);
	    	        event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, noteArray[i], volume), i+1);
	    	        track.add(event);
	        		break;
	        	case 'C':	// Nota = Dó
	        		lastValueIsNote = true;
	        		noteArray[i] = Dó + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);
	    	        event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, noteArray[i], volume), i+1);
	    	        track.add(event);
	        		break;
	        	case 'D':	// Nota = Ré
	        		lastValueIsNote = true;
	        		noteArray[i] = Ré + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);
	    	        event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, noteArray[i], volume), i+1);
	    	        track.add(event);
    	            break;
	        	case 'E':	// Nota = Mí
	        		lastValueIsNote = true;
	        		noteArray[i] = Mí + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);
	    	        event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, noteArray[i], volume), i+1);
	    	        track.add(event);
	        		break;
	        	case 'F':	// Nota = Fá
	        		lastValueIsNote = true;
	        		noteArray[i] = Fá + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);
	    	        event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, noteArray[i], volume), i+1);
	    	        track.add(event);
    	            break;
	        	case 'G':	// Nota = Sól
	        		lastValueIsNote = true;
	        		noteArray[i] = Sól + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);
	    	        event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, noteArray[i], volume), i+1);
	    	        track.add(event);
    	            break;
	        	case '!': 							// Instrumento = Agogô
	        		instrument = agogo;
	        		lastValueIsNote = false;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, instrument, 0), i);
    	            track.add(event);
    	            break;
	        	case 'O', 'o', 'U', 'u', 'I', 'i':	// Instrumento = Hapsichord
	        		instrument = hapsichord;
	        		lastValueIsNote = false;	
	        		event = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, instrument, 0), i);
    	            track.add(event);
    	            break;
	        	case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
	        		lastValueIsNote = false;		// Instrumento = Atual + Valor do dígito - 48 (correção do dígito em ASCII)	        		
	        		event = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, (instrument + (int)character - 48), 0), i);
	        		track.add(event);	
	        		break;
	        	case '?', '.': 	// Aumenta oitava
	        		lastValueIsNote = false;
	        		octave = octave + 1;
	        		if (octave >= MAX_OCTAVE){
	        			octave = MIN_OCTAVE;
	        		}
	        		event = new MidiEvent(new ShortMessage(ShortMessage.CONTINUE), i);
    	            track.add(event);
    	            break;
	        	case '\n': 		// Instrumento = Tubular Bells
	        		instrument = tubularBells;
	        		lastValueIsNote = false;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, instrument, 0), i);
    	            track.add(event);
    	            break;
	        	case ';': 		// Instrumento = Pan Flute
	        		instrument = panFlute;
	        		lastValueIsNote = false;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, instrument, 0), i);
    	            track.add(event);
    	            break;
	        	case ',': 		// Instrumento = Church Organ
	        		instrument = churchOrgan;
	        		lastValueIsNote = false;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, instrument, 0), i);
	        		track.add(event);
	        		break;
	        	case '*':		// Silêncio
	        		instrument = 123;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.CONTROL_CHANGE, 0, silence, 0), i);
        			track.add(event);
        			break;
	        	default:
	        		if(	lastValueIsNote == true) { // Se o último evento foi uma nota, repete ela
	        			lastValueIsNote = false;
	        			event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i - 1], volume), i);
	        			track.add(event);
	        			event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, noteArray[i - 1], volume), i+1);
		    	        track.add(event);
	        		}
	        		else { 							// Silêncio
	        			instrument = 123;
	        			event = new MidiEvent(new ShortMessage(ShortMessage.CONTROL_CHANGE, 0, silence, 0), i);
		        		track.add(event);
	        		}
	        	}
	             
	        }
	    	 		  
	 		return sequence;
	}
}
