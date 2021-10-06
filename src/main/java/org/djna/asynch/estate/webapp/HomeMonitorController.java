package org.djna.asynch.estate.webapp;


import org.djna.asynch.estate.data.loginRequest;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/test")
    public String test() {
        return "Hello there";
    }

    @PostMapping("/login")
    public loginResponse login(@RequestBody loginRequest req) {
        if (req.getUsername().equals("max")) {
            return new loginResponse(true);
        }
        return new loginResponse(false);
    }



    public class loginResponse {
        boolean loggedIn;
        String message;

        public loginResponse(boolean correctDetails) {
            if (correctDetails) {
                this.loggedIn = true;
                this.message = "test";
            } else {
                this.loggedIn = false;
                this.message = "failed to log in";
            }
        }

        public boolean isLoggedIn() {
            return loggedIn;
        }

        public void setLoggedIn(boolean loggedIn) {
            this.loggedIn = loggedIn;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
