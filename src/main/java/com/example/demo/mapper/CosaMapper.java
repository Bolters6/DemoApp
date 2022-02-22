package com.example.demo.mapper;

import DTO.CosaDTO;
import com.example.demo.model.Cosa;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface CosaMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mappings({@Mapping(target = "cosaname", source = "name"),
               @Mapping(target = "materiale", source = "materiale") })
    CosaDTO cosaToCosaDTO(Cosa cosa);

}
