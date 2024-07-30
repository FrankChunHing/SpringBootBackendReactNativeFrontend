package powercoders.javaproject.javabackendserver.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import powercoders.javaproject.javabackendserver.Modal.TradeAndOrder;
import powercoders.javaproject.javabackendserver.Repository.ITradeAndOrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TradeAndOrderService {

    private final ITradeAndOrderRepository tradeAndOrderRepository;

    @Autowired
    public TradeAndOrderService(ITradeAndOrderRepository tradeAndOrderRepository) {
        this.tradeAndOrderRepository = tradeAndOrderRepository;
    }

    public List<TradeAndOrder> getAllTradesAndOrders() {

        return tradeAndOrderRepository.findAll();
    }

    public Optional<TradeAndOrder> getTradeAndOrderById(Long id) {

        return tradeAndOrderRepository.findById(id);
    }

    public TradeAndOrder createTradeAndOrder(TradeAndOrder tradeAndOrder) {
        return tradeAndOrderRepository.save(tradeAndOrder);
    }

    @Transactional
    public void deleteTradeAndOrderById(Long id) {
        tradeAndOrderRepository.deleteById(id);
    }


}
