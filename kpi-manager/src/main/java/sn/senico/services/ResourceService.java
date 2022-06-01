package sn.senico.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.senico.user.model.Resource;
import java.util.Locale;
import java.util.Optional;

/**
 * Service Interface for managing {@link Locale.Category}.
 */
public interface ResourceService {
    /**
     * Save a resource.
     *
     * @param resource the entity to save.
     * @return the persisted entity.
     */
    Resource save(Resource resource);

    /**
     * Partially updates a resource.
     *
     * @param resource the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Resource> partialUpdate(Resource resource);

    /**
     * Get all the categories.
     *
     * @return the list of entities.
     */
    Page<Resource> findAll(Pageable pageable);

    /**
     * Get the "id" resource.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Resource> findOne(Long id);

    /**
     * Delete the "id" resource.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
