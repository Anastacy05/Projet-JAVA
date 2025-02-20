package Bibliotheque;
import java.util.*;

public class Utilisateur {

    //Constructeur
    public Utilisateur(String nom, String prenom, int numero_tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_adhesion = new Date();
        this.numero_tel = numero_tel;
        this.emprunt = false;
        this.date_retour = new Date();
        this.emprunts = new ArrayList<Livre>();
    }

    //Attributs
    private String nom;
    private String prenom;
    private Date date_adhesion;
    private int numero_tel;
    private boolean emprunt; //indique si il y a oui ou non un emprunt en cours
    private Date date_retour; //date a laquelle il est cense rqpporte le livre pour faire 20 jours exact
    private List<Livre> emprunts; //liste servant d'historique des emprunts

    //Interface avec les getter
    public String getNom () {
        return nom;
    }
    public String getPrenom () {
        return prenom;
    }
    public Date getDate_adhesion () {
        return date_adhesion;
    }
    public int getNumero_tel () {
        return numero_tel;
    }
    public boolean getEmprunt () { return emprunt; }
    public Date getDate_retour () { return date_retour; }
    public List<Livre> getEmprunts () {return emprunts; }

    //Interface avec les setter
    public void setNom (String nom) { this.nom = nom; }
    public void setPrenom (String prenom) {
        this.prenom = prenom;
    }
    public void setDate_adhesion (Date date_adhesion) { this.date_adhesion = date_adhesion; }
    public void setNumero_tel (int numero_tel) { this.numero_tel = numero_tel; }
    public void setEmprunt (boolean emprunt) { this.emprunt = emprunt; }
    public void setDate_retour (Date date_retour) { this.date_retour = date_retour; }
    public void setEmprunts (List<Livre> emprunts) { this.emprunts = emprunts; }


    //Methodes

    public void Inscrire (List<Utilisateur> liste) {
        if ((!this.getEmprunt()) && (this.getEmprunts().isEmpty())) {
            boolean IsIn = false;
            for (int i=0; i<liste.size(); i=i+1) {
                Utilisateur element = liste.get(i);
                if ((element.getNom().equals(this.getNom())) && (element.getPrenom().equals(this.getPrenom())) && (element.getNumero_tel() == this.getNumero_tel())) {
                    IsIn = true;
                    break;
                }
            }
            if (IsIn) {
                System.out.println(this.getNom() + " " + this.getPrenom() + " est deja inscrit(e) !");
            } else {
                Date today = new Date();
                this.setDate_adhesion(today);
                liste.add(this);
                System.out.println(this.getNom() + " " + this.getPrenom() + " vient d'etre inscrit(e) avec succes");
            }
        }
        else {
            System.out.println("L'utilisateur" + this.getNom() + " " + this.getPrenom() + "n'est pas inscrit ne peut donc pas avoir un emprunt en cours !");
        }
        System.out.println("\n");
    }

    public void Retirer (List<Utilisateur> liste) {
        boolean IsIn = false;
        int k = 0;
        for (int i=0; i<liste.size(); i=i+1) {
            Utilisateur element = liste.get(i);
            if ((element.getNom().equals(this.getNom())) && (element.getPrenom().equals(this.getPrenom())) && (element.getNumero_tel() == this.getNumero_tel())) {
                IsIn = true;
                k = i;
                break;
            }
        }
        if (IsIn) {
            if (!this.emprunt) {
                liste.remove(liste.get(k));
                System.out.println(this.getNom() + " " + this.getPrenom() + " vient d'etre retire(e) avec succes");
            }
            else {
                System.out.println(this.getNom() + " " + this.getPrenom() + " a un emprunt en cours, il/elle doit rendre le livre en sa possession avant de se retirer !");
            }
        } else {
            System.out.println(this.getNom() + " " + this.getPrenom() + " n'est meme pas inscrit(e) !");
        }
        System.out.println("\n");
    }

    public void Afficher_Historique () {
        System.out.println("Liste des livres empruntes par " + this.getNom() + " " + this.getPrenom() + ":");
        for (Livre livre : this.getEmprunts()) {
            System.out.println("*" + livre.getTitre() + " de " + livre.getAuteur());
        }
        if (this.getEmprunts().isEmpty()) {
            System.out.println("* aucun emprunt consigne ici");
        }
        System.out.println("\n");
    }

}
