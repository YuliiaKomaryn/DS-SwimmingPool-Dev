package distributedsystems.swimmingpool.api.controllers;


import distributedsystems.swimmingpool.api.payloads.ClientPayload;
import distributedsystems.swimmingpool.services.client_servise.models.Client;
import distributedsystems.swimmingpool.services.client_servise.IClientService;
import distributedsystems.swimmingpool.SwimmingpoolApplication;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
@RequiredArgsConstructor
public final class ClientController {
    static final Logger log = LoggerFactory.getLogger(SwimmingpoolApplication.class);

    @Autowired
    private IClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> index() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody ClientPayload payload) {
        Client newClient = new Client(payload.getName(),
                payload.getSurname(),
                payload.getTemperature());
        return ResponseEntity.ok(clientService.save(newClient));
    }

    @GetMapping("{clientId}")
    public ResponseEntity<Client> show(@PathVariable String clientId) throws NotFoundException {
        return ResponseEntity.ok(clientService.getById(clientId));
    }

    @DeleteMapping("{clientId}")
    public ResponseEntity<Void> delete(@PathVariable String clientId) throws NotFoundException {
        clientService.deleteById(clientId);
        return ResponseEntity.noContent().build();
    }
}