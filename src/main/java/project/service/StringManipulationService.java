package project.service;

import org.springframework.stereotype.Service;

/**
 * Service class that has methods for String Manipulation
 *
 * DISCLAIMER:  This class is just for demonstration purposes,
 *              something basic as this would be handled where it is needed
 */
@Service
public class StringManipulationService {

    /**
     * Returns the string that is passed to the method in Upper Case
     * @param string String to convert to Upper Case
     * @return String
     */
    public String convertStringToUpperCase(String string){
        return string.toUpperCase();
    }

    /**
     * Returns the string that is passed to the method in Lower Case
     * @param string String to convert to Lower Case
     * @return String
     */
    public String convertStringToLowerCase(String string){
        return string.toLowerCase();
    }

    /**
     * Returns the string that is passed to the method with the First Character in Upper Case
     * @param string String to have its first character converted to Upper Case
     * @return String
     */
    public String convertsFirstCharInStringToUpperCase(String string){
        return string.substring(0,1).toUpperCase() + string.substring(1);
    }
    public String removeSpacesFromString(String string) {
        if(string.length() <= 1) return string;
        while(true) {
            int whereSpace = string.indexOf(" ");
            if(whereSpace < 0) break;
            string = string.substring(0,whereSpace)+string.substring(whereSpace);
        }
        return string;
    }
}
