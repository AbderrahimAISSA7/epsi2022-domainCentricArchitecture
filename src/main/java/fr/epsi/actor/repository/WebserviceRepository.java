package fr.epsi.actor.repository;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.epsi.actor.model.Actor;
import fr.epsi.actor.repository.webservice.JsonActorDTO;

public class WebserviceRepository implements ActorRepository {

    private static final String url = "https://63481ec00484786c6e926453.mockapi.io/api/v1/actors/";

    @Override
    public List<Actor> listActor() {

        List<Actor> actorList = new ArrayList<>();

        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest req = HttpRequest.newBuilder(URI.create(url)).GET().build();
        try {
            // Récupération du contenu JSON via HTTP
            String body = client.send(req, BodyHandlers.ofString()).body();
            // Mapping JSON vers Objet Métier
            ObjectMapper mapper = new ObjectMapper();
            // Récuperation sous forme de liste d'objet Java
            // (spécifique à l'implémentation JSON)
            List<JsonActorDTO> actorDTOList = mapper.readerForListOf(JsonActorDTO.class).readValue(body);
            // Mapping du résultat vers des Objets Métier
            // (non spécifique à l'implémentation JSON)
            actorList = actorDTOList.stream().map(WebserviceRepository::toDomainEntity).toList();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return actorList;
    }

    /*
     * Méthode de conversion d'un Objet représentant un Acteur issu du format JSON
     * vers une Entity du Domain, indépendant de l'implémentation technique
     */
    private static Actor toDomainEntity(JsonActorDTO dto) {
        return new Actor(dto.getLastname(), dto.getFirstname(), dto.getId());
    }

}
