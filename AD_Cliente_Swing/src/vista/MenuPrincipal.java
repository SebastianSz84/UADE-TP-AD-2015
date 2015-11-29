package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

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
public class MenuPrincipal extends javax.swing.JFrame
{
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
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
						jMenuItem5.setText("Modificacion");
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
							jMenuItem8.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									new AltaCliente();
								}
							});
						}
						{
							jMenuItem9 = new JMenuItem();
							jMenu4.add(jMenuItem9);
							jMenuItem9.setText("Baja");
							jMenuItem9.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									new BajaCliente();
								}
							});
						}
						{
							jMenuItem10 = new JMenuItem();
							jMenu4.add(jMenuItem10);
							jMenuItem10.setText("Modificacion");
							jMenuItem10.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent evt) {
									new ModificarCliente();
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
		} catch (Exception e)
		{
			// add your error handling code here
			e.printStackTrace();
		}
	}
}
