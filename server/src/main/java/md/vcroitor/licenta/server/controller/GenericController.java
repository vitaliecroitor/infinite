package md.vcroitor.licenta.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 11:58 AM
 */
@Controller
public class GenericController {

    @ExceptionHandler(Throwable.class)
    public void handleThrowable(){

    }

    @ExceptionHandler(Exception.class)
    public void handleException(){

    }

    @ExceptionHandler
    public void handleOther(){

    }
}
