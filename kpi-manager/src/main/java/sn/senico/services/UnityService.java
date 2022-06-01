package sn.senico.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.senico.entities.UnityEntity;
import sn.senico.user.model.Unity;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link UnityEntity}.
 */
public interface UnityService {
    /**
     * Save a unity.
     *
     * @param unity the entity to save.
     * @return the persisted entity.
     */
    Unity save(Unity unity);

    /**
     * Partially updates a unity.
     *
     * @param unity the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Unity> partialUpdate(Unity unity);

    /**
     * Get all the categories.
     *
     * @return the list of entities.
     */
    Page<Unity> findAll(Pageable pageable);

    /**
     * Get the "id" unity.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Unity> findOne(Long id);

    /**
     * Delete the "id" unity.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
