package Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.swing.*;

import Music.Converter;
import Music.Reproducer;

/* Classe responsável por criar o botão de início de reprodução
 * da música. Para isto, deve criar um construtor com as características
 * do botão e definir ações a serem tomadas quando este mesmo for clicado*/

public class Button extends JButton implements ActionListener{

	private static final long serialVersionUID = 1L;

	JTextArea textBox;
	static Sequence sequence;
	
	/* Construtor do botão, com constantes para definição
	 * de seu tamanho e sua posição. Este construtor recebe como parâmetro
	 * a caixa de texto instânciada na classe Frame, para que possa
	 * enviar o conteúdo da caixa para a classe que faz o tratamento do texto
	 * Além disso, este parâmetro deve ser re-instanciado aqui, para poder
	 * ser tratado por esta classe. */
	
	Button(JTextArea textBox){
		
		final int buttonPosX = 400;
		final int buttonPosY = 425;
		final int buttonWidth = 165;
		final int buttonHeight = 40;
		
		
		this.textBox = textBox; 	
		this.setText("Tocar texto");
		this.setBounds(buttonPosX, buttonPosY, buttonWidth, buttonHeight);
		this.addActionListener(this);
		this.setFocusable(false);
		
	}
	
	/* Rotina chamada quando o usuário executa alguma interação
	 * com o programa. No caso desta classe, a rotina ativa
	 * quando o botão é clicado. Deve-se adquirir o conteúdo
	 * da caixa de texto e enviá-lo para a classe que irá fazer
	 * a tradução do texto, e após o texto ter sido "musicado",
	 * o resultado deve ser apresentado ao usuário*/
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==this) {
						
			// Apenas para fins de debug
			System.out.println("Input: "+textBox.getText());
			
			/* Desabilita a edição da caixa de texto e o clique do botão
			 * enquanto o software está executando a tradução */
			textBox.setEditable(false);
			this.setEnabled(false);

			/* Envia o texto para a classe de tratamento, e após
			 * receber uma resposta, toca a música correspondente */
			
			String textInput = textBox.getText();
			int[] noteArray = Converter.convertTextToMusic(textInput);
			try {
				sequence = Converter.createMidiSequence(noteArray);
				Reproducer.reproduzSomSynth(sequence);
			} catch (MidiUnavailableException | InvalidMidiDataException | InterruptedException e1) {
				e1.printStackTrace();
			} 

		}

			/* Por fim, re-habilita a edição da caixa de texto e o clique
			 * do botão, para que o usuário possa executar o software novamente 
			 * também habilita a opção de salvar o arquivo de música*/
		
			textBox.setEditable(true);
			FileHandler.saveFile.setEnabled(true);
			this.setEnabled(true);

	}
}
