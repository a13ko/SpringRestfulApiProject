package com.ali.rest.webservices.restfulwebservices.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonversionongController {
    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Ali Gochaliyev");
    }
    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Ali","Gochaliyev"));
    }

    @GetMapping(value = "v1/person/param",params = "version=1")
    public PersonV1 PersonParamV1(){
        return new PersonV1("Ali Gochaliyev");
    }
    @GetMapping(value = "v2/person/param",params = "version=2")
    public PersonV2 PersonParamV2(){
        return new PersonV2(new Name("Ali","Gochaliyev"));
    }

    @GetMapping(value = "person/header",headers = "X-API-VERSION=1")
    public PersonV1 PersonHeaderV1(){
        return new PersonV1("Ali Gochaliyev");
    }
    @GetMapping(value = "person/header",headers = "X-API-VERSION=2")
    public PersonV2 PersonHeaderV2(){
        return new PersonV2(new Name("Ali","Gochaliyev"));
    }

    @GetMapping(value = "person/produces",produces = "application/vnd.company.app-v1+json")
    public PersonV1 PersonProducesV1(){
        return new PersonV1("Ali Gochaliyev");
    }
    @GetMapping(value = "person/produces",produces = "application/vnd.company.app-v2+json")
    public PersonV2 PersonProducesV2(){
        return new PersonV2(new Name("Ali","Gochaliyev"));
    }
}
