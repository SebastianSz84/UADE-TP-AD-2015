package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import Entities.CCentral;

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
public class ActualizarListaPreciosPorXml extends javax.swing.JFrame
{
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JButton jButton1;
	private JTextField jTextField2;
	private JLabel jLabel3;
	private JTextField jTextField1;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				ActualizarListaPreciosPorXml inst = new ActualizarListaPreciosPorXml();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public ActualizarListaPreciosPorXml()
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
				jLabel1.setText("Actualizar precios por XML");
				jLabel1.setBounds(92, 20, 178, 21);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Direccion archivo");
				jLabel2.setBounds(12, 108, 115, 21);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(145, 105, 229, 28);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Actualizar");
				jButton1.setBounds(139, 145, 80, 28);
				jButton1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						if (!jTextField2.getText().isEmpty() && !jTextField1.getText().isEmpty())
						{
							int codigoProveedor = Integer.parseInt(jTextField2.getText());
							CCentral.getInstancia().generarListaDePrecioProveedorAutomatica(jTextField1.getText().toString(), codigoProveedor);
							dispose();
						} else
						{
							JOptionPane.showMessageDialog(null, "Error al actualizar precios.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Codigo Proveedor");
				jLabel3.setBounds(12, 76, 121, 21);
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setBounds(145, 73, 125, 28);
			}
			pack();
			this.setSize(416, 300);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		} catch (Exception e)
		{
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
