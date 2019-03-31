package co.com.personal.traditionalfilessaver.controller;

import co.com.personal.traditionalfilessaver.model.FileContent;
import co.com.personal.traditionalfilessaver.service.FileSaverService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file-content")
public class FileSaverController {

    private final FileSaverService fileSaverService;

    public FileSaverController(FileSaverService fileSaverService) {
        this.fileSaverService = fileSaverService;
    }

    @PostMapping
    public void saveContentInFile(@RequestBody FileContent fileContent) {
        fileSaverService.saveContentInFile(fileContent);
    }
}
