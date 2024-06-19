package br.com.unimed.Caso1.api;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String get() {
        return "API Carros";
    }





    //testes -------------------------------------------------------------------------

/*    @PostMapping("/login")
    public String getLogin(@RequestParam("login") String login, @RequestParam("senha") String senha){
        return "Login: " + login + ", Senha: " + senha;
    }*/

/*    @GetMapping("/login/{login}/senha/{senha}")
    public String getLogin(@PathVariable("login") String login, @PathVariable("senha") String senha){
        return "Login: " + login + ", Senha: " + senha;
    }*/

/*    @GetMapping("/carros/{id}")
    public String getCarroById (@PathVariable("id") Long id) {
        return "Carro por ID: " + id;
    }
    @GetMapping("/carros/tipo/{tipo}")
    public String getCarroByTipo (@PathVariable("tipo") String tipo) {
        return "Lista de Carros: " + tipo;
    }*/
}
