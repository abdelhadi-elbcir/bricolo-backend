package com.securedapp.springjwt.services.facade;

import com.securedapp.springjwt.models.Ratting;

import java.util.List;

public interface RattingService {
    Ratting create(Ratting ratting);
    Ratting update(Ratting ratting, Long id);
    String delete(Long id);
    Ratting getRatting(Long id);
    List<Ratting> getListRattings();
}