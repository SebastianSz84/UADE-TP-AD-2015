package vista;

import java.awt.BorderLayout;
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
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class AltaProveedor extends javax.swing.JFrame
{
	private JLabel jLabel1;
	private JTextField jTextField1;
	private JLabel jLabel2;
	private JButton jButton1;
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
				AltaProveedor inst = new AltaProveedor();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AltaProveedor()
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
				getContentPane().add(jLabel1, BorderLayout.CENTER);
				jLabel1.setText("Nombre");
				jLabel1.setBounds(67, 72, 56, 25);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(141, 71, 138, 28);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Direccion");
				jLabel2.setBounds(67, 119, 63, 21);
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setBounds(142, 116, 137, 28);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Agregar Proveedor");
				jButton1.setBounds(92, 177, 164, 28);
				jButton1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						String nombre = jTextField1.getText();
						String direccion = jTextField2.getText();
						
						if (!nombre.isEmpty())
						{
							ProveedorDTO proveedorDTO = new ProveedorDTO();
							proveedorDTO.setNombre(nombre);
							proveedorDTO.setDireccion(direccion);
							BusinessDelegate.getInstancia().altaProveedor(proveedorDTO);
							dispose();
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
