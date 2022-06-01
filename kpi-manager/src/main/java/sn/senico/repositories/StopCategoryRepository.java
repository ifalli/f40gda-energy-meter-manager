package sn.senico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import sn.senico.entities.StopCategoryEntity;

@Repository
public interface StopCategoryRepository extends JpaRepository<StopCategoryEntity, Long>, QuerydslPredicateExecutor<StopCategoryEntity> {

}
