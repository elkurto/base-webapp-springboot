package a.b.basewebappsb.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/book")
public class ControllerBook {

    @GetMapping("/")
    public String index() {
        return "This is the /book controller";
    }
}
