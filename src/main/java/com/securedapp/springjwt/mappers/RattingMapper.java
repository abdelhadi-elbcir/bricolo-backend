package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.RattingDto;
import com.securedapp.springjwt.models.Ratting;
import org.springframework.stereotype.Component;

@Component
public class RattingMapper {

    public RattingDto toDto(Ratting ratting){
        return  new RattingDto(
                ratting.getStars(),
                ratting.getUser()
        );
    }

    public Ratting toEntity(RattingDto rattingDto){
        Ratting ratting = new Ratting();
        ratting.setStars(rattingDto.getStars());
        ratting.setUser(rattingDto.getUser());
        return  ratting;
    }
}
