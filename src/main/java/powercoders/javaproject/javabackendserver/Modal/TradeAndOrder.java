package powercoders.javaproject.javabackendserver.Modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import powercoders.javaproject.javabackendserver.Modal.User;
import jakarta.persistence.*;

@Entity
//@Table(name = "tradeAndOrders")
public class TradeAndOrder {
    /*
    id VARCHAR(36) PRIMARY KEY,
    user_name VARCHAR(50),
    symbol VARCHAR(50),
    type VARCHAR(10),
    side VARCHAR(8),
    size decimal(6,5),
    price decimal(6,5),
    isExecuted VARCHAR(5)*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String user_name;
    @Column(nullable = false)
    private double time;
    @Column(nullable = false)
    private String symbol;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)// market or limit
    private String side;
    @Column(nullable = false)// buy or sell
    private double size;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    @JsonProperty("isExecuted")
    private boolean isExecuted;
    @Column(nullable = false)
    @JsonProperty("isClosed")
    private boolean isClosed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id"
//            , referencedColumnName = "id"
    )
    @JsonIgnore
    private User user;

    public TradeAndOrder() {}

    public TradeAndOrder(long id) {
        this.id = id;
    }

    public TradeAndOrder(User user, boolean isClosed, boolean isExecuted, double price, double size, String side, String type, String symbol, double time, String user_name, long id) {
        this.user = user;
        this.isClosed = isClosed;
        this.isExecuted = isExecuted;
        this.price = price;
        this.size = size;
        this.side = side;
        this.type = type;
        this.symbol = symbol;
        this.time = time;
        this.user_name = user_name;
        this.id = id;
    }

    public TradeAndOrder(long id, String user_name, double time, String symbol, String type, String side, double size, double price, boolean isExecuted, boolean isClosed) {
        this.id = id;
        this.user_name = user_name;
        this.time = time;
        this.symbol = symbol;
        this.type = type;
        this.side = side;
        this.size = size;
        this.price = price;
        this.isExecuted = isExecuted;
        this.isClosed = isClosed;
    }

    public TradeAndOrder(String user_name, double time, String symbol, String type, String side, double size, double price, boolean isExecuted, boolean isClosed) {
        this.user_name = user_name;
        this.time = time;
        this.symbol = symbol;
        this.type = type;
        this.side = side;
        this.size = size;
        this.price = price;
        this.isExecuted = isExecuted;
        this.isClosed = isClosed;
    }

    public TradeAndOrder(String user_name, double time, String symbol, String type, String side, double size, double price, boolean isExecuted, boolean isClosed, User user) {
        this.user_name = user_name;
        this.time = time;
        this.symbol = symbol;
        this.type = type;
        this.side = side;
        this.size = size;
        this.price = price;
        this.isExecuted = isExecuted;
        this.isClosed = isClosed;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return user_name;
    }

    public void setUsername(String user_name) {
        this.user_name = user_name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isExecuted() {
        return isExecuted;
    }

    public void setExecuted(boolean executed) {
        isExecuted = executed;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
