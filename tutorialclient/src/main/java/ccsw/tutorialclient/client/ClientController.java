package ccsw.tutorialclient.client;

import ccsw.tutorialclient.client.model.Client;
import ccsw.tutorialclient.client.model.ClientDto;
import ccsw.tutorialclient.client.model.ClientSearchDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Client", description = "Api of Client")
@RequestMapping(value = "/client")
@RestController
public class ClientController {

    private final ClientService clientService;
    private final ModelMapper mapper;

    public ClientController(ClientService clientService, ModelMapper mapper) {
        this.clientService = clientService;
        this.mapper = mapper;
    }

    @Operation(summary = "Find Page", description = "Method that return a page of Clients")
    @PostMapping
    public Page<ClientDto> findPage(@RequestBody ClientSearchDto dto) {

        Page<Client> page = this.clientService.findPage(dto);

        return new PageImpl<>(page.getContent().stream()
                .map(e -> mapper.map(e, ClientDto.class)).collect(Collectors.toList()),
                page.getPageable(), page.getTotalElements());
    }

    @Operation(summary = "Find", description = "Method to return a list of clients")
    @GetMapping
    public List<ClientDto> findAll() {

        List<Client> clients = clientService.findAll();

        return clients.stream().map(e -> mapper.map(e, ClientDto.class)).collect(Collectors.toList());

    }

    @Operation(summary = "Save or update", description = "Method to save or update a client")
    @RequestMapping(path = { "", "/{id} "}, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody ClientDto clientDto) {

        this.clientService.save(id, clientDto);
    }


    @Operation(summary = "Delete", description = "Method to delete a client")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {

        this.clientService.delete(id);
    }

}
