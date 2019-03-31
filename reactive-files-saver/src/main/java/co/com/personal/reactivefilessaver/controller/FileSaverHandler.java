package co.com.personal.reactivefilessaver.controller;

import co.com.personal.reactivefilessaver.model.FileContent;
import co.com.personal.reactivefilessaver.service.FileSaverService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class FileSaverHandler {

    private final FileSaverService fileSaverService;

    public FileSaverHandler(FileSaverService fileSaverService) {
        this.fileSaverService = fileSaverService;
    }

    public Mono<ServerResponse> saveContentInFile(ServerRequest serverRequest) {

        //log.info("Controller: " + Thread.currentThread().getName());
        Mono<Void> fileSaved = serverRequest.bodyToMono(FileContent.class).flatMap(fileSaverService::saveContentInFile);
        return ServerResponse.ok().build(fileSaved);
    }
}
