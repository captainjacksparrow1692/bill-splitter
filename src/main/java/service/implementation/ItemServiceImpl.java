package service.implementation;

import dto.ItemDTO;
import entity.Item;
import repository.ItemRepository;
import service.ItemService;
import mapper.BillSplitterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final BillSplitterMapper mapper;

    @Override
    public ItemDTO create(ItemDTO dto) {
        Item item = mapper.toEntity(dto);
        itemRepository.save(item);
        return mapper.toDto(item);
    }

    @Override
    public ItemDTO getById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        return mapper.toDto(item);
    }

    @Override
    public ItemDTO update(Long id, ItemDTO dto) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        item.setName(dto.getName());
        itemRepository.save(item);
        return mapper.toDto(item);
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
