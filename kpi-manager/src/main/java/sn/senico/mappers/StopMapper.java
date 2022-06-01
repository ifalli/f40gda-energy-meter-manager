package sn.senico.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import sn.senico.entities.StopEntity;
import sn.senico.user.model.Stop;

import java.util.Locale;

/**
 * Mapper for the entity {@link StopEntity} and its DTO {@link Stop}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StopMapper extends EntityMapper<Stop, StopEntity> {
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    Stop toDtoId(StopEntity stop);
}
