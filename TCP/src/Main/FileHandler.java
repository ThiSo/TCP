package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/* Classe responsável por criar o menu de opções para manipulação
 * de arquivos, assim como trabalhar com os arquivos propriamente
 * ditos. Aqui, são criados métodos para todos os casos que 
 * envolvem arquivos: carregamento de um txt pelo usuário e
 * salvamento do arquivo midi de saída, após execução do software */

public class FileHandler extends JMenuBar implements ActionListener{

	private static final long serialVersionUID = 1L;

	static JMenuItem openFile;
	static JMenuItem saveFile;
	static JMenuItem close;
	JTextArea textBox;
	
	/* Construtor para o menu de arquivos, onde itens de menu
	 * são instânciados e adicionados no menu em sí
	 * todos possuem uma rotina do que fazer ao serem clicados */
	
	FileHandler(JTextArea textBox){
		
		JMenu fileMenu = new JMenu("Arquivo");
		openFile = new JMenuItem("Abrir");
		saveFile = new JMenuItem("Salvar");
		close = new JMenuItem("Fechar");
		
		openFile.addActionListener(this);
		saveFile.addActionListener(this);
		saveFile.setEnabled(false);
		close.addActionListener(this);
		
		fileMenu.add(openFile);
		fileMenu.add(saveFile);
		fileMenu.add(close);
		
		this.textBox = textBox;
		this.add(fileMenu);
	}

	/* Método que abre um arquivo texto do usuário e, utilizando um scanner,
	 * passa para a caixa de texto, preservando o conteúdo original dela */
	
	public void openFileFunc() {
	
		JFileChooser textOpener =  new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos texto", "txt");
		textOpener.setCurrentDirectory(new File("."));
		textOpener.setFileFilter(filter);
		
		int openOption = textOpener.showOpenDialog(null);
		
		if(openOption == JFileChooser.APPROVE_OPTION) {
			File textFile = new File(textOpener.getSelectedFile().getAbsolutePath());
			Scanner inputText = null;
			
			try {
				inputText = new Scanner(textFile);
				if(textFile.isFile()) {
					while(inputText.hasNextLine()) {
						String line = inputText.nextLine()+"\n";
						textBox.append(line);
					}
				}
			}
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			finally {
				inputText.close();
			}
		}
	}
	
	/* Método utilizado para salvar o arquivo de saída do software
	 * abre uma janela do explorador de arquivos do windows, onde
	 * o usuário pode escolher o locao onde o arquivo deve ser salvo,
	 * e também deve colocar o nome de seu arquivo */
	
	public void saveFileFunc(Sequence sequence) throws IOException {
		
		JFileChooser midiSaver =  new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivo Midi", "mid");
		midiSaver.setCurrentDirectory(new File("."));
		midiSaver.setFileFilter(filter);
		int saveOption = midiSaver.showSaveDialog(null);
		
		if(saveOption == JFileChooser.APPROVE_OPTION) {
			MidiSystem.write(sequence, 1, new File(midiSaver.getSelectedFile().getAbsolutePath()));
		}
	}
	
	/* Método que encerra a execução do software */
	
	public void closeSoftware() {
		
		System.exit(0);
	}
	
	/* Rotina chamada quando o usuário executa alguma interação
	 * com o programa. No caso desta classe, a rotina ativa quando
	 * o usuário clica em algum dos itens do menu de arquivos.
	 * A rotina então valida qual dos itens de menu foi clicado, 
	 * e chama a função correspondente */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Se o botão de abrir arquivo for pressionado
		if(e.getSource() == openFile) {
			
			openFileFunc();
		}
		
		//Se o botão de salvar arquivo for pressionado
		else if(e.getSource() == saveFile) {
			
			try {
				saveFileFunc(Button.sequence);
				
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}	
		}
		
		//Se o botão de close for pressionado	
		else if(e.getSource() == close) {
		
			closeSoftware();
		}
				
	}
}