package com.naas.decline;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("api/v1/no")
public class DeclineController {

    private final DeclineService service;

    public DeclineController(DeclineService service) {
        this.service = service;
    }

    @GetMapping("/health")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> checkHealth() {
        return new ResponseEntity<>("I'm fine", HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public DeclinePathDTO getRandomDeclinePath() {
        Random random = new Random();
        Integer randDeclineId = random.nextInt(1, 36);

        return service.fetchDeclinePathById(randDeclineId);
    }

    @GetMapping("/{tone}")
    public ResponseEntity<?> getDeclinePathByCode(
            @PathVariable String tone
    ) {
        var Tones = service.fetchDeclinePathByTone(tone);
        if(Tones == null) {
            return new ResponseEntity<>(
                    new RuntimeException("No Decline Path found for this tone"),
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(service.fetchDeclinePathByTone(tone), HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<DeclinePathDTO> getAllDeclinePath() {
        return service.fetchDeclinePaths();
    }
}
