package promotion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import promotion.dto.PromotionDTO;
import promotion.entity.Promotion;
import promotion.repository.PromotionRepository;
import promotion.util.PromotionNotFoundException;

import java.util.List;
import java.util.Optional;


public interface PromotionService {
    Promotion save(PromotionDTO promotionDTO);

    List<Promotion> listAll();

    Promotion update(PromotionDTO promotion);

    Promotion getPromotion(Integer promotionId) throws PromotionNotFoundException;

    void delete(Integer promotionId) throws PromotionNotFoundException;

    Page<Promotion> findAll(Pageable pageable);

    Page<Promotion> findByTitle(String search, Pageable pageable);
}
