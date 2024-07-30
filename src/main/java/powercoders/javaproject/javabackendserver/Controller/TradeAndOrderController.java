package powercoders.javaproject.javabackendserver.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import powercoders.javaproject.javabackendserver.Modal.TradeAndOrder;
import powercoders.javaproject.javabackendserver.Service.TradeAndOrderService;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/api/v1/Orders")
    public List<TradeAndOrder> tradeOrder() {
        return TradeAndOrderService.getAllTradesAndOrders();
    }

    @GetMapping("/api/v1/Orders/{id}")
    public Optional<TradeAndOrder> getTradeAndOrder(@PathVariable long id) {
        return TradeAndOrderService.getTradeAndOrderById(id);
    }


    @DeleteMapping("/api/v1/Order/delete")
    public List<TradeAndOrder> deleteTradeAndOrder(@RequestBody TradeAndOrder trade) {
        TradeAndOrderService.deleteTradeAndOrderById(trade.getId());
        return TradeAndOrderService.getAllTradesAndOrders();
    }
}
