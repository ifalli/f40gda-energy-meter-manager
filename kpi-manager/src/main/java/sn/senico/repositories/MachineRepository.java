package sn.senico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import sn.senico.entities.MachineEntity;

@Repository
public interface MachineRepository extends JpaRepository<MachineEntity, Long>, QuerydslPredicateExecutor<MachineEntity> {

}
