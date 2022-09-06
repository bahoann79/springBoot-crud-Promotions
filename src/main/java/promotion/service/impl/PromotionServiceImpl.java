package promotion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import promotion.dto.PromotionDTO;
import promotion.entity.Promotion;
import promotion.repository.PromotionRepository;
import promotion.service.PromotionService;
import promotion.util.PromotionNotFoundException;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    public List<Promotion> listAll(){
        return (List<Promotion>) promotionRepository.findAll();
    }

    @Override
    public Promotion update(PromotionDTO promotion) {
        return null;
    }


    public Promotion save(PromotionDTO promotionDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Promotion promotion = modelMapper.map(promotionDTO, Promotion.class);
        return promotionRepository.save(promotion);
    }

    public Promotion getPromotion(Integer id) throws PromotionNotFoundException {
        Optional<Promotion> result = promotionRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new PromotionNotFoundException("Could not find any Promotion with id: " + id);
    }

    public void delete(Integer id) throws PromotionNotFoundException {
        Long count = promotionRepository.countByPromotionId(id);
        if(count == null || count == 0){
            throw new PromotionNotFoundException("Could not find any Promotion with id: " + id);
        }
        promotionRepository.deleteById(id);
    }

    @Override
    public Page<Promotion> findAll(Pageable pageable) {
        return promotionRepository.findAll(pageable);
    }

    @Override
    public Page<Promotion> findByTitle(String search, Pageable pageable) {
        return promotionRepository.findByTitleContaining(search, pageable);
    }
}
