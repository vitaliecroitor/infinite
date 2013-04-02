package md.vcroitor.licenta.server.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    private static final Logger log = Logger.getLogger(TestController.class);

    @RequestMapping(value = "/test")
    public String test() {
        log.info("test test");
        return "index";
    }
}
