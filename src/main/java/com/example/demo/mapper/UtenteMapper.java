package com.example.demo.mapper;

import com.example.demo.model.CosaDTO;
import com.example.demo.model.Utente;
import com.example.demo.model.UtenteDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface UtenteMapper {

    public UtenteMapper INSTANCE = Mappers.getMapper(UtenteMapper.class);

 //COLOCANDO EL @Mappings solo mapeare lo que este dentro de el , no hara nada automatico
    //MAPEA AUTOMATICO AUNQUE SEAN DE OBJETOS DIFERENTES, MIENTRAS EL CONTENIDO DE CADA OBJETO SEAN VARIABLES NORMALES
    // Y SE LLAMEN IGUAL EN AMBOS LADOS.
    @Mappings({@Mapping(target = "name", source = "name"),
               @Mapping(target = "lastname", source = "lastname"),
               @Mapping(target = "username", source = "username"),
               @Mapping(target = "password", source = "password"),
               @Mapping(target = "email", source = "email"),
               @Mapping(target = "cosa", source = "cosaDTO")})
    Utente utenteDTOToUtente(UtenteDTO utenteDTO);

    @Mappings({@Mapping(target = "name", source = "name"),
            @Mapping(target = "lastname", source = "lastname"),
            @Mapping(target = "completeName", expression = "java(concatName(utente.getName(), utente.getLastname()))"),
            @Mapping(target = "cosaDTO", expression = "java(cosaMappata(utente))"),
            @Mapping(target = "utilityTarget", constant = "farequalchecosa")})
    UtenteDTO utenteToUtenteDTO(Utente utente);

    default String concatName(String name, String lastname){
       return name.concat(" " + lastname);
    }

    default List<CosaDTO> cosaMappata(Utente utente){
         CosaMapper cosaMapper = Mappers.getMapper(CosaMapper.class);
         return utente.getCosa().stream().map(cosa -> cosaMapper.cosaToCosaDTO(cosa)).collect(Collectors.toList());
    }
}
