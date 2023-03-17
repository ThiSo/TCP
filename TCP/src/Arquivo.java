import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Arquivo extends JMenuBar implements ActionListener{

	private static final long serialVersionUID = 1L;

	JMenuItem abrirArquivo;
	JMenuItem salvarArquivo;
	JMenuItem sair;
	JTextArea caixa;
	
	Arquivo(JTextArea caixaTexto){
		
		JMenu menuArquivo = new JMenu("Arquivo");
		abrirArquivo = new JMenuItem("Abrir");
		salvarArquivo = new JMenuItem("Salvar");
		sair = new JMenuItem("Sair");
		
		abrirArquivo.addActionListener(this);
		salvarArquivo.addActionListener(this);
		sair.addActionListener(this);
		
		menuArquivo.add(abrirArquivo);
		menuArquivo.add(salvarArquivo);
		menuArquivo.add(sair);
		
		this.caixa = caixaTexto;
		this.add(menuArquivo);
	}

	public void abrirArquivo() {
	
		JFileChooser abreTexto =  new JFileChooser();
		abreTexto.setCurrentDirectory(new File("."));
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos texto", "txt");
		abreTexto.setFileFilter(filtro);
		
		int opcaoAbrir = abreTexto.showOpenDialog(null);
		
		if(opcaoAbrir == JFileChooser.APPROVE_OPTION) {
			File arquivoTexto = new File(abreTexto.getSelectedFile().getAbsolutePath());
			Scanner textoEntrada = null;
			
			try {
				textoEntrada = new Scanner(arquivoTexto);
				if(arquivoTexto.isFile()) {
					while(textoEntrada.hasNextLine()) {
						String linha = textoEntrada.nextLine()+"\n";
						caixa.append(linha);
					}
				}
			}
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			finally {
				textoEntrada.close();
			}
		}
	}
	
	public void salvarArquivo() {
		
		JFileChooser salvaMidi =  new JFileChooser();
		salvaMidi.setCurrentDirectory(new File("."));
		
		int opcaoSalvar = salvaMidi.showSaveDialog(null);
		
		if(opcaoSalvar == JFileChooser.APPROVE_OPTION) {
			File arquivoMidi;
			PrintWriter arquivoMidiSalvo = null;
			
			arquivoMidi = new File(salvaMidi.getSelectedFile().getAbsolutePath());
			try {
				arquivoMidiSalvo = new PrintWriter(arquivoMidi);
				arquivoMidiSalvo.println(caixa.getText());
			} 
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			finally {
				arquivoMidiSalvo.close();
			}
		}
	}
	
	public void fecharSoftware() {
		
		System.exit(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Se o botão de abrir arquivo for pressionado
		if(e.getSource() == abrirArquivo) {
			
			abrirArquivo();
		}
		
		//Se o botão de salvar arquivo for pressionado
		else if(e.getSource() == salvarArquivo) {
			
			salvarArquivo();	
		}
		
		//Se o botão de sair for pressionado	
		else if(e.getSource() == sair) {
		
			fecharSoftware();
		}
	}
	
}