package Main;
 
import javax.swing.*;

public class Frame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	/*Construtor da interface, que quando chamado na main, irá criar a interface com o usuário.
	 *Dentro deste contrutor, são criados outros objetos que serão então inseridos na interface*/
	
	Frame() {
		
		// Constantes para definição do tamanho da janela da interface
		final int frameWidth = 600;
		final int frameHeight = 620;
		
		// Características da janela principal da interface
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("JMIDI");
		this.setSize(frameWidth, frameHeight);
		this.setResizable(false);
			
		/* Estanciamento das componentes visuais, que serão adicionadas
		   á janela da interface para interação com o usuário*/
		
		/* Instânciamento das Labels - rótulos textuais ou com imagens
		 * os primeiros dois labels servem para apresentar textos na interface
		 * (o primeiro sendo um cabeçalho e o segundo um glossário)
		 * enquanto que o último label contém uma imagem da logo do instituto
		 * de informática, que fica presente no canto inferior da interface*/
		 
		Label textLabel = new Label("JMIDI - Texto para Sons");
		Label glossaryLabel = new Label();

		ImageIcon image = new ImageIcon("inf.png");
		Label imageLabel = new Label(image);
		
		/* Instânciamento do campo de texto, onde o usuário deve digitar
		 * o texto com o qual o software deve trabalhar */
		 
		TextBox textBox = new TextBox();
		
		/* Instânciamento do botão, que inicia a reprodução da música
		 * e que deve ser clicado uma vez que o usuário se sinta satisfeito
		 * com seu texto de entrada */
		
		Button button = new Button(textBox);
		
		/* Instânciamento da barra lateral, que aparece caso o usuário
		 * digite um texto com mais caracteres do que a tela pode mostrar
		 * abaixo do instânciamento estão algumas correções, que devem
		 * ser feitas para que a barra lateral não fique por cima da caixa de texto*/
		
		JScrollPane scrollPane = new JScrollPane(textBox);
		scrollPane.setBounds(textBox.getBounds());
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		/* Instânciamento do menu de tratamento de arquivos, que fica
		 * no topo superior esquerdo, e apresenta opções para o usuário
		 * que pode escolher entre carregar um arquivo texto de seu computador
		 * ou salvar o arquivo de saída do software, com a música reproduzida
		 * o usuário também pode optar por encerrar a execução do software
		 * por meio da opção de "fechar" que fica neste menu*/
		
		FileHandler fileBar = new FileHandler(textBox);
		
		/* Por fim, adição de todos os objetos criados á janela de interface
		   também estão definidas duas correções nas últimas linhas, que devem
		   ser colocadas aqui para garantir que a janela apareça para o
		   usuário (em alguns computadores, definir a visibilidade da 
		   janela antes de inserir elementos resulta na janela não aparecendo)*/
		   
		
		this.setJMenuBar(fileBar);
		this.add(imageLabel);
		this.add(textLabel);
		this.add(glossaryLabel);
		this.add(button);
		this.add(scrollPane);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
}