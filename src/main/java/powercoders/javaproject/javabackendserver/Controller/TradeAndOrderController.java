package powercoders.javaproject.javabackendserver.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import powercoders.javaproject.javabackendserver.Modal.TradeAndOrder;
import powercoders.javaproject.javabackendserver.Service.TradeAndOrderService;

import java.util.List;

@RestController
public class TradeAndOrderController {

    private final TradeAndOrderService TradeAndOrderService;

    static class TradeOrderRequest {
        public String username;
        public double time;
        public String symbol;
        public String type; // market or limit
        public String side; // buy or sell
        public double size;
        public double price;

    }

    @Autowired
    public TradeAndOrderController(TradeAndOrderService tradeAndOrderService) {
        this.TradeAndOrderService = tradeAndOrderService;
    }

    @PostMapping("/api/v1/Order")
    public List<TradeAndOrder> tradeOrder() {
        return TradeAndOrderService.getAllTradesAndOrders();
    }
}
