# APPLICATION DE GESTION D'UNE BIBLIOTHEQUE

## De quoi s'agit-il ?

En réalité, il m'a été demandé dans le cadre d'une formation avec un club d'informatique de concevoir en utilisant les notions basiques du Java une application destinée à un gérant de bibliothèque et devant lui permettre d'avoir le contrôle sur ses livres ainsi que sur les utilisateurs abonnés à sa structure et pouvant emprunter des livres.
Bien sûr, tout cela avec de nombreuses contraintes comme le fait qu'il est interdit à un utilisateur d'avoir deux livres empruntés à la fois ou encore que le délai maximal de remise d'un livre emprunte est de vingt jours.

## Pourquoi le projet est-il utile ?

Personnellement, je n'ai aucun lien avec une quelconque bibliothèque donc il est bien probable que cette application ne me serve à rien, mais j'ai pour habitude de bien faire ce que j'entreprends, c'est pourquoi ce projet est surtout là pour m'aider à m'exercer en Java.
Et puis on ne sait jamais peut-être que cette petite application pourra être utile à un véritable gérant de librairie ou de bibliothèque. 
En soi son principal atout réside dans son accessibilité, l'entrée des données ainsi que leur manipulation notamment pour ce qui est des tâches usuelles comme inscrire un nouvel utilisateur, ou bien sûr gérer l'emprunt et la remise de livres en respectant les contraintes spécifiées par la consigne de mon TP.

## Comment le projet a-t-il été conçu ?

Il nous a été demandé de respecter une certaine structure de projet notamment deux packages _Bibliothèque_ et _Test_, le premier étant censé contenir toutes les classes jugées nécessaires à la gestion effective de notre bibliothèque et le second devant contenir des classes qualifiées de classes de test chacune associées à une classe du package Bibliothèque dont elle teste les différentes méthodes définies.
Sans oublier la classe principale ou encore classe Main située hors des deux packages cités.

J'ai choisi d'utiliser de définir deux classes dans le package _Bibliothèque_ soit **Livre** et **Utilisateur**. La classe **Livre** comme son nom l'indique est là pour représenter les différents ouvrages pas juste en tant qu'un ensemble de feuilles de papier reliées entre elles, mais en tant que livre disponible en plusieurs exemplaires.
La classe **utilisateur**, quant à elle, est là pour représenter les clients, ces gens-là qui viennent emprunter des livres et paient de l'argent pour cela.
Logiquement, j'ai défini deux classes dans mon package _Test_ dont **TestLivre** et bien sûr **TestUtilisateur**.

### La classe _Livre_

J'ai accordé un total de huit attributs à la classe _Livre_, chacun avec une portée private pour respecter le principe d'encapsulation. Voici les fameux attributs :
* titre
* auteur
* genre
* editeur
* nbExemplaires ie le total que possède la bibliothèque
* nbDisponibles ie ce total moins le nombre rendu indisponible, car en cours d'emprunt
* nbpages
* prix_emprunt

Etant donné la finitude évidente d'un stock de livres dans une librairie, j'ai estimé nécessaire d'ajouter cet attribut nbDisponible afin de signaler en cas de tentative d'emprunt d'un livre dont tous les exemplaires auraient déjà été empruntés.
Il a été mentionné dans les consignes que le prix pour emprunter dépendait du livre choisi d'où la présence de l'attribut prix_emprunt.
En ce qui concerne le titre, nom de l'auteur, genre, éditeur et nombre de pages ce sont tous simplement des caractéristiques de tout livre raison pour laquelle je les ai inclus ici.
J'ai défini trois fonctions pour cette classe.

1. La méthode Ajouter
Elle sert essentiellement à rajouter des exemplaires de livres au stock du magasin, sachant que le stock en question est ici représenté par une liste d'objets de classe Livre.
Les ajouts sont faits en tenant compte des éléments déjà présents dans le stock afin d'éviter les redondances.

2. La méthode Emprunter
Elle prend en paramètre l'utilisateur concerné et teste les possibilités d'échecs les unes après les autres avant de valider l'emprunt à savoir si le livre est disponible, si l'utilisateur en question est inscrit et bien sûr s'il n'a pas déjà un autre emprunt en cours.
Si tout est bon, l'utilisateur peut repartir avec le livre.

3. La méthode Rendre
Pour rendre un livre, il faut logiquement en avoir emprunté un que l'on n'a pas encore remis et être inscrit bien entendu.
Si tout est bon, l'opération est validée.

### La classe _Utilisateur_

Elle représente ceux-là qui font vivre la boîte en payant pour emprunter des livres. Les attributs d'un utilisateur sont :
* nom
* prenom
* date_adhesion
* numero_tel
* date_retour est prise en ajoutant 20 jours à la date du jour lorsque l'utilisateur emprunte un livre
* emprunt ie un booléen qui prend la valeur _true_ s'il a un emprunt en cours et _false_ sinon
* emprunts ie une liste de livre initialement vide et qui accueille progressivement les livres empruntés par cet utilisateur

Pour les méthodes, c'est simple : Inscrire et Retirer. Bien sûr, on ne se s'inscrit pas deux fois donc il faut être hors de la liste pour y être inscrit.
Pour être retiré, il faut être inscrit et surtout ne pas avoir d'emprunt en cours, pas question de laisser un utilisateur s'enfuir avec un livre.

### Les classes _TestLivre_ et _TestUtilisateur_

Leurs méthodes appellent celles de _Livre_ et _Utilisateur_ sur des objets qu'elles prennent en paramètres. 

### La classe principale _Main_

Elle instancie tout le monde et lance les méthodes des classes de Test pour obtenir les résultats escomptés dans la console.