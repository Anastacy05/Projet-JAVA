import java.util.*;
import Bibliotheque.*;
import Test.*;

public class Main {

    public static void main (String args[]) {

        Utilisateur user0 = new Utilisateur ("NKOLO", "Stacy",  693635987);
        Utilisateur user1 = new Utilisateur ("MEVAA", "Dgio",  603635987);
        Utilisateur user2 = new Utilisateur ("ROY", "Lyderis",  623635987);
        Utilisateur user3 = new Utilisateur ("MEVAA", "Nifia", 643635987);
        Utilisateur user4 = new Utilisateur ("HAROUNA", "Reiki", 663635987);
        Utilisateur user5 = new Utilisateur ("SANDOVAL", "Sienna", 683635987);

        Livre book1 = new Livre ("Germinal", "Emile Zola", "Roman", "Charpentier", 20, 592, 2500);
        Livre book2 = new Livre ("Cent ans de solitude", "Gabriel Marquez", "Roman", "Editions du Seuil", 16, 480, 3000);
        Livre book3 = new Livre ("Le Maitre et la Marguerite", "Mikhail Boulgakov", "Roman", "Robert Laffont", 31, 496, 2800);
        Livre book4 = new Livre ("Les Miserables", "Victor Hugo", "Roman", "Pagnerre", 5, 1232, 3500);
        Livre book5 = new Livre ("Ubik", "Philip K.Dick", "Science-fiction", "Denoel", 11, 265, 2200);
        Livre book6 = new Livre ("La Horde du Contrevent", "Alain Damasion", "Science-fiction, Fantaisie", "La Volte", 23, 736, 3000);
        Livre book7 = new Livre ("Le Trone de fer", "George R. R. Martin", "Fantaisie", "Pygmalion", 7, 704, 3200);
        Livre book8 = new Livre ("Les Particules elementaires", "Michel Houellebeq", "Roman", "Flammarion", 45, 352, 2700);
        Livre book9 = new Livre ("L'Archipel du Goulag II", "Alexandre Soljenitsyne", "Recit", "Seuil", 2, 672, 3000);
        Livre book10 = new Livre ("Moscou sur Vodka", "Venedict Erofeiev", "Roman", "Gallimard", 28, 192, 2500);

        TestLivre test_livre = new TestLivre();
        TestUtilisateur test_utilisateur = new TestUtilisateur();

        List<Utilisateur> User_list = new ArrayList<>();
        List<Livre> Book_list = new ArrayList<>();

        test_utilisateur.run(user0, user2, user5, User_list);
        test_livre.run(book4, book9, book1, user0, user2, user5, Book_list, User_list);

    }
}