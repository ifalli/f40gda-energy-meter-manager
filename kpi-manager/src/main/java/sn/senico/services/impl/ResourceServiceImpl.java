package sn.senico.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.senico.entities.ResourceEntity;
import sn.senico.mappers.ResourceMapper;
import sn.senico.repositories.ResourceRepository;
import sn.senico.services.ResourceService;
import sn.senico.user.model.Resource;

import java.util.Optional;

/**
 * Service Implementation for managing {@link ResourceEntity}.
 */
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

    private final Logger log = LoggerFactory.getLogger(ResourceServiceImpl.class);

    private final ResourceRepository resourceRepository;

    private final ResourceMapper resourceMapper;

    public ResourceServiceImpl(ResourceRepository resourceRepository, ResourceMapper resourceMapper) {
        this.resourceRepository = resourceRepository;
        this.resourceMapper = resourceMapper;
    }

    @Override
    public Resource save(Resource resource) {
        log.debug("Request to save Resource : {}", resource);
        ResourceEntity resourceEntity = resourceMapper.toEntity(resource);
        resourceEntity = resourceRepository.save(resourceEntity);
        return resourceMapper.toDto(resourceEntity);
    }

    @Override
    public Optional<Resource> partialUpdate(Resource resource) {
        log.debug("Request to partially update Resource : {}", resource);

        return resourceRepository
            .findById(resource.getId())
            .map(existingResource -> {
                resourceMapper.partialUpdate(existingResource, resource);

                return existingResource;
            })
            .map(resourceRepository::save)
            .map(resourceMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Resource> findAll(Pageable pageable) {
        log.debug("Request to get all Anomalies");
        return resourceRepository.findAll(pageable).map(resourceMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Resource> findOne(Long id) {
        log.debug("Request to get Resource : {}", id);
        return resourceRepository.findById(id).map(resourceMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Resource : {}", id);
        resourceRepository.deleteById(id);
    }

}
