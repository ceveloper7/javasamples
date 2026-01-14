package com.ceva.spring6.record;

import com.ceva.spring6.model.Album;

import java.time.LocalDate;
import java.util.Set;

public record Singer(
        Long id,
        String firstName,
        String lastName,
        LocalDate birthDate,
        Set<Album> albums) {
}
