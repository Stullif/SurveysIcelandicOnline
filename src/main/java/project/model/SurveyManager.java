package project.model;
import java.sql.*;
/*
 * Created by gudkj on 10/12/2015.
 */
public class SurveyManager {
    private String[] results;
    private DBConnector dbConnector;
    public String output;
    public SurveyManager() {
        this.dbConnector = new DBConnector();
        this.dbConnector.executeUpdate("INSERT INTO SURVEYS(id,surveyName,numQuestions) " +
                "VALUES (1,'FirstSurvey', '15')");
        results = this.dbConnector.executeQuery("SELECT * FROM SURVEYS");
        output = results[0];
    }
}
