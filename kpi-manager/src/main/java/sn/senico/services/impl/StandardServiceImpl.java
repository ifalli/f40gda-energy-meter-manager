package sn.senico.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.senico.entities.StandardEntity;
import sn.senico.mappers.StandardMapper;
import sn.senico.repositories.StandardRepository;
import sn.senico.services.StandardService;
import sn.senico.user.model.Standard;

import java.util.Optional;

/**
 * Service Implementation for managing {@link StandardEntity}.
 */
@Service
@Transactional
public class StandardServiceImpl implements StandardService {

    private final Logger log = LoggerFactory.getLogger(StandardServiceImpl.class);

    private final StandardRepository standardRepository;

    private final StandardMapper standardMapper;

    public StandardServiceImpl(StandardRepository standardRepository, StandardMapper standardMapper) {
        this.standardRepository = standardRepository;
        this.standardMapper = standardMapper;
    }

    @Override
    public Standard save(Standard standard) {
        log.debug("Request to save Standard : {}", standard);
        StandardEntity standardEntity = standardMapper.toEntity(standard);
        standardEntity = standardRepository.save(standardEntity);
        return standardMapper.toDto(standardEntity);
    }

    @Override
    public Optional<Standard> partialUpdate(Standard standard) {
        log.debug("Request to partially update Standard : {}", standard);

        return standardRepository
            .findById(standard.getId())
            .map(existingStandard -> {
                standardMapper.partialUpdate(existingStandard, standard);

                return existingStandard;
            })
            .map(standardRepository::save)
            .map(standardMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Standard> findAll(Pageable pageable) {
        log.debug("Request to get all Anomalies");
        return standardRepository.findAll(pageable).map(standardMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Standard> findOne(Long id) {
        log.debug("Request to get Standard : {}", id);
        return standardRepository.findById(id).map(standardMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Standard : {}", id);
        standardRepository.deleteById(id);
    }

}
