package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import bean.RodamientoDTO;
import controlador.BusinessDelegate;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class MenuPrincipal extends javax.swing.JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar jMenuBar1;
	private JMenuItem jMenuItem1;
	private JMenuItem jMenuItem8;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem3;
	private JMenuItem jMenuItem4;
	private JMenuItem jMenuItem5;
	private JMenuItem jMenuItem6;
	private JMenuItem jMenuItem7;
	private JMenu jMenu1;
	private JMenu jMenu2;
	private JMenu jMenu3;
	private JMenu jMenu5;
	private JMenuItem jMenuItem13;
	private JMenuItem jMenuItem12;
	private JMenuItem jMenuItem11;
	private JMenuItem jMenuItem10;
	private JMenuItem jMenuItem9;
	private JMenu jMenu4;
	
	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				MenuPrincipal inst = new MenuPrincipal();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public MenuPrincipal()
	{
		super();
		initGUI();
	}
	
	private void initGUI()
	{
		try
		{
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu1 = new JMenu();
					jMenuBar1.add(jMenu1);
					jMenu1.setText("Actualizar lista de precios");
					{
						jMenuItem1 = new JMenuItem();
						jMenu1.add(jMenuItem1);
						jMenuItem1.setText("Por XML");
						jMenuItem1.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent evt)
							{
								new ActualizarListaPreciosPorXml();
							}
						});
					}
					{
						jMenuItem2 = new JMenuItem();
						jMenu1.add(jMenuItem2);
						jMenuItem2.setText("Manualmente");
						jMenuItem2.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent evt)
							{
								new ActualizarListaPreciosManual();
							}
						});
					}
					{
						jMenu2 = new JMenu();
						jMenuBar1.add(jMenu2);
						jMenu2.setText("Mercaderia");
						{
							jMenuItem6 = new JMenuItem();
							jMenu2.add(jMenuItem6);
							jMenuItem6.setText("Ingesar nueva mercaderia");
							jMenuItem6.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent evt)
								{
									new EntradaDeMercaderiaManual();
								}
							});
						}
					}
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("Proveedor");
					{
						jMenuItem3 = new JMenuItem();
						jMenu3.add(jMenuItem3);
						jMenuItem3.setText("Alta");
						jMenuItem3.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent evt)
							{
								new AltaProveedor();
							}
						});
					}
					{
						jMenuItem4 = new JMenuItem();
						jMenu3.add(jMenuItem4);
						jMenuItem4.setText("Baja");
						jMenuItem4.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent evt)
							{
								new BajaProveedor();
							}
						});
					}
					{
						jMenuItem5 = new JMenuItem();
						jMenu3.add(jMenuItem5);
						jMenuItem5.setText("Modificación");
						jMenuItem5.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent evt)
							{
								new ModificarProveedor();
							}
						});
					}
					{
						jMenu4 = new JMenu();
						jMenuBar1.add(jMenu4);
						jMenu4.setText("Cliente");
						{
							jMenuItem8 = new JMenuItem();
							jMenu4.add(jMenuItem8);
							jMenuItem8.setText("Alta");
							jMenuItem8.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent evt)
								{
									new AltaCliente();
								}
							});
						}
						{
							jMenuItem9 = new JMenuItem();
							jMenu4.add(jMenuItem9);
							jMenuItem9.setText("Baja");
							jMenuItem9.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent evt)
								{
									new BajaCliente();
								}
							});
						}
						{
							jMenuItem10 = new JMenuItem();
							jMenu4.add(jMenuItem10);
							jMenuItem10.setText("Modificación");
							jMenuItem10.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent evt)
								{
									new ModificarCliente();
								}
							});
						}
					}
					{
						jMenu5 = new JMenu();
						jMenuBar1.add(jMenu5);
						jMenu5.setText("Rodamiento");
						jMenu5.setBounds(27, 0, 81, 25);
						{
							jMenuItem11 = new JMenuItem();
							jMenu5.add(jMenuItem11);
							jMenuItem11.setText("Alta");
							jMenuItem11.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent evt)
								{
									new AltaRodamiento();
								}
							});
						}
						{
							jMenuItem12 = new JMenuItem();
							jMenu5.add(jMenuItem12);
							jMenuItem12.setText("Baja");
							jMenuItem12.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent evt)
								{
									String codigoSKF = JOptionPane.showInputDialog(null, "Ingrese el código SKF:", "Modificar Rodamiento", JOptionPane.QUESTION_MESSAGE);
									if (codigoSKF.isEmpty())
									{
										JOptionPane.showMessageDialog(null, "Debe ingresar un código SKF.", "Error", JOptionPane.ERROR_MESSAGE);
									}
									else
									{
										RodamientoDTO rodDTO = BusinessDelegate.getInstancia().getRodamiento(codigoSKF);
										if (rodDTO == null)
										{
											JOptionPane.showMessageDialog(null, "Rodamiento inexistente.", "Error", JOptionPane.ERROR_MESSAGE);
										}
										else
										{
											if (BusinessDelegate.getInstancia().existenCotAbiertasXRod(codigoSKF))
											{
												JOptionPane.showMessageDialog(null, "Existen Cotizaciones abiertas con el rodamiento ingresado.", "Error", JOptionPane.ERROR_MESSAGE);
											}
											else
											{
												if (BusinessDelegate.getInstancia().bajaRodamiento(codigoSKF))
												{
													JOptionPane.showMessageDialog(null, "Se ha dado de baja el rodamiento.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
												}
												else
												{
													JOptionPane.showMessageDialog(null, "Error al dar de baja el rodamiento.", "Error", JOptionPane.ERROR_MESSAGE);
												}
											}
										}
									}
								}
							});
						}
						{
							jMenuItem13 = new JMenuItem();
							jMenu5.add(jMenuItem13);
							jMenuItem13.setText("Modificación");
							jMenuItem13.addActionListener(new ActionListener()
							{
								public void actionPerformed(ActionEvent evt)
								{
									String codigoSKF = JOptionPane.showInputDialog(null, "Ingrese el código SKF:", "Modificar Rodamiento", JOptionPane.QUESTION_MESSAGE);
									if (codigoSKF.isEmpty())
									{
										JOptionPane.showMessageDialog(null, "Debe ingresar un código SKF.", "Error", JOptionPane.ERROR_MESSAGE);
									}
									else
									{
										RodamientoDTO rodDTO = BusinessDelegate.getInstancia().getRodamiento(codigoSKF);
										if (rodDTO == null)
										{
											JOptionPane.showMessageDialog(null, "Rodamiento inexistente.", "Error", JOptionPane.ERROR_MESSAGE);
										}
										else
										{
											new ModificarRodamiento(rodDTO);
										}
									}
								}
							});
						}
					}
					{
						jMenuItem7 = new JMenu();
						jMenuBar1.add(jMenuItem7);
						jMenuItem7.setText("Salir");
						jMenuItem7.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent evt)
							{
								System.exit(0);
							}
						});
					}
				}
			}
			pack();
			this.setSize(679, 407);
		}
		catch (Exception e)
		{
			// add your error handling code here
			e.printStackTrace();
		}
	}
}
