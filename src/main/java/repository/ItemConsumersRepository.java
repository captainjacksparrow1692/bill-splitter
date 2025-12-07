package repository;

import entity.ItemConsumers;
import entity.ItemConsumersId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemConsumersRepository   extends JpaRepository<ItemConsumers, ItemConsumersId> {
    List<ItemConsumers> findByItemId(Long itemId);
    List<ItemConsumers> findByPersonId(Long personId);
}