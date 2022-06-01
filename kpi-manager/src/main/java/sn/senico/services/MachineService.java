package sn.senico.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sn.senico.entities.MachineEntity;
import sn.senico.user.model.Machine;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link MachineEntity}.
 */
public interface MachineService {
    /**
     * Save a machine.
     *
     * @param machine the entity to save.
     * @return the persisted entity.
     */
    Machine save(Machine machine);

    /**
     * Partially updates a machine.
     *
     * @param machine the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Machine> partialUpdate(Machine machine);

    /**
     * Get all the machines.
     *
     * @return the list of entities.
     */
    Page<Machine> findAll(Pageable pageable);

    /**
     * Get the "id" machine.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Machine> findOne(Long id);

    /**
     * Delete the "id" machine.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
