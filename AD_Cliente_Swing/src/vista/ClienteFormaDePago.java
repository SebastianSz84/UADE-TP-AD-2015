package vista;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import controlador.BusinessDelegate;
import bean.ClienteDTO;
import bean.FormaDePagoDTO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ClienteFormaDePago extends javax.swing.JFrame {
	private JLabel jLabel1;
	private JTextField jTextField1;
	private JButton jButton1;
	private JButton jButton2;
	final List<FormaDePagoDTO> formas = new ArrayList<FormaDePagoDTO>();

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ClienteFormaDePago inst = new ClienteFormaDePago(new ClienteDTO());
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	

	public ClienteFormaDePago(ClienteDTO clienteDTO) {
		super();
		initGUI(clienteDTO);
	}
	
	private void initGUI(final ClienteDTO clienteDTO) {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText(clienteDTO.getNombre());
				jLabel1.setBounds(12, 12, 84, 16);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(79, 82, 190, 23);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Agregar forma de pago");
				jButton1.setBounds(16, 144, 172, 23);
				jButton1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						String codigoForma = jTextField1.getText();
						if(!codigoForma.isEmpty()){
							FormaDePagoDTO formaDTO = BusinessDelegate.getInstancia().getForma(Integer.parseInt(codigoForma));
							if(formaDTO!=null){
								formas.add(formaDTO);
							}
							jTextField1.setText("");
						}
					}
				});
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Listo!");
				jButton2.setBounds(233, 144, 87, 23);
				jButton2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						clienteDTO.setFormasDepago(formas);
						BusinessDelegate.getInstancia().altaCliente(clienteDTO);
					}
				});
			}
			pack();
			this.setSize(370, 235);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
