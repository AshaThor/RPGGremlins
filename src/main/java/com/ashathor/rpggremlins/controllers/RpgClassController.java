package com.ashathor.rpggremlins.controllers;

import com.ashathor.rpggremlins.models.RpgClass;
import com.ashathor.rpggremlins.repositories.RpgClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/rpgclasses")
public class RpgClassController {

    private RpgClassRepository rpgClassRepository;

    @Autowired
    public List<RpgClass> list() {
        return rpgClassRepository.findAll();
    }

    public RpgClassController(RpgClassRepository rpgClassRepository) {
        this.rpgClassRepository = rpgClassRepository;
    }

    //Root
    @GetMapping
    public String listClasses(ModelMap modelMap) {
        List<RpgClass> rpgClassesList = rpgClassRepository.findAll();
        List<RpgClass> rpgClassesListSorted = rpgClassesList.stream().sorted(Comparator.comparing(RpgClass::getName)).collect(Collectors.toList());
        modelMap.put("rpgClassesList", rpgClassesListSorted);
        return "rpgclass/rpgclasses";
    }


    @GetMapping("/{id}")
    public String getById(@PathVariable("id") long id, ModelMap modelMap) {
        RpgClass rpgClass = rpgClassRepository.getOne(id);
        modelMap.put("rpgClass", rpgClass);
        return "rpgclass/rpgclass";
    }

    //try to get param name working
    public RpgClass getClass(@RequestParam(value = "name") String name) {
        return rpgClassRepository.findByName(name);
    }

    @GetMapping("/new")
    public String rpgClassForm(Model model) {
        model.addAttribute("rpgClass", new RpgClass());
        return "rpgclass/newrpgclass";
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.OK)
    public String create(@ModelAttribute RpgClass rpgClass, Model model) {
        model.addAttribute("rpgClass", rpgClass);
        rpgClassRepository.save(rpgClass);
        return "rpgclass/newsuccess";
    }

    @GetMapping("/admin")
    public String rpgClassAdmin(ModelMap modelMap) {
        List<RpgClass> rpgClassesList = rpgClassRepository.findAll();
        List<RpgClass> rpgClassesListSorted = rpgClassesList.stream().sorted(Comparator.comparing(RpgClass::getName)).collect(Collectors.toList());
        modelMap.put("rpgClassesList", rpgClassesListSorted);
        return "rpgclass/admin";
    }
}
