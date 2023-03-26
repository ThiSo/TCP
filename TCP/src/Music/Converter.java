package Music;
import javax.sound.midi.*;

/* Classe que possui diversos métodos que trabalham
 * com a conversão do texto em notas musicais, mas não
 * tocam a música propriamente dita */

public class Converter {

	/* Método que transforma os caracteres do texto em 
	 * valores inteiros correspondentes, e os coloca num array de notas */
	
	public static int[] convertTextToMusic(String text) {
		
		int[] noteArray = new int[text.length()];
		for(int i = 0; i < text.length(); i++) {
			noteArray[i] = (int) text.charAt(i);
			//apenas para fins de debug
			System.out.print(noteArray[i]);
		}
		
		return noteArray;
	}
	
	/* Método que cria a sequência de notas, com base
	 * no array de inteiros recebido da função anterior */
	
	public static Sequence createMidiSequence(int[] noteArray) throws MidiUnavailableException, InvalidMidiDataException, InterruptedException {
		
		final int MIN_OCTAVE = 0;
		final int MAX_OCTAVE = 9;
		int octave = MIN_OCTAVE;
		int defaultVolume = 25;
		int volume = defaultVolume;
		int instrument = 1;
		
		final int Dó = 12;
		final int Ré = 14;
		final int Mí = 16;
		final int Fá = 17;
		final int Sól = 19;
		final int Lá = 21;
		final int Sí = 23;
		
		MidiEvent event;
		boolean lastValueIsNote = false;
		Sequencer sequencer = MidiSystem.getSequencer();
			 
		/* A sequência musical será feita com base neste sequenciador,
		 * que será enviado para uma track, onde as notas serão adicionadas */
		
		sequencer.open();
	    Sequence sequence = new Sequence(Sequence.PPQ, 2); 
	    Track track = sequence.createTrack();
	    
	    
	    /* Faz a validação de todos os caracteres presentes no texto
	     * e cria um evento para cada caractere. Este evento pode definir o som
	     * que cada caractere faz, o instrumento sendo tocado, a velocidade
	     * de reprodução, o valor da oitava e por quanto tempo o som
	     * deve ser tocado. Algumas precauções devem ser tomadas para garantir
	     * que a nota é a correta e está de acordo com a definição. */
	    
	    for (int i = 0; i < noteArray.length; i++) {
	    		    	
	    	int offsetOctave = 12*octave;
	        switch(noteArray[i]) {
	        	case ((int) ' '):	// Aumenta volume
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
	        	case ((int) 'A'): 	// Nota = Lá
	        		lastValueIsNote = true;
	        		noteArray[i] = Lá + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);
	    	        event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, noteArray[i], volume), i+1);
	    	        track.add(event);
	    	        break;
	        	case ((int) 'B'): 	// Nota = Sí
	        		lastValueIsNote = true;
	        		noteArray[i] = Sí + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);
	    	        event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, noteArray[i], volume), i+1);
	    	        track.add(event);
	        		break;
	        	case ((int) 'C'):	// Nota = Dó
	        		lastValueIsNote = true;
	        		noteArray[i] = Dó + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);
	    	        event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, noteArray[i], volume), i+1);
	    	        track.add(event);
	        		break;
	        	case ((int) 'D'):	// Nota = Ré
	        		lastValueIsNote = true;
	        		noteArray[i] = Ré + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);
	    	        event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, noteArray[i], volume), i+1);
	    	        track.add(event);
    	            break;
	        	case ((int) 'E'):	// Nota = Mí
	        		lastValueIsNote = true;
	        		noteArray[i] = Mí + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);
	    	        event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, noteArray[i], volume), i+1);
	    	        track.add(event);
	        		break;
	        	case ((int) 'F'):	// Nota = Fá
	        		lastValueIsNote = true;
	        		noteArray[i] = Fá + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);
	    	        event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, noteArray[i], volume), i+1);
	    	        track.add(event);
    	            break;
	        	case ((int) 'G'):	// Nota = Sól
	        		lastValueIsNote = true;
	        		noteArray[i] = Sól + offsetOctave;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_ON, 0, noteArray[i], volume), i);
	    	        track.add(event);
	    	        event = new MidiEvent(new ShortMessage(ShortMessage.NOTE_OFF, 0, noteArray[i], volume), i+1);
	    	        track.add(event);
    	            break;
	        	case ((int) '!'): 				// Instrumento = Agogô
	        		instrument = 113;
	        		lastValueIsNote = false;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, instrument, 0), i);
    	            track.add(event);
    	            break;
	        	case ((int) 'O'), ((int) 'o'), ((int) 'U'), ((int) 'u'), ((int) 'I'), ((int) 'i'):
	        		instrument = 6;
	        		lastValueIsNote = false;	// Instrumento = Hapsichord
	        		event = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, instrument, 0), i);
    	            track.add(event);
    	            break;
	        	case ((int) '0'), ((int) '1'), ((int) '2'), ((int) '3'), ((int) '4'), ((int) '5'), ((int) '6'), ((int) '7'),((int) '8'),((int) '9'):
	        		lastValueIsNote = false;	// Instrumento = Atual + Valor do dígito - 48 (correção do dígito em ASCII)	        		
	        		event = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, (instrument + noteArray[i] - 48), 0), i);
	        		track.add(event);	
	        		break;
	        	case ((int) '?'), ((int) '.'): 	// Aumenta oitava
	        		lastValueIsNote = false;
	        		octave = octave + 1;
	        		if (octave > MAX_OCTAVE){
	        			octave = MIN_OCTAVE;
	        		}
	        		event = new MidiEvent(new ShortMessage(ShortMessage.CONTINUE), i);
    	            track.add(event);
    	            break;
	        	case ((int) '\n'): 		// Instrumento = Tubular Bells
	        		instrument = 14;
	        		lastValueIsNote = false;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, instrument, 0), i);
    	            track.add(event);
    	            break;
	        	case ((int) ';'): 		// Instrumento = Pan Flute
	        		instrument = 75;
	        		lastValueIsNote = false;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, instrument, 0), i);
    	            track.add(event);
    	            break;
	        	case ((int) ','): 		// Instrumento = Church Organ
	        		instrument = 19;
	        		lastValueIsNote = false;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.PROGRAM_CHANGE, 0, instrument, 0), i);
	        		track.add(event);
	        		break;
	        	case ((int) '*'):		// Silêncio
	        		instrument = 123;
	        		event = new MidiEvent(new ShortMessage(ShortMessage.CONTROL_CHANGE, 0, instrument, 0), i);
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
	        		else { 							//Silêncio
	        			instrument = 123;
	        			event = new MidiEvent(new ShortMessage(ShortMessage.CONTROL_CHANGE, 0, instrument, 0), i);
		        		track.add(event);
	        		}
	        	}
	            
	        }
	    
	 		sequencer.close();
	         
	 		return sequence;
	}
}
