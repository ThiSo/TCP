import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.Border;

public class Label extends JLabel{

	private static final long serialVersionUID = 1L;
	
	//construtor da label, com parâmetros variáveis
	Label(String texto, int x, int y, int width, int height,int fontSize){
		
		Border border = BorderFactory.createLineBorder(Color.green, 1);
		ImageIcon imagem = new ImageIcon("ufrgs.png");
		
		//template comum de todas as labels
		this.setText(texto);
		this.setBorder(border);
		this.setBounds(x,y,width,height);
		this.setOpaque(true);
		this.setBackground(Color.black);
		this.setForeground(Color.green);
		this.setIcon(imagem);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setFont(new Font("Comic Sans", Font.BOLD, fontSize));
	}
}
