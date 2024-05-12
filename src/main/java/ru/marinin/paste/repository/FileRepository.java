package ru.marinin.paste.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.marinin.paste.models.FileDTO;

public interface FileRepository extends JpaRepository<FileDTO, Long> {
}
