package com.company_management_system.dto;

import jakarta.persistence.Column;

public record EmployeeDTO(
        Long id,
        String firstName,
        String LastName,
        String email
) {}
