package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.dto.AnnounceDto;
import com.securedapp.springjwt.mappers.AnnounceMapper;
import com.securedapp.springjwt.models.Announce;
import com.securedapp.springjwt.repository.AnnounceRepository;
import com.securedapp.springjwt.services.facade.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnnounceServiceImpl implements AnnounceService {

    @Autowired
    private AnnounceRepository announceRepository;
    @Autowired
    private AnnounceMapper announceMapper;

    @Override
    public AnnounceDto create(AnnounceDto announceDto) {
        return announceMapper.toDto(
                announceRepository.save(
                        announceMapper.toEntity(announceDto)
                )
        );
    }

    @Override
    public AnnounceDto update(AnnounceDto announceDto, Long id) {
        Announce announce = announceRepository.findById(id).orElse(null);
        if(announce != null){
            announce.setTitle(announceDto.getTitle());
            announce.setBody(announceDto.getBody());
            announce.setImage(announceDto.getImage());
            announce.setCategory(announceDto.getCategory());
            announce.setService(announceDto.getService());
            announceRepository.save(announce);
            return  announceMapper.toDto(announce);
        }
        return  null;
    }

    @Override
    public String delete(Long id) {
        announceRepository.deleteById(id);
        return "Announce deleted !";
    }

    @Override
    public AnnounceDto getItem(Long id) {
        if(announceRepository.findById(id).isPresent())
            return  announceMapper.toDto(announceRepository.findById(id).get());
        return  null;
    }

    @Override
    public List<AnnounceDto> getList() {
        List<Announce> announceList = announceRepository.findAll();
        List<AnnounceDto> announceDtoList = new ArrayList<>();
        for (Announce announce : announceList)
            if(announce != null)
                announceDtoList.add(announceMapper.toDto(announce));
        return  announceDtoList;
    }
}
