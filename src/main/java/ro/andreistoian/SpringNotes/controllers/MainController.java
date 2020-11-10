package ro.andreistoian.SpringNotes.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.andreistoian.SpringNotes.models.User;
import ro.andreistoian.SpringNotes.services.UserService;
import java.security.Principal;


@Controller
@Slf4j
public class MainController {

    @Autowired
    UserService service;

    @RequestMapping(value = "/")
    public String getNotes(Model model, Principal principal)
    {
        User user = service.getByUserName(principal.getName());
        model.addAttribute("notes", user.getNotes());
        return "notes";
    }

}
