package com.project.todoapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    /** defaults to false in the DB */
    private boolean completed = false;

    /** LOW | MEDIUM | HIGH — store as plain text */
    private String priority = "MEDIUM";

    /** Optional: ISO date (yyyy‑MM‑dd) */
    private LocalDate dueDate;
}
