package cz.vutbr.feec.utko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.vutbr.feec.utko.persistence.repository.UserRepository;
import cz.vutbr.feec.utko.service.iface.UserService;

/**
 * @author Pavel Seda
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
}
