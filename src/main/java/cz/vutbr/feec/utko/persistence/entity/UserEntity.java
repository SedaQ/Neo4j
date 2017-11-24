package cz.vutbr.feec.utko.persistence.entity;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author Pavel Seda
 *
 */
@NodeEntity(label = "User")
public class UserEntity {

  @Id
  @GeneratedValue
  private Long id;
  private String name;

  @Relationship(type = "WATCHED", direction = "OUTGOING")
  private Set<MovieEntity> moviesWatched = new HashSet<>();

  public UserEntity() {}

  public UserEntity(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public Set<MovieEntity> getMoviesWatched() {
    return moviesWatched;
  }

  public void watched(MovieEntity movie) {
    moviesWatched.add(movie);
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setMoviesWatched(Set<MovieEntity> moviesWatched) {
    this.moviesWatched = moviesWatched;
  }


}
