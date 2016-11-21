package lampquest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Main MVC controller.
 *
 * @author Craig, Connor, Philip, & John
 * @version 1.0
 * @since 10/12/2016
 */
@Controller
public class MainController {

    /**
     * Serves the home page.
     * 
     * @return the UI home page
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}

