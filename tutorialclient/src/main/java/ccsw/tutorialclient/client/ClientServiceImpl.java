package ccsw.tutorialclient.client;


import ccsw.tutorialclient.client.model.Client;
import ccsw.tutorialclient.client.model.ClientDto;
import ccsw.tutorialclient.client.model.ClientSearchDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client get(Long id) {
        return this.clientRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Client> findPage(ClientSearchDto dto) {

        return this.clientRepository.findAll(dto.getPageable().getPageable());
    }

    @Override
    public List<Client> findAll() {

        return (List<Client>) this.clientRepository.findAll();
    }

    @Override
    public void save(Long id, ClientDto data) {

        Client client;

        if (id == null) {
            client = new Client();
        } else {
            client = this.get(id);
        }

        BeanUtils.copyProperties(data, client, "id");

        this.clientRepository.save(client);
    }

    @Override
    public void delete(Long id) throws Exception {

        if (this.get(id) == null) {
            throw new Exception("Client with id " + id + " does not exist");
        }

        this.clientRepository.delete(this.get(id));

    }

}
