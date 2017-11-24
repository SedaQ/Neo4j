package cz.vutbr.feec.utko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.vutbr.feec.utko.persistence.repository.ActorRepository;
import cz.vutbr.feec.utko.service.iface.ActorService;

/**
 * @author Pavel Seda
 *
 */
@Service
@Transactional
public class ActorServiceImpl implements ActorService {

  private ActorRepository actorRepository;

  @Autowired
  public ActorServiceImpl(ActorRepository actorRepository) {
    this.actorRepository = actorRepository;
  }
}
