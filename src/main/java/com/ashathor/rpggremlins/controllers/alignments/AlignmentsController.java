package com.ashathor.rpggremlins.controllers.alignments;

import com.ashathor.rpggremlins.models.Alignment;
import com.ashathor.rpggremlins.repositories.AlignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alignments")
public class AlignmentsController {

    @Autowired
    private AlignmentRepository alignmentRepository;

    @Autowired
    private AlignmentSubList alignmentSubList;

    @GetMapping
    public List<Alignment> listAll(){
        return alignmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Alignment getById(@PathVariable("id") Long id){
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
    public List<Alignment> getAlignmentSubListByKeyword(@PathVariable("keyword") String keyWord){
        return alignmentSubList.getAlignmentSubListByKeyword(keyWord);
    }
}