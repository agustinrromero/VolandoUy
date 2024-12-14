package com.servidorcentral.admin;

import com.servidorcentral.controllers.UserController;
import com.servidorcentral.dtos.AirlineDTO;
import com.servidorcentral.dtos.ClientDTO;
import com.servidorcentral.dtos.FlightRouteDTO;
import com.servidorcentral.dtos.PackageDTO;
import com.servidorcentral.dtos.ReservationDTO;
import com.servidorcentral.dtos.UserDTO;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;

public class ViewUser extends JInternalFrame {

    private final UserController userController;
//    private final FlightController flightController;
    private final JTextField txtName;
    private final JTextField txtEmail;
    private final JLabel lblLastName;
    private final JTextField txtLastName;
    private final JLabel lblBirthday;
    private final JTextField txtBirthdayDay;
    private final JLabel lblBirthdaySeparator1;
    private final JTextField txtBirthdayMonth;
    private final JLabel lblBirthdaySeparator2;
    private final JTextField txtBirthdayYear;
    private final JLabel lblIdType;
    private final JTextField txtIdType;
    private final JLabel lblIdNumber;
    private final JTextField txtIdNumber;
    private final JLabel lblCountry;
    private final JTextField txtCountry;
    private final JLabel lblWebUrl;
    private final JTextField txtWebUrl;
    private final JLabel lblDescription;
    private final JScrollPane scrDescription;
    private final JTextArea txaDescription;
    private final JPasswordField txtPassword;
    private final JList<String> lstUsers;
    private final JPanel pnlFlightRouteList;
    private final JList<FlightRouteDTO> lstFlightRoutes;
    private final JPanel pnlReservations;
    private final JList<ReservationDTO> lstReservations;
    private final JPanel pnlPackages;
    private final JList<PackageDTO> lstPackages;
    private final GridBagLayout gridBagLayout;
    private final GridBagLayout gbl_pnlUser;
    private final JTextField txtUsername;

    private boolean clearingDisplay;
    private Set<UserDTO> usersDTO;

    public ViewUser(UserController userController, App app) {
        this.userController = userController;

        // Internal frame properties
        setTitle("Consulta de usuario");
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setBounds(0, 0, 710, 630);

        // Internal frame components
        gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{495, 200};
        gridBagLayout.rowHeights = new int[]{395, 200, 100, 100};
        gridBagLayout.columnWeights = new double[]{1.0, 0.0};
        gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0};
        getContentPane().setLayout(gridBagLayout);

        JPanel pnlUser = new JPanel();
        pnlUser.setBorder(new TitledBorder(null, "Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GridBagConstraints gbc_pnlUser = new GridBagConstraints();
        gbc_pnlUser.insets = new Insets(5, 0, 5, 5);
        gbc_pnlUser.fill = GridBagConstraints.BOTH;
        gbc_pnlUser.gridx = 0;
        gbc_pnlUser.gridy = 0;
        getContentPane().add(pnlUser, gbc_pnlUser);
        gbl_pnlUser = new GridBagLayout();
        gbl_pnlUser.columnWidths = new int[]{15, 190, 30, 0, 30, 0, 50, 100, 15, 15};
        gbl_pnlUser.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 80, 30};
        gbl_pnlUser.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
        gbl_pnlUser.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        pnlUser.setLayout(gbl_pnlUser);

        JLabel lblUsername = new JLabel("Username:");
        GridBagConstraints gbc_lblUsername = new GridBagConstraints();
        gbc_lblUsername.anchor = GridBagConstraints.EAST;
        gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
        gbc_lblUsername.gridx = 1;
        gbc_lblUsername.gridy = 1;
        pnlUser.add(lblUsername, gbc_lblUsername);

        txtUsername = new JTextField();
        txtUsername.setEditable(false);
        GridBagConstraints gbc_txtUsername = new GridBagConstraints();
        gbc_txtUsername.gridwidth = 6;
        gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
        gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtUsername.gridx = 2;
        gbc_txtUsername.gridy = 1;
        pnlUser.add(txtUsername, gbc_txtUsername);
        txtUsername.setColumns(10);

        JLabel lblName = new JLabel("Nombre:");
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.anchor = GridBagConstraints.EAST;
        gbc_lblName.insets = new Insets(0, 0, 5, 5);
        gbc_lblName.gridx = 1;
        gbc_lblName.gridy = 2;
        pnlUser.add(lblName, gbc_lblName);

        txtName = new JTextField();
        txtName.setEditable(false);
        GridBagConstraints gbc_txtName = new GridBagConstraints();
        gbc_txtName.gridwidth = 6;
        gbc_txtName.insets = new Insets(0, 0, 5, 5);
        gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtName.gridx = 2;
        gbc_txtName.gridy = 2;
        pnlUser.add(txtName, gbc_txtName);
        txtName.setColumns(10);

        JLabel lblEmail = new JLabel("Correo:");
        GridBagConstraints gbc_lblEmail = new GridBagConstraints();
        gbc_lblEmail.anchor = GridBagConstraints.EAST;
        gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
        gbc_lblEmail.gridx = 1;
        gbc_lblEmail.gridy = 3;
        pnlUser.add(lblEmail, gbc_lblEmail);

        txtEmail = new JTextField();
        txtEmail.setEditable(false);
        GridBagConstraints gbc_txtEmail = new GridBagConstraints();
        gbc_txtEmail.gridwidth = 6;
        gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
        gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtEmail.gridx = 2;
        gbc_txtEmail.gridy = 3;
        pnlUser.add(txtEmail, gbc_txtEmail);
        txtEmail.setColumns(10);

        JLabel lblPassword = new JLabel("Contraseña:");
        GridBagConstraints gbc_lblPassword = new GridBagConstraints();
        gbc_lblPassword.anchor = GridBagConstraints.EAST;
        gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
        gbc_lblPassword.gridx = 1;
        gbc_lblPassword.gridy = 4;
        pnlUser.add(lblPassword, gbc_lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setEditable(false);
        txtPassword.setColumns(10);
        GridBagConstraints gbc_txtPassword = new GridBagConstraints();
        gbc_txtPassword.gridwidth = 6;
        gbc_txtPassword.insets = new Insets(0, 0, 5, 5);
        gbc_txtPassword.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtPassword.gridx = 2;
        gbc_txtPassword.gridy = 4;
        pnlUser.add(txtPassword, gbc_txtPassword);

        // Show password on mouse hover
        char defaultEchoChar = txtPassword.getEchoChar();

        txtPassword.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                txtPassword.setEchoChar((char) 0);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                txtPassword.setEchoChar(defaultEchoChar);
            }
        });

        lblLastName = new JLabel("Apellido:");
        GridBagConstraints gbc_lblLastName = new GridBagConstraints();
        gbc_lblLastName.anchor = GridBagConstraints.EAST;
        gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
        gbc_lblLastName.gridx = 1;
        gbc_lblLastName.gridy = 5;
        pnlUser.add(lblLastName, gbc_lblLastName);

        txtLastName = new JTextField();
        txtLastName.setEditable(false);
        GridBagConstraints gbc_txtLastName = new GridBagConstraints();
        gbc_txtLastName.gridwidth = 6;
        gbc_txtLastName.insets = new Insets(0, 0, 5, 5);
        gbc_txtLastName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtLastName.gridx = 2;
        gbc_txtLastName.gridy = 5;
        pnlUser.add(txtLastName, gbc_txtLastName);
        txtLastName.setColumns(10);

        lblBirthday = new JLabel("Fecha de nacimiento:");
        GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
        gbc_lblBirthday.anchor = GridBagConstraints.EAST;
        gbc_lblBirthday.insets = new Insets(0, 0, 5, 5);
        gbc_lblBirthday.gridx = 1;
        gbc_lblBirthday.gridy = 6;
        pnlUser.add(lblBirthday, gbc_lblBirthday);

        txtBirthdayDay = new JTextField();
        txtBirthdayDay.setEditable(false);
        GridBagConstraints gbc_txtBirthdayDay = new GridBagConstraints();
        gbc_txtBirthdayDay.insets = new Insets(0, 0, 5, 5);
        gbc_txtBirthdayDay.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtBirthdayDay.gridx = 2;
        gbc_txtBirthdayDay.gridy = 6;
        pnlUser.add(txtBirthdayDay, gbc_txtBirthdayDay);
        txtBirthdayDay.setColumns(10);

        lblBirthdaySeparator1 = new JLabel("/");
        GridBagConstraints gbc_lblBirthdaySeparator1 = new GridBagConstraints();
        gbc_lblBirthdaySeparator1.anchor = GridBagConstraints.EAST;
        gbc_lblBirthdaySeparator1.insets = new Insets(0, 0, 5, 5);
        gbc_lblBirthdaySeparator1.gridx = 3;
        gbc_lblBirthdaySeparator1.gridy = 6;
        pnlUser.add(lblBirthdaySeparator1, gbc_lblBirthdaySeparator1);

        txtBirthdayMonth = new JTextField();
        txtBirthdayMonth.setEditable(false);
        GridBagConstraints gbc_txtBirthdayMonth = new GridBagConstraints();
        gbc_txtBirthdayMonth.insets = new Insets(0, 0, 5, 5);
        gbc_txtBirthdayMonth.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtBirthdayMonth.gridx = 4;
        gbc_txtBirthdayMonth.gridy = 6;
        pnlUser.add(txtBirthdayMonth, gbc_txtBirthdayMonth);
        txtBirthdayMonth.setColumns(10);

        lblBirthdaySeparator2 = new JLabel("/");
        GridBagConstraints gbc_lblBirthdaySeparator2 = new GridBagConstraints();
        gbc_lblBirthdaySeparator2.anchor = GridBagConstraints.EAST;
        gbc_lblBirthdaySeparator2.insets = new Insets(0, 0, 5, 5);
        gbc_lblBirthdaySeparator2.gridx = 5;
        gbc_lblBirthdaySeparator2.gridy = 6;
        pnlUser.add(lblBirthdaySeparator2, gbc_lblBirthdaySeparator2);

        txtBirthdayYear = new JTextField();
        txtBirthdayYear.setEditable(false);
        GridBagConstraints gbc_txtBirthdayYear = new GridBagConstraints();
        gbc_txtBirthdayYear.insets = new Insets(0, 0, 5, 5);
        gbc_txtBirthdayYear.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtBirthdayYear.gridx = 6;
        gbc_txtBirthdayYear.gridy = 6;
        pnlUser.add(txtBirthdayYear, gbc_txtBirthdayYear);
        txtBirthdayYear.setColumns(10);

        lblIdType = new JLabel("Tipo de documento:");
        GridBagConstraints gbc_lblIdType = new GridBagConstraints();
        gbc_lblIdType.anchor = GridBagConstraints.EAST;
        gbc_lblIdType.insets = new Insets(0, 0, 5, 5);
        gbc_lblIdType.gridx = 1;
        gbc_lblIdType.gridy = 7;
        pnlUser.add(lblIdType, gbc_lblIdType);

        txtIdType = new JTextField();
        txtIdType.setEditable(false);
        GridBagConstraints gbc_txtIdType = new GridBagConstraints();
        gbc_txtIdType.gridwidth = 6;
        gbc_txtIdType.insets = new Insets(0, 0, 5, 5);
        gbc_txtIdType.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtIdType.gridx = 2;
        gbc_txtIdType.gridy = 7;
        pnlUser.add(txtIdType, gbc_txtIdType);
        txtIdType.setColumns(10);

        lblIdNumber = new JLabel("Número de documento:");
        GridBagConstraints gbc_lblIdNumber = new GridBagConstraints();
        gbc_lblIdNumber.anchor = GridBagConstraints.EAST;
        gbc_lblIdNumber.insets = new Insets(0, 0, 5, 5);
        gbc_lblIdNumber.gridx = 1;
        gbc_lblIdNumber.gridy = 8;
        pnlUser.add(lblIdNumber, gbc_lblIdNumber);

        txtIdNumber = new JTextField();
        txtIdNumber.setEditable(false);
        GridBagConstraints gbc_txtIdNumber = new GridBagConstraints();
        gbc_txtIdNumber.gridwidth = 6;
        gbc_txtIdNumber.insets = new Insets(0, 0, 5, 5);
        gbc_txtIdNumber.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtIdNumber.gridx = 2;
        gbc_txtIdNumber.gridy = 8;
        pnlUser.add(txtIdNumber, gbc_txtIdNumber);
        txtIdNumber.setColumns(10);

        lblCountry = new JLabel("Nacionalidad:");
        GridBagConstraints gbc_lblCountry = new GridBagConstraints();
        gbc_lblCountry.anchor = GridBagConstraints.EAST;
        gbc_lblCountry.insets = new Insets(0, 0, 5, 5);
        gbc_lblCountry.gridx = 1;
        gbc_lblCountry.gridy = 9;
        pnlUser.add(lblCountry, gbc_lblCountry);

        txtCountry = new JTextField();
        txtCountry.setEditable(false);
        GridBagConstraints gbc_txtCountry = new GridBagConstraints();
        gbc_txtCountry.gridwidth = 6;
        gbc_txtCountry.insets = new Insets(0, 0, 5, 5);
        gbc_txtCountry.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCountry.gridx = 2;
        gbc_txtCountry.gridy = 9;
        pnlUser.add(txtCountry, gbc_txtCountry);
        txtCountry.setColumns(10);

        lblWebUrl = new JLabel("Web:");
        GridBagConstraints gbc_lblWebUrl = new GridBagConstraints();
        gbc_lblWebUrl.anchor = GridBagConstraints.EAST;
        gbc_lblWebUrl.insets = new Insets(0, 0, 5, 5);
        gbc_lblWebUrl.gridx = 1;
        gbc_lblWebUrl.gridy = 10;
        pnlUser.add(lblWebUrl, gbc_lblWebUrl);

        txtWebUrl = new JTextField();
        txtWebUrl.setEditable(false);
        GridBagConstraints gbc_txtWebUrl = new GridBagConstraints();
        gbc_txtWebUrl.gridwidth = 6;
        gbc_txtWebUrl.insets = new Insets(0, 0, 5, 5);
        gbc_txtWebUrl.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtWebUrl.gridx = 2;
        gbc_txtWebUrl.gridy = 10;
        pnlUser.add(txtWebUrl, gbc_txtWebUrl);
        txtWebUrl.setColumns(10);

        lblDescription = new JLabel("Descripción:");
        GridBagConstraints gbc_lblDescription = new GridBagConstraints();
        gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescription.anchor = GridBagConstraints.EAST;
        gbc_lblDescription.gridx = 1;
        gbc_lblDescription.gridy = 11;
        pnlUser.add(lblDescription, gbc_lblDescription);

        scrDescription = new JScrollPane();
        GridBagConstraints gbc_scrDescription = new GridBagConstraints();
        gbc_scrDescription.insets = new Insets(0, 0, 5, 5);
        gbc_scrDescription.gridwidth = 6;
        gbc_scrDescription.fill = GridBagConstraints.BOTH;
        gbc_scrDescription.gridx = 2;
        gbc_scrDescription.gridy = 11;
        pnlUser.add(scrDescription, gbc_scrDescription);

        txaDescription = new JTextArea();
        txaDescription.setLineWrap(true);
        txaDescription.setEditable(false);
        scrDescription.setViewportView(txaDescription);

        JPanel pnlUserList = new JPanel();
        pnlUserList.setBorder(new TitledBorder(null, "Usuarios registrados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GridBagConstraints gbc_pnlUserList = new GridBagConstraints();
        gbc_pnlUserList.fill = GridBagConstraints.BOTH;
        gbc_pnlUserList.insets = new Insets(0, 0, 5, 0);
        gbc_pnlUserList.gridx = 1;
        gbc_pnlUserList.gridy = 0;
        getContentPane().add(pnlUserList, gbc_pnlUserList);
        GridBagLayout gbl_pnlUserList = new GridBagLayout();
        gbl_pnlUserList.columnWidths = new int[]{0, 0};
        gbl_pnlUserList.rowHeights = new int[]{0, 0};
        gbl_pnlUserList.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_pnlUserList.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        pnlUserList.setLayout(gbl_pnlUserList);

        JScrollPane scrUserList = new JScrollPane();
        GridBagConstraints gbc_scrUserList = new GridBagConstraints();
        gbc_scrUserList.insets = new Insets(5, 0, 0, 0);
        gbc_scrUserList.fill = GridBagConstraints.BOTH;
        gbc_scrUserList.gridx = 0;
        gbc_scrUserList.gridy = 0;
        pnlUserList.add(scrUserList, gbc_scrUserList);
        lstUsers = new JList<String>();
        scrUserList.setViewportView(lstUsers);
        lstUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        lstUsers.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && !clearingDisplay) {
                JList<String> lstUsernames = (JList<String>) e.getSource();
                String username = lstUsernames.getSelectedValue();
                updateUserData(username);
            }
        });

        pnlFlightRouteList = new JPanel();
        pnlFlightRouteList.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Rutas de vuelo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
        GridBagConstraints gbc_pnlFlightRouteList = new GridBagConstraints();
        gbc_pnlFlightRouteList.gridwidth = 2;
        gbc_pnlFlightRouteList.insets = new Insets(0, 0, 5, 0);
        gbc_pnlFlightRouteList.fill = GridBagConstraints.BOTH;
        gbc_pnlFlightRouteList.gridx = 0;
        gbc_pnlFlightRouteList.gridy = 1;
        getContentPane().add(pnlFlightRouteList, gbc_pnlFlightRouteList);
        GridBagLayout gbl_pnlFlightRouteList = new GridBagLayout();
        gbl_pnlFlightRouteList.columnWidths = new int[]{0, 0};
        gbl_pnlFlightRouteList.rowHeights = new int[]{0, 0};
        gbl_pnlFlightRouteList.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_pnlFlightRouteList.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        pnlFlightRouteList.setLayout(gbl_pnlFlightRouteList);

        JScrollPane scrFlightRoutes = new JScrollPane();
        GridBagConstraints gbc_scrFlightRoutes = new GridBagConstraints();
        gbc_scrFlightRoutes.fill = GridBagConstraints.BOTH;
        gbc_scrFlightRoutes.gridx = 0;
        gbc_scrFlightRoutes.gridy = 0;
        pnlFlightRouteList.add(scrFlightRoutes, gbc_scrFlightRoutes);

        lstFlightRoutes = new JList<FlightRouteDTO>();
        lstFlightRoutes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrFlightRoutes.setViewportView(lstFlightRoutes);

        lstFlightRoutes.addMouseListener(new MouseAdapter() {
            @SuppressWarnings("unchecked")
            public void mouseClicked(MouseEvent evt) {
                JList<FlightRouteDTO> list = (JList<FlightRouteDTO>) evt.getSource();
                Rectangle r = ViewUser.this.lstFlightRoutes.getCellBounds(0, list.getLastVisibleIndex());

                if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1 && r != null && r.contains(evt.getPoint())) {
                    FlightRouteDTO flightRouteDTO = ViewUser.this.lstFlightRoutes.getSelectedValue();
//                    app.viewFlightRoute(dtRuta);
                }
            }
        });

        pnlReservations = new JPanel();
        pnlReservations.setBorder(new TitledBorder(null, "Reservas de vuelos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GridBagConstraints gbc_pnlReservations = new GridBagConstraints();
        gbc_pnlReservations.gridwidth = 2;
        gbc_pnlReservations.insets = new Insets(0, 0, 5, 0);
        gbc_pnlReservations.fill = GridBagConstraints.BOTH;
        gbc_pnlReservations.gridx = 0;
        gbc_pnlReservations.gridy = 2;
        getContentPane().add(pnlReservations, gbc_pnlReservations);
        GridBagLayout gbl_pnlReservations = new GridBagLayout();
        gbl_pnlReservations.columnWidths = new int[]{0, 0};
        gbl_pnlReservations.rowHeights = new int[]{0, 0};
        gbl_pnlReservations.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_pnlReservations.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        pnlReservations.setLayout(gbl_pnlReservations);

        JScrollPane scrReservations = new JScrollPane();
        GridBagConstraints gbc_scrReservations = new GridBagConstraints();
        gbc_scrReservations.fill = GridBagConstraints.BOTH;
        gbc_scrReservations.gridx = 0;
        gbc_scrReservations.gridy = 0;
        pnlReservations.add(scrReservations, gbc_scrReservations);

        lstReservations = new JList<ReservationDTO>();
        lstReservations.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrReservations.setViewportView(lstReservations);

        lstReservations.addMouseListener(new MouseAdapter() {
            @SuppressWarnings("unchecked")
            public void mouseClicked(MouseEvent evt) {
                JList<ReservationDTO> list = (JList<ReservationDTO>) evt.getSource();
                Rectangle r = lstReservations.getCellBounds(0, list.getLastVisibleIndex());
                if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1 && r != null && r.contains(evt.getPoint())) {
                    ReservationDTO reservation = lstReservations.getSelectedValue();
//                    app.viewReservation(reservation);
                }
            }
        });

        pnlPackages = new JPanel();
        pnlPackages.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Paquetes comprados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
        GridBagConstraints gbc_pnlPackages = new GridBagConstraints();
        gbc_pnlPackages.gridwidth = 2;
        gbc_pnlPackages.fill = GridBagConstraints.BOTH;
        gbc_pnlPackages.gridx = 0;
        gbc_pnlPackages.gridy = 3;
        getContentPane().add(pnlPackages, gbc_pnlPackages);
        GridBagLayout gbl_pnlPackages = new GridBagLayout();
        gbl_pnlPackages.columnWidths = new int[]{0, 0};
        gbl_pnlPackages.rowHeights = new int[]{0, 0};
        gbl_pnlPackages.columnWeights = new double[]{1.0, Double.MIN_VALUE};
        gbl_pnlPackages.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        pnlPackages.setLayout(gbl_pnlPackages);

        JScrollPane scrPackages = new JScrollPane();
        GridBagConstraints gbc_scrPackages = new GridBagConstraints();
        gbc_scrPackages.fill = GridBagConstraints.BOTH;
        gbc_scrPackages.gridx = 0;
        gbc_scrPackages.gridy = 0;
        pnlPackages.add(scrPackages, gbc_scrPackages);

        lstPackages = new JList<PackageDTO>();
        lstPackages.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrPackages.setViewportView(lstPackages);

        lstPackages.addMouseListener(new MouseAdapter() {
            @SuppressWarnings("unchecked")
            public void mouseClicked(MouseEvent evt) {
                JList<PackageDTO> list = (JList<PackageDTO>) evt.getSource();
                Rectangle r = lstPackages.getCellBounds(0, list.getLastVisibleIndex());
                if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1 && r != null && r.contains(evt.getPoint())) {
                    PackageDTO packageDTO = lstPackages.getSelectedValue();
//                    app.viewPackage(packageDTO);
                }
            }
        });
    }

    private void updateUserData(String username) {
        UserDTO searchedUser = usersDTO.stream()
                .filter(each -> each.getUsername().equals(username))
                .findFirst()
                .get();

        this.txtUsername.setText(searchedUser.getUsername());
        this.txtName.setText(searchedUser.getName());
        this.txtEmail.setText(searchedUser.getEmail());
        this.txtPassword.setText(searchedUser.getPassword());

        if (searchedUser instanceof ClientDTO searchedClient) {
            this.txtLastName.setText(searchedClient.getLastName());
            this.txtIdType.setText(searchedClient.getIdType().getName());
            this.txtIdNumber.setText(searchedClient.getIdNumber());
            this.txtCountry.setText(searchedClient.getCountry().getName());
            this.txtBirthdayDay.setText(Integer.toString(searchedClient.getBirthday().getDayOfMonth()));
            this.txtBirthdayMonth.setText(Integer.toString(searchedClient.getBirthday().getMonthValue()));
            this.txtBirthdayYear.setText(Integer.toString(searchedClient.getBirthday().getYear()));

            this.userController.getUserReservationsDTO(searchedClient.getUsername());
//            this.lstReservations.setListData();
//            this.lstPackages.setListData();

            this.setClientInfoVisible(true);
            this.setAirlineInfoVisible(false);
        } else if (searchedUser instanceof AirlineDTO searchedAirline) {
            this.txtWebUrl.setText(searchedAirline.getWebUrl());
            this.txaDescription.setText(searchedAirline.getDescription());

//            this.lstFlightRoutes.setListData();

            this.setClientInfoVisible(false);
            this.setAirlineInfoVisible(true);
        }
    }

    public void clearDisplay() {
        this.clearingDisplay = true;

        this.txtUsername.setText("");
        this.txtName.setText("");
        this.txtEmail.setText("");
        this.txtPassword.setText("");
        this.txtLastName.setText("");
        this.txtIdType.setText("");
        this.txtIdNumber.setText("");
        this.txtCountry.setText("");
        this.txtBirthdayDay.setText("");
        this.txtBirthdayMonth.setText("");
        this.txtBirthdayYear.setText("");
        this.txtWebUrl.setText("");
        this.txaDescription.setText("");

        this.lstReservations.setListData(new ReservationDTO[0]);
        this.lstPackages.setListData(new PackageDTO[0]);
        this.lstFlightRoutes.setListData(new FlightRouteDTO[0]);

        this.clearingDisplay = false;
    }

    public void initialize() {
        this.usersDTO = userController.getAllUsersDTO();

        this.clearingDisplay = true;
        this.lstUsers.setListData(usersDTO.stream().map(UserDTO::getUsername).toArray(String[]::new));
        this.clearingDisplay = false;

        this.gridBagLayout.rowHeights[2] = 0;
        this.gridBagLayout.rowHeights[3] = 0;

        this.pnlPackages.setVisible(false);
        this.pnlReservations.setVisible(false);
    }

    public void initializeWithUser(String username) {
        // TODO
    }

    private void setAirlineInfoVisible(boolean visible) {
        this.lblWebUrl.setVisible(visible);
        this.txtWebUrl.setVisible(visible);
        this.lblDescription.setVisible(visible);
        this.scrDescription.setVisible(visible);
        this.txaDescription.setVisible(visible);

        this.pnlFlightRouteList.setVisible(visible);
        this.lstFlightRoutes.setVisible(visible);

        if (visible) {
            gridBagLayout.rowHeights[1] = 200;
            gridBagLayout.rowWeights[1] = 1;
            gbl_pnlUser.rowHeights[11] = 80;
        } else {
            gridBagLayout.rowHeights[1] = 0;
            gridBagLayout.rowWeights[1] = 0;
            gbl_pnlUser.rowHeights[11] = 0;
        }
    }

    private void setClientInfoVisible(boolean visible) {
        this.lblLastName.setVisible(visible);
        this.txtLastName.setVisible(visible);
        this.lblBirthday.setVisible(visible);
        this.txtBirthdayDay.setVisible(visible);
        this.lblBirthdaySeparator1.setVisible(visible);
        this.txtBirthdayMonth.setVisible(visible);
        this.lblBirthdaySeparator2.setVisible(visible);
        this.txtBirthdayYear.setVisible(visible);
        this.lblIdType.setVisible(visible);
        this.txtIdType.setVisible(visible);
        this.lblIdNumber.setVisible(visible);
        this.txtIdNumber.setVisible(visible);
        this.lblCountry.setVisible(visible);
        this.txtCountry.setVisible(visible);

        this.pnlPackages.setVisible(visible);
        this.lstPackages.setVisible(visible);
        this.pnlReservations.setVisible(visible);
        this.lstReservations.setVisible(visible);

        if (visible) {
            gridBagLayout.rowHeights[2] = 100;
            gridBagLayout.rowWeights[2] = 1;
            gridBagLayout.rowHeights[3] = 100;
            gridBagLayout.rowWeights[3] = 1;
        } else {
            gridBagLayout.rowHeights[2] = 0;
            gridBagLayout.rowWeights[2] = 0;
            gridBagLayout.rowHeights[3] = 0;
            gridBagLayout.rowWeights[3] = 0;
        }
    }

}

