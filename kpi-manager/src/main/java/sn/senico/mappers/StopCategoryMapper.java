package sn.senico.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import sn.senico.entities.StopCategoryEntity;
import sn.senico.user.model.StopCategory;

import java.util.Locale;

/**
 * Mapper for the entity {@link StopCategoryEntity} and its DTO {@link StopCategory}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StopCategoryMapper extends EntityMapper<StopCategory, StopCategoryEntity> {
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    StopCategory toDtoId(StopCategoryEntity stopCategory);
}
