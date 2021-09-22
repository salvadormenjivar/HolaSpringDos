package udemy.spring.HolaSpringDos;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import udemy.spring.HolaSpringDos.entidades.Persona;

@Controller
@Slf4j
public class ControladorInicio {

    @Value("${index.saludo}")
    private String saludo;

    @GetMapping("/")
    public String inicio(Model model) {
        Persona persona = new Persona("Salvador", "Peña", "salvadorpm@gmail.com", "55555");
        Persona persona2 = new Persona("Juan", "Peres", "juan@gmail.com", "22225");
        //List<Persona> lstPersonas = new ArrayList<>();
//        lstPersona.add(persona);
//        lstPersona.add(persona2);

        var lstPersonas = Arrays.asList(persona, persona2); 

        String saludar = "Hola mundo con thymeleaf desde el controlador 2";
        model.addAttribute("saludo", saludar);
        model.addAttribute("saludoProperties", saludo);
        model.addAttribute("salvador", persona);
        model.addAttribute("lstPersonas", lstPersonas);
        
        log.info("Ejecutando el controlador Spring mvc");
        return "index";

    }

}
