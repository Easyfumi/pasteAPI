package ru.marinin.paste.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.marinin.paste.models.FileDTO;
import ru.marinin.paste.repository.FileRepository;

import java.io.File;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class FileService {

    private final FileRepository fileRepository;

    public void addFile(@RequestParam MultipartFile file) {
        if (file.getSize() == 0) {
            log.info(file.toString());
            throw new RuntimeException();
        }
        FileDTO fileDTO = new FileDTO(file.getOriginalFilename());
        fileRepository.save(fileDTO);
    }

    public FileDTO getFileById(Long id) {
        return fileRepository.findById(id).orElse(null);
    }

    public List<FileDTO> getAll() {
        return fileRepository.findAll();
    }

    public void deleteFile(Long id) {
        fileRepository.deleteById(id);
    }
}
