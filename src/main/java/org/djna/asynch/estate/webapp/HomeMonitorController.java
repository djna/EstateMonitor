package org.djna.asynch.estate.webapp;


import org.apache.log4j.Logger;
import org.djna.asynch.estate.data.ThermostatReading;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

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

    @GetMapping("/myproperty")
    public String myProperty(
            @RequestParam(name="property", required=false, defaultValue="101") String property,
            @RequestParam(name="locationSelected", required=false, defaultValue="hall") String location,
            Model model) {
        LOGGER.info("monitor " + property + "/" + location);
        model.addAttribute("property", property);
        model.addAttribute("location", location);
        ThermostatReading reading = new ThermostatReading(property, new Date(), -5,location);
        model.addAttribute("reading",reading);
        return "myproperty";
    }
}
