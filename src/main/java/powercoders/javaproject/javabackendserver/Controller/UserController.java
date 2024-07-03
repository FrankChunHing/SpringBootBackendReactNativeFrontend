package powercoders.javaproject.javabackendserver.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import powercoders.javaproject.javabackendserver.Modal.TradeAndOrder;
import powercoders.javaproject.javabackendserver.Modal.User;
import powercoders.javaproject.javabackendserver.Repository.IUserRepository;
import powercoders.javaproject.javabackendserver.backup.UserCash;
import powercoders.javaproject.javabackendserver.Service.UserCashService;
import powercoders.javaproject.javabackendserver.Service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController { // main part of controller RESTapi

    private final UserService userService;
    private final UserCashService userCashService;
    private final IUserRepository UserRepository;

    @Autowired
    public UserController(UserService userService, UserCashService userCashService, IUserRepository UserRepository) {
        this.userService = userService;
        this.userCashService = userCashService;
        this.UserRepository = UserRepository;
    }

    @PostMapping("/api/v1/user/login")
    public String login(@RequestBody User user) {

        return userService.login(user);
    }

    @PostMapping("/api/v1/user/register")
    public String register(@RequestBody User user) {

        return userService.register(user);
    }


    @GetMapping("/users/{name}")
    public Optional<User> getUserInfo(@PathVariable String name) {
        return userService.getUserByUsername(name);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/{username}/trades")
    public ResponseEntity<User> addTradeToUser(@PathVariable String username, @RequestBody TradeAndOrder trade) {
        User updatedUser = userService.addTradeToUser(username, trade);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

//    @GetMapping("/")
//    public List<User> login() {
//        return userService.login();
//    }

    @GetMapping("/api/v1/user/cash")
    public List<UserCash> whatevernamefunction(){

        return UserCashService.getCash();
    }




    @GetMapping("/users")
    public List<User> getUsers() {
//        User user = new User(4, "John", "Doe");
//        userRepository.save(user);
//        User user2 = new User(5, "123", "asxdv");
//        userService.saveUser(user2);
        return UserRepository.findAll();
    }



}
