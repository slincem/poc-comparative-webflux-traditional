package co.com.personal.reactivefilessaver.service;

import co.com.personal.reactivefilessaver.model.FileContent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

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

    public Mono<Void> saveContentInFile(FileContent fileContent){

        return Mono.fromSupplier(() -> {
            Long randomId = Long.valueOf(new Random().nextInt(100000000));
            log.info("... Writing file ...");
            writeJson(fileContent, randomId).subscribe();
            return null;
        });
    }

    private Mono<Void> writeJson(FileContent fileContent, Long randomId) {
        return Mono.fromSupplier(() -> {
            try {
                //log.info(Thread.currentThread().getName());
                objectMapper.writeValue(new File("src/main/resources/filesSaved/saved-" + randomId + ".txt"), fileContent);
            } catch (IOException e) {
                log.error("No pude escribir en el archivo");
            }
            return null;
        });
    }

}
