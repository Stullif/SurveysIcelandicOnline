package project.model;
import java.sql.*;
/*
 * Created by gudkj on 10/12/2015.
 */
public class SurveyManager {
    private static Connection c;
    private static Statement st;
    private static ResultSet resultSet;
    public String output;
    public String password = "Enter pass here";
    public String dbLink = "jdbc:postgresql://localhost:5432/Surveys";
    public SurveyManager() {
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
            c = DriverManager.getConnection(dbLink,"postgres",password);
            st = c.createStatement();
            st.executeUpdate("DROP TABLE IF EXISTS SURVEYS");
            st.executeUpdate(sql);

            sql = "INSERT INTO SURVEYS(id,surveyName,numQuestions) " +
                    "VALUES (1,'FirstSurvey', '15')";
            st.executeUpdate(sql);

            sql = "SELECT * FROM SURVEYS";
            resultSet = st.executeQuery(sql);
            while(resultSet.next()) {
                this.output = resultSet.getString("surveyName")+ "\t" + resultSet.getString("numQuestions");
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
    }
}
