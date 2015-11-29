package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import bean.RodamientoDTO;
import controlador.BusinessDelegate;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class ModificarRodamiento extends javax.swing.JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jLabel1;
	private JTextField jTextField1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JTextField jTextField4;
	private JLabel jLabel4;
	private JTextField jTextField3;
	private JButton jButton1;
	private JTextField jTextField2;
	private RodamientoDTO rodDTO;
	
	/**
	 * Auto-generated main method to display this JFrame
	 */
	
	public ModificarRodamiento(RodamientoDTO rodDTO)
	{
		super();
		this.rodDTO = rodDTO;
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
				jTextField1.setEditable(false);
				jTextField1.setText(rodDTO.getCodigoSKF());
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setBounds(7, 72, 61, 16);
				jLabel2.setText("Tipo:");
			}
			{
				jTextField2 = new JTextField();
				getContentPane().add(jTextField2);
				jTextField2.setBounds(96, 69, 266, 23);
				jTextField2.setText(rodDTO.getTipo());
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Modificar Rodamiento");
				jButton1.setBounds(96, 208, 192, 23);
				jButton1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						String tipo = jTextField2.getText();
						try
						{
							int cantidad = Integer.parseInt(jTextField3.getText());
							float precio = Float.parseFloat(jTextField4.getText());
							if (cantidad < 0)
							{
								JOptionPane.showMessageDialog(null, "Debe ingresar un número entero positivo en Cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
							}
							else
							{
								if (precio < 0)
								{
									JOptionPane.showMessageDialog(null, "Debe ingresar un número entero positivo en Cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
								}
								else
								{
									if (!tipo.isEmpty())
									{
										rodDTO.setTipo(tipo);
										rodDTO.getStock().setCantidad(cantidad);
										rodDTO.getStock().setPrecio(precio);
										if (BusinessDelegate.getInstancia().modificarRodamiento(rodDTO))
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
										JOptionPane.showMessageDialog(null, "Debe completar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
									}
								}
							}
						}
						catch (Exception e)
						{
							JOptionPane.showMessageDialog(null, "Verifique el formato de los campos Cantidad y Precio.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
			}
			{
				jTextField3 = new JTextField();
				getContentPane().add(jTextField3);
				jTextField3.setBounds(96, 104, 266, 22);
				jTextField3.setText(Integer.toString(rodDTO.getStock().getCantidad()));
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Cantidad:");
				jLabel3.setBounds(7, 107, 61, 16);
			}
			{
				jLabel4 = new JLabel();
				getContentPane().add(jLabel4);
				jLabel4.setText("Precio:");
				jLabel4.setBounds(7, 143, 61, 16);
			}
			{
				jTextField4 = new JTextField();
				getContentPane().add(jTextField4);
				jTextField4.setBounds(96, 140, 266, 22);
				jTextField4.setText(Float.toString(rodDTO.getStock().getPrecio()));
			}
			pack();
			setSize(400, 300);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
