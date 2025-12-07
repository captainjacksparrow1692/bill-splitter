package service;

import dto.ItemDTO;
import java.util.List;

public interface ItemService {
    ItemDTO create(ItemDTO dto);
    ItemDTO getById(Long id);
    ItemDTO update(Long id, ItemDTO dto);
    void delete(Long id);
}

