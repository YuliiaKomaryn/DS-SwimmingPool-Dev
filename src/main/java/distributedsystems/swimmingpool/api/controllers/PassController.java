package distributedsystems.swimmingpool.api.controllers;

import distributedsystems.swimmingpool.api.payloads.PassPayload;
import distributedsystems.swimmingpool.SwimmingpoolApplication;
import distributedsystems.swimmingpool.services.purchase_services.IPurchaseService;
import distributedsystems.swimmingpool.services.purchase_services.models.Pass;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pass")
@RequiredArgsConstructor
public final class PassController {
    static final Logger log = LoggerFactory.getLogger(SwimmingpoolApplication.class);

    @Autowired
    private IPurchaseService purchaseService;

    @GetMapping
    public ResponseEntity<List<Pass>> index() {
        return ResponseEntity.ok(purchaseService.findAll());
    }

    @PostMapping
    public ResponseEntity<Pass> create(@RequestBody PassPayload payload) {
        Pass newPass = new Pass(payload.getType(),
                payload.getPrice(),
                payload.getExpireDate());
        return ResponseEntity.ok(purchaseService.save(newPass));
    }

    @GetMapping("{passId}")
    public ResponseEntity<Pass> show(@PathVariable String passId) throws NotFoundException {
        return ResponseEntity.ok(purchaseService.getById(passId));
    }

    @DeleteMapping("{passId}")
    public ResponseEntity<Void> delete(@PathVariable String passId) throws NotFoundException {
        purchaseService.deleteById(passId);
        return ResponseEntity.noContent().build();
    }
}