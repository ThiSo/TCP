package Main;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.Border;

/* Classe responsável por criar construtores para as labels
 * Aqui, existem três construtores que recebem parâmetros diferentes
 * apesar de esta escolha de implementação ocasionar uma repetição
 * de alguns trechos de código, ela apresenta uma vantagem em relação
 * a criação de um só construtor: não há necessidade de fazer correções
 * nas labels dentro da classe que as cria (frame) */

public class Label extends JLabel{

	private static final long serialVersionUID = 1L;
	
	/* Construtor da label de cabeçalho da interface
	 * que apresenta uma mensagem acima da caixa de texto*/
	
	Label(String text){
		
		final int labelPosX = 10;
		final int labelPosY = 10;
		final int labelWidth =375;
		final int labelHeight = 30;
		final int labelFontSize = 20;
		Border border = BorderFactory.createLineBorder(Color.black, 2);
		
		this.setText(text);
		this.setBorder(border);
		this.setBounds(labelPosX, labelPosY, labelWidth, labelHeight);
		this.setOpaque(false);
		this.setBackground(Color.black);
		this.setForeground(Color.black);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.TOP);
		this.setFont(new Font("Arial", Font.PLAIN, labelFontSize));
	}
	
	/* Construtor da label de glossário que fica direita 
	 * da caixa de texto e que apresenta o mapeamento de caracteres 
	 * definido na especificação do trabalho*/
	
	Label(){
		
		final int labelPosX = 390;
		final int labelPosY = 50;
		final int labelWidth = 190;
		final int labelHeight = 360;
		final int labelFontSize = 13;
		Border border = BorderFactory.createLineBorder(Color.black, 2);
		
		this.setText("<html>"
					+ "Glossário de notas:<br><br>"
					+ "A = nota La<br>"
					+ "B = nota Si<br>"
					+ "C = nota Do<br>"
					+ "D = nota Re<br>"
					+ "E = nota Mi<br>"
					+ "F = nota Fa<br>"
					+ "G = nota Sol<br><br>"
					+ "Glossário de Instrumentos:<br><br>"
					+ "; = instrumento Pan Flute<br>"
					+ ", = instrumento Church Organ<br>"
					+ "NL = instrumento Tubular Bells<br><br>"
					+ "Outras opções:<br><br>"
					+ "?/. = aumenta oitava<br>"
					+ "consoantes/a/e = repete<br>"
					+ "&emsp;&emsp;&emsp;&ensp;&nbsp;nota ou silêncio<br>"
					+ "BACKSPACE = dobra volume</html>");
		this.setBorder(border);
		this.setBounds(labelPosX, labelPosY, labelWidth, labelHeight);
		this.setOpaque(false);
		this.setBackground(Color.black);
		this.setForeground(Color.black);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.TOP);
		this.setFont(new Font("Arial", Font.PLAIN, labelFontSize));
	}
	
	/* Construtor da label de imagem que fica abaixo da label 
	 * de glossário, e que apresenta uma imagem da logo
	 * do instituto de informática na interface*/
	
	Label(ImageIcon image){
				
		final int labelPosX = 435;
		final int labelPosY = 460;
		final int labelWidth = 100;
		final int labelHeight = 100;
		
		this.setIcon(image);
		this.setBounds(labelPosX, labelPosY, labelWidth, labelHeight);
	}
}