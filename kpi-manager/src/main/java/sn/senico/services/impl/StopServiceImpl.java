package sn.senico.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.senico.entities.StopEntity;
import sn.senico.mappers.StopMapper;
import sn.senico.repositories.StopRepository;
import sn.senico.services.StopService;
import sn.senico.user.model.Machine;
import sn.senico.user.model.Stop;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link StopEntity}.
 */
@Service
@Transactional
public class StopServiceImpl implements StopService {

    private final Logger log = LoggerFactory.getLogger(StopServiceImpl.class);

    private final StopRepository stopRepository;

    private final StopMapper stopMapper;

    public StopServiceImpl(StopRepository stopRepository, StopMapper stopMapper) {
        this.stopRepository = stopRepository;
        this.stopMapper = stopMapper;
    }

    @Override
    public Stop save(Stop stopDTO) {
        log.debug("Request to save Stop : {}", stopDTO);
        StopEntity stop = stopMapper.toEntity(stopDTO);
        stop = stopRepository.save(stop);
        return stopMapper.toDto(stop);
    }

    @Override
    public Optional<Stop> partialUpdate(Stop stopDTO) {
        log.debug("Request to partially update Stop : {}", stopDTO);

        return stopRepository
            .findById(stopDTO.getId())
            .map(existingStop -> {
                stopMapper.partialUpdate(existingStop, stopDTO);

                return existingStop;
            })
            .map(stopRepository::save)
            .map(stopMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Page<Stop> findAll(Pageable pageable) {
        log.debug("Request to get all Anomalies");
        return stopRepository.findAll(pageable).map(stopMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Stop> findOne(Long id) {
        log.debug("Request to get Stop : {}", id);
        return stopRepository.findById(id).map(stopMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Stop : {}", id);
        stopRepository.deleteById(id);
    }
}
