package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.models.Ratting;
import com.securedapp.springjwt.repository.RattingRepository;
import com.securedapp.springjwt.services.facade.RattingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RattingServiceImpl implements RattingService {

    @Autowired
    private RattingRepository rattingRepository;

    @Override
    public Ratting create(Ratting ratting) {
        return rattingRepository.save(ratting);
    }

    @Override
    public Ratting update(Ratting ratting, Long id) {
        Ratting rattingToUpdate = rattingRepository.findById(id).orElse(null);
        if(rattingToUpdate != null){
            rattingToUpdate.setStars(ratting.getStars());
            return  rattingToUpdate;
        }
        return null;
    }

    @Override
    public String delete(Long id) {
        Ratting rattingToDelete= rattingRepository.findById(id).orElse(null);
        if(rattingToDelete != null){
            rattingRepository.deleteById(rattingToDelete.getId());
            return  "Ratting deleted !";
        }
        return "Ratting doesn't exist !";
    }

    @Override
    public Ratting getItem(Long id) {
        return rattingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ratting> getList() {
        return rattingRepository.findAll();
    }
}
