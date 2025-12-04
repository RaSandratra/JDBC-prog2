
import java.sql.*

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/jdbc";
        String user = "postgres";
        String password = "12345678";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connexion réussie à PostgreSQL ! Bienvenue Sandratra");


            Statement statement = connection.createStatement();


            String query = "SELECT id, nom, prenom, salaire FROM employes";
            ResultSet resultSet = statement.executeQuery(query);


            System.out.println("Données de la table :");
            System.out.println("------------------------------------------------");
            System.out.printf("%-5s %-20s %-20s %-10s%n",
                    "ID", "Nom", "Prénom", "Salaire");
            System.out.println("------------------------------------------------");


            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                double salaire = resultSet.getDouble("salaire");

                System.out.printf("%-5d %-20s %-20s %-10.2f%n",
                        id, nom, prenom, salaire);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Erreur de connexion ou d'exécution : " + e.getMessage());
        }
    }
}
