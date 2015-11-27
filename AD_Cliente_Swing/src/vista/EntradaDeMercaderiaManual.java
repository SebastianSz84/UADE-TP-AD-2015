package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controlador.BusinessDelegate;
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
public class EntradaDeMercaderiaManual extends javax.swing.JFrame
{

	private JLabel jLabel1;
	private JScrollPane jScrollPane1;
	private JButton jButton1;
	private JScrollPane jScrollPane2;
	private JTable jTable1;
	private TableModel jTable1Model;

	/**
	 * Auto-generated main method to display this JFrame
	 */
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				EntradaDeMercaderiaManual inst = new EntradaDeMercaderiaManual();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

	public EntradaDeMercaderiaManual()
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
				jLabel1.setText("Entrada de productos manualmente");
				jLabel1.setBounds(233, 19, 224, 21);
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(0, 46, 706, 188);
				{
					jScrollPane2 = new JScrollPane();
					jScrollPane1.setViewportView(jScrollPane2);
					jScrollPane2.setPreferredSize(new java.awt.Dimension(703, 160));
					{
						jTable1Model = new DefaultTableModel(new String[][]
						{
						{ "", "", "", "", "", "" },
						{ "", "", "", "", "", "" },
						{ "", "", "", "", "", "" },
						{ "", "", "", "", "", "" },
						{ "", "", "", "", "", "" },
						{ "", "", "", "", "", "" },
						{ "", "", "", "", "", "" },
						{ "", "", "", "", "", "" },
						{ "", "", "", "", "", "" },
						{ "", "", "", "", "", "" } }, new String[]
						{ "SKF", "Cantidad" });
						jTable1 = new JTable();
						jScrollPane2.setViewportView(jTable1);
						jTable1.setModel(jTable1Model);
					}
				}
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Actualizar");
				jButton1.setBounds(301, 263, 80, 28);
				jButton1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						boolean breaked = false;
						for (int i = 0; i < 10; i++)
						{
							for (int j = 0; j < 6; j++)
							{
								String valor = (String) jTable1Model.getValueAt(i, j);
								if (valor == "")
								{
									breaked = true;
									break;
								}
							}
							if (breaked)
							{
								break;
							}
							String SKF = (String) jTable1Model.getValueAt(i, 0);
							int cantidad = (Integer) jTable1Model.getValueAt(i, 1);

							BusinessDelegate.getInstancia().GenerarBultosDeRodamiento(SKF, cantidad);
						}

						dispose();
					}
				});
			}
			pack();
			this.setSize(724, 360);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
		} catch (Exception e)
		{
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
