package com.naas;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclineService {

    private final DeclineRepository declineRepository;

    public DeclineService(DeclineRepository declineRepository) {
        this.declineRepository = declineRepository;
    }

    public List<DeclinePath> fetchDeclinePaths() {
        return this.declineRepository.findAll();
    }

    public List<DeclinePath> fetchDeclinePathByTone(String tone) {
        return this.declineRepository.getByToneContaining(tone);
    }

    public DeclinePath fetchDeclinePathById(Integer id) {
        return this.declineRepository.findById(id).orElse(null);
    }
}
