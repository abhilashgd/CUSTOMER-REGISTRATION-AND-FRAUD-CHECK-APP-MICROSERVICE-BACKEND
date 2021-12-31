package com.microservicetest.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
