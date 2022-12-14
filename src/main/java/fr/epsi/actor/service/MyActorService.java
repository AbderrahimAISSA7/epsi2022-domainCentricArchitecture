package fr.epsi.actor.service;

import java.util.List;
import java.util.Optional;

import fr.epsi.actor.model.Actor;
import fr.epsi.actor.repository.ActorRepository;
import fr.epsi.actor.repository.database.DatabaseActorRepository;
import fr.epsi.actor.repository.webservice.WebserviceRepository;

public class MyActorService implements ActorService {

    // Il suffit de changer ici l'implémentation de Repository pour 
    // basculer de l'un à l'autre.
    // Il reste donc une adhérence minime entre le Domain et le Repository !
    private ActorRepository repo = new WebserviceRepository();
    // private ActorRepository repo = new DatabaseActorRepository();

    @Override
    public Optional<Actor> getById(Integer id) {
        
        for (Actor actor : repo.listActor()) {
            if (actor.getId()==id) return Optional.of(actor);
        }
        return Optional.empty();
    }

    @Override
    public List<Actor> listerTousLesActeurs() {
        
        return repo.listActor();
    }
    
    
}
