package sn.senico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import sn.senico.entities.UnityEntity;

@Repository
public interface UnityRepository extends JpaRepository<UnityEntity, Long>, QuerydslPredicateExecutor<UnityEntity> {

}
