package com.securedapp.springjwt.services.impl;

import com.securedapp.springjwt.dto.AnnounceDto;
import com.securedapp.springjwt.services.facade.AnnounceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnounceServiceImpl implements AnnounceService {
    @Override
    public AnnounceDto create(AnnounceDto announceDto) {
        return null;
    }

    @Override
    public AnnounceDto update(AnnounceDto announceDto, Long id) {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public AnnounceDto getItem(Long id) {
        return null;
    }

    @Override
    public List<AnnounceDto> getList() {
        return null;
    }
}
