package ru.marinin.paste.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.Target;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private LocalDateTime dateOfCreated;

    public FileDTO( String name) {
        this.name = name;
    }

    private void init() {
        dateOfCreated = LocalDateTime.now();
    }
}
