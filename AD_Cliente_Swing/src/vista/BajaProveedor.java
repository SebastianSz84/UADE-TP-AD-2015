package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import bean.ProveedorDTO;
import controlador.BusinessDelegate;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class BajaProveedor extends javax.swing.JFrame
{
	private JLabel jLabel1;
	private JTextField jTextField1;
	private JButton jButton1;
	
	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				BajaProveedor inst = new BajaProveedor();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public BajaProveedor()
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
				jLabel1.setBounds(74, 67, 49, 21);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(141, 64, 146, 28);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Borrar Proveedor");
				jButton1.setBounds(115, 141, 144, 28);
				jButton1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						String codigo = jTextField1.getText();
						
						if (!codigo.isEmpty())
						{
							ProveedorDTO prove = BusinessDelegate.getInstancia().getProveedorDTO(Integer.parseInt(codigo));
							if (prove != null)
							{
								BusinessDelegate.getInstancia().bajaProveedor(Integer.parseInt(codigo));
								JOptionPane.showMessageDialog(null, "Se ha dado de baja el proveedor.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}
							else
							{
								JOptionPane.showMessageDialog(null, "No existe el proveedor", "Error", JOptionPane.ERROR_MESSAGE);
								jTextField1.setText("");
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
