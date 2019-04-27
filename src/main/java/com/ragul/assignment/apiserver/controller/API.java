package com.ragul.assignment.apiserver.controller;

import com.ragul.assignment.apiserver.model.StateData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class API {


    @GetMapping(path = "codeToState")
    public ResponseEntity<String> codeToState(@RequestParam String code) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("code", code);

        ResponseEntity<StateData> responseEntity = new RestTemplate().getForEntity(
                "http://34.66.114.249:8000/codeToState/{code}", StateData.class,
                uriVariables);

        StateData response = responseEntity.getBody();
        if (isEmpty(response)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(response.getName());
    }

    @GetMapping(path = "stateToCode")
    public ResponseEntity<String> stateToCode(@RequestParam String state) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("state", state);

        ResponseEntity<StateData> responseEntity = new RestTemplate().getForEntity("http://34.66.114.249:8000/stateToCode/{state}", StateData.class, uriVariables);

        StateData response = responseEntity.getBody();
        if (isEmpty(response)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(response.getAbbreviation());
    }

    private boolean isEmpty(StateData stateData) {
        return stateData == null;
    }
}
