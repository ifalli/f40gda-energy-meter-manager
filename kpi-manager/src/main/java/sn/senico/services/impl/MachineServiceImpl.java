package sn.senico.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.senico.entities.MachineEntity;
import sn.senico.mappers.MachineMapper;
import sn.senico.repositories.MachineRepository;
import sn.senico.services.MachineService;
import sn.senico.user.model.Machine;

import java.util.Optional;

/**
 * Service Implementation for managing {@link MachineEntity}.
 */
@Service
@Transactional
public class MachineServiceImpl implements MachineService {

    private final Logger log = LoggerFactory.getLogger(MachineServiceImpl.class);

    private final MachineRepository machineRepository;

    private final MachineMapper machineMapper;

    public MachineServiceImpl(MachineRepository machineRepository, MachineMapper machineMapper) {
        this.machineRepository = machineRepository;
        this.machineMapper = machineMapper;
    }

    @Override
    public Machine save(Machine machine) {
        log.debug("Request to save Machine : {}", machine);
        MachineEntity machineEntity = machineMapper.toEntity(machine);
        machineEntity = machineRepository.save(machineEntity);
        return machineMapper.toDto(machineEntity);
    }

    @Override
    public Optional<Machine> partialUpdate(Machine machine) {
        log.debug("Request to partially update Machine : {}", machine);

        return machineRepository
            .findById(machine.getId())
            .map(existingMachine -> {
                machineMapper.partialUpdate(existingMachine, machine);

                return existingMachine;
            })
            .map(machineRepository::save)
            .map(machineMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Machine> findAll(Pageable pageable) {
        log.debug("Request to get all Anomalies");
        return machineRepository.findAll(pageable).map(machineMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Machine> findOne(Long id) {
        log.debug("Request to get Machine : {}", id);
        return machineRepository.findById(id).map(machineMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Machine : {}", id);
        machineRepository.deleteById(id);
    }

}
