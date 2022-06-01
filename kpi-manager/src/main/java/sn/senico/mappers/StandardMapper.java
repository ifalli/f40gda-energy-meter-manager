package sn.senico.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import sn.senico.entities.StandardEntity;
import sn.senico.user.model.Standard;

import java.util.Locale;

/**
 * Mapper for the entity {@link StandardEntity} and its DTO {@link Standard}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StandardMapper extends EntityMapper<Standard, StandardEntity> {
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    Standard toDtoId(StandardEntity standard);
}
