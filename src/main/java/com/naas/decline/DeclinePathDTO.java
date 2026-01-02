package com.naas.decline;

public record DeclinePathDTO(
        String code,
        String title,
        String message,
        String tone
) {
}
