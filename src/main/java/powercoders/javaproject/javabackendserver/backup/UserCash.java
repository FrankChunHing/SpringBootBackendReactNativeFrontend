package powercoders.javaproject.javabackendserver.backup;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

//one to one
@Entity
//@Table(name = "userCash")
public class UserCash {
    @Id
    private String username;
    private Integer cash;

    public UserCash() {}


    public UserCash(String username, Integer cash) {
        this.username = username;
        this.cash = cash;
    }

    public String getUsername() { return username;}

    public void setUsername(String username) { this.username = username;}

    public Integer getCash() { return cash;}

    public void setCash(Integer cash) { this.cash = cash;}

    public String toString() {
        return "username" + username + " cash: " + cash;
    }

}
