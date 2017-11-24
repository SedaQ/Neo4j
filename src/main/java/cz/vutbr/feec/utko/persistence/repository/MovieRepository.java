package cz.vutbr.feec.utko.persistence.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import cz.vutbr.feec.utko.persistence.entity.MovieEntity;

/**
 * @author Pavel Seda
 *
 */
public interface MovieRepository extends Neo4jRepository<MovieEntity, Long> {

}
