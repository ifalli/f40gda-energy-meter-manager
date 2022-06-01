package sn.senico.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.senico.entities.StopSubCategoryEntity;
import sn.senico.user.model.StopSubCategory;

import java.util.Optional;

/**
 * Service Interface for managing {@link StopSubCategoryEntity}.
 */
public interface StopSubCategoryService {
    /**
     * Save a stopSubCategory.
     *
     * @param stopSubCategory the entity to save.
     * @return the persisted entity.
     */
    StopSubCategory save(StopSubCategory stopSubCategory);

    /**
     * Partially updates a stopSubCategory.
     *
     * @param stopSubCategory the entity to update partially.
     * @return the persisted entity.
     */
    Optional<StopSubCategory> partialUpdate(StopSubCategory stopSubCategory);

    /**
     * Get all the categories.
     *
     * @return the list of entities.
     */
    Page<StopSubCategory> findAll(Pageable pageable);

    /**
     * Get the "id" stopSubCategory.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<StopSubCategory> findOne(Long id);

    /**
     * Delete the "id" stopSubCategory.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
