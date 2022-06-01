package sn.senico.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import sn.senico.entities.ResourceEntity;
import sn.senico.user.model.Resource;

import java.util.Locale;

/**
 * Mapper for the entity {@link ResourceEntity} and its DTO {@link Resource}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ResourceMapper extends EntityMapper<Resource, ResourceEntity> {
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    Resource toDtoId(ResourceEntity resource);
}
