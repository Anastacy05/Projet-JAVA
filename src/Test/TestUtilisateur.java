package Test;
import Bibliotheque.*;
import java.util.*;
import java.text.*;

public class TestUtilisateur {

    public void TestInscrire (Utilisateur user, List<Utilisateur> User_list) {
        System.out.println("Tentative d'inscription de " + user.getNom() + " " + user.getPrenom());
        user.Inscrire(User_list);
    }

    public void TestRetirer (Utilisateur user, List<Utilisateur> User_list) {
        System.out.println("Tentative de retrait de " + user.getNom() + " " + user.getPrenom());
        user.Retirer(User_list);
    }

    public void TestAfficher_Historique (Utilisateur user) {
        System.out.println("Tentative d'affichage de l'historique des emprunts de " + user.getNom() + " " + user.getPrenom());
        user.Afficher_Historique();
    }

    public void run (Utilisateur user1, Utilisateur user2, Utilisateur user3, List<Utilisateur> User_list) {
        this.TestInscrire(user1, User_list); //valide
        this.TestInscrire(user1, User_list); //rejete car deja inscrit
        this.TestRetirer(user1, User_list); //valide
        this.TestRetirer(user1, User_list); //rejete car non inscris
        this.TestInscrire(user1, User_list); //valide
        this.TestInscrire(user2, User_list); //valide
        this.TestInscrire(user3, User_list); //valide
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        String date = "";
        System.out.println("Liste des utilisateurs inscrits :");
        for (Utilisateur user : User_list) {
            date = formater.format(user.getDate_adhesion());
            System.out.println("* " + user.getNom() + " " + user.getPrenom() + " incrit(e) le " + date);
        }
        System.out.println("\n");
    }

}
