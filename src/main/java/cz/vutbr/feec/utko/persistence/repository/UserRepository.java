package cz.vutbr.feec.utko.persistence.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import cz.vutbr.feec.utko.persistence.entity.UserEntity;

/**
 * @author Pavel Seda
 *
 */
public interface UserRepository extends Neo4jRepository<UserEntity, Long> {

}
