package distributedsystems.swimmingpool.api.controllers;

import distributedsystems.swimmingpool.api.payloads.SwimmingStuffPayload;
import distributedsystems.swimmingpool.SwimmingpoolApplication;
import distributedsystems.swimmingpool.services.stuff_rent_service.ISwimmingStuffService;
import distributedsystems.swimmingpool.services.stuff_rent_service.models.SwimmingStuff;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/swimmingstuff")
@RequiredArgsConstructor
public final class SwimmingStuffController {
    static final Logger log = LoggerFactory.getLogger(SwimmingpoolApplication.class);

    @Autowired
    private ISwimmingStuffService swimmingStuffService;

    @GetMapping
    public ResponseEntity<List<SwimmingStuff>> index() {
        return ResponseEntity.ok(swimmingStuffService.findAll());
    }

    @PostMapping
    public ResponseEntity<SwimmingStuff> create(@RequestBody SwimmingStuffPayload payload) {
        SwimmingStuff newSwimmingStuff = new SwimmingStuff(payload.getType(),
                payload.getPrice());
        return ResponseEntity.ok(swimmingStuffService.save(newSwimmingStuff));
    }

    @GetMapping("{swimmingstuffId}")
    public ResponseEntity<SwimmingStuff> show(@PathVariable String swimmingstuffId) throws NotFoundException {
        return ResponseEntity.ok(swimmingStuffService.getById(swimmingstuffId));
    }

    @DeleteMapping("{swimmingstuffId}")
    public ResponseEntity<Void> delete(@PathVariable String swimmingstuffId) throws NotFoundException {
        swimmingStuffService.deleteById(swimmingstuffId);
        return ResponseEntity.noContent().build();
    }
}