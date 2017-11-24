package cz.vutbr.feec.utko.persistence.entity;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;


/**
 * @author Pavel Seda
 *
 */
@RelationshipEntity(type = "AWARD")
public class AwardEntity {

  @Id
  @GeneratedValue
  private Long id;
  @StartNode
  ActorEntity actor;
  @EndNode
  MovieEntity movie;

  private String award;
  private int year;

  public AwardEntity() {}

  public AwardEntity(ActorEntity actor, MovieEntity movie, String award, int year) {
    this.actor = actor;
    this.movie = movie;
    this.award = award;
    this.year = year;

    this.actor.getAwards().add(this);
    this.movie.getAwards().add(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public ActorEntity getActor() {
    return actor;
  }

  public void setActor(ActorEntity actor) {
    this.actor = actor;
  }

  public MovieEntity getMovie() {
    return movie;
  }

  public void setMovie(MovieEntity movie) {
    this.movie = movie;
  }

  public String getAward() {
    return award;
  }

  public void setAward(String award) {
    this.award = award;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

}
