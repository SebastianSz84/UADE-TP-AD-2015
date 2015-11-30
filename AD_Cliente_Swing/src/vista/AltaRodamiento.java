package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import bean.RodamientoDTO;
import bean.StockDTO;
import controlador.BusinessDelegate;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class AltaRodamiento extends javax.swing.JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
				AltaRodamiento inst = new AltaRodamiento();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public AltaRodamiento()
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
				jLabel1.setText("Código SKF:");
				jLabel1.setBounds(7, 36, 77, 16);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(96, 33, 266, 23);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setBounds(7, 95, 61, 16);
				jLabel2.setText("Tipo:");
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setBounds(96, 92, 266, 23);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Crear Rodamiento");
				jButton1.setBounds(108, 208, 171, 23);
				jButton1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						String codigoSKF = jTextField1.getText();
						String tipo = jTextField2.getText();
						
						if (!codigoSKF.isEmpty() && !tipo.isEmpty())
						{
							RodamientoDTO rodDTO = BusinessDelegate.getInstancia().getRodamiento(codigoSKF);
							if (rodDTO == null)
							{
								rodDTO = new RodamientoDTO();
								rodDTO.setCodigoSKF(codigoSKF);
								rodDTO.setTipo(tipo);
								StockDTO stkDTO = new StockDTO();
								stkDTO.setCantidad(0);
								stkDTO.setPrecio(0);
								rodDTO.setStock(stkDTO);
								if (BusinessDelegate.getInstancia().altaRodamiento(rodDTO))
								{
									JOptionPane.showMessageDialog(null, "Se ha dado de alta el rodamiento.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
									dispose();
								}
								else
								{
									JOptionPane.showMessageDialog(null, "Error al dar de alta el rodamiento.", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
							else
							{
								JOptionPane.showMessageDialog(null, "El rodamiento ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Debe completar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
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
