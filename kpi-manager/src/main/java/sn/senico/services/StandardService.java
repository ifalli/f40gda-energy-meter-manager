package sn.senico.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.senico.entities.StandardEntity;
import sn.senico.user.model.Standard;

import java.util.Optional;

/**
 * Service Interface for managing {@link StandardEntity}.
 */
public interface StandardService {
    /**
     * Save a standard.
     *
     * @param standard the entity to save.
     * @return the persisted entity.
     */
    Standard save(Standard standard);

    /**
     * Partially updates a standard.
     *
     * @param standard the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Standard> partialUpdate(Standard standard);

    /**
     * Get all the categories.
     *
     * @return the list of entities.
     */
    Page<Standard> findAll(Pageable pageable);

    /**
     * Get the "id" standard.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Standard> findOne(Long id);

    /**
     * Delete the "id" standard.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
