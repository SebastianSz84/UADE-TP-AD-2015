package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import bean.ProveedorDTO;
import controlador.BusinessDelegate;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class ModificarProveedor extends javax.swing.JFrame
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
				ModificarProveedor inst = new ModificarProveedor();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public ModificarProveedor()
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
				jLabel1.setBounds(76, 57, 49, 21);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(161, 54, 142, 28);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Nombre");
				jLabel2.setBounds(76, 111, 55, 21);
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setBounds(161, 108, 142, 28);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Direccion");
				jLabel3.setBounds(76, 163, 63, 21);
			}
			{
				jTextField3 = new JTextField();
				getContentPane().add(jTextField3);
				jTextField3.setBounds(161, 160, 142, 28);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Modifcar Proveedor");
				jButton1.setBounds(109, 214, 146, 28);
				jButton1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						String codigo = jTextField1.getText();
						String nombre = jTextField2.getText();
						String direccion = jTextField3.getText();

						if (!codigo.isEmpty())
						{
							ProveedorDTO proveedorDTO = new ProveedorDTO();
							proveedorDTO.setCodigoProveedor(Integer.parseInt(codigo));
							proveedorDTO.setNombre(nombre);
							proveedorDTO.setDireccion(direccion);
							BusinessDelegate.getInstancia().modificacionProveedor(proveedorDTO);
							dispose();
						}
					}
				});
			}
			pack();
			setSize(400, 300);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		} catch (Exception e)
		{
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
