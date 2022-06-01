package sn.senico.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.senico.entities.UnityEntity;
import sn.senico.mappers.UnityMapper;
import sn.senico.repositories.UnityRepository;
import sn.senico.services.UnityService;
import sn.senico.user.model.Unity;

import java.util.Optional;

/**
 * Service Implementation for managing {@link UnityEntity}.
 */
@Service
@Transactional
public class UnityServiceImpl implements UnityService {

    private final Logger log = LoggerFactory.getLogger(UnityServiceImpl.class);

    private final UnityRepository unityRepository;

    private final UnityMapper unityMapper;

    public UnityServiceImpl(UnityRepository unityRepository, UnityMapper unityMapper) {
        this.unityRepository = unityRepository;
        this.unityMapper = unityMapper;
    }

    @Override
    public Unity save(Unity unityDTO) {
        log.debug("Request to save Unity : {}", unityDTO);
        UnityEntity unity = unityMapper.toEntity(unityDTO);
        unity = unityRepository.save(unity);
        return unityMapper.toDto(unity);
    }

    @Override
    public Optional<Unity> partialUpdate(Unity unityDTO) {
        log.debug("Request to partially update Unity : {}", unityDTO);

        return unityRepository
            .findById(unityDTO.getId())
            .map(existingUnity -> {
                unityMapper.partialUpdate(existingUnity, unityDTO);

                return existingUnity;
            })
            .map(unityRepository::save)
            .map(unityMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Page<Unity> findAll(Pageable pageable) {
        log.debug("Request to get all Anomalies");
        return unityRepository.findAll(pageable).map(unityMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Unity> findOne(Long id) {
        log.debug("Request to get Unity : {}", id);
        return unityRepository.findById(id).map(unityMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Unity : {}", id);
        unityRepository.deleteById(id);
    }
}
