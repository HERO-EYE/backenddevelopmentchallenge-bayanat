package sakhbouri.abdulaziz.backenddevelopmentchallenge;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RESTClient {

    private String server = "https://byanat.wiremockapi.cloud/api/v1/towers";
    private RestTemplate rest;
    private HttpHeaders headers;
    private HttpStatusCode status;
    List<Tower> towers;
    public RESTClient() {
        this.rest = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
    }

    // a method to get all towers data
    public String getAll() {
        HttpEntity<Tower[]> requestEntity = new HttpEntity<Tower[]>(null, headers);
        ResponseEntity<Tower[]> responseEntity = rest.exchange(server, HttpMethod.GET, requestEntity, Tower[].class);
        towers  = Arrays.stream(responseEntity.getBody()).toList();

        return towers.toString();
    }

    // a method to get towers filtered data
    public String getData(Map<String,String> jsonmap) {

        if (towers == null || towers.isEmpty()) {
            getAll();
        }

        List<Tower> filtered_towers = new ArrayList<>();

        if(jsonmap.size()>0) {
            int tower_id = 0;
            String networkoperator = null;
            String technology = null;
            String tower_type = null;
            if (jsonmap.containsKey("tower_id")) tower_id = Integer.parseInt(jsonmap.get("tower_id"));
            if (jsonmap.containsKey("networkoperator")) networkoperator = jsonmap.get("networkoperator");
            if (jsonmap.containsKey("technology")) technology = jsonmap.get("technology");
            if (jsonmap.containsKey("tower_type")) tower_type = jsonmap.get("tower_type");
            
            for(int i=0 ; i<towers.size(); i++) {
                if (tower_id>0 && networkoperator!=null && technology!=null && tower_type!=null) {
                    if (towers.get(i).getTower_id()==tower_id && towers.get(i).getOperator().equals(networkoperator) && towers.get(i).getTechnology().equals(technology) && towers.get(i).getTower_type().equals(tower_type)) {
                        filtered_towers.add(towers.get(i));
                    }
                } else if (tower_id>0 && networkoperator!=null && technology!=null) {
                    if (towers.get(i).getTower_id()==tower_id && towers.get(i).getOperator().equals(networkoperator) && towers.get(i).getTechnology().equals(technology)) {
                        filtered_towers.add(towers.get(i));
                    }
                } else if (tower_id>0 && networkoperator!=null && tower_type!=null) {
                    if (towers.get(i).getTower_id()==tower_id && towers.get(i).getOperator().equals(networkoperator) && towers.get(i).getTower_type().equals(tower_type)) {
                        filtered_towers.add(towers.get(i));
                    }
                } else if (networkoperator!=null && tower_type!=null && technology!=null) {
                    if (towers.get(i).getOperator().equals(networkoperator) && towers.get(i).getTechnology().equals(technology) && towers.get(i).getTower_type().equals(tower_type)) {
                        filtered_towers.add(towers.get(i));
                    }
                } else if (tower_id>0 && networkoperator!=null) {
                    if (towers.get(i).getTower_id()==tower_id && towers.get(i).getOperator().equals(networkoperator)) {
                        filtered_towers.add(towers.get(i));
                    }
                } else if (tower_id>0 && technology!=null) {
                    if (towers.get(i).getTower_id()==tower_id && towers.get(i).getTechnology().equals(technology)) {
                        filtered_towers.add(towers.get(i));
                    }
                } else if (tower_id>0 && tower_type!=null) {
                    if (towers.get(i).getTower_id()==tower_id && towers.get(i).getTower_type().equals(tower_type)) {
                        filtered_towers.add(towers.get(i));
                    }
                } else if (networkoperator!=null && technology!=null) {
                    if (towers.get(i).getOperator().equals(networkoperator) && towers.get(i).getTechnology().equals(technology)) {
                        filtered_towers.add(towers.get(i));
                    }
                } else if (networkoperator!=null && tower_type!=null) {
                    if (towers.get(i).getOperator().equals(networkoperator) && towers.get(i).getTower_type().equals(tower_type)) {
                        filtered_towers.add(towers.get(i));
                    }
                } else if (technology!=null && tower_type!=null) {
                    if (towers.get(i).getTower_type().equals(tower_type) && towers.get(i).getTechnology().equals(technology)) {
                        filtered_towers.add(towers.get(i));
                    }
                } else if (tower_id>0) {
                    if (towers.get(i).getTower_id()==tower_id) {
                        filtered_towers.add(towers.get(i));
                    }
                } else if (networkoperator!=null) {
                    if (towers.get(i).getOperator().equals(networkoperator)) {
                        filtered_towers.add(towers.get(i));
                    }
                } else if (technology!=null) {
                    if (towers.get(i).getTechnology().equals(technology)) {
                        filtered_towers.add(towers.get(i));
                    }
                } else if (tower_type!=null) {
                    if (towers.get(i).getTower_type().equals(tower_type)) {
                        filtered_towers.add(towers.get(i));
                    }
                }
            }
        } else {
            filtered_towers = towers;
        }

        return filtered_towers.toString();
    }

}
