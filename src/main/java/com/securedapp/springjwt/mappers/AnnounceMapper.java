package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.AnnounceDto;
import com.securedapp.springjwt.models.Announce;
import org.springframework.stereotype.Component;

@Component
public class AnnounceMapper {

    public AnnounceDto toDto(Announce announce){
        return  new AnnounceDto(
                announce.getTitle(),
                announce.getBody(),
                announce.getImage(),
                announce.getService(),
                announce.getCategory()
        );
    }

    public Announce toEntity(AnnounceDto announceDto){
        Announce announce = new Announce();
        announce.setTitle(announceDto.getTitle());
        announce.setBody(announceDto.getBody());
        announce.setImage(announceDto.getImage());
        announce.setCategory(announceDto.getCategory());
        announce.setService(announceDto.getService());
        return announce;
    }

}
