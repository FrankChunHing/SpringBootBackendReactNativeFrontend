package powercoders.javaproject.javabackendserver.backup.LoginHandle;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import powercoders.javaproject.javabackendserver.backup.SqlConnection.MysqlConnect;

@RestController
public class LoginHandle {
    static class LoginRequest {
        public String username;
        public String password;
    }

    @PostMapping("/api/v1/login")
    public Object login(@RequestBody LoginRequest loginRequest) {
        System.out.println("Username: " + loginRequest.username);
        System.out.println("Password: " + loginRequest.password);
        return MysqlConnect.SqlConnect(loginRequest.username, loginRequest.password);
        // Implement your actual authentication logic here
//        if ("user".equals(loginRequest.username) && "pass".equals(loginRequest.password)) {
//            return "Login successful!";
//        } else {
//            return "Invalid credentials.";
//        }
    }

}
