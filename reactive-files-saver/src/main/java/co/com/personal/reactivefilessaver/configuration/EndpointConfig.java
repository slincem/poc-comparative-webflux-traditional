package co.com.personal.reactivefilessaver.configuration;

import co.com.personal.reactivefilessaver.controller.FileSaverHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class EndpointConfig {


    @Bean
    public RouterFunction<ServerResponse> saveContentInFileRoute(FileSaverHandler fileSaverHandler) {
        return route(POST("/file-content-reactive"), fileSaverHandler::saveContentInFile);
    }
}
