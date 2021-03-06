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
public class ModificarCliente extends javax.swing.JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JButton jButton2;
	private JTextField jTextField4;
	private JTextField jTextField3;
	private JTextField jTextField2;
	private JTextField jTextField1;
	private JButton jButton1;
	private JLabel jLabel4;
	
	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				ModificarCliente inst = new ModificarCliente();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ModificarCliente()
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
				jLabel1.setText("Codigo");
				jLabel1.setBounds(12, 22, 54, 16);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Nombre");
				jLabel2.setBounds(12, 65, 59, 16);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Direccion");
				jLabel3.setBounds(12, 110, 65, 16);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Oficina de Venta Nro");
				jLabel4.setBounds(12, 164, 158, 16);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Modificar");
				jButton1.setVisible(false);
				jButton1.setBounds(260, 212, 102, 23);
				jButton1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						String codigo = jTextField1.getText();
						String nombre = jTextField2.getText();
						String direccion = jTextField3.getText();
						String idOVenta = jTextField4.getText();
						
						if (!codigo.isEmpty() && !nombre.isEmpty() && !direccion.isEmpty() && !idOVenta.isEmpty())
						{
							OVentaDTO oventaDTO = BusinessDelegate.getInstancia().getOV(Integer.parseInt(idOVenta));
							if (oventaDTO != null)
							{
								ClienteDTO clienteDTO = new ClienteDTO();
								clienteDTO.setId(Integer.parseInt(codigo));
								clienteDTO.setNombre(nombre);
								clienteDTO.setDireccion(direccion);
								clienteDTO.setOVenta(oventaDTO);
								BusinessDelegate.getInstancia().modificacionCliente(clienteDTO);
								dispose();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "No existe la oficina de venta", "Error", JOptionPane.ERROR_MESSAGE);
								jTextField4.setText("");
							}
						}
					}
				});
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(100, 19, 268, 23);
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setVisible(false);
				jTextField2.setBounds(100, 62, 270, 23);
			}
			{
				jTextField3 = new JTextField();
				getContentPane().add(jTextField3);
				jTextField3.setVisible(false);
				jTextField3.setBounds(100, 107, 270, 23);
			}
			{
				jTextField4 = new JTextField();
				getContentPane().add(jTextField4);
				jTextField4.setVisible(false);
				jTextField4.setBounds(182, 161, 188, 23);
			}
			{
				jButton2 = new JButton();
				getContentPane().add(jButton2);
				jButton2.setText("Buscar");
				jButton2.setBounds(41, 212, 85, 23);
				jButton2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						String codigo = jTextField1.getText();
						ClienteDTO cliente = BusinessDelegate.getInstancia().getClienteDTO(Integer.parseInt(codigo));
						if (cliente != null)
						{
							jTextField1.setEnabled(false);
							jButton2.setVisible(false);
							jButton1.setVisible(true);
							jTextField2.setVisible(true);
							jTextField3.setVisible(true);
							jTextField4.setVisible(true);
							jTextField2.setText(cliente.getNombre());
							jTextField3.setText(cliente.getDireccion());
							jTextField4.setText(String.valueOf(cliente.getId()));
						}
						else
						{
							JOptionPane.showMessageDialog(null, "No existe cliente", "Error", JOptionPane.ERROR_MESSAGE);
							jTextField1.setText("");
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
