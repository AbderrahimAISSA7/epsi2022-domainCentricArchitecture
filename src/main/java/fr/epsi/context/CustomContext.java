package fr.epsi.context;

import fr.epsi.actor.repository.ActorRepository;
import fr.epsi.actor.repository.database.DatabaseActorRepository;
import fr.epsi.actor.repository.webservice.WebserviceRepository;
import fr.epsi.actor.service.ActorService;
import fr.epsi.actor.service.MyActorService;

public class CustomContext {
    
    // instance unique du contexte (pattern Simgleton)
    // les attributs static d'une classe sont initialisés 
    // lors du chargement de la classe par la JVM
    private static CustomContext instance = new CustomContext();

    private ActorService actorService;

    // Lors de l'instanciation du Context, on initialise les
    // objets qu'il contient
    private CustomContext(){
        // Création du Repository de type Webservice
        ActorRepository repository = new WebserviceRepository();
        // Création du Service en lui injectant le repository via son constructeur
        actorService = new MyActorService(repository);
    };

    public static CustomContext getInstance() {
        return instance;
    }

    public ActorService getActorService() {
        return actorService;
    }

}
