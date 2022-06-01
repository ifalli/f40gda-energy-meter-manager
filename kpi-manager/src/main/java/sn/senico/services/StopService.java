package sn.senico.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.senico.user.model.Stop;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * Service Interface for managing {@link Locale.Category}.
 */
public interface StopService {
    /**
     * Save a category.
     *
     * @param categoryDTO the entity to save.
     * @return the persisted entity.
     */
    Stop save(Stop categoryDTO);

    /**
     * Partially updates a category.
     *
     * @param categoryDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Stop> partialUpdate(Stop categoryDTO);

    /**
     * Get all the categories.
     *
     * @return the list of entities.
     */
    Page<Stop> findAll(Pageable pageable);

    /**
     * Get the "id" category.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Stop> findOne(Long id);

    /**
     * Delete the "id" category.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
