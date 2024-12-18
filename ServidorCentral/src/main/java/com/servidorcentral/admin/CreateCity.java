package com.servidorcentral.admin;

import com.servidorcentral.controllers.FlightController;
import com.servidorcentral.enums.Country;
import com.servidorcentral.exceptions.CityAlreadyExistsException;
import com.servidorcentral.models.City;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateCity extends JInternalFrame {

    FlightController flightController;

    /*
      Internal frame components
     */
    private final JTextField txtCityName;
    private final JComboBox<String> cmbCountry;
    private final JTextField txtAirportName;
    private final JTextField txtWebUrl;
    private final JTextArea txaDescription;

    public CreateCity(FlightController flightController) {
        this.flightController = flightController;

        // Internal frame properties
        setTitle("Crear ciudad");
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setBounds(0, 0, 600, 330);

        // Internal frame components
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{25, 180, 80, 0, 120, 25, 0};
        gridBagLayout.rowHeights = new int[]{30, 0, 0, 0, 0, 80, 0, 0, 30, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel lblCityName = new JLabel("Nombre de la ciudad:");
        GridBagConstraints gbc_lblCityName = new GridBagConstraints();
        gbc_lblCityName.anchor = GridBagConstraints.EAST;
        gbc_lblCityName.insets = new Insets(0, 0, 5, 5);
        gbc_lblCityName.gridx = 1;
        gbc_lblCityName.gridy = 1;
        getContentPane().add(lblCityName, gbc_lblCityName);

        txtCityName = new JTextField();
        GridBagConstraints gbc_txtCityName = new GridBagConstraints();
        gbc_txtCityName.gridwidth = 3;
        gbc_txtCityName.insets = new Insets(0, 0, 5, 5);
        gbc_txtCityName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCityName.gridx = 2;
        gbc_txtCityName.gridy = 1;
        getContentPane().add(txtCityName, gbc_txtCityName);
        txtCityName.setColumns(10);

        JLabel lblCountry = new JLabel("País:");
        GridBagConstraints gbc_lblCountry = new GridBagConstraints();
        gbc_lblCountry.anchor = GridBagConstraints.EAST;
        gbc_lblCountry.insets = new Insets(0, 0, 5, 5);
        gbc_lblCountry.gridx = 1;
        gbc_lblCountry.gridy = 2;
        getContentPane().add(lblCountry, gbc_lblCountry);

        cmbCountry = new JComboBox<String>(Country.getValues());
        GridBagConstraints gbc_cmbCountry = new GridBagConstraints();
        gbc_cmbCountry.gridwidth = 3;
        gbc_cmbCountry.insets = new Insets(0, 0, 5, 5);
        gbc_cmbCountry.fill = GridBagConstraints.BOTH;
        gbc_cmbCountry.gridx = 2;
        gbc_cmbCountry.gridy = 2;
        getContentPane().add(cmbCountry, gbc_cmbCountry);

        JLabel lblAirportName = new JLabel("Nombre del aeropuerto:");
        GridBagConstraints gbc_lblAirportName = new GridBagConstraints();
        gbc_lblAirportName.anchor = GridBagConstraints.EAST;
        gbc_lblAirportName.insets = new Insets(0, 0, 5, 5);
        gbc_lblAirportName.gridx = 1;
        gbc_lblAirportName.gridy = 3;
        getContentPane().add(lblAirportName, gbc_lblAirportName);

        txtAirportName = new JTextField();
        GridBagConstraints gbc_txtAirportName = new GridBagConstraints();
        gbc_txtAirportName.gridwidth = 3;
        gbc_txtAirportName.insets = new Insets(0, 0, 5, 5);
        gbc_txtAirportName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtAirportName.gridx = 2;
        gbc_txtAirportName.gridy = 3;
        getContentPane().add(txtAirportName, gbc_txtAirportName);
        txtAirportName.setColumns(10);

        JLabel lblWebUrl = new JLabel("Sitio web:");
        GridBagConstraints gbc_lblWebUrl = new GridBagConstraints();
        gbc_lblWebUrl.anchor = GridBagConstraints.EAST;
        gbc_lblWebUrl.insets = new Insets(0, 0, 5, 5);
        gbc_lblWebUrl.gridx = 1;
        gbc_lblWebUrl.gridy = 4;
        getContentPane().add(lblWebUrl, gbc_lblWebUrl);

        txtWebUrl = new JTextField();
        GridBagConstraints gbc_txtWebUrl = new GridBagConstraints();
        gbc_txtWebUrl.gridwidth = 3;
        gbc_txtWebUrl.insets = new Insets(0, 0, 5, 5);
        gbc_txtWebUrl.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtWebUrl.gridx = 2;
        gbc_txtWebUrl.gridy = 4;
        getContentPane().add(txtWebUrl, gbc_txtWebUrl);
        txtWebUrl.setColumns(10);

        JLabel lblDescription = new JLabel("Descripción:");
        GridBagConstraints gbc_lblDescription = new GridBagConstraints();
        gbc_lblDescription.anchor = GridBagConstraints.EAST;
        gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
        gbc_lblDescription.gridx = 1;
        gbc_lblDescription.gridy = 5;
        getContentPane().add(lblDescription, gbc_lblDescription);

        JScrollPane scrDescription = new JScrollPane();
        GridBagConstraints gbc_scrDescription = new GridBagConstraints();
        gbc_scrDescription.gridwidth = 3;
        gbc_scrDescription.insets = new Insets(0, 0, 5, 5);
        gbc_scrDescription.fill = GridBagConstraints.BOTH;
        gbc_scrDescription.gridx = 2;
        gbc_scrDescription.gridy = 5;
        getContentPane().add(scrDescription, gbc_scrDescription);

        txaDescription = new JTextArea();
        txaDescription.setLineWrap(true);
        scrDescription.setViewportView(txaDescription);

        JButton btnCancel = new JButton("Cancelar");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearDisplay();
                setVisible(false);
            }
        });
        GridBagConstraints gbc_btnCancel = new GridBagConstraints();
        gbc_btnCancel.anchor = GridBagConstraints.EAST;
        gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
        gbc_btnCancel.gridx = 4;
        gbc_btnCancel.gridy = 7;
        getContentPane().add(btnCancel, gbc_btnCancel);

        JButton btnAccept = new JButton("Aceptar");
        btnAccept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createCity();
            }
        });
        GridBagConstraints gbc_btnAccept = new GridBagConstraints();
        gbc_btnAccept.anchor = GridBagConstraints.EAST;
        gbc_btnAccept.insets = new Insets(0, 0, 5, 5);
        gbc_btnAccept.gridx = 3;
        gbc_btnAccept.gridy = 7;
        getContentPane().add(btnAccept, gbc_btnAccept);
    }

    private void createCity() {
        if (!this.checkFields()) {
            return;
        }

        City city = new City.Builder(this.txtCityName.getText(),
                                     Country.fromString((String) this.cmbCountry.getSelectedItem()))
                .setAirport(this.txtAirportName.getText())
                .setWebUrl(this.txtWebUrl.getText())
                .setDescription(this.txaDescription.getText())
                .build();

        try {
            this.flightController.createCity(city);
            JOptionPane.showMessageDialog(this, "Ciudad creada exitosamente", "Crear ciudad", JOptionPane.INFORMATION_MESSAGE);
            this.clearDisplay();
        } catch (CityAlreadyExistsException e) {
            JOptionPane.showMessageDialog(this, "La ciudad ya existe", "Crear ciudad", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean checkFields() {
        if (this.txtCityName.getText().isEmpty()
            || this.txtAirportName.getText().isEmpty()
            || this.txtWebUrl.getText().isEmpty()
            || this.txaDescription.getText().isEmpty()
        ) {
            JOptionPane.showMessageDialog(this, "Debe rellenar los campos obligatorios", "Crear ciudad", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public void clearDisplay() {
        this.txtCityName.setText("");
        this.cmbCountry.setSelectedIndex(0);
        this.txtAirportName.setText("");
        this.txtWebUrl.setText("");
        this.txaDescription.setText("");
    }

}
