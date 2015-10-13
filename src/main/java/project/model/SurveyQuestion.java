package project.model;

import java.util.ArrayList;

/**
 * Created by gudkj on 10/12/2015.
 */
public class SurveyQuestion {
    private String question;
    private ArrayList<String> options;
    private String type;
    public SurveyQuestion(String question, ArrayList<String> options, String type) {
        this.question = question;
        this.options = options;
        this.type = type;
    }
}
