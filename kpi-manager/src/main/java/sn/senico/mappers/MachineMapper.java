package sn.senico.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import sn.senico.entities.MachineEntity;
import sn.senico.user.model.Machine;


/**
 * Mapper for the entity {@link MachineEntity} and its DTO {@link Machine}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface MachineMapper extends EntityMapper<Machine, MachineEntity> {
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    Machine toDtoId(MachineEntity machine);
}
