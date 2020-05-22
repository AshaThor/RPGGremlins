package com.ashathor.rpggremlins.controllers;

import com.ashathor.rpggremlins.models.Alignment;
import com.ashathor.rpggremlins.repositories.AlignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/alignments")
public class AlignmentsController {

    @Autowired
    private AlignmentRepository alignmentRepository;

    @GetMapping
    public List<Alignment> list(){
        return alignmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Alignment get(@PathVariable("id") Long id){
        return alignmentRepository.getOne(id);
    }

    /**Filter through Alignments using a keyword and return all matches
     * E.g. /keyword/evil
     * Returns a List<Alignment> containing "Chaotic Evil, Lawful Evil, Neutral Evil"
     *
     * @param keyWord
     * @return List<Alignment>
     * */
    @GetMapping("/keyword/{keyword}")
    public List<Alignment> get(@PathVariable("keyword") String keyWord){
        List<Alignment> alignments = alignmentRepository.findAll();
        List<Alignment> keyWordAlignments = new ArrayList<>();
        for (Alignment alignment : alignments){
            if (alignment.getAlignment().toLowerCase().contains(keyWord.toLowerCase())){
                keyWordAlignments.add(alignment);
            }
        }
        return keyWordAlignments;
    }
}
