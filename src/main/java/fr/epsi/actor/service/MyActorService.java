package fr.epsi.actor.service;

import java.util.List;
import java.util.Optional;

import fr.epsi.actor.model.Actor;
import fr.epsi.actor.repository.ActorRepository;
import fr.epsi.actor.repository.DatabaseActorRepository;
import fr.epsi.actor.repository.WebserviceRepository;

public class MyActorService implements ActorService {

    // 
    private ActorRepository repo = new WebserviceRepository();

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
