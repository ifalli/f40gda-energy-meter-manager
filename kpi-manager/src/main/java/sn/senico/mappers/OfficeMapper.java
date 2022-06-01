package sn.senico.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import sn.senico.entities.OfficeEntity;
import sn.senico.user.model.Office;

import java.util.Locale;

/**
 * Mapper for the entity {@link OfficeEntity} and its DTO {@link Office}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface OfficeMapper extends EntityMapper<Office, OfficeEntity> {
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    Office toDtoId(OfficeEntity office);
}
