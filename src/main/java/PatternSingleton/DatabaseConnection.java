package PatternSingleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/cfvan"; // URL pour MySQL
    private static final String USER = "root"; // Nom d'utilisateur par défaut dans Laragon
    private static final String PASSWORD = ""; // Mot de passe par défaut (vide)

    private static Connection connection = null;
    private static DatabaseConnection instance = null; // Instance unique de models.DatabaseConnection

    // Constructeur privé pour empêcher l'instanciation extérieure
    private DatabaseConnection() {}

    // Méthode pour obtenir l'instance unique de models.DatabaseConnection
    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    // Méthode pour obtenir la connexion
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // Load the MySQL driver
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.err.println("MySQL Driver not found! Ensure the JAR is added to the classpath.");
                e.printStackTrace();
                throw new SQLException("Unable to load MySQL Driver", e);
            }

            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }

}
