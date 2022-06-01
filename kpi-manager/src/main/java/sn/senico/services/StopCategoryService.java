package sn.senico.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.senico.entities.StopCategoryEntity;
import sn.senico.user.model.StopCategory;

import java.util.Optional;

/**
 * Service Interface for managing {@link StopCategoryEntity}.
 */
public interface StopCategoryService {
    /**
     * Save a stopCategory.
     *
     * @param stopCategory the entity to save.
     * @return the persisted entity.
     */
    StopCategory save(StopCategory stopCategory);

    /**
     * Partially updates a stopCategory.
     *
     * @param stopCategory the entity to update partially.
     * @return the persisted entity.
     */
    Optional<StopCategory> partialUpdate(StopCategory stopCategory);

    /**
     * Get all the categories.
     *
     * @return the list of entities.
     */
    Page<StopCategory> findAll(Pageable pageable);

    /**
     * Get the "id" stopCategory.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<StopCategory> findOne(Long id);

    /**
     * Delete the "id" stopCategory.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
