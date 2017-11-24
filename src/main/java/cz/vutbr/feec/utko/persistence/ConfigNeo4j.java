package cz.vutbr.feec.utko.persistence;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Pavel Seda
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(CfgStrings.PERSISTENCE)
@EnableNeo4jRepositories(CfgStrings.PERSISTENCE_REPOSITORY)
@PropertySource(value = {"classpath:application.properties"}, ignoreResourceNotFound = true)
public class ConfigNeo4j {

  @Bean
  public SessionFactory getSessionFactory() {
    return new SessionFactory(configuration(), CfgStrings.PERSISTENCE_DOMAIN);
  }

  @Bean
  public Neo4jTransactionManager transactionManager() throws Exception {
    return new Neo4jTransactionManager(getSessionFactory());
  }

  @Bean
  public org.neo4j.ogm.config.Configuration configuration() {
    return new org.neo4j.ogm.config.Configuration.Builder().uri("bolt://localhost").build();
  }

  // To resolve ${} in @Value
  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
    return new PropertySourcesPlaceholderConfigurer();
  }
}

