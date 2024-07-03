package powercoders.javaproject.javabackendserver.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import powercoders.javaproject.javabackendserver.Modal.TradeAndOrder;

@Repository
public interface ITradeAndOrderRepository extends JpaRepository<TradeAndOrder, Long>{
}
