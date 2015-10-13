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
    public String output;
    public String password = "hoppilius4";
    public String dbLink = "jdbc:postgresql://localhost:5432/Surveys";
    public DBConnector() {
        c = null;
        st = null;
        resultSet = null;
        String sql = "CREATE TABLE IF NOT EXISTS SURVEYS " +
                "(id INTEGER not NULL, " +
                " surveyName VARCHAR(255), " +
                " numQuestions VARCHAR(255), " +
                " PRIMARY KEY ( id ))";
        try{
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(dbLink, "postgres", password);
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
    public String[] executeQuery(String sql) {
        c = null;
        st = null;
        resultSet = null;
        try{
            Class.forName("org.postgresql.Driver");
            this.c = DriverManager.getConnection(dbLink, "postgres", password);
            this.st = c.createStatement();
            this.resultSet = st.executeQuery(sql);
            this.results = new ArrayList<String>();
            while(this.resultSet.next()) {
                results.add(this.resultSet.getString("surveyName")+ "\t" + resultSet.getString("numQuestions"));
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
        return this.results.toArray(new String[results.size()]);
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
