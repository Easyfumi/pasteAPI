package ru.marinin.paste.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.marinin.paste.services.FileService;

@Controller
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    @GetMapping("/add")
    public String addFileForm() {
        return "add_file";
    }

    @PostMapping("/add")
    public String addFile(@RequestParam MultipartFile file) {
        fileService.addFile(file);
        System.out.println("file added");
        return "redirect:/files/{id}";
    }

    @GetMapping("/files/{id}")
    public String viewFile(@PathVariable(value = "id") long id, Model model) {
        return "file_details";
    }
}
