package cz.vutbr.feec.utko.persistence.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


/**
 * @author Pavel Seda
 *
 */
@NodeEntity(label = "Movie")
public class MovieEntity {

  @Id
  @GeneratedValue
  private Long id;
  private String title;
  @Relationship(type = "ACTED_IN", direction = "INCOMING")
  private Set<ActorEntity> actors = new HashSet<>();

  @Relationship(type = "AWARD", direction = "INCOMING")
  private List<AwardEntity> awards = new ArrayList<>();

  public MovieEntity() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Set<ActorEntity> getActors() {
    return actors;
  }

  public void setActors(Set<ActorEntity> actors) {
    this.actors = actors;
  }

  public List<AwardEntity> getAwards() {
    return awards;
  }

  public void setAwards(List<AwardEntity> awards) {
    this.awards = awards;
  }


}
