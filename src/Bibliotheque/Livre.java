package Bibliotheque;
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Livre {

    //Constructeurs

    public Livre () {
        this.titre = "Sans titre";
        this.auteur = "Auteur inconnu";
        this.genre = "Sans genre";
        this.editeur = "Sans editeur";
        this.nbExemplaire = 1;
        this.nbDisponible = 1;
        this.nbpages = 2;
        this.prix_emprunt = 0;
    }

    public Livre (String titre, String auteur, String genre, String editeur, int nbExemplaire, int nbpages, int prix_emprunt) {
        this.titre = titre;
        this.auteur = auteur;
        this.genre = genre;
        this.editeur = editeur;
        this.nbExemplaire = nbExemplaire;
        this.nbDisponible = nbExemplaire;
        this.nbpages = nbpages;
        this.prix_emprunt = prix_emprunt;
    }

    //Attributs
    private String titre;
    private String auteur;
    private String genre;
    private String editeur;
    private int nbExemplaire;
    private int nbDisponible; //Nbre d'exemplaires dispo en prenant en compte ceux deja emruntes par d'autres
    private int nbpages;
    private int prix_emprunt;


    //Interface avec les getter
    public String getTitre () {
        return titre;
    }
    public String getGenre () {
        return genre;
    }
    public String getAuteur () {
        return auteur;
    }
    public String getEditeur () {
        return editeur;
    }
    public int getNbExemplaire () {
        return nbExemplaire;
    }
    public int getNbDisponible () { return nbDisponible; }
    public int getNbpages () {
        return nbpages;
    }
    public int getPrix_emprunt () { return prix_emprunt; }

    //Interface avec les setter
    public void setTitre ( String titre ) {
        this.titre = titre;
    }
    public void setGenre ( String genre ) {
        this.genre = genre;
    }
    public void setAuteur ( String auteur ) {
        this.auteur = auteur;
    }
    public void setEditeur ( String editeur ) {
        this.editeur = editeur;
    }
    public void setNbExemplaire ( int nbExemplaire ) {
        this.nbExemplaire = nbExemplaire;
    }
    public void setNbDisponible ( int nbDisponible ) {
        if (this.nbExemplaire >= nbDisponible) {
            this.nbDisponible = nbDisponible;
        }
        else {
            this.nbDisponible = this.nbExemplaire;
        }
    }
    public void setNbpages ( int nbpages ) {
        this.nbpages = nbpages;
    }
    public void setPrix_emprunt (int prix_emprunt) { this.prix_emprunt = prix_emprunt; }


    //Methodes

    public void Ajouter (List<Livre> liste_livres) {
        boolean IsIn = false;
        int plus = this.nbExemplaire;
        for (int i = 0; i < liste_livres.size(); i = i+1) {
            Livre Element = liste_livres.get(i);
            if ((Element.getTitre().equals(this.getTitre())) && (Element.getGenre().equals(this.getGenre())) && (Element.getAuteur().equals(this.getAuteur())) && (Element.getEditeur().equals(this.getEditeur())) && (Element.getNbpages() == this.getNbpages())) {
                IsIn = true;
                liste_livres.get(i).setNbExemplaire(Element.getNbExemplaire() + plus);
                liste_livres.get(i).setNbDisponible(Element.getNbDisponible() + plus);
                System.out.println("Les " + Integer.toString(plus) + " nouveaux exemplaires du livre " + this.getTitre() + " ont ete ajoutes avec succes");
                break;
            }
        }
        if (!IsIn) {
            liste_livres.add(this);
            System.out.println("Les " + Integer.toString(plus) + " exemplaires du nouveau livre " + this.getTitre() + " ont ete ajoutes avec succes");
        }
        System.out.println("\n");
    }

    public void Emprunter (Utilisateur utilisateur, List<Livre> liste_livres, List<Utilisateur> liste_u) {
        boolean IsIn = false;
        int i = 0;
        for (int k = 0; k < liste_livres.size(); k = k + 1) {
            Livre Element = liste_livres.get(k);
            if ((Element.getTitre().equals(this.getTitre())) && (Element.getGenre().equals(this.getGenre())) && (Element.getAuteur().equals(this.getAuteur())) && (Element.getEditeur().equals(this.getEditeur()))) {
                i = k;
                IsIn = true;
                break;
            }
        }
        int j = liste_u.indexOf(utilisateur);
        if (j==-1) {
            System.out.println(utilisateur.getNom() + " " + utilisateur.getPrenom() + " n'est pas inscris et ne peut donc pas emprunter de livres !");
        }
        else {
            if (utilisateur.getEmprunt()) {
                System.out.println(utilisateur.getNom() + " " + utilisateur.getPrenom() + " a deja un emprunt en cours, il/elle doit rendre le livre pour en emprunter un autre");
            } else {
                if (!IsIn) {
                    System.out.println("Desole, mais nous ne possedons pas le livre " + this.getTitre() + "ici");
                } else if (liste_livres.get(i).getNbDisponible() == 0) {
                    System.out.println("Desole, mais nous n'avons plus d'exemplaires disponibles du livre " + this.getTitre());
                } else {
                    liste_livres.get(i).setNbDisponible(liste_livres.get(i).getNbDisponible() - 1);
                    int prix = liste_livres.get(i).getPrix_emprunt();
                    System.out.println(utilisateur.getNom() + " " + utilisateur.getPrenom() + " doit payer " + prix + " FCFA et le livre " + this.getTitre() + " sera a lui/elle pour 20 jours.");
                    utilisateur.setEmprunt(true);
                    List<Livre> liste_emprunts = utilisateur.getEmprunts();
                    liste_emprunts.add(this);
                    utilisateur.setEmprunts(liste_emprunts);
                    Date today = new Date();
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(today);
                    cal.add(Calendar.DATE, 20);
                    Date next = cal.getTime();
                    utilisateur.setDate_retour(next);
                    liste_u.set(j, utilisateur);
                }
            }
        }
        System.out.println("\n");
    }

    public void Rendre (Utilisateur utilisateur, List<Livre> liste_livres, List<Utilisateur> liste_u ) {
        boolean IsIn = false;
        int i = 0;
        for (int k = 0; k < liste_livres.size(); k = k + 1) {
            Livre Element = liste_livres.get(k);
            if ((Element.getTitre().equals(this.getTitre())) && (Element.getGenre().equals(this.getGenre())) && (Element.getAuteur().equals(this.getAuteur())) && (Element.getEditeur().equals(this.getEditeur()))) {
                i = k;
                IsIn = true;
                break;
            }
        }
        int j = liste_u.indexOf(utilisateur);
        if (j==-1) {
            System.out.println(utilisateur.getNom() + " " + utilisateur.getPrenom() + " n'est pas inscris et n'a donc pas pu emprunte de livres !");
        }
        else {
            if (!utilisateur.getEmprunt()) {
                System.out.println(utilisateur.getNom() + " " + utilisateur.getPrenom() + " n'a aucun emprunt en cours !");
            }
            else {
                if (!IsIn) {
                    System.out.println("Nous n'avons pas ce livre ici, " + utilisateur.getNom() + " " + utilisateur.getPrenom() + " a du l'emprunter dans une autre bibliotheque !");
                }
                else {
                    liste_livres.get(i).setNbDisponible(liste_livres.get(i).getNbDisponible() + 1);
                    utilisateur.setEmprunt(false);
                    System.out.println("La remise du livre " + this.getTitre() + " par " + utilisateur.getNom() + " " + utilisateur.getPrenom() + " a bien ete validee");

                    Date today = new Date();
                    int day = today.getDay();
                    int month = today.getMonth();
                    int year = today.getYear();
                    LocalDate local_today = LocalDate.of(year, month, day);

                    Date retour = utilisateur.getDate_retour();
                    day = retour.getDay();
                    month = retour.getMonth();
                    year = retour.getYear();
                    LocalDate local_retour = LocalDate.of(year, month, day);

                    long nbjours = ChronoUnit.DAYS.between(local_today, local_retour);
                    if (nbjours < 0) {
                        System.out.println("Le delai de 20 jours d'emprunt a ete depasse, " + utilisateur.getNom() + " " + utilisateur.getPrenom() + " recevra donc une amende !");
                    }
                    else {
                        System.out.println(utilisateur.getNom() + " " + utilisateur.getPrenom() + " a rapporte le livre dans les temps, cette ponctualite est appreciee");
                    }
                }
            }
        }
        System.out.println("\n");
    }

}

