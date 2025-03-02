package com.mtoaima.internationalization_and_versioning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtoaima.internationalization_and_versioning.entity.Name;
import com.mtoaima.internationalization_and_versioning.entity.PersonV1;
import com.mtoaima.internationalization_and_versioning.entity.PersonV2;

@RestController
@RequestMapping("/versioning") 
public class VersioningContoller {

    // Versioning using URL Path
    @GetMapping("/url/v1/person")
    public PersonV1 getFirstVersionOfPersonBasedOnURl() {
        return new PersonV1("Mostafa Ibrahim"); // Return PersonV1 with full name as a String
    }

    @GetMapping("/url/v2/person")
    public PersonV2 getSecondVersionOfPersonBasedOnURl() {
        return new PersonV2(new Name("Mostafa", "Ibrahim")); // Return PersonV2 with a structured Name object
    }

    // Versioning using Request Parameters
    @GetMapping(path = "/params/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonBasedOnParamter() {
        return new PersonV1("Mostafa Ibrahim");
    }

    @GetMapping(path = "/params/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonBasedOnParamter() {
        return new PersonV2(new Name("Mostafa", "Ibrahim"));
    }

    // Versioning using Headers
    @GetMapping(path = "/headers/person", headers = "x-api-version=1")
    public PersonV1 getFirstVersionOfPersonBasedOnHeaders() {
        return new PersonV1("Mostafa Ibrahim");
    }

    @GetMapping(path = "/headers/person", headers = "x-api-version=2")
    public PersonV2 getSecondVersionOfPersonBasedOnHeaders() {
        return new PersonV2(new Name("Mostafa", "Ibrahim"));
    }

    // Versioning using Media Type (a.k.a. Content Negotiation)
    @GetMapping(path = "/mediatpye/person", produces ="application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonBasedOMediaType() {
        return new PersonV1("Mostafa Ibrahim");
    }

    @GetMapping(path = "/mediatpye/person", produces ="application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonBasedOnMediaType() {
        return new PersonV2(new Name("Mostafa", "Ibrahim"));
    }
}
