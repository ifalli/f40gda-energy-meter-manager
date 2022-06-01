package sn.senico.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import sn.senico.entities.UnityEntity;
import sn.senico.user.model.Unity;

import java.util.Locale;

/**
 * Mapper for the entity {@link UnityEntity} and its DTO {@link Unity}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UnityMapper extends EntityMapper<Unity, UnityEntity> {
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    Unity toDtoId(UnityEntity unity);
}
