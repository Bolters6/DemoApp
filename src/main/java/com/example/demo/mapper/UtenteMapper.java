package com.example.demo.mapper;

import com.example.demo.model.CosaDTO;
import com.example.demo.model.Utente;
import com.example.demo.model.UtenteDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface UtenteMapper {


    @BeanMapping(ignoreByDefault = true)
    @Mappings({@Mapping(target = "name", source = "name"),
               @Mapping(target = "lastname", source = "lastname"),
               @Mapping(target = "username", source = "username"),
               @Mapping(target = "password", source = "password"),
               @Mapping(target = "email", source = "email")})
    Utente utenteDTOToUtente(UtenteDTO utenteDTO);

    @BeanMapping(ignoreByDefault = true)
    @Mappings({@Mapping(target = "name", source = "name"),
            @Mapping(target = "lastname", source = "lastname"),
            @Mapping(target = "completeName", expression = "java(concatName(utente.getName(), utente.getLastname()))"),
            @Mapping(target = "cosaDTO", expression = "java(cosaMappata(utente))"),
            @Mapping(target = "utilityTarget", source = "cosa.utility")})
    UtenteDTO utenteToUtenteDTO(Utente utente);

    default String concatName(String name, String lastname){
       return name.concat(" " + lastname);
    }

    default CosaDTO cosaMappata(Utente utente){
         CosaMapper cosaMapper = Mappers.getMapper(CosaMapper.class);
         return cosaMapper.cosaToCosaDTO(utente.getCosa());
    }
}
