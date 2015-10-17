package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.persistence.entities.Survey;
import project.persistence.repositories.SurveyRepository;
import project.service.SurveyService;

import java.util.Collections;
import java.util.List;

/**
 * Created by Jakob on 17.10.2015.
 */

//@Service
public class SurveyImplementation implements SurveyService {

    // Instance Variables
    SurveyRepository repository;

    // Dependency Injection
    //@Autowired
    public SurveyImplementation(SurveyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Survey save(Survey survey) {
        return repository.save(survey);
    }

    @Override
    public void delete(Survey survey) {
        repository.delete(survey);
    }

    @Override
    public List<Survey> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Survey> findAllReverseOrder() {
        // Get all the surveys
        List<Survey> surveys = repository.findAll();

        // Reverse the list
        Collections.reverse(surveys);

        return surveys;
    }

    @Override
    public Survey findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Survey> findByName(String name) {
        return repository.findByName(name);
    }
}

