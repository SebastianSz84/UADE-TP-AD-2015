package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import bean.ClienteDTO;
import bean.OVentaDTO;
import controlador.BusinessDelegate;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class AltaCliente extends javax.swing.JFrame
{
	private JLabel jLabel1;
	private JTextField jTextField1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JButton jButton1;
	private JTextField jTextField3;
	private JTextField jTextField2;
	
	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				AltaCliente inst = new AltaCliente();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AltaCliente()
	{
		super();
		initGUI();
	}
	
	private void initGUI()
	{
		try
		{
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("Nombre");
				jLabel1.setBounds(7, 36, 60, 16);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(96, 33, 266, 23);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Direccion");
				jLabel2.setBounds(12, 95, 61, 16);
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setBounds(96, 92, 266, 23);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Oficina de Venta Nro");
				jLabel3.setBounds(7, 152, 126, 16);
			}
			{
				jTextField3 = new JTextField();
				getContentPane().add(jTextField3);
				jTextField3.setBounds(172, 149, 190, 23);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Crear Usuario");
				jButton1.setBounds(133, 208, 123, 23);
				jButton1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						String nombre = jTextField1.getText();
						String direccion = jTextField2.getText();
						String idOVenta = jTextField3.getText();
						
						if (!nombre.isEmpty() && !direccion.isEmpty() && !idOVenta.isEmpty())
						{
							OVentaDTO oventaDTO = BusinessDelegate.getInstancia().getOV(Integer.parseInt(idOVenta));
							if (oventaDTO != null)
							{
								ClienteDTO clienteDTO = new ClienteDTO();
								clienteDTO.setNombre(nombre);
								clienteDTO.setDireccion(direccion);
								clienteDTO.setOVenta(oventaDTO);
								new ClienteFormaDePago(clienteDTO);
								dispose();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "No existe la oficina de venta", "Error", JOptionPane.ERROR_MESSAGE);
								jTextField3.setText("");
							}
						}
						
					}
				});
			}
			pack();
			setSize(400, 300);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
		catch (Exception e)
		{
			// add your error handling code here
			e.printStackTrace();
		}
	}
	
}
