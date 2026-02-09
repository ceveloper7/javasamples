package com.ceva.spring6.record;

import java.time.LocalDate;

public record Album(Long id,
                    Long singerId,
                    String title,
                    LocalDate releaseDate) {}