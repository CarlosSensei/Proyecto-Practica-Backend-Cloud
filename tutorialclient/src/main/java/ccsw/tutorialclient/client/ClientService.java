package ccsw.tutorialclient.client;

import ccsw.tutorialclient.client.model.Client;
import ccsw.tutorialclient.client.model.ClientDto;

import java.util.List;

public interface ClientService {

    // Metodo para recuperar un client por su id
    Client get(Long id);

    // Metodo para recuperar todos los clientes
    List<Client> findAll();

    // Metodo para crear o actualizar un cliente
    void save(Long id, ClientDto clientDto);

    // Metodo para borrar un cliente
    void delete(Long id) throws Exception;

}
