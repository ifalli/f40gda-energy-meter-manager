package sn.senico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import sn.senico.entities.StandardEntity;
import sn.senico.repositories.custom.StopRepositoryCustomer;

@Repository
public interface StandardRepository extends JpaRepository<StandardEntity, Long>, StopRepositoryCustomer, QuerydslPredicateExecutor<StandardEntity> {

}
