import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Botão extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;


	JTextField caixaTexto;
	
	Botão(JTextField caixaTexto){
		
		//template comum dos botões
		this.caixaTexto = caixaTexto; 	//caixaTexto tem que ser re-instanciada para ser usada no actionListener
		this.setText("Tocar texto");
		this.setBounds(80,460,100,40);
		this.addActionListener(this);
		this.setFocusable(false);
		
	}
	
	//Ações a serem tomadas quando o botão é clicado
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this) {
			System.out.println("Bienvenido "+caixaTexto.getText());
			caixaTexto.setEditable(false);
			this.setEnabled(false);
		}
	}

}
