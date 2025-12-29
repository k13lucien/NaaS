package com.naas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class DeclineController {

    private final DeclineService service;
    private Integer randDeclineId;

    public DeclineController(DeclineService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public String checkHealth() {
        return "I'm fine";
    }

    @GetMapping("api/v1/no")
    public DeclinePath getRandomDeclinePath() {
        Random random = new Random();
        randDeclineId = random.nextInt(1, 36);

        return this.service.fetchDeclinePathById(randDeclineId);
    }

    @GetMapping("api/v1/no/{tone}")
    public List<DeclinePath> getDeclinePathByCode(
            @PathVariable String tone
    ) {
        return this.service.fetchDeclinePathByTone(tone);
    }

    @GetMapping("api/v1/no/all")
    public List<DeclinePath> getAllDeclinePath() {
        return this.service.fetchDeclinePaths();
    }
}
