package com.servidorcentral.admin;

import com.servidorcentral.controllers.FlightController;
import com.servidorcentral.enums.Country;
import com.servidorcentral.exceptions.CategoryAlreadyExistsException;
import com.servidorcentral.models.Category;

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

public class CreateCategory extends JInternalFrame {

    private final FlightController flightController;

    private final JTextField txtCategoryName;

    public CreateCategory(FlightController flightController) {
        this.flightController = flightController;

        setTitle("Crear categoría");
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setBounds(0, 0, 400, 170);

        // WindowBuilder
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{25, 80, 0, 0, 120, 25, 0};
        gridBagLayout.rowHeights = new int[]{30, 0, 25, 0, 30, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);

        JLabel lblCategoryName = new JLabel("Nombre:");
        GridBagConstraints gbc_lblCategoryName = new GridBagConstraints();
        gbc_lblCategoryName.anchor = GridBagConstraints.EAST;
        gbc_lblCategoryName.insets = new Insets(0, 0, 5, 5);
        gbc_lblCategoryName.gridx = 1;
        gbc_lblCategoryName.gridy = 1;
        getContentPane().add(lblCategoryName, gbc_lblCategoryName);

        txtCategoryName = new JTextField();
        GridBagConstraints gbc_txtCategoryName = new GridBagConstraints();
        gbc_txtCategoryName.gridwidth = 3;
        gbc_txtCategoryName.insets = new Insets(0, 0, 5, 5);
        gbc_txtCategoryName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCategoryName.gridx = 2;
        gbc_txtCategoryName.gridy = 1;
        getContentPane().add(txtCategoryName, gbc_txtCategoryName);
        txtCategoryName.setColumns(10);

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
        gbc_btnCancel.gridy = 3;
        getContentPane().add(btnCancel, gbc_btnCancel);

        JButton btnAccept = new JButton("Aceptar");
        btnAccept.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createCategory();
            }
        });
        GridBagConstraints gbc_btnAccept = new GridBagConstraints();
        gbc_btnAccept.anchor = GridBagConstraints.EAST;
        gbc_btnAccept.insets = new Insets(0, 0, 5, 5);
        gbc_btnAccept.gridx = 3;
        gbc_btnAccept.gridy = 3;
        getContentPane().add(btnAccept, gbc_btnAccept);
    }

    private void createCategory() {
        if (this.txtCategoryName.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Debe rellenar los campos obligatorios", "Crear categoría", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Category category = new Category(this.txtCategoryName.getText());
            this.flightController.createCategory(category);

            JOptionPane.showMessageDialog(this, "Categoría creada exitosamente", "Crear categoría", JOptionPane.INFORMATION_MESSAGE);
            this.clearDisplay();
        } catch (CategoryAlreadyExistsException e) {
            JOptionPane.showMessageDialog(this, "La categoría ya existe", "Crear categoría", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearDisplay() {
        this.txtCategoryName.setText("");
    }

}

