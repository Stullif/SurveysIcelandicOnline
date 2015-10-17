package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.persistence.entities.Survey;

import java.util.List;
/**
 * Created by Jakob on 17.10.2015.
 */
/**
 * By extending the {@link JpaRepository} we have access to powerful methods.
 * http://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
 * http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 *
 */
public interface SurveyRepository extends JpaRepository<Survey, Long> {

    Survey save(Survey survey);

    void delete(Survey survey);

    List<Survey> findAll();

    // If we need a custom query that maybe doesn't fit the naming convention used by the JPA repository,
    // then we can write it quite easily with the @Query notation, like you see below.
    //@Query(value = "SELECT p FROM Survey p ")
    List<Survey> findAllSurveys();

    List<Survey> findAllByOrderByIdDesc();

    Survey findById(Long id);

    List<Survey> findByName(String name);

}


