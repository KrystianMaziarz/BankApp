package pl.krystianmaziarz.bank.controllers.httpControllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

@GetMapping("/dashboard")
public String welcome () {

    return "dashboard";

}
}
