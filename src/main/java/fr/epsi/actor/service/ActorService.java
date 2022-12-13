package fr.epsi.actor.service;

import java.util.List;
import java.util.Optional;

import fr.epsi.actor.model.Actor;

public interface ActorService {
    
    public List<Actor> listerTousLesActeurs();

    public Optional<Actor> getById(Integer id);
}
