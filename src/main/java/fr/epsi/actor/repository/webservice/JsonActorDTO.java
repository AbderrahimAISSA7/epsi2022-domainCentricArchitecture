package fr.epsi.actor.repository.webservice;

import fr.epsi.actor.model.Actor;

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

    public Actor toActor() {
        return new Actor(lastname, firstname, id);
    }
    
}
