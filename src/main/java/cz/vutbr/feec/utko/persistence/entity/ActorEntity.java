package cz.vutbr.feec.utko.persistence.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author Pavel Seda
 *
 */
@NodeEntity(label = "Actor")
public class ActorEntity {
  @Id
  @GeneratedValue
  private Long id;
  private String name;
  @Relationship(type = "ACTED_IN")
  private Set<MovieEntity> actedIn = new HashSet<>();
  @Relationship(type = "AWARD")
  private List<AwardEntity> awards = new ArrayList<>();
  /**
   * Neo4j doesn't REALLY have bi-directional relationships. It just means when querying to ignore
   * the direction of the relationship. https://dzone.com/articles/modelling-data-neo4j
   */
  @Relationship(type = "TEAMMATE", direction = Relationship.UNDIRECTED)
  public Set<ActorEntity> teammates;

  public ActorEntity() {}

  public ActorEntity(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void worksWith(ActorEntity person) {
    if (teammates == null) {
      teammates = new HashSet<>();
    }
    teammates.add(person);
  }

  public String toString() {
    return this.name + "'s teammates => "
        + Optional.ofNullable(this.teammates).orElse(Collections.emptySet()).stream()
            .map(person -> person.getName()).collect(Collectors.toList());
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<MovieEntity> getActedIn() {
    return actedIn;
  }

  public void setActedIn(Set<MovieEntity> actedIn) {
    this.actedIn = actedIn;
  }

  public List<AwardEntity> getAwards() {
    return awards;
  }

  public void setAwards(List<AwardEntity> awards) {
    this.awards = awards;
  }

  public Set<ActorEntity> getTeammates() {
    return teammates;
  }

  public void setTeammates(Set<ActorEntity> teammates) {
    this.teammates = teammates;
  }


}
