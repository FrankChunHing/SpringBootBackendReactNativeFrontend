package powercoders.javaproject.javabackendserver.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import powercoders.javaproject.javabackendserver.Exceptions.UsernameNotAvailableException;
import powercoders.javaproject.javabackendserver.Modal.TradeAndOrder;
import powercoders.javaproject.javabackendserver.Modal.User;
import powercoders.javaproject.javabackendserver.Repository.IUserRepository;

import java.util.Optional;

@Service //  logic in application
public class UserService {

    private final IUserRepository UserRepository;

    @Autowired
    public UserService(IUserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public String login(User user) {
        Optional<User> checkUserAndPassword = UserRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (checkUserAndPassword.isPresent()) {
            return user.getUsername();
        } else {
            return "login failed";
        }
    }

    public String register(User user) {
        Optional<User> existingUser = UserRepository.findByUsername(user.getUsername());
        System.out.println(user.getUsername());
        System.out.println(existingUser.isPresent());
        if (existingUser.isPresent()) {
            throw new UsernameNotAvailableException();
        } else {
            UserRepository.save(user);
            return "User registered successfully. Your username:" + user.getUsername();
        }
    }

    public User addTradeToUser(String username, TradeAndOrder trade) {
        Optional<User> userOptional = UserRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            trade.setUser(user);
            trade.setUsername(user.getUsername());
            user.getTradesAndOrders().add(trade);
            UserRepository.save(user);
            return user;
        } else {
            System.out.println("User not found: " + username);
            return null;
        }
    }

    public Optional<User> getUserByUsername(String username) {
        return UserRepository.findByUsername(username);
    }

    public void deleteUser(Long id) {
        UserRepository.deleteById(id);
    }

//    public List<User> login() {
//        return List.of(
//                new User(1L,"admin","password"),
//                new User("User", "123123")
//        );
//    }


//    public String register(User user) {
//        try {
//            userRepository.save(user);
//            return "User registered successfully";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "User registration failed";
//        }
//    }
}
