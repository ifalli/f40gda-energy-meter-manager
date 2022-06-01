package sn.senico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import sn.senico.entities.OfficeEntity;

@Repository
public interface OfficeRepository extends JpaRepository<OfficeEntity, Long>, QuerydslPredicateExecutor<OfficeEntity> {

}
