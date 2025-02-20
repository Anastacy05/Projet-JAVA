package Test;
import Bibliotheque.*;
import java.util.*;
import java.text.*;

public class TestLivre {

    public void TestAjouter (Livre book, List<Livre> Book_list) {
        System.out.println("Tentative d'ajout de livres " + book.getTitre() + " de " + book.getAuteur());
        book.Ajouter(Book_list);
    }

    public void TestEmprunter (Livre book, Utilisateur user, List<Livre> Book_list, List<Utilisateur> User_list) {
        System.out.println("Tentative d'emprunt d'un exemplaire du livre " + book.getTitre() + " par " + user.getNom() + " " + user.getPrenom());
        book.Emprunter(user, Book_list, User_list);
    }

    public void TestRendre (Livre book, Utilisateur user, List<Livre> Book_list, List<Utilisateur> User_list) {
        System.out.println("Tentative de remise d'un exemplaire du livre " + book.getTitre() + " par " + user.getNom() + " " + user.getPrenom());
        book.Rendre(user, Book_list, User_list);
    }

    public void run (Livre book1, Livre book2, Livre book3, Utilisateur user1, Utilisateur user2, Utilisateur user3, List<Livre> Book_list, List<Utilisateur> User_list) {
        this.TestAjouter(book1, Book_list);
        this.TestAjouter(book1, Book_list); //le nombre d'exemplaires sera juste double
        this.TestAjouter(book2, Book_list); //un nouvel element de la liste
        this.TestAjouter(book3, Book_list); //un nouvel element de la liste

        this.TestEmprunter(book1, user1, Book_list, User_list); //valide
        this.TestEmprunter(book2, user1, Book_list, User_list); //rejete car on emprunte qu'un livre a la fois
        this.TestRendre(book1, user1, Book_list, User_list); //valide
        this.TestRendre(book1, user1, Book_list, User_list); //rejete car il n'a aucun emprunt en cours
        this.TestEmprunter(book2, user1, Book_list, User_list); //valide
        this.TestEmprunter(book2, user2, Book_list, User_list); //valide ou rejete si rupture de stock
        this.TestEmprunter(book2, user3, Book_list, User_list); //valide ou rejete si rupture de stock

        user1.Afficher_Historique(); //2 livres
        user2.Afficher_Historique(); //1 ou 0 livre
        user3.Afficher_Historique(); //1 ou 0 livre
    }

}
