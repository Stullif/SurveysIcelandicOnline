package project.model;
import java.sql.*;
import java.util.ArrayList;

/*
 * Created by gudkj on 10/12/2015.
 */
public class SurveyManager {
    private String[] results;
    private DBConnector dbConnector;
    public String output;
    private Survey workingSurvey;
    public SurveyManager() {
        this.dbConnector = new DBConnector();
        this.dbConnector.executeUpdate("INSERT INTO SURVEYS(id,surveyName,numQuestions) " +
                "VALUES (1,'FirstSurvey', '15')");
        results = this.dbConnector.executeQuery("SELECT * FROM SURVEYS");
        output = results[0];
    }
    public Survey startSurveyCreation(String name) {
        this.workingSurvey = new Survey(name);
        return this.workingSurvey;
    }
    public void addSurveyQuestion(String name, String type, ArrayList<String> options) {
        this.workingSurvey.addSurveyQuestion(name, type, options);
    }
    public Survey getWorkingSurvey() {
        return this.workingSurvey;
    }
    public void setSurveyFinished(boolean finished) {
        this.workingSurvey.setFinished(finished);
    }
    public boolean isSurveyFinished() {
        return this.workingSurvey.isFinished();
    }
}
