package co.com.personal.traditionalfilessaver.service;

import co.com.personal.traditionalfilessaver.model.FileContent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Random;

@Service
@Slf4j
public class FileSaverService {

    private ObjectMapper objectMapper;

    public FileSaverService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void saveContentInFile(FileContent fileContent){
        Long randomId = Long.valueOf(new Random().nextInt(100000000));
        try {
            log.info("... Writing file ...");
            objectMapper.writeValue(new File("src/main/resources/filesSaved/saved-" + randomId + ".txt"), fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
