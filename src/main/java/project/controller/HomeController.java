package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.model.SurveyManager;
import project.model.Survey;
import project.service.StringManipulationService;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    // Instance Variables
    StringManipulationService stringService;
    static SurveyManager surveyManager = new SurveyManager();
    private String[] options = new String[]{"Drop Down Menu","Radio Button","Text Input","Multiple Choice"};
    private ArrayList<String> populateDropDownList(String[] input) {
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < input.length; i++) {
            list.add(input[i]);
        }
        return list;
    }
    // Dependency Injection
    @Autowired
    public HomeController(StringManipulationService stringService) {
        this.stringService = stringService;
    }

    // Request mapping is the path that you want to map this method to
    // In this case, the mapping is the root "/", so when the project
    // is running and you enter "localhost:8080" into a browser, this
    // method is called
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        // The string "Index" that is returned here is the name of the view
        // (the Index.jsp file) that is in the path /main/webapp/WEB-INF/jsp/
        // If you change "Index" to something else, be sure you have a .jsp
        // file that has the same name
        return "Index";
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String home(Model model) {
        // The string "Index" that is returned here is the name of the view
        // (the Index.jsp file) that is in the path /main/webapp/WEB-INF/jsp/
        // If you change "Index" to something else, be sure you have a .jsp
        // file that has the same name
        model.addAttribute("name", "");
        return "User";
    }

    @RequestMapping(value = "/surveycreator", method = RequestMethod.GET)
    public String surveycreator(@RequestParam("name") String name, Model model) {
        ArrayList<String> list = this.populateDropDownList(this.options);
        model.addAttribute("optionList", list);
        model.addAttribute("survey", surveyManager.startSurveyCreation(name));
        return "SurveyCreator";
    }
    @RequestMapping(value = "/surveycreator", method = RequestMethod.POST)
    public String surveycreator(HttpServletRequest request, Model model) {
        surveyManager.setSurveyFinished(null != request.getParameter("finished"));
        if(surveyManager.isSurveyFinished()) {
            return "CreationComplete";
        }
        String question = request.getParameter("question").trim();
        String type = request.getParameter("typeQuestion").trim();
        ArrayList<String> options = new ArrayList<String>(); //REPLACE

        surveyManager.addSurveyQuestion(question, type, options);

        ArrayList<String> list = this.populateDropDownList(this.options);

        model.addAttribute("optionList", list);
        model.addAttribute("survey", surveyManager.getWorkingSurvey());
        return "SurveyCreator";
    }
    @RequestMapping(value = "/surveyviewer", method = RequestMethod.GET)
    public String surveyviewer(Model model) {
        model.addAttribute("surveys", surveyManager.getSurveyList());
        return "SurveyViewer";
    }
    @RequestMapping(value = "/surveyviewer", method = RequestMethod.POST)
    public String surveyviewer(Model model, HttpServletRequest request) {
        boolean saved = surveyManager.saveWorkingSurvey();
        if(!saved) System.out.println("Survay dun bin fucked");
        model.addAttribute("surveys",surveyManager.getSurveyList());
        return "SurveyViewer";
    }
}
