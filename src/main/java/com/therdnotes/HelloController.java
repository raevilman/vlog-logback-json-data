package com.therdnotes;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

@Controller
public class HelloController {

    Logger log = LoggerFactory.getLogger("HelloController");

    @Get("/hello")
    public String sayHello() {
        try {
            String reqID = UUID.randomUUID().toString();
            MDC.put("reqId", reqID);
            log.info("Request received");
            // DO SOME WORK
            log.info("Returning response");
            return "Hello";
        } finally {
            MDC.clear();
        }
    }
}
