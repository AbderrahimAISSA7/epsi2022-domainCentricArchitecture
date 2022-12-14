package fr.epsi.actor.repository.webservice;

/**
 * Cet objet permet le mapping depuis le JSON
 * Il ne sert que dans cette couche de Repository, il pourrait donc posséder des
 * détails d'implémentation propres à JSON comme des annotations JSONAlias.
 * Ce n'est pas un problème tant qu'on effectue un mapping vers un objet du
 * domaine avant de répondre vers la couche Domaine/Business
 */
public class JsonActorDTO {

    private String firstname;
    private String lastname;
    private int id;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
