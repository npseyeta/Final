package th.ac.kmitl.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getIndex() {
        return "redirect:home";
    }

    @RequestMapping("/home")
    public String getHome() {
        return "home";
    }
}
