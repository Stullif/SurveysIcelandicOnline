package project.model;
import java.sql.*;
import java.util.ArrayList;

/*
 * Created by gudkj on 10/12/2015.
 */
public class SurveyManager {
    private ArrayList<String> results;
    private DBConnector dbConnector;
    public String output;
    private Survey workingSurvey;
    public SurveyManager() {
        this.dbConnector = new DBConnector();
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
    public ArrayList<Survey> getSurveyList() {
        ArrayList<Survey> list = this.getAllSurveys();
        return list;
    }
    public ArrayList<Survey> getAllSurveys() {
        ArrayList<Survey> list = dbConnector.executeQuery("SELECT * FROM Surveys");
        return list;
    }

    public static Survey parseSurvey(String name, String numQuestions) {
        return new Survey(name);
    }
    public boolean saveWorkingSurvey() {
        String name = this.workingSurvey.getName();
        String sql = "INSERT INTO SURVEYS(surveyName,numQuestions) " + "VALUES ('"+name+"', '15')";
        this.dbConnector.executeUpdate(sql);
        return true;
    }
}
