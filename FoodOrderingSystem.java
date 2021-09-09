import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class FoodOrderingSystem{
	
	private static int id;
	private static int registerId[];
	private static String registerPin[];
	
	private static int trackingNum;
	private static int registerTrack[];
	private static String registerStatus[];
	
	private static JTable table;
	
	private static double totalPrice = 0;
	private static double p1 = 0, p2 = 0, p3 = 0, p4 = 0, p5 = 0, p6 = 0, p7 = 0, p8 = 0, p9 = 0;
	private static double d1, d2 = 0, d3 = 0, d4 = 0, d5 = 0;
	private static double de1 = 0, de2 = 0;
	
	private static double total = 0;
	private static double food1 = 0, food2 = 0, food3 = 0, food4 = 0, food5 = 0, food6 = 0, food7 = 0, food8 = 0, food9 = 0;
	private static double drink1 = 0, drink2 = 0, drink3 = 0, drink4 = 0, drink5 = 0;
	private static double pr, pr1;

	private static double totalForFoods = 0;
	private static double totalForDrinks = 0;
	private static double totalForDesserts = 0;
	

    public static void createLoginMenu() throws IOException {    	
    	JLabel picLabel;
		JLabel mainTitle;
    	JButton mainButton, mainButton2, mainButton3;
        Panel mainPanel1, mainPanel2, mainPanel3;
        JFrame mainFrame;
        
        JPanel LoginPanel = new JPanel(new BorderLayout());
        File imageFile = new File("image/welcome.jpg");
        Image image = ImageIO.read(imageFile);
        Image imageScaled = image.getScaledInstance(350, 300, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(imageScaled);
        picLabel = new JLabel(imageIcon);
        Box right = Box.createVerticalBox();
        mainPanel1 = new Panel();
        mainPanel2 = new Panel();
        mainPanel3 = new Panel();
        mainTitle = new JLabel("FA 20 - Group 14 Food Restaurant");
        mainTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainTitle.setAlignmentY(0.0f);
        mainTitle.setHorizontalAlignment(SwingConstants.CENTER);
        mainTitle.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 18));
        mainTitle.setForeground(Color.BLUE);

        // Button, with filler
        mainButton = new JButton("Customer Create Account >>");
        mainPanel1.add(mainButton);
        mainButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainButton2 = new JButton("Customer Log in >>");
        mainPanel2.add(mainButton2);
        mainButton2.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainButton3 = new JButton("Admin Log In >>");
        mainPanel3.add(mainButton3);
        mainButton3.setAlignmentX(Component.LEFT_ALIGNMENT);

        LoginPanel.add(picLabel, BorderLayout.CENTER);
        LoginPanel.add(right, BorderLayout.SOUTH);
        right.add(mainTitle);
        right.add(mainPanel1);
        right.add(mainPanel2);
        right.add(mainPanel3);
        
        mainFrame = new JFrame();
        mainFrame.setTitle("FA 20 - Group 14 Food Restaurant");
        mainFrame.getContentPane().add(LoginPanel);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        
        JLabel newCusTitle;
    	JButton newCusConfirmButton, newCusExitButton;
    	Panel newCusPanel1, newCusPanel2, newCusPanel3;
    	JTextField newCusNameField, newCusPinField;
    	JFrame newCusFrame;
    	
        JPanel newCusPanel = new JPanel(new BorderLayout());
        Box right2 = Box.createVerticalBox();
        newCusPanel1 = new Panel();
        newCusPanel2 = new Panel();
        newCusPanel3 = new Panel();
        newCusTitle = new JLabel("New Customer Create Account");
        newCusTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        newCusTitle.setAlignmentY(0.0f);
        newCusTitle.setHorizontalAlignment(SwingConstants.CENTER);
        newCusTitle.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 18));
        newCusTitle.setForeground(Color.BLUE);

        JLabel lblName = new JLabel("Name : ");
        newCusPanel1.add(lblName);
        lblName.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        newCusNameField = new JTextField();
        newCusNameField.setColumns(10);
        newCusPanel1.add(newCusNameField);
        newCusNameField.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel lblNewPin = new JLabel("New Password : ");
        newCusPanel2.add(lblNewPin);
        lblNewPin.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        newCusPinField = new JTextField();
        newCusPinField.setColumns(10);
        newCusPanel2.add(newCusPinField);
        newCusNameField.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Button, with filler
        newCusConfirmButton = new JButton("Confirm");
        newCusPanel3.add(newCusConfirmButton);
        newCusConfirmButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        newCusExitButton = new JButton("Cancel");
        newCusPanel3.add(newCusExitButton);
        newCusExitButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        newCusPanel.add(right2, BorderLayout.SOUTH);
        right2.add(newCusTitle);
        right2.add(newCusPanel1);
        right2.add(newCusPanel2);
        right2.add(newCusPanel3);
        
        newCusFrame = new JFrame();
        newCusFrame.setTitle("Admin Menu");
        newCusFrame.getContentPane().add(newCusPanel);
        newCusFrame.pack();
        newCusFrame.setLocationRelativeTo(null);
        newCusFrame.setBounds(300, 300, 400, 170); // x,y,width,height
        
        JLabel cusLoginTitle;
        JButton cusLoginConfirmButton, cusLoginExitButton;
        Panel cusLoginPanel1, cusLoginPanel2, cusLoginPanel3;
        JTextField cusLoginIdField, cusLoginPinField;
        JFrame cusLoginFrame;

        JPanel cusLoginPanel = new JPanel(new BorderLayout());
        Box right3 = Box.createVerticalBox();
        cusLoginPanel1 = new Panel();
        cusLoginPanel2 = new Panel();
        cusLoginPanel3 = new Panel();
        cusLoginTitle = new JLabel("Customer Log In");
        cusLoginTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        cusLoginTitle.setAlignmentY(0.0f);
        cusLoginTitle.setHorizontalAlignment(SwingConstants.CENTER);
        cusLoginTitle.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 18));
        cusLoginTitle.setForeground(Color.BLUE);

        JLabel lblID = new JLabel("ID: ");
        cusLoginPanel1.add(lblID);
        lblID.setAlignmentX(Component.LEFT_ALIGNMENT);

        cusLoginIdField = new JTextField();
        cusLoginIdField.setColumns(10);
        cusLoginPanel1.add(cusLoginIdField);
        cusLoginIdField.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblPin = new JLabel("Password: ");
        cusLoginPanel2.add(lblPin);
        lblPin.setAlignmentX(Component.LEFT_ALIGNMENT);

        cusLoginPinField = new JTextField();
        cusLoginPinField.setColumns(10);
        cusLoginPanel2.add(cusLoginPinField);
        cusLoginIdField.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Button, with filler
        cusLoginConfirmButton = new JButton("Confirm");
        cusLoginPanel3.add(cusLoginConfirmButton);
        cusLoginConfirmButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        cusLoginExitButton = new JButton("Cancel");
        cusLoginPanel3.add(cusLoginExitButton);
        cusLoginExitButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        cusLoginPanel.add(right3, BorderLayout.SOUTH);
        right3.add(cusLoginTitle);
        right3.add(cusLoginPanel1);
        right3.add(cusLoginPanel2);
        right3.add(cusLoginPanel3);

        cusLoginFrame = new JFrame();
        cusLoginFrame.setTitle("Customer Log In");
        cusLoginFrame.getContentPane().add(cusLoginPanel);
        cusLoginFrame.pack();
        cusLoginFrame.setLocationRelativeTo(null);
        cusLoginFrame.setBounds(300, 300, 400, 170); // x,y,width,height
        
        JLabel adminLoginTitle;
        JButton adminLoginConfirmButton, adminLoginExitButton;
        Panel adminLoginPanel1, adminLoginPanel2;
        JTextField adminPinField;
        JFrame adminLoginFrame;

        JPanel panel = new JPanel(new BorderLayout());
        Box right4 = Box.createVerticalBox();
        adminLoginPanel1 = new Panel();
        adminLoginPanel2 = new Panel();
        adminLoginTitle = new JLabel("Admin Log In (Password:999)");
        adminLoginTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        adminLoginTitle.setAlignmentY(0.0f);
        adminLoginTitle.setHorizontalAlignment(SwingConstants.CENTER);
        adminLoginTitle.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 18));
        adminLoginTitle.setForeground(Color.BLUE);

        JLabel lblAdminPin = new JLabel("Password: ");
        adminLoginPanel1.add(lblAdminPin);
        lblAdminPin.setAlignmentX(Component.LEFT_ALIGNMENT);

        adminPinField = new JTextField();
        adminPinField.setColumns(10);
        adminLoginPanel1.add(adminPinField);
        adminPinField.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Button, with filler
        adminLoginConfirmButton = new JButton("Confirm");
        adminLoginPanel2.add(adminLoginConfirmButton);
        adminLoginConfirmButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        adminLoginExitButton = new JButton("Cancel");
        adminLoginPanel2.add(adminLoginExitButton);
        adminLoginExitButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        panel.add(right4, BorderLayout.SOUTH);
        right4.add(adminLoginTitle);
        right4.add(adminLoginPanel1);
        right4.add(adminLoginPanel2);

        adminLoginFrame = new JFrame();
        adminLoginFrame.setTitle("Admin Log In");
        adminLoginFrame.getContentPane().add(panel);
        adminLoginFrame.pack();
        adminLoginFrame.setLocationRelativeTo(null);
        adminLoginFrame.setBounds(300, 300, 400, 140); // x,y,width,height
        
        mainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newCusFrame.setVisible(true);
				mainFrame.dispose();
            }
        });
        
        mainButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cusLoginFrame.setVisible(true);
				mainFrame.dispose();
			}
        });
        
        mainButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adminLoginFrame.setVisible(true);
				mainFrame.dispose();
			}
        });
        
        newCusConfirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(newCusNameField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Name cannot be left empty, Please fill in your name. ");
				}
				else if(newCusPinField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "New password cannot be left empty, Please fill in new password. ");
				}
				else {
					id++;
					registerPin[id] = newCusPinField.getText();
					registerId[id] = id;
					JOptionPane.showMessageDialog(null, "Successful! \nID: " + registerId[id] + "\nPassword: " + newCusPinField.getText());
					newCusNameField.setText("");
					newCusPinField.setText("");
					newCusFrame.dispose();
					mainFrame.setVisible(true);
				}
			}
        });
        
        cusLoginConfirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cusLoginIdField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill in your ID. ");
				}
				else if(!isInteger(cusLoginIdField.getText())){
					JOptionPane.showMessageDialog(null, "Invalid ID, ID has to be integer. ");
				}
				else if(cusLoginPinField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill in your password. ");
				}
				else {
					boolean valid = false;
					for(int i = 1; i <= id; i++) {
						if(Integer.parseInt(cusLoginIdField.getText()) == registerId[i] && cusLoginPinField.getText().equals(registerPin[i])) {
							valid = true;
						}
					}
					if(valid) {
						cusLoginIdField.setText("");
						cusLoginPinField.setText("");
						cusLoginFrame.dispose();
						try {
							createMainMenu();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect ID or password. ");
					}
				}
			}
        });
        
        adminLoginConfirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(adminPinField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill in password. ");
				}
				else if(adminPinField.getText().equals("999")) {
					adminLoginFrame.dispose();
					try {
						createAdminMenu();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect password. ");
				}
			}
        });
        
        newCusExitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newCusNameField.setText("");
				newCusPinField.setText("");
				newCusFrame.dispose();
				mainFrame.setVisible(true);
			}
        });
        
        cusLoginExitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cusLoginIdField.setText("");
				cusLoginPinField.setText("");
				cusLoginFrame.dispose();
				mainFrame.setVisible(true);
			}
        });
        
        adminLoginExitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				adminPinField.setText("");
				adminLoginFrame.dispose();
				mainFrame.setVisible(true);
			}
        });
    }
    
    public static void createAdminMenu() throws IOException {
    	JLabel title;
    	JButton button, button2;
    	Panel panel_1, panel_2, panel_3;
    	JTextField textField, textField2;
    	JFrame frame;
    	
        JPanel panel = new JPanel(new BorderLayout());
        Box right = Box.createVerticalBox();
        panel_1 = new Panel();
        panel_2 = new Panel();
        panel_3 = new Panel();
        title = new JLabel("Update Food Status");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setAlignmentY(0.0f);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 18));
        title.setForeground(Color.BLUE);

        JLabel lbltrackingNum = new JLabel("Tracking Number: ");
        panel_1.add(lbltrackingNum);
        lbltrackingNum.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        textField = new JTextField();
        textField.setColumns(10);
        panel_1.add(textField);
        textField.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel lblStatus = new JLabel("Status: ");
        panel_2.add(lblStatus);
        lblStatus.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        textField2 = new JTextField();
        textField2.setColumns(10);
        panel_2.add(textField2);
        textField.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        // Button, with filler
        button = new JButton("Confirm");
        panel_3.add(button);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button2 = new JButton("Cancel");
        panel_3.add(button2);
        button2.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(right, BorderLayout.SOUTH);
        right.add(title);
        right.add(panel_1);
        right.add(panel_2);
        right.add(panel_3);

        frame = new JFrame();
        frame.setTitle("Admin Menu");
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setBounds(300, 300, 400, 170); // x,y,width,height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in your tracking number. ");
                } else if(!isInteger(textField.getText())) {
                	JOptionPane.showMessageDialog(null, "Invalid tracking number, has to be integer. ");
                } else if (textField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in new status. ");
                } else {
                	boolean valid = false;
					for(int i = 1; i <= trackingNum; i++) {
						if(Integer.parseInt(textField.getText()) == registerTrack[i]) {
							valid = true;
						}
					}
					if(valid) {
						registerStatus[Integer.parseInt(textField.getText())] = textField2.getText();
						JOptionPane.showMessageDialog(null, "Status for tracking number #" + textField.getText() + " has been updated. ");
						frame.dispose();
		            	try {
							createLoginMenu();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Invalid tracking number. ");
					}
                }
            }
        });
        
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	frame.dispose();
            	try {
					createLoginMenu();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
    }
    
    public static void createMainMenu() throws IOException {
    	JLabel picLabel, title;
    	JButton button, button2;
        Panel panel_1, panel_2;
        JFrame frame;
        
        JPanel panel = new JPanel(new BorderLayout());
        File imageFile = new File("image/food_logo1.jpg");
        Image image = ImageIO.read(imageFile);
        Image imageScaled = image.getScaledInstance(350, 300, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(imageScaled);
        picLabel = new JLabel(imageIcon);
        Box right = Box.createVerticalBox();
        panel_1 = new Panel();
        panel_2 = new Panel();
        title = new JLabel("Main Menu");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setAlignmentY(0.0f);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 18));
        title.setForeground(Color.BLUE);

        // Button, with filler
        button = new JButton("Order Food Now >>");
        panel_1.add(button);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button2 = new JButton("Track Your Food >>");
        panel_2.add(button2);
        button2.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(picLabel, BorderLayout.CENTER);
        panel.add(right, BorderLayout.SOUTH);
        right.add(title);
        right.add(panel_1);
        right.add(panel_2);
        
        frame = new JFrame();
        frame.setTitle("FA 20 - Group 14 Food Restaurant");
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    createFoodMenu();
                    frame.dispose();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        
        button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
        		try {
        			createTrackMenu();
        			frame.dispose();
        		} catch(IOException e1) {
        			e1.printStackTrace();
        		}
			}
        });
    }
    
    public static void createFoodMenu() throws IOException {
    	JFrame frame;
    	JButton backButton, orderButton;
    	JTextField textField;
    	GridBagConstraints gbc;
        DefaultTableModel dtm;
        Double[] price;
        Double[] priceDrinks;
        Double[] priceDesserts;

        JSpinner[] numSpinner;
        JLabel[] foodLabel;
        JLabel[] foodImage;
        String[] file;

        JSpinner[] numSpinnerDrinks;
        JLabel[] drinkLabel;
        JLabel[] drinkImage;
        String[] fileDrinks;

        JSpinner[] numSpinnerDesserts;
        JLabel[] dessertLabel;
        JLabel[] dessertImage;
        String[] fileDesserts;

        final int ELEMENTS = 9;
        final int DRINK_ELEMENTS = 5;
        final int DESSERT_ELEMENTS = 2;
        
        frame = new JFrame("Food Menu ");
        frame.setBounds(100, 100, 750, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        JLabel lblFoodOrdered = new JLabel("Cart");
        lblFoodOrdered.setBounds(529, 11, 81, 14);

        frame.getContentPane().add(lblFoodOrdered);

        table = new JTable();
        backButton = new JButton();
        orderButton = new JButton();
        dtm = new DefaultTableModel(0, 0);
        final String header[] = new String[]{"Item", "Qty", "Price", "Spinner"};
        dtm.setColumnIdentifiers(header);
        dtm.addRow(header);
        table = new JTable();
        table.setModel(dtm);
        table.setBounds(475, 31, 1, 1); // int x, int y, int width, int height
        table.setSize(245, 300); // width,height
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(30);
        table.getColumnModel().getColumn(2).setPreferredWidth(30);
        table.getColumnModel().getColumn(3).setMinWidth(0); // hide spinner
        // column
        table.getColumnModel().getColumn(3).setMaxWidth(0); // hide spinner
        // column
        table.setShowGrid(false); // remove cell boarder
        frame.getContentPane().add(table);
        JLabel lblTotal = new JLabel("Total  : ");
        lblTotal.setBounds(519, 340, 46, 14);
        frame.getContentPane().add(lblTotal);
        textField = new JTextField();
        textField.setBounds(585, 340, 86, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        orderButton = new JButton("Order");
        orderButton.setBounds(500, 385, 89, 23);
        frame.getContentPane().add(orderButton);
        backButton = new JButton("Back");
        backButton.setBounds(610, 385, 89, 23);
        frame.getContentPane().add(backButton);
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        
        JPanel foodPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints(); // getting constraints for the specified
        // component
        gbc.insets = new Insets(10, 0, 0, 0);
        foodImage = new JLabel[ELEMENTS];
        foodLabel = new JLabel[ELEMENTS];
        numSpinner = new JSpinner[ELEMENTS];
        file = new String[ELEMENTS];
        price = new Double[ELEMENTS];

        file[0] = new String("image/MedSalad.png");
        file[1] = new String("image/Ramen.jpg");
        file[2] = new String("image/spaghetti.jpg");
        file[3] = new String("image/burger.jpg");
        file[4] = new String("image/pho.jpg");
        file[5] = new String("image/friedrice.jpg");
        file[6] = new String("image/chickenRice.jpg");
        file[7] = new String("image/thaiFood.jpg");
        file[8] = new String("image/bibimbap.jpg");
        foodLabel[0] = new JLabel("Salad");
        foodLabel[1] = new JLabel("Ramen");
        foodLabel[2] = new JLabel("Spaghetti");
        foodLabel[3] = new JLabel("Burger");
        foodLabel[4] = new JLabel("Vietnamese Pho");
        foodLabel[5] = new JLabel("Fried Rice");
        foodLabel[6] = new JLabel("Chicken Rice");
        foodLabel[7] = new JLabel("Thai Food");
        foodLabel[8] = new JLabel("Korean Bibimbap");
        price[0] = 7.50;
        price[1] = 11.50;
        price[2] = 14.70;
        price[3] = 12.50;
        price[4] = 9.50;
        price[5] = 8.00;
        price[6] = 7.50;
        price[7] = 6.50;
        price[8] = 13.50;
        
        ChangeListener listenerForFood = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                final int quantity = (int) ((JSpinner) e.getSource()).getValue();
                final int rows = table.getRowCount();
                for (int row = 0; row < rows; row++) {
                    if (dtm.getValueAt(row, 3) == e.getSource()) {
                        if (dtm.getValueAt(row, 0).equals("Salad")) {
                            dtm.setValueAt(quantity, row, 1); // obj, row, column
                            dtm.setValueAt(p1 * quantity, row, 2);
                            food1 = p1 * quantity;

                        } else if (dtm.getValueAt(row, 0).equals("Ramen")) {

                            dtm.setValueAt(quantity, row, 1);
                            dtm.setValueAt(p2 * quantity, row, 2);
                            food2 = p2 * quantity;
                        } else if (dtm.getValueAt(row, 0).equals("Spaghetti")) {

                            dtm.setValueAt(quantity, row, 1);
                            dtm.setValueAt(p3 * quantity, row, 2);
                            food3 = p3 * quantity;
                        } else if (dtm.getValueAt(row, 0).equals("Burger")) {

                            dtm.setValueAt(quantity, row, 1);
                            dtm.setValueAt(p4 * quantity, row, 2);
                            food4 = p4 * quantity;
                        } else if (dtm.getValueAt(row, 0).equals("Vietnamese Pho")) {

                            dtm.setValueAt(quantity, row, 1);
                            dtm.setValueAt(p5 * quantity, row, 2);
                            food5 = p5 * quantity;
                        } else if (dtm.getValueAt(row, 0).equals("Fried Rice")) {

                            dtm.setValueAt(quantity, row, 1);
                            dtm.setValueAt(p6 * quantity, row, 2);
                            food6 = p6 * quantity;
                        } else if (dtm.getValueAt(row, 0).equals("Chicken Rice")) {

                            dtm.setValueAt(quantity, row, 1); // obj, row,
                            // column
                            dtm.setValueAt(p7 * quantity, row, 2);
                            food7 = p7 * quantity;
                        } else if (dtm.getValueAt(row, 0).equals("Thai Food")) {

                            dtm.setValueAt(quantity, row, 1); // obj, row,
                            // column
                            dtm.setValueAt(p8 * quantity, row, 2);
                            food8 = p8 * quantity;
                        } else if (dtm.getValueAt(row, 0).equals("Korean Bibimbap")) {

                            dtm.setValueAt(quantity, row, 1); // obj, row,
                            // column
                            dtm.setValueAt(p9 * quantity, row, 2);
                            food9 = p9 * quantity;
                        }

                        if (quantity == 0) {
                            dtm.removeRow(row);
                        }
                        totalForFoods = food1 + food2 + food3 + food4 + food5 + food6 + food7 + food8 + food9;
                        total = totalForFoods + totalForDrinks + totalForDesserts;
                        textField.setText(total + "");
                        return;
                    }
                }

                // there was no row with this JSpinner, so we have to add it
                for (int i = 0; i < ELEMENTS; i++) {
                    // looking for the "clicked" JSpinner
                    if (numSpinner[i] == e.getSource()) {
                        totalPrice = price[i];
                        switch (foodLabel[i].getText()) {
                            case "Salad":
                                p1 = 7.50;
                                food1 = p1;
                                break;
                            case "Ramen":
                                p2 = 11.50;
                                food2 = p2;
                                break;
                            case "Spaghetti":
                                p3 = 14.70;
                                food3 = p3;
                                break;
                            case "Burger":
                                p4 = 12.50;
                                food4 = p4;
                                break;
                            case "Vietnamese Pho":
                                p5 = 9.50;
                                food5 = p5;
                                break;
                            case "Fried Rice":
                                p6 = 8.00;
                                food6 = p6;
                                break;
                            case "Chicken Rice":
                                p7 = 7.50;
                                food7 = p7;
                                break;
                            case "Thai Food":
                                p8 = 6.50;
                                food8 = p8;
                                break;
                            case "Korean Bibimbap":
                                p9 = 13.50;
                                food9 = p9;
                                break;
                        }

                        totalForFoods = food1 + food2 + food3 + food4 + food5 + food6 + food7 + food8 + food9;
                        total = totalForFoods + totalForDrinks + totalForDesserts;
                        textField.setText(total + "");
                        dtm.addRow(new Object[]{foodLabel[i].getText(), quantity, totalPrice, numSpinner[i]});
                        return;
                    }

                }
            }
        };
        
        for (int i = 0; i < ELEMENTS; i++) {
            try {

                Image image = ImageIO.read(new File(file[i]));
                Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(imageScaled);
                SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); // value,minimum,maximum,stepSize
                numSpinner[i] = new JSpinner(spnummodel);
                numSpinner[i].addChangeListener(listenerForFood);
                foodImage[i] = new JLabel(imageIcon);
            } catch (Exception e) {
                System.out.print(e);
            }
        }
        gbc.gridx = 0; // gridx 0 represent the most left
        for (int i = 0; i < ELEMENTS; i++) {
            if (i % 3 == 0) {
                gbc.gridy += 2;
                gbc.gridx = 0;
            }
            foodPanel.add(foodImage[i], gbc);
            gbc.gridy++; // gridy---> add one row,for foodLabel
            foodPanel.add(foodLabel[i], gbc);
            gbc.gridy--; // remove the row
            gbc.gridx++; // move to next column
            foodPanel.add(numSpinner[i], gbc);
            gbc.gridx++; // move to next column
            tabbedPane.addTab("Foods", foodPanel);
        }
        
        JPanel dessertPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        dessertImage = new JLabel[DESSERT_ELEMENTS];
        dessertLabel = new JLabel[DESSERT_ELEMENTS];
        numSpinnerDesserts = new JSpinner[DESSERT_ELEMENTS];
        priceDesserts = new Double[DESSERT_ELEMENTS];

        fileDesserts = new String[DESSERT_ELEMENTS];
        fileDesserts[0] = new String("image/oreocake.jpg");
        fileDesserts[1] = new String("image/red velvet cake.jpg");

        dessertLabel[0] = new JLabel("Oreo Cake");
        dessertLabel[1] = new JLabel("Red Velvet Cake");

        priceDesserts[0] = 7.50;
        priceDesserts[1] = 7.00;

        ChangeListener listenerForDesserts = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {

                final int quantity = (int) ((JSpinner) e.getSource()).getValue();
                final int rows = table.getRowCount();

                for (int row = 0; row < rows; row++) {
                    if (dtm.getValueAt(row, 3) == e.getSource()) {
                        if (dtm.getValueAt(row, 0).equals("Oreo Cake")) {
                            dtm.setValueAt(quantity, row, 1); // obj, row,
                            pr = de1 * quantity; // column
                            dtm.setValueAt(de1 * quantity, row, 2);
                        } else if (dtm.getValueAt(row, 0).equals("Red Velvet Cake")) {
                            dtm.setValueAt(quantity, row, 1); // obj, row, // column
                            dtm.setValueAt(de2 * quantity, row, 2);
                            pr1 = de2 * quantity;
                        }
                        if (quantity == 0) {
                            dtm.removeRow(row);
                        }
                        totalForDesserts = pr + pr1;
                        total = totalForFoods + totalForDrinks + totalForDesserts;
                        textField.setText(total + "");
                        return;
                    }
                }

                // there was no row with this JSpinner, so we have to add it
                for (int i = 0; i < DESSERT_ELEMENTS; i++) {
                    // looking for the "clicked" JSpinner
                    if (numSpinnerDesserts[i] == e.getSource()) {
                        totalPrice = priceDesserts[i];
                        switch (dessertLabel[i].getText()) {
                            case "Oreo Cake":
                                de1 = 7.50;
                                pr = de1;
                                break;
                            case "Red Velvet Cake":
                                de2 = 7.00;
                                pr1 = de2;
                                break;
                        }
                        totalForDesserts = pr + pr1;
                        total = totalForFoods + totalForDrinks + totalForDesserts;
                        textField.setText(total + "");
                        dtm.addRow(new Object[]{dessertLabel[i].getText(), quantity, totalPrice, numSpinnerDesserts[i]});
                        return;
                    }

                }
            }

        };
        
        for (int i = 0; i < DESSERT_ELEMENTS; i++) {
            Image image = ImageIO.read(new File(fileDesserts[i]));
            Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(imageScaled);
            SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); // value,minimum,maximum,stepSize
            numSpinnerDesserts[i] = new JSpinner(spnummodel);
            numSpinnerDesserts[i].addChangeListener(listenerForDesserts);
            dessertImage[i] = new JLabel(imageIcon);
        }
        gbc.gridx = 0; // gridx 0 represent the most left
        gbc.insets = new Insets(10, 5, 0, 0); // top,left,bottom,right
        for (int i = 0; i < DESSERT_ELEMENTS; i++) {
            if (i % 3 == 0) {
                gbc.gridx = 0;
                gbc.gridy += 2;
            }
            dessertPanel.add(dessertImage[i], gbc);
            gbc.gridy++; // gridy---> add one row,for foodLabel
            dessertPanel.add(dessertLabel[i], gbc);
            gbc.gridy--; // remove the row
            gbc.gridx++; // move to next column
            dessertPanel.add(numSpinnerDesserts[i], gbc);
            gbc.gridx++; // move to next column
            tabbedPane.addTab("Desserts", dessertPanel);
        }
        
        JPanel drinkPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        drinkImage = new JLabel[DRINK_ELEMENTS];
        drinkLabel = new JLabel[DRINK_ELEMENTS];
        numSpinnerDrinks = new JSpinner[DRINK_ELEMENTS];
        priceDrinks = new Double[DRINK_ELEMENTS];

        fileDrinks = new String[DRINK_ELEMENTS];
        fileDrinks[0] = new String("image/raspberry.jpg");
        fileDrinks[1] = new String("image/chocalate_pudding.jpg");
        fileDrinks[2] = new String("image/blue hawailan.jpg");
        fileDrinks[3] = new String("image/berry boba.jpg");
        fileDrinks[4] = new String("image/lemon ice.jpg");

        drinkLabel[0] = new JLabel("Raspberry");
        drinkLabel[1] = new JLabel("Hazelnut Chocolate");
        drinkLabel[2] = new JLabel("Blue Hawailan");
        drinkLabel[3] = new JLabel("Berry Boba Tea");
        drinkLabel[4] = new JLabel("Lemon Ice");

        priceDrinks[0] = 7.50;
        priceDrinks[1] = 8.50;
        priceDrinks[2] = 7.00;
        priceDrinks[3] = 6.00;
        priceDrinks[4] = 4.00;

        ChangeListener listenerForDrinks = new ChangeListener() {
            public void stateChanged(ChangeEvent e) {

                final int quantity = (int) ((JSpinner) e.getSource()).getValue();
                final int rows = table.getRowCount();
                for (int row = 0; row < rows; row++) {
                    if (dtm.getValueAt(row, 3) == e.getSource()) {
                        if (dtm.getValueAt(row, 0).equals("Raspberry")) {
                            dtm.setValueAt(quantity, row, 1);
                            dtm.setValueAt(d1 * quantity, row, 2);
                            drink1 = d1 * quantity;

                        } else if (dtm.getValueAt(row, 0).equals("Hazelnut Chocolate")) {
                            dtm.setValueAt(quantity, row, 1); // obj, row,
                            // column
                            dtm.setValueAt(d2 * quantity, row, 2);
                            drink2 = d2 * quantity;

                        } else if (dtm.getValueAt(row, 0).equals("Blue Hawailan")) {

                            dtm.setValueAt(quantity, row, 1);
                            dtm.setValueAt(d3 * quantity, row, 2);
                            drink3 = d3 * quantity;

                        } else if (dtm.getValueAt(row, 0).equals("Berry Boba Tea")) {

                            dtm.setValueAt(quantity, row, 1);
                            dtm.setValueAt(d4 * quantity, row, 2);
                            drink4 = d4 * quantity;

                        } else if (dtm.getValueAt(row, 0).equals("Lemon Ice")) {

                            dtm.setValueAt(quantity, row, 1); // obj, row,
                            // column
                            dtm.setValueAt(d5 * quantity, row, 2);
                            drink5 = d5 * quantity;

                        }
                        if (quantity == 0) {
                            dtm.removeRow(row);
                        }
                        totalForDrinks = drink1 + drink2 + drink3 + drink4 + drink5;
                        total = totalForFoods + totalForDrinks + totalForDesserts;
                        textField.setText(total + "");

                        return;
                    }
                }

                // there was no row with this JSpinner, so we have to add it
                for (int i = 0; i < DRINK_ELEMENTS; i++) {
                    // looking for the "clicked" JSpinner
                    if (numSpinnerDrinks[i] == e.getSource()) {
                        totalPrice = priceDrinks[i];
                        switch (drinkLabel[i].getText()) {
                            case "Raspberry":
                                d1 = 7.50;
                                drink1 = d1;
                                break;
                            case "Hazelnut Chocolate":
                                d2 = 8.50;
                                drink2 = d2;
                                break;
                            case "Blue Hawailan":
                                d3 = 7.00;
                                drink3 = d3;
                                break;
                            case "Berry Boba Tea":
                                d4 = 6.00;
                                drink4 = d4;
                                break;
                            case "Lemon Ice":
                                d5 = 4.00;
                                drink5 = d5;
                                break;
                        }
                        totalForDrinks = drink1 + drink2 + drink3 + drink4 + drink5;
                        total = totalForFoods + totalForDrinks + totalForDesserts;
                        textField.setText(total + "");
                        dtm.addRow(new Object[]{drinkLabel[i].getText(), quantity, totalPrice, numSpinnerDrinks[i]});
                        return;
                    }

                }

            }
        };
        
        for (int i = 0; i < DRINK_ELEMENTS; i++) {
            Image image = ImageIO.read(new File(fileDrinks[i]));
            Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(imageScaled);
            SpinnerNumberModel spnummodel = new SpinnerNumberModel(0, 0, 10, 1); // value,minimum,maximum,stepSize
            numSpinnerDrinks[i] = new JSpinner(spnummodel);
            numSpinnerDrinks[i].addChangeListener(listenerForDrinks);
            drinkImage[i] = new JLabel(imageIcon);
        }
        gbc.gridx = 0; // gridx 0 represent the most left
        gbc.insets = new Insets(10, 5, 0, 0); // top,left,bottom,right
        for (int i = 0; i < DRINK_ELEMENTS; i++) {
            if (i % 3 == 0) {
                gbc.gridx = 0;
                gbc.gridy += 2;
            }
            drinkPanel.add(drinkImage[i], gbc);
            gbc.gridy++; // gridy---> add one row,for foodLabel
            drinkPanel.add(drinkLabel[i], gbc);
            gbc.gridy--; // remove the row
            gbc.gridx++; // move to next column
            drinkPanel.add(numSpinnerDrinks[i], gbc);
            gbc.gridx++; // move to next column
            tabbedPane.addTab("Drinks", drinkPanel);

        }
        
        tabbedPane.setBounds(18, 11, 450, 450);
        frame.getContentPane().add(tabbedPane);
        frame.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    createMainMenu();
                    frame.dispose();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        orderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "You haven't ordered anything yet.");
                } else {
                    try {
                        createOrderMenu();
                        frame.dispose();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
            }

        });
    }
    
    static void createOrderMenu() throws IOException {
    	JFrame frame;
    	JTextField textField;
    	JTextField textField_1;
    	JTextField textField_2;
    	JTextField textField_3;
    	JTextArea textArea;
    	
        frame = new JFrame("Order Menu");
        frame.setBounds(100, 100, 420, 450); // x,y,width,height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel lblFillInDetails = new JLabel("Fill in Details");
        lblFillInDetails.setBounds(120, 11, 131, 26);
        lblFillInDetails.setFont(new Font("Serif", Font.PLAIN, 16));
        lblFillInDetails.setForeground(Color.BLUE);
        frame.getContentPane().add(lblFillInDetails);

        JLabel lblName = new JLabel("Name: ");
        lblName.setBounds(10, 46, 46, 14);
        frame.getContentPane().add(lblName);

        textField = new JTextField();
        textField.setBounds(92, 43, 176, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JLabel lblAddress = new JLabel("Tel No: ");
        lblAddress.setBounds(10, 92, 46, 14);
        frame.getContentPane().add(lblAddress);

        textField_1 = new JTextField();
        textField_1.setBounds(92, 89, 176, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        JLabel lblAddress_1 = new JLabel("Address: ");
        lblAddress_1.setBounds(10, 137, 62, 14);
        frame.getContentPane().add(lblAddress_1);

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        textArea = new JTextArea();
        textArea.setBounds(92, 132, 236, 85);
        textArea.setMargin(new Insets(10, 10, 10, 10)); // top,left,bottom,right
        textArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        frame.getContentPane().add(textArea);

        JLabel lblCard = new JLabel("Card No:");
        lblCard.setBounds(10, 248, 62, 14);
        frame.getContentPane().add(lblCard);

        textField_2 = new JTextField();
        textField_2.setBounds(92, 244, 176, 20);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        JLabel lblCvv = new JLabel("CVV: ");
        lblCvv.setBounds(10, 295, 46, 14);
        frame.getContentPane().add(lblCvv);

        textField_3 = new JTextField();
        textField_3.setBounds(92, 290, 176, 20);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        JButton btnCancel = new JButton("Cancel ");
        btnCancel.setBounds(120, 344, 89, 23);
        frame.getContentPane().add(btnCancel);

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    createFoodMenu();
                    frame.dispose();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
        });

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(239, 344, 89, 23);
        frame.getContentPane().add(btnConfirm);

        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Name cannot be left empty, Please fill in your name. ");
                } else if(textField_1.getText().equals("")) {
                	JOptionPane.showMessageDialog(null, "Telephone no. cannot be left empty, Please fill in your number. ");
                } else if(textField_1.getText().length() != 13) {
                	JOptionPane.showMessageDialog(null, "Invalid phone no., Please follow format (XXX)XXX-XXXX.  ");
                } else if(textArea.getText().equals("")) {
                	JOptionPane.showMessageDialog(null, "Address cannot be left empty, Please fill in your address. ");
                } else{
                	trackingNum++;
                	registerStatus[trackingNum] = "is under preparation";
                	registerTrack[trackingNum] = trackingNum;
                    JOptionPane.showMessageDialog(null, "Thank you for your payment. Your order has been placed. =) "
                    		+ "\nYour tracking number: #" + registerTrack[trackingNum]);
                    try {
                        createMainMenu();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    // setVisible(false);
                    frame.dispose();
                }
            }
        });
        File imageFile = new File("image/order.png");
        Image image = ImageIO.read(imageFile);
        Image imageScaled = image.getScaledInstance(80, 95, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(imageScaled);
        JLabel lblNewLabel = new JLabel(imageIcon);
        lblNewLabel.setBounds(278, 19, 126, 90);
        frame.getContentPane().add(lblNewLabel);
        frame.setVisible(true);
    }
    
    static void createTrackMenu() throws IOException {
		JFrame frame;
		JTextField textField;
		
        frame = new JFrame("Tracking Order");
        frame.setBounds(100, 100, 400, 150); // x,y,width,height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        
        JLabel lblFillInDetails = new JLabel("Fill in Details");
        lblFillInDetails.setBounds(120, 11, 131, 26);
        lblFillInDetails.setFont(new Font("Serif", Font.PLAIN, 16));
        lblFillInDetails.setForeground(Color.BLUE);
        frame.getContentPane().add(lblFillInDetails);
        
        JLabel lbltrackingNum = new JLabel("Tracking Number: ");
        lbltrackingNum.setBounds(10, 46, 180, 14);
        frame.getContentPane().add(lbltrackingNum);

        textField = new JTextField();
        textField.setBounds(190, 43, 176, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(120, 75, 89, 23);
        frame.getContentPane().add(btnConfirm);
        frame.setVisible(true);
        
        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill in your tracking number. ");
                } else if(!isInteger(textField.getText())){
                	JOptionPane.showMessageDialog(null, "Invalid tracking number, has to be integer. ");
                } else if (Integer.parseInt(textField.getText()) != trackingNum) {
                	JOptionPane.showMessageDialog(null, "The tracking number is incorrect. ");
                } else {
                	boolean valid = false;
					for(int i = 1; i <= id; i++) {
						if(Integer.parseInt(textField.getText()) == registerId[i]) {
							valid = true;
						}
					}
					if(valid) {
						JOptionPane.showMessageDialog(null, "Your food is " + registerStatus[Integer.parseInt(textField.getText())] + ".");
						frame.dispose();
		                try {
							createLoginMenu();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid tracking number. ");
					}
                }
            }
        });
	}
    
    public static boolean isInteger(String s) {
    	try {
    		Integer.parseInt(s);
    		return true;
    	}
    	catch(Exception e) {
    		return false;
    	}
    }
    
    public static void main(String[] args) {
    	registerId = new int[100];
    	registerPin = new String[100];
    	registerTrack = new int[100];
    	registerStatus = new String[100];
    	try {
			createLoginMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
