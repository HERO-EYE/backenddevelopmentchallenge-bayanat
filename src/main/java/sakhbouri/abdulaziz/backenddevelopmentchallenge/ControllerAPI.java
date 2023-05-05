package sakhbouri.abdulaziz.backenddevelopmentchallenge;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
public class ControllerAPI implements ErrorController {

    // create new RESTClient object
    RESTClient restClient = new RESTClient();

    // create RequestMapping for "/challenge/towers"
    @RequestMapping(value="/challenge/towers")
    public String towers(@RequestParam("tower_id") Optional<Integer> tower_id, @RequestParam("networkoperator") Optional<String> networkoperator, @RequestParam("technology") Optional<String> technology, @RequestParam("tower_type") Optional<String> tower_type) {
        Map<String,String> jsonmap = new HashMap<>();

        // check each parameter , then read the parameter and store it to jsonmap
        if( tower_id.isPresent()) jsonmap.put("tower_id" , tower_id.get().toString());
        if( networkoperator.isPresent()) jsonmap.put("networkoperator" , networkoperator.get());
        if( technology.isPresent()) jsonmap.put("technology" , technology.get());
        if( tower_type.isPresent()) jsonmap.put("tower_type" , tower_type.get());

        // pass GET/POST parameters(jsonmap) to getData method, then return the response body
        return restClient.getData(jsonmap);
    }

    // HTTP Errors Handling
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        Map error = new HashMap();

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());


            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                error.put("timestamp", new Date().toString());
                error.put("status", statusCode);
                error.put("error", "Not Found");
                return error.toString();
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                error.put("timestamp", new Date().toString());
                error.put("status", statusCode);
                error.put("error", "Server Error");
                return error.toString();
            }
        }
        error.put("timestamp", new Date().toString());
        error.put("error", "Unknown Error");
        return error.toString();
    }

}
