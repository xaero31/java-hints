package rest.spring;

import jpa.hibernate.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

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
    public String getNameFromParam(@RequestParam String name) {
        return String.format("Param name is %s", name);
    }

    @GetMapping(path = "/error")
    @ResponseBody
    public Response getErrorStatus() {
        return Response.status(Response.Status.GATEWAY_TIMEOUT)
                .entity(new User(1337, "pidor", "pidorov", null))
                .build();
    }

    @GetMapping(path = "/okResponse")
    @ResponseBody
    public Response getOkResponse(@RequestParam(name = "msg", defaultValue = "default") String message) {
        return Response.ok(String.format("Input string is %s", message)).build();
    }

    @GetMapping(path = "/okResponseEntity")
    @ResponseBody
    public ResponseEntity<String> getOkResponseEntity(
            @RequestParam(name = "msg", defaultValue = "default") String message) {
        return ResponseEntity.ok(String.format("Input string is %s", message));
    }
}
