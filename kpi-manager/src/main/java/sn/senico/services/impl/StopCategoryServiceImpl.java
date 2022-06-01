package sn.senico.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.senico.entities.StopCategoryEntity;
import sn.senico.mappers.StopCategoryMapper;
import sn.senico.repositories.StopCategoryRepository;
import sn.senico.services.StopCategoryService;
import sn.senico.user.model.StopCategory;

import java.util.Optional;

/**
 * Service Implementation for managing {@link StopCategoryEntity}.
 */
@Service
@Transactional
public class StopCategoryServiceImpl implements StopCategoryService {

    private final Logger log = LoggerFactory.getLogger(StopCategoryServiceImpl.class);

    private final StopCategoryRepository stopCategoryRepository;

    private final StopCategoryMapper stopCategoryMapper;

    public StopCategoryServiceImpl(StopCategoryRepository stopCategoryRepository, StopCategoryMapper stopCategoryMapper) {
        this.stopCategoryRepository = stopCategoryRepository;
        this.stopCategoryMapper = stopCategoryMapper;
    }

    @Override
    public StopCategory save(StopCategory stopCategoryDTO) {
        log.debug("Request to save StopCategory : {}", stopCategoryDTO);
        StopCategoryEntity stopCategory = stopCategoryMapper.toEntity(stopCategoryDTO);
        stopCategory = stopCategoryRepository.save(stopCategory);
        return stopCategoryMapper.toDto(stopCategory);
    }

    @Override
    public Optional<StopCategory> partialUpdate(StopCategory stopCategoryDTO) {
        log.debug("Request to partially update StopCategory : {}", stopCategoryDTO);

        return stopCategoryRepository
            .findById(stopCategoryDTO.getId())
            .map(existingStopCategory -> {
                stopCategoryMapper.partialUpdate(existingStopCategory, stopCategoryDTO);

                return existingStopCategory;
            })
            .map(stopCategoryRepository::save)
            .map(stopCategoryMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Page<StopCategory> findAll(Pageable pageable) {
        log.debug("Request to get all Anomalies");
        return stopCategoryRepository.findAll(pageable).map(stopCategoryMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<StopCategory> findOne(Long id) {
        log.debug("Request to get StopCategory : {}", id);
        return stopCategoryRepository.findById(id).map(stopCategoryMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete StopCategory : {}", id);
        stopCategoryRepository.deleteById(id);
    }
}
