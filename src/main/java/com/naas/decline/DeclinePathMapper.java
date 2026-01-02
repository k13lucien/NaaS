package com.naas.decline;

import org.springframework.stereotype.Service;

@Service
public class DeclinePathMapper {

    public DeclinePathDTO toDeclinePathDTO(DeclinePath declinePath) {

        return new DeclinePathDTO(
                declinePath.getCode(),
                declinePath.getTitle(),
                declinePath.getMessage(),
                declinePath.getTone()
        );
    }
}
