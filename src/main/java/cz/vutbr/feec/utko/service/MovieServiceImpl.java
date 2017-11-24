package cz.vutbr.feec.utko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.vutbr.feec.utko.persistence.repository.MovieRepository;
import cz.vutbr.feec.utko.service.iface.MovieService;

/**
 * @author Pavel Seda
 *
 */
@Service
@Transactional
public class MovieServiceImpl implements MovieService {

  private MovieRepository movieRepository;

  @Autowired
  public MovieServiceImpl(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }
}
