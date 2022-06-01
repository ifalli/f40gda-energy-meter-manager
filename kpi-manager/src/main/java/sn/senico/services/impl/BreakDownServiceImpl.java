package sn.senico.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.senico.entities.BreakDownEntity;
import sn.senico.mappers.BreakDownMapper;
import sn.senico.repositories.BreakDownRepository;
import sn.senico.services.BreakDownService;
import sn.senico.user.model.BreakDown;

import java.util.Optional;

/**
 * Service Implementation for managing {@link BreakDownEntity}.
 */
@Service
@Transactional
public class BreakDownServiceImpl implements BreakDownService {

    private final Logger log = LoggerFactory.getLogger(BreakDownServiceImpl.class);

    private final BreakDownRepository breakDownRepository;

    private final BreakDownMapper breakDownMapper;

    public BreakDownServiceImpl(BreakDownRepository breakDownRepository, BreakDownMapper breakDownMapper) {
        this.breakDownRepository = breakDownRepository;
        this.breakDownMapper = breakDownMapper;
    }

    @Override
    public BreakDown save(BreakDown breakDown) {
        log.debug("Request to save BreakDown : {}", breakDown);
        BreakDownEntity breakDownEntity = breakDownMapper.toEntity(breakDown);
        breakDownEntity = breakDownRepository.save(breakDownEntity);
        return breakDownMapper.toDto(breakDownEntity);
    }

    @Override
    public Optional<BreakDown> partialUpdate(BreakDown breakDown) {
        log.debug("Request to partially update BreakDown : {}", breakDown);

        return breakDownRepository
            .findById(breakDown.getId())
            .map(existingBreakDown -> {
                breakDownMapper.partialUpdate(existingBreakDown, breakDown);

                return existingBreakDown;
            })
            .map(breakDownRepository::save)
            .map(breakDownMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BreakDown> findAll(Pageable pageable) {
        log.debug("Request to get all Anomalies");
        return breakDownRepository.findAll(pageable).map(breakDownMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BreakDown> findOne(Long id) {
        log.debug("Request to get BreakDown : {}", id);
        return breakDownRepository.findById(id).map(breakDownMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete BreakDown : {}", id);
        breakDownRepository.deleteById(id);
    }

}
