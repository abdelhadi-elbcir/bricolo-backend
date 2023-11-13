package com.securedapp.springjwt.mappers;

import com.securedapp.springjwt.dto.FavoriteDto;
import com.securedapp.springjwt.models.Favorite;
import org.springframework.stereotype.Component;

@Component
public class FavoriteMapper {

    public FavoriteDto toDto(Favorite favorite){
        return new FavoriteDto(

        );
    }

    public Favorite toEntity(FavoriteDto favoriteDto){
        Favorite favorite = new Favorite();

        return  favorite;
    }
}
