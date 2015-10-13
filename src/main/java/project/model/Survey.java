package project.model;
import java.util.ArrayList;

/**
 * Created by gudkj on 10/12/2015.
 */
public class Survey {
    private boolean finished = false;
    private ArrayList<SurveyQuestion> questions = new ArrayList<SurveyQuestion>();

    public Survey() {

    }
    public void addSurveyQuestion(SurveyQuestion question) {
        this.questions.add(question);
    }
    public boolean isFinished() {
        return this.finished;
    }
    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
