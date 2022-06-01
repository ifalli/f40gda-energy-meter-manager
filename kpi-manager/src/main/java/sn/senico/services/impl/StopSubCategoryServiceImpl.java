package sn.senico.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.senico.entities.StopSubCategoryEntity;
import sn.senico.mappers.StopSubCategoryMapper;
import sn.senico.repositories.StopSubCategoryRepository;
import sn.senico.services.StopSubCategoryService;
import sn.senico.user.model.StopSubCategory;

import java.util.Optional;

/**
 * Service Implementation for managing {@link StopSubCategoryEntity}.
 */
@Service
@Transactional
public class StopSubCategoryServiceImpl implements StopSubCategoryService {

    private final Logger log = LoggerFactory.getLogger(StopSubCategoryServiceImpl.class);

    private final StopSubCategoryRepository stopSubCategoryRepository;

    private final StopSubCategoryMapper stopSubCategoryMapper;

    public StopSubCategoryServiceImpl(StopSubCategoryRepository stopSubCategoryRepository, StopSubCategoryMapper stopSubCategoryMapper) {
        this.stopSubCategoryRepository = stopSubCategoryRepository;
        this.stopSubCategoryMapper = stopSubCategoryMapper;
    }

    @Override
    public StopSubCategory save(StopSubCategory stopSubCategoryDTO) {
        log.debug("Request to save StopSubCategory : {}", stopSubCategoryDTO);
        StopSubCategoryEntity stopSubCategory = stopSubCategoryMapper.toEntity(stopSubCategoryDTO);
        stopSubCategory = stopSubCategoryRepository.save(stopSubCategory);
        return stopSubCategoryMapper.toDto(stopSubCategory);
    }

    @Override
    public Optional<StopSubCategory> partialUpdate(StopSubCategory stopSubCategoryDTO) {
        log.debug("Request to partially update StopSubCategory : {}", stopSubCategoryDTO);

        return stopSubCategoryRepository
            .findById(stopSubCategoryDTO.getId())
            .map(existingStopSubCategory -> {
                stopSubCategoryMapper.partialUpdate(existingStopSubCategory, stopSubCategoryDTO);

                return existingStopSubCategory;
            })
            .map(stopSubCategoryRepository::save)
            .map(stopSubCategoryMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Page<StopSubCategory> findAll(Pageable pageable) {
        log.debug("Request to get all Anomalies");
        return stopSubCategoryRepository.findAll(pageable).map(stopSubCategoryMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<StopSubCategory> findOne(Long id) {
        log.debug("Request to get StopSubCategory : {}", id);
        return stopSubCategoryRepository.findById(id).map(stopSubCategoryMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete StopSubCategory : {}", id);
        stopSubCategoryRepository.deleteById(id);
    }
}
