package org.djna.asynch.estate.webapp;


import com.google.gson.JsonObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class HomeMonitorController {

    @GetMapping(value = "/greeting")
    public HashMap<String, String> monitor()
    {
        HashMap<String, String> output = new HashMap<>();
        output.put("property", "101");
        output.put("locationSelected", "hall");
        output.put("topic",  "home/thermostats/101/hall");
        System.out.println(output);
        return output;
    }
}
