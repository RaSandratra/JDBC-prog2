// TestConnexion.java - Votre premier programme
public class testconnexion {
    public static void main(String[] args) {
        System.out.println("=== Test de connexion à PostgreSQL ===");
        
     
        String url = "jdbc:postgresql://localhost:5432/jdbc";
        String user = "postgres";
        String password = "12345678"; 
        
   
        try {
            System.out.println("1. Chargement du driver...");
            
            // Cette ligne charge le driver PostgreSQL
            Class.forName("org.postgresql.Driver");
            System.out.println("✅ Driver chargé avec succès !");
            
            System.out.println("2. Tentative de connexion...");
            
      
            java.sql.Connection connexion = java.sql.DriverManager.getConnection(url, user, password);
            
            if (connexion != null) {
                System.out.println("✅ Connexion réussie !");
                System.out.println("Vous êtes connecté à PostgreSQL");
                
                // Fermer la connexion (IMPORTANT !)
                connexion.close();
                System.out.println("Connexion fermée proprement.");
            }
            
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Erreur : Driver PostgreSQL non trouvé !");
            System.err.println("Vérifiez que le fichier .jar est dans lib/");
            e.printStackTrace();
        } catch (java.sql.SQLException e) {
            System.err.println("❌ Erreur de connexion à la base de données :");
            System.err.println("Message : " + e.getMessage());
            System.err.println("Vérifiez :");
            System.err.println("1. PostgreSQL est-il démarré ?");
            System.err.println("2. Le mot de passe est-il correct ?");
            System.err.println("3. La base 'entreprise_db' existe-t-elle ?");
        }
    }
}
