package com.naas.decline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DeclineService {

    private final DeclineRepository declineRepository;
    private final DeclinePathMapper declinePathMapper;

    @Autowired
    public DeclineService(DeclineRepository declineRepository, DeclinePathMapper declinePathMapper) {
        this.declineRepository = declineRepository;
        this.declinePathMapper = declinePathMapper;
    }

    public List<DeclinePathDTO> fetchDeclinePaths() {
        return this.declineRepository.findAll()
                .stream()
                .map(declinePathMapper::toDeclinePathDTO)
                .toList();
    }

    public List<DeclinePathDTO> fetchDeclinePathByTone(String tone) {
        return declineRepository.getByToneContaining(tone)
                .stream()
                .map(declinePathMapper::toDeclinePathDTO)
                .toList();
    }

    public DeclinePathDTO fetchDeclinePathById(Integer id) {
        return declinePathMapper.toDeclinePathDTO(
                Objects.requireNonNull(declineRepository.findById(id).orElse(null))
        );
    }
}
