package md.vcroitor.licenta.server.controller;

import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class TestController {

    private static final Logger log = Logger.getLogger(TestController.class);
    @Resource(name = "mongoTemplate")
    MongoOperations mongoOperation;

    @RequestMapping(value = "/index")
    public String test() {

        User user = new User("vitalik", "password123");

        // save
        mongoOperation.save(user, "users");

        // find
        User savedUser = mongoOperation.findOne(new Query(Criteria.where("username").is("vitalik")), User.class, "users");

        log.info("Got: " + savedUser.getUsername() + "    " + savedUser.getPassword());
        return "index";
    }
}
