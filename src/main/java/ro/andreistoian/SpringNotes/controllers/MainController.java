package ro.andreistoian.SpringNotes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ro.andreistoian.SpringNotes.models.Note;
import ro.andreistoian.SpringNotes.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    UserService service;

    @RequestMapping(value = "/")
    public String getNotes(Model model)
    {
        List<Note> noteList = new ArrayList<>();
        service.listAll().forEach(u -> noteList.addAll(u.getNotes()));
        model.addAttribute("notes", noteList);
        return "notes";
    }

}
