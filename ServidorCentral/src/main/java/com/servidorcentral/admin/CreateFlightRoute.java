package com.servidorcentral.admin;

import com.servidorcentral.dtos.CityDTO;
import com.toedter.calendar.JDateChooser;

import com.servidorcentral.controllers.FlightController;
import com.servidorcentral.controllers.UserController;
import com.servidorcentral.dtos.AirlineDTO;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CreateFlightRoute extends JInternalFrame {

    private final UserController userController;
    private final FlightController flightController;

    private final JComboBox<String> cmbAirline;
    private final JTextField txtName;
    private final JTextField txtShortDescription;
    private final JTextArea txaDescription;
    private final JComboBox<String> cmbOriginCountry;
    private final JComboBox<String> cmbOriginCity;
    private final JComboBox<String> cmbDestinationCountry;
    private final JComboBox<String> cmbDestinationCity;
    private final JDateChooser dateChooser;
    private final JSpinner spnTimeHour;
    private final JSpinner spnTimeMinute;
    private final JFormattedTextField frmTouristCost;
    private final JFormattedTextField frmBusinessCost;
    private final JFormattedTextField frmExtraLuggageCost;
    private final JList<String> lstAvailableCategories;
    private final JList<String> lstSelectedCategories;

    private String[] originalCategories;

    public CreateFlightRoute(UserController userController, FlightController flightController) {
        this.userController = userController;
        this.flightController = flightController;

        // Internal frame properties
        setTitle("Crear ruta de vuelo");
        setBounds(0, 0, 990, 505);
        setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        setResizable(true);
        setClosable(true);
        setMaximizable(true);
        setIconifiable(true);

        // Internal frame components
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{600, 375, 0};
        gridBagLayout.rowHeights = new int[]{0, 0};
        gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JPanel pnlFlightRouteData = new JPanel();
        pnlFlightRouteData.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Información de la ruta de vuelo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
        GridBagConstraints gbc_pnlFlightRouteData = new GridBagConstraints();
        gbc_pnlFlightRouteData.insets = new Insets(0, 0, 0, 5);
        gbc_pnlFlightRouteData.fill = GridBagConstraints.BOTH;
        gbc_pnlFlightRouteData.gridx = 0;
        gbc_pnlFlightRouteData.gridy = 0;
        getContentPane().add(pnlFlightRouteData, gbc_pnlFlightRouteData);
        GridBagLayout gbl_pnlFlightRouteData = new GridBagLayout();
        gbl_pnlFlightRouteData.columnWidths = new int[]{25, 0, 45, 0, 45, 0, 0, 0, 110, 25, 0};
        gbl_pnlFlightRouteData.rowHeights = new int[]{25, 0, 0, 0, 80, 0, 0, 0, 0, 0, 0, 0, 30, 0, 25, 0};
        gbl_pnlFlightRouteData.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_pnlFlightRouteData.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        pnlFlightRouteData.setLayout(gbl_pnlFlightRouteData);

        JLabel lblAirline = new JLabel("Aerolínea:");
        GridBagConstraints gbc_lblAirline = new GridBagConstraints();
        gbc_lblAirline.insets = new Insets(0, 0, 5, 5);
        gbc_lblAirline.anchor = GridBagConstraints.EAST;
        gbc_lblAirline.gridx = 1;
        gbc_lblAirline.gridy = 1;
        pnlFlightRouteData.add(lblAirline, gbc_lblAirline);

        cmbAirline = new JComboBox<String>();
        GridBagConstraints gbc_cmbAirline = new GridBagConstraints();
        gbc_cmbAirline.gridwidth = 7;
        gbc_cmbAirline.insets = new Insets(0, 0, 5, 5);
        gbc_cmbAirline.fill = GridBagConstraints.HORIZONTAL;
        gbc_cmbAirline.gridx = 2;
        gbc_cmbAirline.gridy = 1;
        pnlFlightRouteData.add(cmbAirline, gbc_cmbAirline);

        JLabel lblName = new JLabel("Nombre:");
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.anchor = GridBagConstraints.EAST;
        gbc_lblName.insets = new Insets(0, 0, 5, 5);
        gbc_lblName.gridx = 1;
        gbc_lblName.gridy = 2;
        pnlFlightRouteData.add(lblName, gbc_lblName);

        txtName = new JTextField();
        GridBagConstraints gbc_txtName = new GridBagConstraints();
        gbc_txtName.gridwidth = 7;
        gbc_txtName.insets = new Insets(0, 0, 5, 5);
        gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtName.gridx = 2;
        gbc_txtName.gridy = 2;
        pnlFlightRouteData.add(txtName, gbc_txtName);
        txtName.setColumns(10);

        JLabel lblShortDescription = new JLabel("Descripción corta:");
        GridBagConstraints gbc_lblShortDescription = new GridBagConstraints();
        gbc_lblShortDescription.anchor = GridBagConstraints.EAST;
        gbc_lblShortDescription.insets = new Insets(0, 0, 5, 5);
        gbc_lblShortDescription.gridx = 1;
        gbc_lblShortDescription.gridy = 3;
        pnlFlightRouteData.add(lblShortDescription, gbc_lblShortDescription);

        txtShortDescription = new JTextField();
        GridBagConstraints gbc_txtShortDescription = new GridBagConstraints();
        gbc_txtShortDescription.gridwidth = 7;
        gbc_txtShortDescription.insets = new Insets(0, 0, 5, 5);
        gbc_txtShortDescription.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtShortDescription.gridx = 2;
        gbc_txtShortDescription.gridy = 3;
        pnlFlightRouteData.add(txtShortDescription, gbc_txtShortDescription);
        txtShortDescription.setColumns(10);

        JLabel lblDescription = new JLabel("Descripción:");
        GridBagConstraints gbc_lblDescription = new GridBagConstraints();
        gbc_lblDescription.anchor = GridBagConstraints.EAST;
        gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescription.gridx = 1;
        gbc_lblDescription.gridy = 4;
        pnlFlightRouteData.add(lblDescription, gbc_lblDescription);

        JScrollPane scrDescription = new JScrollPane();
        GridBagConstraints gbc_scrDescription = new GridBagConstraints();
        gbc_scrDescription.gridwidth = 7;
        gbc_scrDescription.insets = new Insets(0, 0, 5, 5);
        gbc_scrDescription.fill = GridBagConstraints.BOTH;
        gbc_scrDescription.gridx = 2;
        gbc_scrDescription.gridy = 4;
        pnlFlightRouteData.add(scrDescription, gbc_scrDescription);

        txaDescription = new JTextArea();
        scrDescription.setViewportView(txaDescription);

        JLabel lblOrigin = new JLabel("Origen:");
        GridBagConstraints gbc_lblOrigin = new GridBagConstraints();
        gbc_lblOrigin.anchor = GridBagConstraints.EAST;
        gbc_lblOrigin.insets = new Insets(0, 0, 5, 5);
        gbc_lblOrigin.gridx = 1;
        gbc_lblOrigin.gridy = 5;
        pnlFlightRouteData.add(lblOrigin, gbc_lblOrigin);

        cmbOriginCountry = new JComboBox<String>();
        cmbOriginCountry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateOriginCities((String) cmbOriginCountry.getSelectedItem());
            }
        });
        GridBagConstraints gbc_cmbOriginCountry = new GridBagConstraints();
        gbc_cmbOriginCountry.gridwidth = 4;
        gbc_cmbOriginCountry.insets = new Insets(0, 0, 5, 5);
        gbc_cmbOriginCountry.fill = GridBagConstraints.HORIZONTAL;
        gbc_cmbOriginCountry.gridx = 2;
        gbc_cmbOriginCountry.gridy = 5;
        pnlFlightRouteData.add(cmbOriginCountry, gbc_cmbOriginCountry);

        cmbOriginCity = new JComboBox<String>();
        GridBagConstraints gbc_cmbOriginCity = new GridBagConstraints();
        gbc_cmbOriginCity.gridwidth = 3;
        gbc_cmbOriginCity.insets = new Insets(0, 0, 5, 5);
        gbc_cmbOriginCity.fill = GridBagConstraints.HORIZONTAL;
        gbc_cmbOriginCity.gridx = 6;
        gbc_cmbOriginCity.gridy = 5;
        pnlFlightRouteData.add(cmbOriginCity, gbc_cmbOriginCity);

        JLabel lblDestination = new JLabel("Destino:");
        GridBagConstraints gbc_lblDestination = new GridBagConstraints();
        gbc_lblDestination.anchor = GridBagConstraints.EAST;
        gbc_lblDestination.insets = new Insets(0, 0, 5, 5);
        gbc_lblDestination.gridx = 1;
        gbc_lblDestination.gridy = 6;
        pnlFlightRouteData.add(lblDestination, gbc_lblDestination);

        cmbDestinationCountry = new JComboBox<String>();
        cmbDestinationCountry.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateDestinationCities((String) cmbDestinationCountry.getSelectedItem());
            }
        });
        GridBagConstraints gbc_cmbDestinationCountry = new GridBagConstraints();
        gbc_cmbDestinationCountry.gridwidth = 4;
        gbc_cmbDestinationCountry.insets = new Insets(0, 0, 5, 5);
        gbc_cmbDestinationCountry.fill = GridBagConstraints.HORIZONTAL;
        gbc_cmbDestinationCountry.gridx = 2;
        gbc_cmbDestinationCountry.gridy = 6;
        pnlFlightRouteData.add(cmbDestinationCountry, gbc_cmbDestinationCountry);

        cmbDestinationCity = new JComboBox<String>();
        GridBagConstraints gbc_cmbDestinationCity = new GridBagConstraints();
        gbc_cmbDestinationCity.gridwidth = 3;
        gbc_cmbDestinationCity.insets = new Insets(0, 0, 5, 5);
        gbc_cmbDestinationCity.fill = GridBagConstraints.HORIZONTAL;
        gbc_cmbDestinationCity.gridx = 6;
        gbc_cmbDestinationCity.gridy = 6;
        pnlFlightRouteData.add(cmbDestinationCity, gbc_cmbDestinationCity);

        JLabel lblDate = new JLabel("Fecha:");
        GridBagConstraints gbc_lblDate = new GridBagConstraints();
        gbc_lblDate.anchor = GridBagConstraints.EAST;
        gbc_lblDate.insets = new Insets(0, 0, 5, 5);
        gbc_lblDate.gridx = 1;
        gbc_lblDate.gridy = 7;
        pnlFlightRouteData.add(lblDate, gbc_lblDate);

        dateChooser = new JDateChooser();
        GridBagConstraints gbc_dateChooser = new GridBagConstraints();
        gbc_dateChooser.gridwidth = 4;
        gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
        gbc_dateChooser.fill = GridBagConstraints.BOTH;
        gbc_dateChooser.gridx = 2;
        gbc_dateChooser.gridy = 7;
        pnlFlightRouteData.add(dateChooser, gbc_dateChooser);

        JLabel lblTime = new JLabel("Hora:");
        GridBagConstraints gbc_lblTime = new GridBagConstraints();
        gbc_lblTime.anchor = GridBagConstraints.EAST;
        gbc_lblTime.insets = new Insets(0, 0, 5, 5);
        gbc_lblTime.gridx = 1;
        gbc_lblTime.gridy = 8;
        pnlFlightRouteData.add(lblTime, gbc_lblTime);

        spnTimeHour = new JSpinner();
        spnTimeHour.setModel(new SpinnerNumberModel(0, 0, 23, 1));
        GridBagConstraints gbc_spnTimeHour = new GridBagConstraints();
        gbc_spnTimeHour.fill = GridBagConstraints.HORIZONTAL;
        gbc_spnTimeHour.insets = new Insets(0, 0, 5, 5);
        gbc_spnTimeHour.gridx = 2;
        gbc_spnTimeHour.gridy = 8;
        pnlFlightRouteData.add(spnTimeHour, gbc_spnTimeHour);

        JLabel lblTimeSeparator = new JLabel(":");
        GridBagConstraints gbc_lblTimeSeparator = new GridBagConstraints();
        gbc_lblTimeSeparator.insets = new Insets(0, 0, 5, 5);
        gbc_lblTimeSeparator.gridx = 3;
        gbc_lblTimeSeparator.gridy = 8;
        pnlFlightRouteData.add(lblTimeSeparator, gbc_lblTimeSeparator);

        spnTimeMinute = new JSpinner();
        spnTimeMinute.setModel(new SpinnerNumberModel(0, 0, 59, 1));
        GridBagConstraints gbc_spnTimeMinute = new GridBagConstraints();
        gbc_spnTimeMinute.fill = GridBagConstraints.HORIZONTAL;
        gbc_spnTimeMinute.insets = new Insets(0, 0, 5, 5);
        gbc_spnTimeMinute.gridx = 4;
        gbc_spnTimeMinute.gridy = 8;
        pnlFlightRouteData.add(spnTimeMinute, gbc_spnTimeMinute);

        NumberFormat priceFormat = NumberFormat.getNumberInstance();

        JLabel lblTouristCost = new JLabel("Costo clase turista:");
        GridBagConstraints gbc_lblTouristCost = new GridBagConstraints();
        gbc_lblTouristCost.anchor = GridBagConstraints.EAST;
        gbc_lblTouristCost.insets = new Insets(0, 0, 5, 5);
        gbc_lblTouristCost.gridx = 1;
        gbc_lblTouristCost.gridy = 9;
        pnlFlightRouteData.add(lblTouristCost, gbc_lblTouristCost);

        JLabel lblPriceTourist = new JLabel("US$");
        GridBagConstraints gbc_lblPriceTourist = new GridBagConstraints();
        gbc_lblPriceTourist.anchor = GridBagConstraints.EAST;
        gbc_lblPriceTourist.insets = new Insets(0, 0, 5, 5);
        gbc_lblPriceTourist.gridx = 2;
        gbc_lblPriceTourist.gridy = 9;
        pnlFlightRouteData.add(lblPriceTourist, gbc_lblPriceTourist);

        frmTouristCost = new JFormattedTextField(priceFormat);
        GridBagConstraints gbc_frmTouristCost = new GridBagConstraints();
        gbc_frmTouristCost.gridwidth = 3;
        gbc_frmTouristCost.insets = new Insets(0, 0, 5, 5);
        gbc_frmTouristCost.fill = GridBagConstraints.HORIZONTAL;
        gbc_frmTouristCost.gridx = 3;
        gbc_frmTouristCost.gridy = 9;
        pnlFlightRouteData.add(frmTouristCost, gbc_frmTouristCost);

        JLabel lblBusinessCost = new JLabel("Costo clase ejecutiva:");
        GridBagConstraints gbc_lblBusinessCost = new GridBagConstraints();
        gbc_lblBusinessCost.anchor = GridBagConstraints.EAST;
        gbc_lblBusinessCost.insets = new Insets(0, 0, 5, 5);
        gbc_lblBusinessCost.gridx = 1;
        gbc_lblBusinessCost.gridy = 10;
        pnlFlightRouteData.add(lblBusinessCost, gbc_lblBusinessCost);

        JLabel lblPriceBusiness = new JLabel("US$");
        GridBagConstraints gbc_lblPriceBusiness = new GridBagConstraints();
        gbc_lblPriceBusiness.anchor = GridBagConstraints.EAST;
        gbc_lblPriceBusiness.insets = new Insets(0, 0, 5, 5);
        gbc_lblPriceBusiness.gridx = 2;
        gbc_lblPriceBusiness.gridy = 10;
        pnlFlightRouteData.add(lblPriceBusiness, gbc_lblPriceBusiness);

        frmBusinessCost = new JFormattedTextField(priceFormat);
        GridBagConstraints gbc_frmBusinessCost = new GridBagConstraints();
        gbc_frmBusinessCost.gridwidth = 3;
        gbc_frmBusinessCost.insets = new Insets(0, 0, 5, 5);
        gbc_frmBusinessCost.fill = GridBagConstraints.HORIZONTAL;
        gbc_frmBusinessCost.gridx = 3;
        gbc_frmBusinessCost.gridy = 10;
        pnlFlightRouteData.add(frmBusinessCost, gbc_frmBusinessCost);

        JLabel lblExtraLuggageCost = new JLabel("Costo equipaje extra:");
        GridBagConstraints gbc_lblExtraLuggageCost = new GridBagConstraints();
        gbc_lblExtraLuggageCost.anchor = GridBagConstraints.EAST;
        gbc_lblExtraLuggageCost.insets = new Insets(0, 0, 5, 5);
        gbc_lblExtraLuggageCost.gridx = 1;
        gbc_lblExtraLuggageCost.gridy = 11;
        pnlFlightRouteData.add(lblExtraLuggageCost, gbc_lblExtraLuggageCost);

        JLabel lblPriceExtraLuggage = new JLabel("US$");
        GridBagConstraints gbc_lblPriceExtraLuggage = new GridBagConstraints();
        gbc_lblPriceExtraLuggage.anchor = GridBagConstraints.EAST;
        gbc_lblPriceExtraLuggage.insets = new Insets(0, 0, 5, 5);
        gbc_lblPriceExtraLuggage.gridx = 2;
        gbc_lblPriceExtraLuggage.gridy = 11;
        pnlFlightRouteData.add(lblPriceExtraLuggage, gbc_lblPriceExtraLuggage);

        frmExtraLuggageCost = new JFormattedTextField(priceFormat);
        GridBagConstraints gbc_frmExtraLuggageCost = new GridBagConstraints();
        gbc_frmExtraLuggageCost.gridwidth = 3;
        gbc_frmExtraLuggageCost.insets = new Insets(0, 0, 5, 5);
        gbc_frmExtraLuggageCost.fill = GridBagConstraints.HORIZONTAL;
        gbc_frmExtraLuggageCost.gridx = 3;
        gbc_frmExtraLuggageCost.gridy = 11;
        pnlFlightRouteData.add(frmExtraLuggageCost, gbc_frmExtraLuggageCost);

        JButton btnAcept = new JButton("Aceptar");
        GridBagConstraints gbc_btnAcept = new GridBagConstraints();
        gbc_btnAcept.insets = new Insets(0, 0, 5, 5);
        gbc_btnAcept.gridx = 7;
        gbc_btnAcept.gridy = 13;
        pnlFlightRouteData.add(btnAcept, gbc_btnAcept);

        JButton btnCancel = new JButton("Cancelar");
        GridBagConstraints gbc_btnCancel = new GridBagConstraints();
        gbc_btnCancel.anchor = GridBagConstraints.EAST;
        gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
        gbc_btnCancel.gridx = 8;
        gbc_btnCancel.gridy = 13;
        pnlFlightRouteData.add(btnCancel, gbc_btnCancel);

        JPanel pnlCategories = new JPanel();
        pnlCategories.setBorder(new TitledBorder(null, "Categorías", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        GridBagConstraints gbc_pnlCategories = new GridBagConstraints();
        gbc_pnlCategories.fill = GridBagConstraints.BOTH;
        gbc_pnlCategories.gridx = 1;
        gbc_pnlCategories.gridy = 0;
        getContentPane().add(pnlCategories, gbc_pnlCategories);
        GridBagLayout gbl_pnlCategories = new GridBagLayout();
        gbl_pnlCategories.columnWidths = new int[]{25, 130, 130, 0, 25, 0};
        gbl_pnlCategories.rowHeights = new int[]{25, 0, 60, 60, 30, 0, 120, 25, 0};
        gbl_pnlCategories.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_pnlCategories.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        pnlCategories.setLayout(gbl_pnlCategories);

        JLabel lblAvailableCategories = new JLabel("Categorías disponibles:");
        GridBagConstraints gbc_lblAvailableCategories = new GridBagConstraints();
        gbc_lblAvailableCategories.gridwidth = 3;
        gbc_lblAvailableCategories.anchor = GridBagConstraints.WEST;
        gbc_lblAvailableCategories.insets = new Insets(0, 0, 5, 5);
        gbc_lblAvailableCategories.gridx = 1;
        gbc_lblAvailableCategories.gridy = 1;
        pnlCategories.add(lblAvailableCategories, gbc_lblAvailableCategories);

        JScrollPane scrAvailableCategories = new JScrollPane();
        GridBagConstraints gbc_scrAvailableCategories = new GridBagConstraints();
        gbc_scrAvailableCategories.gridheight = 2;
        gbc_scrAvailableCategories.gridwidth = 2;
        gbc_scrAvailableCategories.insets = new Insets(0, 0, 5, 5);
        gbc_scrAvailableCategories.fill = GridBagConstraints.BOTH;
        gbc_scrAvailableCategories.gridx = 1;
        gbc_scrAvailableCategories.gridy = 2;
        pnlCategories.add(scrAvailableCategories, gbc_scrAvailableCategories);

        lstAvailableCategories = new JList<String>();
        scrAvailableCategories.setViewportView(lstAvailableCategories);

        JButton btnAddCategory = new JButton("+");
        GridBagConstraints gbc_btnAddCategory = new GridBagConstraints();
        gbc_btnAddCategory.fill = GridBagConstraints.BOTH;
        gbc_btnAddCategory.insets = new Insets(0, 0, 5, 5);
        gbc_btnAddCategory.gridx = 3;
        gbc_btnAddCategory.gridy = 2;
        pnlCategories.add(btnAddCategory, gbc_btnAddCategory);

        JButton btnRemoveCategory = new JButton("-");
        GridBagConstraints gbc_btnRemoveCategory = new GridBagConstraints();
        gbc_btnRemoveCategory.fill = GridBagConstraints.BOTH;
        gbc_btnRemoveCategory.insets = new Insets(0, 0, 5, 5);
        gbc_btnRemoveCategory.gridx = 3;
        gbc_btnRemoveCategory.gridy = 3;
        pnlCategories.add(btnRemoveCategory, gbc_btnRemoveCategory);

        JLabel lblSelectedCategories = new JLabel("Categorías seleccionadas:");
        GridBagConstraints gbc_lblSelectedCategories = new GridBagConstraints();
        gbc_lblSelectedCategories.gridwidth = 3;
        gbc_lblSelectedCategories.anchor = GridBagConstraints.WEST;
        gbc_lblSelectedCategories.insets = new Insets(0, 0, 5, 5);
        gbc_lblSelectedCategories.gridx = 1;
        gbc_lblSelectedCategories.gridy = 5;
        pnlCategories.add(lblSelectedCategories, gbc_lblSelectedCategories);

        JScrollPane scrSelectedCategories = new JScrollPane();
        GridBagConstraints gbc_scrSelectedCategories = new GridBagConstraints();
        gbc_scrSelectedCategories.gridwidth = 3;
        gbc_scrSelectedCategories.insets = new Insets(0, 0, 5, 5);
        gbc_scrSelectedCategories.fill = GridBagConstraints.BOTH;
        gbc_scrSelectedCategories.gridx = 1;
        gbc_scrSelectedCategories.gridy = 6;
        pnlCategories.add(scrSelectedCategories, gbc_scrSelectedCategories);

        lstSelectedCategories = new JList<String>();
        scrSelectedCategories.setViewportView(lstSelectedCategories);
    }

    public void initialize() {
        Set<AirlineDTO> airlines = this.userController.getAllAirlinesDTO();
        DefaultComboBoxModel<String> airlinesModel = new DefaultComboBoxModel<>();
        airlinesModel.addAll(airlines.stream().map(AirlineDTO::getName).collect(Collectors.toSet()));
        this.cmbAirline.setModel(airlinesModel);

        Set<String> countryNames = this.flightController.getCountryNames();
        DefaultComboBoxModel<String> originCountriesModel = new DefaultComboBoxModel<>();
        DefaultComboBoxModel<String> destinationCountriesModel = new DefaultComboBoxModel<>();
        originCountriesModel.addAll(countryNames);
        destinationCountriesModel.addAll(countryNames);
        this.cmbOriginCountry.setModel(originCountriesModel);
        this.cmbDestinationCountry.setModel(destinationCountriesModel);

        Set<String> categories = this.flightController.getAllCategories();
        String[] categoriesArray = categories.toArray(new String[0]);
        Arrays.sort(categoriesArray);
        this.originalCategories = categoriesArray;
        this.lstAvailableCategories.setListData(categoriesArray);
    }

    public void clearDisplay() {
        cmbAirline.setSelectedIndex(0);
        txtName.setText("");
        txtShortDescription.setText("");
        txaDescription.setText("");
        cmbOriginCountry.setSelectedIndex(0);
        cmbDestinationCountry.setSelectedIndex(0);
        dateChooser.setDate(null);
        spnTimeHour.setValue(0);
        spnTimeMinute.setValue(0);
        frmTouristCost.setText("");
        frmBusinessCost.setText("");
        frmExtraLuggageCost.setText("");

        lstAvailableCategories.clearSelection();
        lstAvailableCategories.setListData(this.originalCategories);
        lstSelectedCategories.clearSelection();
        lstSelectedCategories.setListData(new String[0]);
    }

    public void updateOriginCities(String originCountry) {
        Set<CityDTO> originCities = this.flightController.getCitiesFromCountry(originCountry);
        DefaultComboBoxModel<String> originCitiesModel = new DefaultComboBoxModel<>();
        originCitiesModel.addAll(originCities.stream()
                .map(CityDTO::getName)
                .collect(Collectors.toSet()));
    }

    public void updateDestinationCities(String destinationCountry) {
        Set<CityDTO> destinationCities = this.flightController.getCitiesFromCountry(destinationCountry);
        DefaultComboBoxModel<String> destinationCitiesModel = new DefaultComboBoxModel<>();
        destinationCitiesModel.addAll(destinationCities.stream()
                .map(CityDTO::getName)
                .collect(Collectors.toSet()));
    }

}

