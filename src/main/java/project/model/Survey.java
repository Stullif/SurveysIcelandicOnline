package project.model;
import java.util.ArrayList;

/**
 * Created by gudkj on 10/12/2015.
 */
public class Survey {
    private boolean finished = false;
    private String name;
    private int questionCounter = 0;
    private ArrayList<SurveyQuestion> questions = new ArrayList<SurveyQuestion>();
    public Survey() {

    }
    public Survey(String name) {
        this.name = name;
    }
    public void addSurveyQuestion(String question, String type, ArrayList<String> options) {
        this.addSurveyQuestion(new SurveyQuestion(question, options, type));
    }
    public ArrayList<SurveyQuestion> getQuestions() {
        return this.questions;
    }
    public void addSurveyQuestion(SurveyQuestion question) {
        this.questions.add(question);
        this.questionCounter++;
    }
    public int getNumQuestions() {
        return this.questionCounter;
    }
    public boolean isFinished() {
        return this.finished;
    }
    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
