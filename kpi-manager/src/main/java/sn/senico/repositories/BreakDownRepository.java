package sn.senico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import sn.senico.entities.BreakDownEntity;

@Repository
public interface BreakDownRepository extends JpaRepository<BreakDownEntity, Long>, QuerydslPredicateExecutor<BreakDownEntity> {

}
