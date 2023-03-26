package Music;
import javax.sound.midi.*;

/* Classe que efetivamente toca a música correspondente ao texto
 * fornecido pelo usuário. Como a sequência já se encontra pronta,
 * apenas utiliza uma função nativa da biblioteca javax.sound.midi
 * para tocar a sequência */

public class Reproducer {
	
	public static void reproduzSomSynth(Sequence sequence) throws MidiUnavailableException, InvalidMidiDataException {
		        
		Sequencer sequencer = MidiSystem.getSequencer();
		
	    sequencer.setSequence(sequence);
	         
	    // Inicia a reproducao, definindo o número de batidas por minuto
		sequencer.open();		
		sequencer.setTempoInBPM(60);
	    sequencer.start();	         
	     
	 }
}
