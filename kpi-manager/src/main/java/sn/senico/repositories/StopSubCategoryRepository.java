package sn.senico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import sn.senico.entities.StopSubCategoryEntity;

@Repository
public interface StopSubCategoryRepository extends JpaRepository<StopSubCategoryEntity, Long>, QuerydslPredicateExecutor<StopSubCategoryEntity> {

}
