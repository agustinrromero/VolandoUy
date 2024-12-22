package com.servidorcentral.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.servidorcentral.controllers.Factory;
import com.servidorcentral.controllers.FlightController;
import com.servidorcentral.controllers.UserController;

public class App {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                App window = new App();
                window.mainFrame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private JFrame mainFrame;

    private final CreateUser createUserInternalFrame;
    private final ViewUser viewUserInternalFrame;

    private final CreateCity createCityInternalFrame;
    private final CreateCategory createCategoryInternalFrame;

    public App() {
        Factory factory = Factory.getInstance();
        UserController userController = factory.getUserController();
        FlightController flightController = factory.getFlightController();
        this.initialize();

        mainFrame.setLayout(null);

        /*
          Create user internal frame
         */
        createUserInternalFrame = new CreateUser(userController);
        createUserInternalFrame.setLocation(10, 10);
        createUserInternalFrame.setVisible(false);
        createUserInternalFrame.updateDisplay();
        mainFrame.getContentPane().add(createUserInternalFrame);

        /*
          View user internal frame
         */
        viewUserInternalFrame = new ViewUser(userController, this);
        viewUserInternalFrame.setLocation(10, 10);
        viewUserInternalFrame.setVisible(false);
        mainFrame.getContentPane().add(viewUserInternalFrame);

        /*
          Create city internal frame
         */
        createCityInternalFrame = new CreateCity(flightController);
        createCityInternalFrame.setLocation(10, 10);
        createCityInternalFrame.setVisible(false);
        mainFrame.getContentPane().add(createCityInternalFrame);

        /*
          Create category internal frame
         */
        createCategoryInternalFrame = new CreateCategory(flightController);
        createCategoryInternalFrame.setLocation(10, 10);
        createCategoryInternalFrame.setVisible(false);
        mainFrame.getContentPane().add(createCategoryInternalFrame);

    }

    private void initialize() {
        mainFrame = new JFrame();
        mainFrame.setTitle("VolandoUy Admin");
        mainFrame.setBounds(100, 100, 1200, 800);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        mainFrame.setJMenuBar(menuBar);

        /*
          User menu
         */
        JMenu userMenu = new JMenu("Usuario");
        menuBar.add(userMenu);

        /*
          Create user
         */
        JMenuItem createUserMenuItem = new JMenuItem("Crear usuario");
        createUserMenuItem.addActionListener(e -> {
            createUserInternalFrame.clearDisplay();
            createUserInternalFrame.setVisible(true);
        });
        userMenu.add(createUserMenuItem);

        /*
          View user
         */
        JMenuItem viewUserMenuItem = new JMenuItem("Consultar usuario");
        viewUserMenuItem.addActionListener(e -> {
            viewUserInternalFrame.clearDisplay();
            viewUserInternalFrame.initialize();
            viewUserInternalFrame.setVisible(true);
        });
        userMenu.add(viewUserMenuItem);

        /*
          Others menu
         */
        JMenu othersMenu = new JMenu("Otros");
        menuBar.add(othersMenu);

        /*
          Create city
         */
        JMenuItem createCityMenuItem = new JMenuItem("Crear ciudad");
        createCityMenuItem.addActionListener(e -> {
            createCityInternalFrame.clearDisplay();
            createCityInternalFrame.setVisible(true);
        });
        othersMenu.add(createCityMenuItem);

        /*
          Create category
         */
        JMenuItem createCategoryMenuItem = new JMenuItem("Crear categoría");
        createCategoryMenuItem.addActionListener(e -> {
            createCategoryInternalFrame.setVisible(true);
        });
        othersMenu.add(createCategoryMenuItem);
    }

}

