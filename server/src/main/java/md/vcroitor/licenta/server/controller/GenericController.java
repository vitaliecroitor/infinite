package md.vcroitor.licenta.server.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 11:58 AM
 */
@Controller
public class GenericController {

    private static final Logger log = Logger.getLogger(GenericController.class);

    @ExceptionHandler(Throwable.class)
    public void handleThrowable(){

    }

    @ExceptionHandler(Exception.class)
    public void handleException(){

    }

    @ExceptionHandler
    public void handleOther(Throwable th){
        log.info(Arrays.toString(th.getStackTrace()));
    }
}
