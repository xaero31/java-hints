package rest.spring;

import jpa.springboot.hibernate.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

/**
 * created by Nikita_Ermakov at 12/6/2019
 */
@RequestMapping("/rest")
@SpringBootApplication
public class SpringRestDemo {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestDemo.class, args);
    }

    @GetMapping(path = "/hello/{name}", produces = "text/plain")
    @ResponseBody
    public String helloName(@PathVariable(name = "name") String name) {
        return String.format("Hello, %s", name);
    }

    @PostMapping(path = "/getUserName")
    @ResponseBody
    public String extractUserName(@RequestBody User user) {
        return user == null ? "null user" : user.getName();
    }

    @GetMapping(path = "/param", produces = "text/plain")
    @ResponseBody
    public String getNameFromParam(String name) {
        return String.format("Param name is %s", name);
    }
}
