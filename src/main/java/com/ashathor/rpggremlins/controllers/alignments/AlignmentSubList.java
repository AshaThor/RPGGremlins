package com.ashathor.rpggremlins.controllers.alignments;

import com.ashathor.rpggremlins.models.Alignment;
import com.ashathor.rpggremlins.repositories.AlignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlignmentSubList {

    @Autowired
    private AlignmentRepository alignmentRepository;

    public List<Alignment> getAlignmentSubListByKeyword(String keyWord){
        List<Alignment> listOfAlignments = alignmentRepository.findAll();
        List<Alignment> keyWordAlignments = new ArrayList<>();
        for (Alignment alignment : listOfAlignments){
            if (alignment.getAlignment().toLowerCase().contains(keyWord.toLowerCase())){
                keyWordAlignments.add(alignment);
            }
        }
        return keyWordAlignments;
    }
}
