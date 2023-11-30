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
        Announce announce = announceMapper.toEntity(announceDto);
        Announce announceFounded = announceRepository.findById(id).orElse(null);
        if(announceFounded != null){
            announceFounded.setTitle(announce .getTitle());
            announceFounded.setBody(announce .getBody());
            announceFounded.setImage(announce .getImage());
            announceFounded.setCategory(announce .getCategory());
            announceFounded.setService(announce .getService());
            announceRepository.save(announceFounded);
            return  announceMapper.toDto(announceFounded);
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
        announceMapper.getServiceMapper().setAnnounce(false);
        announceMapper.getCategoryMapper().setAnnounce(false);
        List<AnnounceDto> announceDtoList = announceMapper.toDto(announceRepository.findAll());
        announceMapper.getServiceMapper().setAnnounce(true);
        announceMapper.getCategoryMapper().setAnnounce(true);
        return  announceDtoList;
    }
}
