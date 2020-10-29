package EI.POO1.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

/*
 * basicamante é um controlador (classe controlador), o spring boot consegue
 * encontrar este controlador é colocar a anotação restcontroller, neste caso o
 * controlador vai funcionar como tendo um conjunto de metodos (classe com
 * conjunto de metodos) e cada classe tem um conjunto de metodos e cada metodo
 * vai corresponder a uma posibilidade do utilizador pedir dados, pedir ou
 * enviar dados, uma possibilidade um ponto em que o controlador pode fazer
 * interação com o nosso servidor. caminhos que vamos utilizar para o utilizador
 * aceder ao servidor (n points),
 * 
 */

@RequestMapping(path = "/api/greeter") // API/GREETER é o caminho geral para o controlador completo, cada classe é um
                                       // controlador
public class GreeterController {
    private Logger logger = LoggerFactory.getLogger(GreeterController.class);

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getGreeting() {
        logger.info("Saying Hello to the world"); // conseguir ver no terminal a informação do que foi feito
        return "Hello World";
    } // return a informacao que o cliente vai ver

    // estes metodos sao os serviços que quero fornecer, tem que mostrar o caminho,
    // e o formato da informação
    // em json o string nao é boa ideia, as vezes tem que ser arrays ou objetos
    // get = buscar informação

    // o greeter vai fornecer varios servicos, cada servico é uma funcao, que depois
    // vai ter o seu proprio caminho,
    // o api vai estar sempre no caminho para distinguir de paginas, se tem haver
    // com api para fornecer json ou se sao paginas

    @GetMapping(path = "{name}", // passar valores para o servidor
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String getGreeting(@PathVariable("name") String name) {
        logger.info("Saying Hello to " + name);
        return "Hello " + name;
    }

}
