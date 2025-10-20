package com.sjl.domain.model.player;

import java.util.UUID;

public record Player(
        UUID id,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String licenseNumber,
        String level,
        boolean referee,
        boolean manager
) {

    public Player {
        if (email != null && !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email: " + email);
        }
    }

    public boolean isComplete() {
        return firstName != null && lastName != null && licenseNumber != null;
    }
}
