package fr.epsi.actor.service;

import java.util.List;
import java.util.Optional;

import fr.epsi.actor.model.Actor;
import fr.epsi.actor.repository.ActorRepository;

public class MyActorService implements ActorService {

    // Le Repository n'est plus créé par le Service
    // ce dernier s'attend à ce que cette dépendance 
    // lui soit renseignée lors de l'appel à son constructeur
    private ActorRepository repo;

    // Le constructeur permet d'injecter la dépendance vers le Repository
    // À noter qu'il s'agit du seul constucteur, rendant cette dépendance obligatoire
    // contrairement la méthode d'injection par setter
    public MyActorService(ActorRepository providedRepository) {
        this.repo = providedRepository;
    }

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
