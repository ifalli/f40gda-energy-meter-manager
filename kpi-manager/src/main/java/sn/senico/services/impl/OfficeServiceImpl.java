package sn.senico.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.senico.entities.OfficeEntity;
import sn.senico.mappers.OfficeMapper;
import sn.senico.repositories.OfficeRepository;
import sn.senico.services.OfficeService;
import sn.senico.user.model.Office;

import java.util.Optional;

/**
 * Service Implementation for managing {@link OfficeEntity}.
 */
@Service
@Transactional
public class OfficeServiceImpl implements OfficeService {

    private final Logger log = LoggerFactory.getLogger(OfficeServiceImpl.class);

    private final OfficeRepository officeRepository;

    private final OfficeMapper officeMapper;

    public OfficeServiceImpl(OfficeRepository officeRepository, OfficeMapper officeMapper) {
        this.officeRepository = officeRepository;
        this.officeMapper = officeMapper;
    }

    @Override
    public Office save(Office office) {
        log.debug("Request to save Office : {}", office);
        OfficeEntity officeEntity = officeMapper.toEntity(office);
        officeEntity = officeRepository.save(officeEntity);
        return officeMapper.toDto(officeEntity);
    }

    @Override
    public Optional<Office> partialUpdate(Office office) {
        log.debug("Request to partially update Office : {}", office);

        return officeRepository
            .findById(office.getId())
            .map(existingOffice -> {
                officeMapper.partialUpdate(existingOffice, office);

                return existingOffice;
            })
            .map(officeRepository::save)
            .map(officeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Office> findAll(Pageable pageable) {
        log.debug("Request to get all Anomalies");
        return officeRepository.findAll(pageable).map(officeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Office> findOne(Long id) {
        log.debug("Request to get Office : {}", id);
        return officeRepository.findById(id).map(officeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Office : {}", id);
        officeRepository.deleteById(id);
    }

}
