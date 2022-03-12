package com.example.demo.mapper;

import com.example.demo.model.Cosa;
import com.example.demo.model.CosaDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface CosaMapper {

    public CosaMapper INSTANCE = Mappers.getMapper(CosaMapper.class);

    @Mappings({
            @Mapping(target = "name", source = "cosaname"),
            @Mapping(target = "materiale", source = "materiale"),
            @Mapping(target = "utility",  source = "utility")
    })
    Cosa cosaDTOToCosa(CosaDTO cosaDTO);
    @Mappings({@Mapping(target = "cosaname", source = "name"),
               @Mapping(target = "materiale", source = "materiale") })
    CosaDTO cosaToCosaDTO(Cosa cosa);

}
