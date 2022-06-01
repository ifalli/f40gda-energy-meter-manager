package sn.senico.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import sn.senico.entities.BreakDownEntity;
import sn.senico.user.model.BreakDown;


/**
 * Mapper for the entity {@link BreakDownEntity} and its DTO {@link BreakDown}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface BreakDownMapper extends EntityMapper<BreakDown, BreakDownEntity> {
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    BreakDown toDtoId(BreakDownEntity breakDown);
}
