package sn.senico.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import sn.senico.entities.StopSubCategoryEntity;
import sn.senico.user.model.StopSubCategory;

import java.util.Locale;

/**
 * Mapper for the entity {@link StopSubCategoryEntity} and its DTO {@link StopSubCategory}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface StopSubCategoryMapper extends EntityMapper<StopSubCategory, StopSubCategoryEntity> {
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    StopSubCategory toDtoId(StopSubCategoryEntity stopSubCategory);
}
