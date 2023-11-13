package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.mappers.RattingMapper;
import com.securedapp.springjwt.dto.RattingDto;
import com.securedapp.springjwt.models.Ratting;
import com.securedapp.springjwt.repository.RattingRepository;
import com.securedapp.springjwt.services.facade.RattingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RattingServiceImpl implements RattingService {

    @Autowired
    private RattingRepository rattingRepository;
    @Autowired
    private RattingMapper rattingMapper;
    
    @Override
    public RattingDto create(RattingDto rattingDto) {
        return rattingMapper.toDto(
                rattingRepository.save(
                        rattingMapper.toEntity(rattingDto)
                )
        );
    }

    @Override
    public RattingDto update(RattingDto rattingDto, Long id) {
        Ratting rattingToUpdate = rattingRepository.findById(id).orElse(null);
        if(rattingToUpdate != null){
            rattingToUpdate.setStars(rattingDto.getStars());
            rattingRepository.save(rattingToUpdate);
            return  rattingMapper.toDto(rattingToUpdate);
        }
        return null;
    }

    @Override
    public String delete(Long id) {
        Ratting rattingToDelete= rattingRepository.findById(id).orElse(null);
        if(rattingToDelete != null){
            rattingRepository.deleteById(rattingToDelete.getId());
            return  "RattingDto deleted !";
        }
        return "RattingDto doesn't exist !";
    }

    @Override
    public RattingDto getItem(Long id) {
        if(rattingRepository.findById(id).isPresent())
          return rattingMapper.toDto(rattingRepository.findById(id).get());
        return null;
    }

    @Override
    public List<RattingDto> getList() {
        List<Ratting> rattingList = rattingRepository.findAll();
        List<RattingDto> rattingDtoList = new ArrayList<>();
        for (Ratting ratting : rattingList)
            if(ratting != null)
                rattingDtoList.add(rattingMapper.toDto(ratting));
        return rattingDtoList;
    }
}
