import javax.sound.midi.Instrument;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

public class MidiPlayer {
    MidiPlayer(int noteArray[], int instCode, double gain) {
        try {
            Synthesizer synth = MidiSystem.getSynthesizer();
            synth.open();
            Instrument[] instrumentos = synth.getDefaultSoundbank().getInstruments();
            MidiChannel channel = synth.getChannels()[0];

            channel.controlChange(7, (int) (gain * 127.0));
            channel.programChange(instrumentos[instCode+1].getPatch().getProgram());

            play(noteArray, channel);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }

    private void play(int notes[], MidiChannel ch) throws InterruptedException {
        try {
            for (int i = 0; i < notes.length; i++) {
                ch.noteOn(notes[i], 100);
                Thread.sleep(250);              // CALCULAR AQUI OS BPM
                ch.noteOff(notes[i]);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}