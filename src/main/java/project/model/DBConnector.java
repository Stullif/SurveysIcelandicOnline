package project.model;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by gudkj on 10/12/2015.
 */
public class DBConnector {
    private Connection c;
    private Statement st;
    private ResultSet resultSet;
    private ArrayList<String> results;
    private ArrayList<Survey> surveys;
    public String user = "postgres";
    public String password = "Enter your password here";
    public String dbLink = "jdbc:postgresql://localhost:5432/Surveys";
    public DBConnector() {
        c = null;
        st = null;
        resultSet = null;
        String sql = "CREATE TABLE IF NOT EXISTS SURVEYS " +
                "(id SERIAL, " +
                " surveyName VARCHAR(255), " +
                " numQuestions VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(dbLink, user, password);
            st = c.createStatement();
            st.executeUpdate("DROP TABLE IF EXISTS SURVEYS");
            st.executeUpdate(sql);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if (c != null) {
                    if(st != null) st.close();
                    if(resultSet != null)resultSet.close();
                    c.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public ArrayList<Survey> executeQuery(String sql) {
        c = null;
        st = null;
        resultSet = null;
        try{
            Class.forName("org.postgresql.Driver");
            this.c = DriverManager.getConnection(dbLink, "postgres", password);
            this.st = c.createStatement();
            this.resultSet = st.executeQuery(sql);
            this.results = new ArrayList<String>();
            this.surveys = new ArrayList<Survey>();
            while(this.resultSet.next()) {
                String name = this.resultSet.getString("surveyName"),
                        numQuestions = resultSet.getString("numQuestions");
                this.results.add(name + "\t" + numQuestions);
                this.surveys.add(SurveyManager.parseSurvey(name, numQuestions));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if (c != null) {
                    if(st != null) st.close();
                    if(resultSet != null)resultSet.close();
                    c.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.surveys;
    }
    public void executeUpdate(String sql) {
        c = null;
        st = null;
        resultSet = null;
        try{
            Class.forName("org.postgresql.Driver");
            this.c = DriverManager.getConnection(dbLink, "postgres", password);
            this.st = c.createStatement();

            st.executeUpdate(sql);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if (c != null) {
                    if (st != null) st.close();
                    if (resultSet != null) resultSet.close();
                    c.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
