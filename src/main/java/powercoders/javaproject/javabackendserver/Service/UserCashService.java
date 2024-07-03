package powercoders.javaproject.javabackendserver.Service;

import org.springframework.stereotype.Service;
import powercoders.javaproject.javabackendserver.backup.UserCash;

import java.util.List;

@Service
public class UserCashService {
    public static List<UserCash> getCash(){
        return List.of(
                new UserCash("admin",100000),
                new UserCash("user1",2000)
        );
    }
}
