package com.servidorcentral.admin;

import com.servidorcentral.controllers.UserController;
import com.servidorcentral.enums.Country;
import com.servidorcentral.enums.IdType;
import com.servidorcentral.exceptions.UserAlreadyExistsException;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateUser extends JInternalFrame {

    private final UserController userController;

	/*
	  Internal frame components
	 */
    private final GridBagLayout gridBagLayout;
    private final JComboBox<String> cmbUserType;
    private final JTextField txtUsername;
    private final JTextField txtName;
    private final JTextField txtEmail;
    private final JPasswordField txtPassword;
    private final JPasswordField txtConfirmPassword;
    private final JLabel lblSelectedImage;
    private final JTextField txtRegistrationDay;
    private final JTextField txtRegistrationMonth;
    private final JTextField txtRegistrationYear;
    private final JLabel lblLastName;
    private final JTextField txtLastName;
    private final JLabel lblIdType;
    private final JComboBox<String> cmbIdType;
    private final JLabel lblIdNumber;
    private final JTextField txtIdNumber;
    private final JLabel lblBirthday;
    private final JTextField txtBirthdayDay;
    private final JLabel lblBirthdaySeparator1;
    private final JTextField txtBirthdayMonth;
    private final JLabel lblBirthdaySeparator2;
    private final JTextField txtBirthdayYear;
    private final JLabel lblCountry;
    private final JComboBox<String> cmbCountry;
    private final JLabel lblDescription;
    private final JTextArea txaDescription;
    private final JScrollPane scrDescription;
	private final JLabel lblWebUrl;
    private final JTextField txtWebUrl;

    private byte[] image;

    public CreateUser(UserController userController) {
        this.userController = userController;

        // Internal frame properties
        setTitle("Crear usuario");
        setBounds(0, 0, 710, 485);
        setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        setResizable(true);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);

        // Internal frame components
    	gridBagLayout = new GridBagLayout();
    	gridBagLayout.columnWidths = new int[]{15, 190, 30, 0, 30, 0, 50, 0, 0, 120, 35, 0};
    	gridBagLayout.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 80, 0, 30, 0, 30, 0};
    	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
    	getContentPane().setLayout(gridBagLayout);

    	JLabel lblUserType = new JLabel("Tipo de usuario:");
    	GridBagConstraints gbc_lblUserType = new GridBagConstraints();
    	gbc_lblUserType.insets = new Insets(0, 0, 5, 5);
    	gbc_lblUserType.anchor = GridBagConstraints.EAST;
    	gbc_lblUserType.gridx = 1;
    	gbc_lblUserType.gridy = 1;
    	getContentPane().add(lblUserType, gbc_lblUserType);

    	cmbUserType = new JComboBox<String>(new String[] {"Cliente", "Aerolínea"});
    	cmbUserType.addActionListener(arg0 -> updateDisplay());
    	GridBagConstraints gbc_cmbUserType = new GridBagConstraints();
    	gbc_cmbUserType.gridwidth = 8;
    	gbc_cmbUserType.insets = new Insets(0, 0, 5, 5);
    	gbc_cmbUserType.fill = GridBagConstraints.HORIZONTAL;
    	gbc_cmbUserType.gridx = 2;
    	gbc_cmbUserType.gridy = 1;
    	getContentPane().add(cmbUserType, gbc_cmbUserType);

    	JLabel lblUsername = new JLabel("Username*:");
    	GridBagConstraints gbc_lblUsername = new GridBagConstraints();
    	gbc_lblUsername.anchor = GridBagConstraints.EAST;
    	gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
    	gbc_lblUsername.gridx = 1;
    	gbc_lblUsername.gridy = 2;
    	getContentPane().add(lblUsername, gbc_lblUsername);

    	txtUsername = new JTextField();
    	GridBagConstraints gbc_txtUsername = new GridBagConstraints();
    	gbc_txtUsername.gridwidth = 8;
    	gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
    	gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txtUsername.gridx = 2;
    	gbc_txtUsername.gridy = 2;
    	getContentPane().add(txtUsername, gbc_txtUsername);
    	txtUsername.setColumns(10);

    	JLabel lblName = new JLabel("Nombre*:");
    	GridBagConstraints gbc_lblName = new GridBagConstraints();
    	gbc_lblName.anchor = GridBagConstraints.EAST;
    	gbc_lblName.insets = new Insets(0, 0, 5, 5);
    	gbc_lblName.gridx = 1;
    	gbc_lblName.gridy = 3;
    	getContentPane().add(lblName, gbc_lblName);

    	txtName = new JTextField();
    	GridBagConstraints gbc_txtName = new GridBagConstraints();
    	gbc_txtName.gridwidth = 8;
    	gbc_txtName.insets = new Insets(0, 0, 5, 5);
    	gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txtName.gridx = 2;
    	gbc_txtName.gridy = 3;
    	getContentPane().add(txtName, gbc_txtName);
    	txtName.setColumns(10);

    	JLabel lblEmail = new JLabel("Correo*:");
    	GridBagConstraints gbc_lblEmail = new GridBagConstraints();
    	gbc_lblEmail.anchor = GridBagConstraints.EAST;
    	gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
    	gbc_lblEmail.gridx = 1;
    	gbc_lblEmail.gridy = 4;
    	getContentPane().add(lblEmail, gbc_lblEmail);

    	txtEmail = new JTextField();
    	GridBagConstraints gbc_txtEmail = new GridBagConstraints();
    	gbc_txtEmail.gridwidth = 8;
    	gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
    	gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txtEmail.gridx = 2;
    	gbc_txtEmail.gridy = 4;
    	getContentPane().add(txtEmail, gbc_txtEmail);
    	txtEmail.setColumns(10);

        JLabel lblPassword = new JLabel("Contraseña*:");
    	GridBagConstraints gbc_lblPassword = new GridBagConstraints();
    	gbc_lblPassword.anchor = GridBagConstraints.EAST;
    	gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
    	gbc_lblPassword.gridx = 1;
    	gbc_lblPassword.gridy = 5;
    	getContentPane().add(lblPassword, gbc_lblPassword);

    	txtPassword = new JPasswordField();
    	GridBagConstraints gbc_txtPassword = new GridBagConstraints();
    	gbc_txtPassword.gridwidth = 8;
    	gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
    	gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txtPassword.gridx = 2;
    	gbc_txtPassword.gridy = 5;
    	getContentPane().add(txtPassword, gbc_txtPassword);

        JLabel lblConfirmPassword = new JLabel("Confirmar contraseña*:");
    	GridBagConstraints gbc_lblConfirmPassword = new GridBagConstraints();
    	gbc_lblConfirmPassword.anchor = GridBagConstraints.EAST;
    	gbc_lblConfirmPassword.insets = new Insets(0, 0, 5, 5);
    	gbc_lblConfirmPassword.gridx = 1;
    	gbc_lblConfirmPassword.gridy = 6;
    	getContentPane().add(lblConfirmPassword, gbc_lblConfirmPassword);

    	txtConfirmPassword = new JPasswordField();
    	GridBagConstraints gbc_txtConfirmPassword = new GridBagConstraints();
    	gbc_txtConfirmPassword.gridwidth = 8;
    	gbc_txtConfirmPassword.insets = new Insets(0, 0, 5, 5);
    	gbc_txtConfirmPassword.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txtConfirmPassword.gridx = 2;
    	gbc_txtConfirmPassword.gridy = 6;
    	getContentPane().add(txtConfirmPassword, gbc_txtConfirmPassword);

        JLabel lblProfileImage = new JLabel("Imagen de perfil:");
    	GridBagConstraints gbc_lblProfileImage = new GridBagConstraints();
    	gbc_lblProfileImage.anchor = GridBagConstraints.EAST;
    	gbc_lblProfileImage.insets = new Insets(0, 0, 5, 5);
    	gbc_lblProfileImage.gridx = 1;
    	gbc_lblProfileImage.gridy = 7;
    	getContentPane().add(lblProfileImage, gbc_lblProfileImage);

        JButton btnSelectImage = new JButton("Seleccionar imagen");
    	btnSelectImage.addActionListener(e -> selectImage());

    	lblSelectedImage = new JLabel("");
    	GridBagConstraints gbc_lblSelectedImage = new GridBagConstraints();
    	gbc_lblSelectedImage.gridwidth = 5;
    	gbc_lblSelectedImage.insets = new Insets(0, 0, 5, 5);
    	gbc_lblSelectedImage.gridx = 2;
    	gbc_lblSelectedImage.gridy = 7;
    	getContentPane().add(lblSelectedImage, gbc_lblSelectedImage);

    	GridBagConstraints gbc_btnSelectImage = new GridBagConstraints();
    	gbc_btnSelectImage.insets = new Insets(0, 0, 5, 5);
    	gbc_btnSelectImage.gridx = 8;
    	gbc_btnSelectImage.gridy = 7;
    	getContentPane().add(btnSelectImage, gbc_btnSelectImage);

        JButton btnRemoveImage = new JButton("Eliminar imagen");
    	btnRemoveImage.addActionListener(e -> {
            image = null;
            lblSelectedImage.setText("");
        });
    	GridBagConstraints gbc_btnRemoveImage = new GridBagConstraints();
    	gbc_btnRemoveImage.insets = new Insets(0, 0, 5, 5);
    	gbc_btnRemoveImage.gridx = 9;
    	gbc_btnRemoveImage.gridy = 7;
    	getContentPane().add(btnRemoveImage, gbc_btnRemoveImage);

        JLabel lblRegistrationDate = new JLabel("Fecha de alta*:");
    	GridBagConstraints gbc_lblRegistrationDate = new GridBagConstraints();
    	gbc_lblRegistrationDate.anchor = GridBagConstraints.EAST;
    	gbc_lblRegistrationDate.insets = new Insets(0, 0, 5, 5);
    	gbc_lblRegistrationDate.gridx = 1;
    	gbc_lblRegistrationDate.gridy = 8;
    	getContentPane().add(lblRegistrationDate, gbc_lblRegistrationDate);

    	txtRegistrationDay = new JTextField();
    	GridBagConstraints gbc_txtRegistrationDay = new GridBagConstraints();
    	gbc_txtRegistrationDay.insets = new Insets(0, 0, 5, 5);
    	gbc_txtRegistrationDay.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txtRegistrationDay.gridx = 2;
    	gbc_txtRegistrationDay.gridy = 8;
    	getContentPane().add(txtRegistrationDay, gbc_txtRegistrationDay);
    	txtRegistrationDay.setColumns(10);

        JLabel lblRegistrationDateSeparator1 = new JLabel("/");
    	GridBagConstraints gbc_lblRegistrationDateSeparator1 = new GridBagConstraints();
    	gbc_lblRegistrationDateSeparator1.insets = new Insets(0, 0, 5, 5);
    	gbc_lblRegistrationDateSeparator1.gridx = 3;
    	gbc_lblRegistrationDateSeparator1.gridy = 8;
    	getContentPane().add(lblRegistrationDateSeparator1, gbc_lblRegistrationDateSeparator1);

    	txtRegistrationMonth = new JTextField();
    	GridBagConstraints gbc_txtRegistrationMonth = new GridBagConstraints();
    	gbc_txtRegistrationMonth.insets = new Insets(0, 0, 5, 5);
    	gbc_txtRegistrationMonth.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txtRegistrationMonth.gridx = 4;
    	gbc_txtRegistrationMonth.gridy = 8;
    	getContentPane().add(txtRegistrationMonth, gbc_txtRegistrationMonth);
    	txtRegistrationMonth.setColumns(10);

        JLabel lblRegistrationDateSeparator2 = new JLabel("/");
    	GridBagConstraints gbc_lblRegistrationDateSeparator2 = new GridBagConstraints();
    	gbc_lblRegistrationDateSeparator2.insets = new Insets(0, 0, 5, 5);
    	gbc_lblRegistrationDateSeparator2.gridx = 5;
    	gbc_lblRegistrationDateSeparator2.gridy = 8;
    	getContentPane().add(lblRegistrationDateSeparator2, gbc_lblRegistrationDateSeparator2);

    	txtRegistrationYear = new JTextField();
    	GridBagConstraints gbc_txtRegistrationYear = new GridBagConstraints();
    	gbc_txtRegistrationYear.insets = new Insets(0, 0, 5, 5);
    	gbc_txtRegistrationYear.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txtRegistrationYear.gridx = 6;
    	gbc_txtRegistrationYear.gridy = 8;
    	getContentPane().add(txtRegistrationYear, gbc_txtRegistrationYear);
    	txtRegistrationYear.setColumns(10);

    	lblLastName = new JLabel("Apellido*:");
    	GridBagConstraints gbc_lblLastName = new GridBagConstraints();
    	gbc_lblLastName.anchor = GridBagConstraints.EAST;
    	gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
    	gbc_lblLastName.gridx = 1;
    	gbc_lblLastName.gridy = 9;
    	getContentPane().add(lblLastName, gbc_lblLastName);

    	txtLastName = new JTextField();
    	GridBagConstraints gbc_txtLastName = new GridBagConstraints();
    	gbc_txtLastName.gridwidth = 8;
    	gbc_txtLastName.insets = new Insets(0, 0, 5, 5);
    	gbc_txtLastName.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txtLastName.gridx = 2;
    	gbc_txtLastName.gridy = 9;
    	getContentPane().add(txtLastName, gbc_txtLastName);
    	txtLastName.setColumns(10);

    	lblIdType = new JLabel("Tipo de documento:");
    	GridBagConstraints gbc_lblIdType = new GridBagConstraints();
    	gbc_lblIdType.anchor = GridBagConstraints.EAST;
    	gbc_lblIdType.insets = new Insets(0, 0, 5, 5);
    	gbc_lblIdType.gridx = 1;
    	gbc_lblIdType.gridy = 10;
    	getContentPane().add(lblIdType, gbc_lblIdType);

    	cmbIdType = new JComboBox<String>(IdType.getValues());
    	GridBagConstraints gbc_cmbIdType = new GridBagConstraints();
    	gbc_cmbIdType.gridwidth = 8;
    	gbc_cmbIdType.insets = new Insets(0, 0, 5, 5);
    	gbc_cmbIdType.fill = GridBagConstraints.HORIZONTAL;
    	gbc_cmbIdType.gridx = 2;
    	gbc_cmbIdType.gridy = 10;
    	getContentPane().add(cmbIdType, gbc_cmbIdType);

    	lblIdNumber = new JLabel("Número de documento*:");
    	GridBagConstraints gbc_lblIdNumber = new GridBagConstraints();
    	gbc_lblIdNumber.anchor = GridBagConstraints.EAST;
    	gbc_lblIdNumber.insets = new Insets(0, 0, 5, 5);
    	gbc_lblIdNumber.gridx = 1;
    	gbc_lblIdNumber.gridy = 11;
    	getContentPane().add(lblIdNumber, gbc_lblIdNumber);

    	txtIdNumber = new JTextField();
    	GridBagConstraints gbc_txtIdNumber = new GridBagConstraints();
    	gbc_txtIdNumber.gridwidth = 8;
    	gbc_txtIdNumber.insets = new Insets(0, 0, 5, 5);
    	gbc_txtIdNumber.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txtIdNumber.gridx = 2;
    	gbc_txtIdNumber.gridy = 11;
    	getContentPane().add(txtIdNumber, gbc_txtIdNumber);
    	txtIdNumber.setColumns(10);

    	lblBirthday = new JLabel("Fecha de nacimiento*:");
    	GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
    	gbc_lblBirthday.anchor = GridBagConstraints.EAST;
    	gbc_lblBirthday.insets = new Insets(0, 0, 5, 5);
    	gbc_lblBirthday.gridx = 1;
    	gbc_lblBirthday.gridy = 12;
    	getContentPane().add(lblBirthday, gbc_lblBirthday);

    	txtBirthdayDay = new JTextField();
    	GridBagConstraints gbc_txtBirthdayDay = new GridBagConstraints();
    	gbc_txtBirthdayDay.insets = new Insets(0, 0, 5, 5);
    	gbc_txtBirthdayDay.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txtBirthdayDay.gridx = 2;
    	gbc_txtBirthdayDay.gridy = 12;
    	getContentPane().add(txtBirthdayDay, gbc_txtBirthdayDay);
    	txtBirthdayDay.setColumns(10);

    	lblBirthdaySeparator1 = new JLabel("/");
    	GridBagConstraints gbc_lblBirthdaySeparator1 = new GridBagConstraints();
    	gbc_lblBirthdaySeparator1.insets = new Insets(0, 0, 5, 5);
    	gbc_lblBirthdaySeparator1.gridx = 3;
    	gbc_lblBirthdaySeparator1.gridy = 12;
    	getContentPane().add(lblBirthdaySeparator1, gbc_lblBirthdaySeparator1);

    	txtBirthdayMonth = new JTextField();
    	GridBagConstraints gbc_txtBirthdayMonth = new GridBagConstraints();
    	gbc_txtBirthdayMonth.insets = new Insets(0, 0, 5, 5);
    	gbc_txtBirthdayMonth.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txtBirthdayMonth.gridx = 4;
    	gbc_txtBirthdayMonth.gridy = 12;
    	getContentPane().add(txtBirthdayMonth, gbc_txtBirthdayMonth);
    	txtBirthdayMonth.setColumns(10);

    	lblBirthdaySeparator2 = new JLabel("/");
    	GridBagConstraints gbc_lblBirthdaySeparator2 = new GridBagConstraints();
    	gbc_lblBirthdaySeparator2.insets = new Insets(0, 0, 5, 5);
    	gbc_lblBirthdaySeparator2.gridx = 5;
    	gbc_lblBirthdaySeparator2.gridy = 12;
    	getContentPane().add(lblBirthdaySeparator2, gbc_lblBirthdaySeparator2);

    	txtBirthdayYear = new JTextField();
    	GridBagConstraints gbc_txtBirthdayYear = new GridBagConstraints();
    	gbc_txtBirthdayYear.insets = new Insets(0, 0, 5, 5);
    	gbc_txtBirthdayYear.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txtBirthdayYear.gridx = 6;
    	gbc_txtBirthdayYear.gridy = 12;
    	getContentPane().add(txtBirthdayYear, gbc_txtBirthdayYear);
    	txtBirthdayYear.setColumns(10);

    	lblCountry = new JLabel("Nacionalidad*:");
    	GridBagConstraints gbc_lblCountry = new GridBagConstraints();
    	gbc_lblCountry.anchor = GridBagConstraints.EAST;
    	gbc_lblCountry.insets = new Insets(0, 0, 5, 5);
    	gbc_lblCountry.gridx = 1;
    	gbc_lblCountry.gridy = 13;
    	getContentPane().add(lblCountry, gbc_lblCountry);

    	cmbCountry = new JComboBox<String>(Country.getValues());
    	GridBagConstraints gbc_cmbCountry = new GridBagConstraints();
    	gbc_cmbCountry.gridwidth = 8;
    	gbc_cmbCountry.insets = new Insets(0, 0, 5, 5);
    	gbc_cmbCountry.fill = GridBagConstraints.HORIZONTAL;
    	gbc_cmbCountry.gridx = 2;
    	gbc_cmbCountry.gridy = 13;
    	getContentPane().add(cmbCountry, gbc_cmbCountry);

    	lblDescription = new JLabel("Descripción*:");
    	GridBagConstraints gbc_lblDescription = new GridBagConstraints();
    	gbc_lblDescription.anchor = GridBagConstraints.EAST;
    	gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
    	gbc_lblDescription.gridx = 1;
    	gbc_lblDescription.gridy = 14;
    	getContentPane().add(lblDescription, gbc_lblDescription);

    	scrDescription = new JScrollPane();
    	GridBagConstraints gbc_scrDescription = new GridBagConstraints();
    	gbc_scrDescription.gridwidth = 8;
    	gbc_scrDescription.insets = new Insets(0, 0, 5, 5);
    	gbc_scrDescription.fill = GridBagConstraints.BOTH;
    	gbc_scrDescription.gridx = 2;
    	gbc_scrDescription.gridy = 14;
    	getContentPane().add(scrDescription, gbc_scrDescription);

    	txaDescription = new JTextArea();
    	scrDescription.setViewportView(txaDescription);

    	lblWebUrl = new JLabel("Link de pág. web:");
    	GridBagConstraints gbc_lblWebUrl = new GridBagConstraints();
    	gbc_lblWebUrl.anchor = GridBagConstraints.EAST;
    	gbc_lblWebUrl.insets = new Insets(0, 0, 5, 5);
    	gbc_lblWebUrl.gridx = 1;
    	gbc_lblWebUrl.gridy = 15;
    	getContentPane().add(lblWebUrl, gbc_lblWebUrl);

    	txtWebUrl = new JTextField();
    	GridBagConstraints gbc_txtWebUrl = new GridBagConstraints();
    	gbc_txtWebUrl.gridwidth = 8;
    	gbc_txtWebUrl.insets = new Insets(0, 0, 5, 5);
    	gbc_txtWebUrl.fill = GridBagConstraints.HORIZONTAL;
    	gbc_txtWebUrl.gridx = 2;
    	gbc_txtWebUrl.gridy = 15;
    	getContentPane().add(txtWebUrl, gbc_txtWebUrl);
    	txtWebUrl.setColumns(10);

    	JButton btnAccept = new JButton("Aceptar");
    	btnAccept.addActionListener(arg0 -> createUser());
    	GridBagConstraints gbc_btnAccept = new GridBagConstraints();
    	gbc_btnAccept.anchor = GridBagConstraints.EAST;
    	gbc_btnAccept.insets = new Insets(0, 0, 5, 5);
    	gbc_btnAccept.gridx = 8;
    	gbc_btnAccept.gridy = 17;
    	getContentPane().add(btnAccept, gbc_btnAccept);

    	JButton btnCancel = new JButton("Cancelar");
    	btnCancel.addActionListener(arg0 -> {
            clearDisplay();
            setVisible(false);
        });
    	GridBagConstraints gbc_btnCancel = new GridBagConstraints();
    	gbc_btnCancel.anchor = GridBagConstraints.EAST;
    	gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
    	gbc_btnCancel.gridx = 9;
    	gbc_btnCancel.gridy = 17;
    	getContentPane().add(btnCancel, gbc_btnCancel);


    }

    private void createUser() {
        if (!this.checkFields()) {
            return;
        }

        try {
            if (Objects.equals(this.cmbUserType.getSelectedItem(), "Cliente")) {
                this.userController.createClient(
                    this.txtUsername.getText(),
                    this.txtName.getText(),
                    this.txtEmail.getText(),
                    new String(this.txtPassword.getPassword()),
                    this.image,
                    LocalDate.of(Integer.parseInt(this.txtRegistrationYear.getText()), Integer.parseInt(this.txtRegistrationMonth.getText()), Integer.parseInt(this.txtRegistrationDay.getText())),
                    this.txtLastName.getText(),
                    LocalDate.of(Integer.parseInt(this.txtBirthdayYear.getText()), Integer.parseInt(this.txtBirthdayMonth.getText()), Integer.parseInt(this.txtBirthdayDay.getText())),
                    IdType.fromString((String) this.cmbIdType.getSelectedItem()),
                    this.txtIdNumber.getText(),
                    Country.fromString((String) this.cmbCountry.getSelectedItem())
                );
            } else if (Objects.equals(this.cmbUserType.getSelectedItem(), "Aerolínea")) {
                this.userController.createAirline(
                    this.txtUsername.getText(),
                    this.txtName.getText(),
                    this.txtEmail.getText(),
                    new String(this.txtPassword.getPassword()),
                    this.image,
                    LocalDate.of(Integer.parseInt(this.txtRegistrationYear.getText()), Integer.parseInt(this.txtRegistrationMonth.getText()), Integer.parseInt(this.txtRegistrationDay.getText())),
                    this.txaDescription.getText(),
                    this.txtWebUrl.getText()
                );
            }

            JOptionPane.showMessageDialog(this, "Usuario creado exitosamente", "Crear usuario", JOptionPane.INFORMATION_MESSAGE);
            this.clearDisplay();
        } catch (UserAlreadyExistsException e) {
            JOptionPane.showMessageDialog(this, "El usuario ya existe", "Crear usuario", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean checkFields() {
        // Check if all required fields are filled
        if (this.txtUsername.getText().isEmpty()
            || this.txtName.getText().isEmpty()
            || this.txtEmail.getText().isEmpty()
            || this.txtPassword.getPassword().length == 0
            || this.txtConfirmPassword.getPassword().length == 0
            || this.txtRegistrationDay.getText().isEmpty()
            || this.txtRegistrationMonth.getText().isEmpty()
            || this.txtRegistrationYear.getText().isEmpty()
        ) {
            JOptionPane.showMessageDialog(this, "Debe rellenar los campos obligatorios", "Crear usuario", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // If user is a client
        if (Objects.equals(this.cmbUserType.getSelectedItem(), "Cliente")
            && (this.txtLastName.getText().isEmpty()
            || this.txtIdNumber.getText().isEmpty()
            || this.txtBirthdayDay.getText().isEmpty()
            || this.txtBirthdayMonth.getText().isEmpty()
            || this.txtBirthdayYear.getText().isEmpty())
        ) {
            JOptionPane.showMessageDialog(this, "Debe rellenar los campos obligatorios", "Crear usuario", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // If a user is an airline
        if (Objects.equals(this.cmbUserType.getSelectedItem(), "Aerolínea")
            && this.txaDescription.getText().isEmpty()
        ) {
            JOptionPane.showMessageDialog(this, "Debe rellenar los campos obligatorios", "Crear usuario", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if email is valid
        if (!this.txtEmail.getText().contains("@")) {
            JOptionPane.showMessageDialog(this, "Ingrese un correo electrónico válido", "Crear usuario", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if passwords match
		String password = new String(this.txtPassword.getPassword());
		String confirmPassword = new String(this.txtConfirmPassword.getPassword());
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden", "Crear usuario", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check if registration date is valid
        try {
			LocalDate.of(Integer.parseInt(this.txtRegistrationYear.getText()), Integer.parseInt(this.txtRegistrationMonth.getText()), Integer.parseInt(this.txtRegistrationDay.getText()));
        } catch (DateTimeException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese una fecha de alta válida", "Crear usuario", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Check client date fields
        if (Objects.equals(this.cmbUserType.getSelectedItem(), "Cliente")) {
            LocalDate birthdayDate = LocalDate.now();
            try {
                 birthdayDate = LocalDate.of(Integer.parseInt(this.txtBirthdayYear.getText()), Integer.parseInt(this.txtBirthdayMonth.getText()), Integer.parseInt(this.txtBirthdayDay.getText()));
            } catch (DateTimeException | NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese una fecha de nacimiento válida", "Crear usuario", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            if (birthdayDate.isBefore(LocalDate.now().minusYears(120))) {
                JOptionPane.showMessageDialog(this, "El usuario debe tener menos de 120 años", "Crear usuario", JOptionPane.ERROR_MESSAGE);
                return false;
            } else if (birthdayDate.isAfter(LocalDate.now().minusYears(18))) {
                JOptionPane.showMessageDialog(this, "El usuario debe ser mayor de edad", "Crear usuario", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }

    private void selectImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Elige una imagen");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "png"));

        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            this.lblSelectedImage.setText(selectedFile.getName());

            try (FileInputStream inputStream = new FileInputStream(selectedFile)) {
                this.image = new byte[(int) selectedFile.length()];
                inputStream.read(this.image);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al leer la foto de perfil", "Alta de usuario", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void updateDisplay() {
        if (Objects.equals(this.cmbUserType.getSelectedItem(), "Cliente")) {
            this.lblLastName.setVisible(true);
            this.txtLastName.setVisible(true);
            this.lblIdType.setVisible(true);
            this.cmbIdType.setVisible(true);
            this.lblIdNumber.setVisible(true);
            this.txtIdNumber.setVisible(true);
            this.lblBirthday.setVisible(true);
            this.txtBirthdayDay.setVisible(true);
            this.lblBirthdaySeparator1.setVisible(true);
            this.txtBirthdayMonth.setVisible(true);
            this.lblBirthdaySeparator2.setVisible(true);
            this.txtBirthdayYear.setVisible(true);
            this.lblCountry.setVisible(true);
            this.cmbCountry.setVisible(true);

			this.gridBagLayout.rowHeights[14] = 0;
            this.lblDescription.setVisible(false);
            this.txaDescription.setVisible(false);
            this.scrDescription.setVisible(false);
            this.lblWebUrl.setVisible(false);
            this.txtWebUrl.setVisible(false);
        } else if (Objects.equals(this.cmbUserType.getSelectedItem(), "Aerolínea")) {
            this.lblLastName.setVisible(false);
            this.txtLastName.setVisible(false);
            this.lblIdType.setVisible(false);
            this.cmbIdType.setVisible(false);
            this.lblIdNumber.setVisible(false);
            this.txtIdNumber.setVisible(false);
            this.lblBirthday.setVisible(false);
            this.txtBirthdayDay.setVisible(false);
            this.lblBirthdaySeparator1.setVisible(false);
            this.txtBirthdayMonth.setVisible(false);
            this.lblBirthdaySeparator2.setVisible(false);
            this.txtBirthdayYear.setVisible(false);
            this.lblCountry.setVisible(false);
            this.cmbCountry.setVisible(false);

			this.gridBagLayout.rowHeights[14] = 80;
            this.lblDescription.setVisible(true);
            this.txaDescription.setVisible(true);
            this.scrDescription.setVisible(true);
            this.lblWebUrl.setVisible(true);
            this.txtWebUrl.setVisible(true);
        }
    }

    public void clearDisplay() {
        this.txtUsername.setText("");
        this.txtName.setText("");
        this.txtEmail.setText("");
        this.txtPassword.setText("");
        this.txtConfirmPassword.setText("");
        this.lblSelectedImage.setText("");
		this.image = null;
        this.txtRegistrationDay.setText("");
        this.txtRegistrationMonth.setText("");
        this.txtRegistrationYear.setText("");
        this.txtLastName.setText("");
        this.cmbIdType.setSelectedIndex(0);
        this.txtIdNumber.setText("");
        this.txtBirthdayDay.setText("");
        this.txtBirthdayMonth.setText("");
        this.txtBirthdayYear.setText("");
        this.cmbCountry.setSelectedIndex(0);
        this.txaDescription.setText("");
        this.txtWebUrl.setText("");
    }

}

