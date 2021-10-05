package org.djna.asynch.estate.webapp;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeMonitorController {
    static private Logger LOGGER = Logger.getLogger(HomeMonitorController.class);
    // enable simple server test
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    // display page that subscribes to one topic
    @GetMapping("/monitor")
    public String monitor(
            @RequestParam(name="property", required=false, defaultValue="101") String property,
            @RequestParam(name="locationSelected", required=false, defaultValue="hall") String location,
            Model model) {
        LOGGER.info("monitor " + property + "/" + location);
        model.addAttribute("property", property);
        model.addAttribute("location", location);
        model.addAttribute("topic", "home/thermostats/" + property + "/" + location);
        return "monitor";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/authenticate")
    public String authenticate(
        @RequestParam(name="username", required=true) String name,
        @RequestParam (name="password", required=true) String password,
        Model model) {
        System.out.println(name);
        System.out.println(password);
        return "estateowner";
    }
}
