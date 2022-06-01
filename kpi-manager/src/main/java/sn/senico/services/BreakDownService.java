package sn.senico.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.senico.entities.BreakDownEntity;
import sn.senico.user.model.BreakDown;

import java.util.Optional;

/**
 * Service Interface for managing {@link BreakDownEntity}.
 */
public interface BreakDownService {
    /**
     * Save a breakDown.
     *
     * @param breakDown the entity to save.
     * @return the persisted entity.
     */
    BreakDown save(BreakDown breakDown);

    /**
     * Partially updates a breakDown.
     *
     * @param breakDown the entity to update partially.
     * @return the persisted entity.
     */
    Optional<BreakDown> partialUpdate(BreakDown breakDown);

    /**
     * Get all the breakDowns.
     *
     * @return the list of entities.
     */
    Page<BreakDown> findAll(Pageable pageable);

    /**
     * Get the "id" breakDown.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BreakDown> findOne(Long id);

    /**
     * Delete the "id" breakDown.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
