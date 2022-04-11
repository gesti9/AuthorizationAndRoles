package kz.gesti9.authorizationandrolls.rest;
import kz.gesti9.authorizationandrolls.model.User;
import kz.gesti9.authorizationandrolls.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/users")
public class EmployeeRestController {

    @Autowired
    private final UserService userService;

    public EmployeeRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public List<User> findAll(){
        return userService.showAll();
    }

    @GetMapping("/create")
    public void createUserForm(User user){
    }

    @PostMapping("/create")
    @ResponseBody
    public void createUser(@RequestBody  User user, HttpServletRequest request){
        userService.saveUser(user,request.getRemoteAddr());

    }

    @GetMapping("/user-delete/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
    }

    @PostMapping("/update-user/{id}")
    @ResponseBody
    public void updateUser(@PathVariable("id") Long id, @RequestBody User user){
        User user1 = userService.findById(id);
        user1 = userService.saveUser(user,"name");
    }

}
