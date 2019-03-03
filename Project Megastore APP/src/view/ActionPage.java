package view;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import entities.*;
import entities.customers.*;
import entities.items.Item;
import controllers.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gigabyte
 */
public class ActionPage extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	private static int nrOfBasketsCreated;
	private String customerUsername;

	private ProcessData process;
	private CustomerController customerController;
	private ArrayList<Item> items;
	private ArrayList<StoreBasket> allBaskets;
	private StoreBasket basket;
	private StoreBasketFile s;

	/**
	 * Creates new form ActionPage
	 */
	public ActionPage() {
		initComponents();
		nrOfBasketsCreated = 0;
		customerUsername = "";
		process = new ProcessData();
		customerController = new CustomerController();
		s = new StoreBasketFile();
		items = new ArrayList<Item>(process.getItems());
		allBaskets = new ArrayList<StoreBasket>();
		basket = new StoreBasket();
		priceList.setEnabled(false);
		idList.setEnabled(false);
	}

	public void setUserLogged(String userLogged) {
		userLoggedLabel.setText("  " + userLogged);
	}

	public StoreBasket getBasket() {
		return basket;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jMenu1 = new javax.swing.JMenu();
		jPanel2 = new javax.swing.JPanel();
		loggedLabel = new javax.swing.JLabel();
		newBasketButton = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		nrOfBasketsLabel = new javax.swing.JTextField();
		itemsComboBox = new javax.swing.JComboBox<>();
		addItemLabel = new javax.swing.JLabel();
		purchaseButton = new javax.swing.JButton();
		printBasketInfoButton = new javax.swing.JButton();
		userLoggedLabel = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		totalPriceLabel = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		itemList = new JList<String>(new DefaultListModel<String>());
		jScrollPane1 = new javax.swing.JScrollPane();
		idList = new JList<String>(new DefaultListModel<String>());
		jScrollPane3 = new javax.swing.JScrollPane();
		priceList = new JList<String>(new DefaultListModel<String>());
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		deleteItemButton = new javax.swing.JButton();
		deleteItemButton.setVisible(false);
		deleteItemButton.setEnabled(false);
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu2 = new javax.swing.JMenu();
		loadDataMenuItem = new javax.swing.JMenuItem();
		javax.swing.JMenuItem saveDataMenuItem = new javax.swing.JMenuItem();
		aboutMenuItem = new javax.swing.JMenuItem();
		exitMenuItem = new javax.swing.JMenuItem();
		jMenu3 = new javax.swing.JMenu();

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE));

		jMenu1.setText("jMenu1");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel2.setBackground(new java.awt.Color(0, 102, 102));

		loggedLabel.setForeground(new java.awt.Color(255, 255, 255));
		loggedLabel.setText("  Logged as : ");
		loggedLabel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

		newBasketButton.setText("New Basket ");
		newBasketButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				newBasketButtonActionPerformed(evt);
			}
		});

		jLabel1.setForeground(new java.awt.Color(255, 255, 255));
		jLabel1.setText("   Nr of baskets created : ");
		jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 255)));

		nrOfBasketsLabel
				.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 255, 255)));
		nrOfBasketsLabel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nrOfBasketsLabelActionPerformed(evt);
			}
		});

		itemsComboBox.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				itemsComboBoxItemStateChanged(evt);
			}
		});
		itemsComboBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				itemsComboBoxActionPerformed(evt);
			}
		});

		addItemLabel.setForeground(new java.awt.Color(204, 204, 255));
		addItemLabel.setText("Select item to purchase");
		addItemLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		purchaseButton.setText("Purchase basket");
		purchaseButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				purchaseButtonActionPerformed(evt);
			}
		});

		printBasketInfoButton.setText("Print basket Info");
		printBasketInfoButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				printBasketInfoButtonActionPerformed(evt);
			}
		});

		userLoggedLabel.setForeground(new java.awt.Color(255, 255, 255));
		userLoggedLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jLabel2.setForeground(new java.awt.Color(255, 255, 255));
		jLabel2.setText("  Total Price : ");
		jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		totalPriceLabel.setForeground(new java.awt.Color(204, 255, 255));
		totalPriceLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 255, 255)));

		itemList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
				itemListValueChanged(evt);
			}
		});
		jScrollPane2.setViewportView(itemList);

		jScrollPane1.setViewportView(idList);

		jScrollPane3.setViewportView(priceList);

		jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
		jLabel4.setForeground(new java.awt.Color(255, 255, 255));
		jLabel4.setText("  ITEM");
		jLabel4.setToolTipText("");
		jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
		jLabel5.setForeground(new java.awt.Color(255, 255, 255));
		jLabel5.setText("   ID");
		jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
		jLabel6.setForeground(new java.awt.Color(255, 255, 255));
		jLabel6.setText("  PRICE");
		jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		deleteItemButton.setText("Delete Item");
		deleteItemButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteItemButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel2Layout.createSequentialGroup().addComponent(loggedLabel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(userLoggedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 113,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel1).addGap(0, 0, 0)
								.addComponent(nrOfBasketsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(26, 26, 26))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(29, 29, 29)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(addItemLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 145,
														Short.MAX_VALUE)
												.addComponent(itemsComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)))
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(
										newBasketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout
										.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(deleteItemButton, javax.swing.GroupLayout.Alignment.TRAILING,
												javax.swing.GroupLayout.PREFERRED_SIZE, 111,
												javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(55, 55, 55).addComponent(jLabel2,
												javax.swing.GroupLayout.PREFERRED_SIZE, 100,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel2Layout.createSequentialGroup()
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
												.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0,
														Short.MAX_VALUE)
												.addComponent(purchaseButton, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanel2Layout.createSequentialGroup().addGap(48, 48, 48)
														.addGroup(jPanel2Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.TRAILING)
																.addComponent(jLabel5,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 100,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jScrollPane1,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 100,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(49, 49, 49)
														.addGroup(jPanel2Layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(jScrollPane3,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 89,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(jLabel6,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 86,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addComponent(totalPriceLabel,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 89,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
												.addGroup(jPanel2Layout.createSequentialGroup().addGap(55, 55, 55)
														.addComponent(printBasketInfoButton)))))
						.addGap(43, 43, 43)));
		jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(userLoggedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(nrOfBasketsLabel, javax.swing.GroupLayout.PREFERRED_SIZE,
														24, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(loggedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(42, 42, 42)
										.addComponent(newBasketButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(40, 40, 40).addComponent(addItemLabel).addGap(29, 29, 29)
										.addComponent(itemsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(41, 41, 41)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING,
														javax.swing.GroupLayout.PREFERRED_SIZE, 22,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(jPanel2Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE,
																26, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE,
																26, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addGap(18, 18, 18)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 148,
														Short.MAX_VALUE)
												.addComponent(jScrollPane1).addComponent(jScrollPane3))))
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(11, 11, 11).addComponent(
										deleteItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel2Layout.createSequentialGroup().addGap(18, 18, 18)
										.addGroup(jPanel2Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34,
														Short.MAX_VALUE)
												.addComponent(totalPriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
						.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(purchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(printBasketInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(63, 63, 63)));

		jMenu2.setText("Menu");
		jMenu2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenu2ActionPerformed(evt);
			}
		});

		loadDataMenuItem.setText("Load Data");
		loadDataMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loadDataMenuItemActionPerformed(evt);
			}
		});
		jMenu2.add(loadDataMenuItem);

		saveDataMenuItem.setText("Save Data");
		saveDataMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveDataMenuItemActionPerformed(evt);
			}
		});
		jMenu2.add(saveDataMenuItem);

		aboutMenuItem.setText("About ");
		aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				aboutMenuItemActionPerformed(evt);
			}
		});
		jMenu2.add(aboutMenuItem);

		exitMenuItem.setText("Exit ");
		exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitMenuItemActionPerformed(evt);
			}
		});
		jMenu2.add(exitMenuItem);

		jMenuBar1.add(jMenu2);
		jMenuBar1.add(jMenu3);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_aboutMenuItemActionPerformed
		// TODO add your handling code here:

		JOptionPane.showMessageDialog(this, "Information about the app.");

	}// GEN-LAST:event_aboutMenuItemActionPerformed

	private void nrOfBasketsLabelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_nrOfBasketsLabelActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_nrOfBasketsLabelActionPerformed

	private void itemsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_itemsComboBoxActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_itemsComboBoxActionPerformed

	private void newBasketButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_newBasketButtonActionPerformed
		// TODO add your handling code here:

		// get the customer name that is being served to
		customerUsername = JOptionPane.showInputDialog("Enter customer username");

		User user = customerController.getCustomer(customerUsername);

		//

		// me ane te metodes checkCustomer te klases process kontrolloj per username te
		// sakte te futur nga cashier,
		// nese rezulton username i sakte, kryhen rritjet e pikeve

		/*
		 * Check if the customer exists, if true, increase the bonus points
		 */
		process.checkIfCustomerIsRegistered(user);

		/*
		 * Save the existing basket information before creating a new one
		 */
		basket.saveData();
		basket.initialiseData();
		basket.setNameOfCashier(userLoggedLabel.getText());
		basket.increaseID();
		basket.increaseNumberOfBaskets();
		basket.setDate();

		// zbrazim listat me informacionet mbi Items te blere
		/*
		 * Empty the information lists about the bought items
		 */

		DefaultListModel listModel = (DefaultListModel) itemList.getModel();
		listModel.removeAllElements();
		DefaultListModel listModel2 = (DefaultListModel) idList.getModel();
		listModel2.removeAllElements();
		DefaultListModel listModel3 = (DefaultListModel) priceList.getModel();
		listModel3.removeAllElements();

		itemsComboBox.removeAllItems();
		totalPriceLabel.setText("0.0");

		for (Item s : items) {
			itemsComboBox.addItem(s.getName());
		}

		/*
		 * Item 1 should not be selected by default, so we set index = -1;
		 */
		itemsComboBox.setSelectedIndex(-1);
		nrOfBasketsCreated++;
		nrOfBasketsLabel.setText("  " + nrOfBasketsCreated);
	}// GEN-LAST:event_newBasketButtonActionPerformed

	private void itemsComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_itemsComboBoxItemStateChanged
		// TODO add your handling code here:

		if (evt.getStateChange() == ItemEvent.SELECTED) {
			String selectedItem = itemsComboBox.getSelectedItem().toString();
			for (Item i : items) {
				if (selectedItem.equals(i.getName())) {
					process.processBasketData(i.getName(), basket);
					basket.setID(nrOfBasketsCreated);
					((DefaultListModel) itemList.getModel()).addElement(i.getName());
					((DefaultListModel) idList.getModel()).addElement(i.getID());
					((DefaultListModel) priceList.getModel()).addElement(i.getPrice());

					totalPriceLabel.setText(Double.toString(basket.getTotalPrice()));
					break;
				}
			}
		}

	}// GEN-LAST:event_itemsComboBoxItemStateChanged

	private void printBasketInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_printBasketInfoButtonActionPerformed
		JOptionPane.showMessageDialog(this, basket.printAllInfo());
	}// GEN-LAST:event_printBasketInfoButtonActionPerformed

	private void saveDataMenuItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_saveDataMenuItemActionPerformed
		s.addStoreBasketToFile(allBaskets);

	}// GEN-LAST:event_saveDataMenuItemActionPerformed

	private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_exitMenuItemActionPerformed
		// TODO add your handling code here:

		/*
		 * Exit the program
		 */
		System.exit(1);
	}// GEN-LAST:event_exitMenuItemActionPerformed

	private void itemListValueChanged(javax.swing.event.ListSelectionEvent evt) {// GEN-FIRST:event_itemListValueChanged
		deleteItemButton.setVisible(true);
		deleteItemButton.setEnabled(true);

	}// GEN-LAST:event_itemListValueChanged

	private void purchaseButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_purchaseButtonActionPerformed
		/*
		 * print the bill
		 */
		JOptionPane.showMessageDialog(this, basket.printAllInfo());
		String info = "";
		int size = itemList.getModel().getSize();
		StringBuilder allItems = new StringBuilder();

		/*
		 * print all items and their price
		 */
		for (int i = 0; i < size; i++) {
			allItems.append("\n").append(itemList.getModel().getElementAt(i)).append("         ")
					.append(String.valueOf(priceList.getModel().getElementAt(i)));
		}
		JOptionPane.showMessageDialog(this, "Item " + "         Price\n" + allItems);

		allBaskets.add(basket);
		basket.saveData();
		basket.initialiseData();
		basket.setNameOfCashier(userLoggedLabel.getText());
		basket.increaseID();
		basket.increaseNumberOfBaskets();
		basket.setDate();
		DefaultListModel listModel = (DefaultListModel) itemList.getModel();
		listModel.removeAllElements();
		DefaultListModel listModel2 = (DefaultListModel) idList.getModel();
		listModel2.removeAllElements();
		DefaultListModel listModel3 = (DefaultListModel) priceList.getModel();
		listModel3.removeAllElements();
		itemsComboBox.removeAllItems();
		totalPriceLabel.setText("0.0");

	}// GEN-LAST:event_purchaseButtonActionPerformed

	private void deleteItemButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteItemButtonActionPerformed
		int selectedIndex = itemList.getSelectedIndex();

		basket.removeItemPrice(
				Double.parseDouble(((DefaultListModel) priceList.getModel()).getElementAt(selectedIndex).toString()));
		totalPriceLabel.setText(String.valueOf(basket.getTotalPrice()));
		((DefaultListModel) itemList.getModel()).remove(selectedIndex);
		((DefaultListModel) idList.getModel()).remove(selectedIndex);
		((DefaultListModel) priceList.getModel()).remove(selectedIndex);

		/*
		 * hide button until a new item is selected
		 */
		deleteItemButton.setVisible(false);
		deleteItemButton.setEnabled(false);

	}// GEN-LAST:event_deleteItemButtonActionPerformed

	private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenu2ActionPerformed
		// TODO add your handling code here:

	}// GEN-LAST:event_jMenu2ActionPerformed

	private void loadDataMenuItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_loadDataMenuItemActionPerformed
		// TODO add your handling code here:

		ArrayList<StoreBasket> baskets;
		baskets = new ArrayList<>(s.readBaskets());

		/*
		 * print info for each basket
		 */
		for (StoreBasket i : baskets) {
			JOptionPane.showMessageDialog(this, i.printAllInfo());
		}

	}// GEN-LAST:event_loadDataMenuItemActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		try {

			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ActionPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ActionPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ActionPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ActionPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				ActionPage a = new ActionPage();
				a.setVisible(true);
				a.setResizable(false);

			}

		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JMenuItem aboutMenuItem;
	private javax.swing.JLabel addItemLabel;
	private javax.swing.JButton deleteItemButton;
	private javax.swing.JMenuItem exitMenuItem;
	private javax.swing.JList<String> idList;
	private javax.swing.JList<String> itemList;
	private javax.swing.JComboBox<String> itemsComboBox;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JMenuItem loadDataMenuItem;
	private javax.swing.JLabel loggedLabel;
	private javax.swing.JButton newBasketButton;
	private javax.swing.JTextField nrOfBasketsLabel;
	private javax.swing.JList<String> priceList;
	private javax.swing.JButton printBasketInfoButton;
	private javax.swing.JButton purchaseButton;
	private javax.swing.JLabel totalPriceLabel;
	private javax.swing.JLabel userLoggedLabel;
	// End of variables declaration//GEN-END:variables
}
