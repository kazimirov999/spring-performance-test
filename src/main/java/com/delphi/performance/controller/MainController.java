package com.delphi.performance.controller;

import com.codahale.metrics.annotation.Timed;
import com.delphi.performance.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kazimirov on 7/24/17.
 */
@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> index() {

        return new ResponseEntity<>("This is a performance test service, use '/factorial' rest", HttpStatus.OK);
    }

    @Timed
    @RequestMapping(value = "/factorial", method = RequestMethod.GET)
    public ResponseEntity<String> countFactorial(@RequestParam long n) {

        return new ResponseEntity<String>("Factorial = "+ businessService.countFactorial(n), HttpStatus.OK);
    }
}
