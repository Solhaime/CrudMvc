package SpringBootCrudApp.web.controllers.RestTestControllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test( Authentication authentication ){
       return String.valueOf(authentication.getAuthorities().stream().filter(grantedAuthority -> grantedAuthority.getAuthority().equals("ADMIN")).count());
    }

/*    @PostMapping("admin/users/add")
    public String testTest(@RequestParam("username") String username ){
        return username;
    }*/
}
