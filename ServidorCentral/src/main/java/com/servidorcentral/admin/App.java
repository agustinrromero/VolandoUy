package com.servidorcentral.admin;

import com.servidorcentral.controllers.Factory;
import com.servidorcentral.controllers.FlightController;
import com.servidorcentral.controllers.UserController;
import com.servidorcentral.dtos.CityDTO;
import com.servidorcentral.enums.Country;
import com.servidorcentral.models.Airline;
import com.servidorcentral.models.Category;
import com.servidorcentral.models.City;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.EventQueue;

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

    private final CreateFlightRoute createFlightRouteInternalFrame;

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
          Create flight route internal frame
         */
        createFlightRouteInternalFrame = new CreateFlightRoute(userController, flightController);
        createFlightRouteInternalFrame.setLocation(10, 10);
        createFlightRouteInternalFrame.setVisible(false);
        mainFrame.getContentPane().add(createFlightRouteInternalFrame);

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

        try {
            flightController.createCategory(new Category("categoria1"));
            flightController.createCategory(new Category("categoria2"));
            flightController.createCategory(new Category("categoria3"));
            flightController.createCity(new City.Builder("Afgania1", Country.AFGANISTAN)
                    .build()
            );
            flightController.createCity(new City.Builder("Afgania2", Country.AFGANISTAN)
                    .build()
            );
            flightController.createCity(new City.Builder("Afgania3", Country.AFGANISTAN)
                    .build()
            );
            flightController.createCity(new City.Builder("Albania", Country.ALBANIA)
                    .build()
            );
            userController.createAirline(new Airline.AirlineBuilder("username", "correo@correo")
                    .setDescription("descripcion")
                    .setWebUrl("web")
                    .setName("nombre")
                    .setPassword("contrase;a0")
                    .build()
            );

            for (CityDTO city : flightController.getCitiesFromCountry("Afganistán")) {
                System.out.println(city.getName());
            }
        } catch (Exception e) {
            // do nothing
        }

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
          Flight menu
         */
        JMenu flightMenu = new JMenu("Vuelo");
        menuBar.add(flightMenu);

        /*
          Create flight route
         */
        JMenuItem createFlightRouteMenuItem = new JMenuItem("Crear ruta de vuelo");
        createFlightRouteMenuItem.addActionListener(e -> {
            // createFlightRouteInternalFrame.clearDisplay();
            createFlightRouteInternalFrame.initialize();
            createFlightRouteInternalFrame.setVisible(true);
        });
        flightMenu.add(createFlightRouteMenuItem);

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

