package br.com.wenceslau;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/hello")
public class HelloRest {

    @GetMapping
    public Response hello(@RequestParam String nome) {

        String msg = String.format("Hi %s. Spring Rest Get Request received: %s", nome, LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

        Response response = new Response();
        response.setMensagem(msg);

        // Here we are returning an object of type 'Response' that will be automatically converted to JSON
        // This kind of response is used in API Rest services, and used by SPA applications
        return response;
    }
}

class Response {
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
