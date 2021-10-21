package com.ashathor.rpggremlins.controllers;

import com.ashathor.rpggremlins.models.RpgClass;
import com.ashathor.rpggremlins.repositories.remote.RpgClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/v1/rpgclasses")
public class RpgClassController {

    private RpgClassRepository rpgClassRepository;

    /** Constructor */
    @Autowired
    public RpgClassController(RpgClassRepository rpgClassRepository) {
        this.rpgClassRepository = rpgClassRepository;
    }

    /** Root mapping
     * Returns an ordered list of RPGClasses in JSON from the database
     * @return List<RPGClass>*/
    @GetMapping
    public List<RpgClass> listClasses() {
        List<RpgClass> rpgClassesList = rpgClassRepository.findAll();
        return rpgClassesList.stream().sorted(Comparator.comparing(RpgClass::getName)).collect(Collectors.toList());
    }

    /** /{id} Mapping
     * This endpoint takes an id and returns json of the given class
     * @param id long Idof RPGClass
     * @return one RPGClass*/
    @GetMapping("/{id}")
    public RpgClass getById(@PathVariable("id") long id) {
        return rpgClassRepository.getOne(id);
    }

    //try to get param name working
    @GetMapping("/name")
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
