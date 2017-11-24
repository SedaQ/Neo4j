package cz.vutbr.feec.utko.persistence.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import cz.vutbr.feec.utko.persistence.entity.ActorEntity;

/**
 * @author Pavel Seda
 *
 */
public interface ActorRepository extends Neo4jRepository<ActorEntity, Long> {

  ActorEntity findByName(String name);

}
