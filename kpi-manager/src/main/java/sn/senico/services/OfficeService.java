package sn.senico.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.senico.entities.OfficeEntity;
import sn.senico.user.model.Machine;
import sn.senico.user.model.Office;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * Service Interface for managing {@link OfficeEntity}.
 */
public interface OfficeService {
    /**
     * Save a office.
     *
     * @param office the entity to save.
     * @return the persisted entity.
     */
    Office save(Office office);

    /**
     * Partially updates a office.
     *
     * @param office the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Office> partialUpdate(Office office);

    /**
     * Get all the offices.
     *
     * @return the list of entities.
     */
    Page<Office> findAll(Pageable pageable);

    /**
     * Get the "id" office.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Office> findOne(Long id);

    /**
     * Delete the "id" office.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
