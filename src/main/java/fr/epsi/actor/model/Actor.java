package fr.epsi.actor.model;

/**
 * Cet objet représente une Entity du Domain, il est primordial
 * qu'il ne dépende d'aucun détail d'implémentation tel que des
 * annotations de mapping JSON ou base de données (ORM).
 * En d'autres termes, sa structure ne doit pas être dictée par la manière dont
 * ses données seront stockées ou manipulées par les autres couches, que ce soit
 * Controller ou Repository
 * 
 * Il s'agit de repésenter la donnée métier sous sa forme la plus "pure".
 */
public class Actor {

    private String nom;
    private String prenom;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String nomAffichable() {
        return prenom + " " + nom + " [" + id + "]";
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Actor(String nom, String prenom, Integer id) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public String toString() {

        return nomAffichable();
    }
}
