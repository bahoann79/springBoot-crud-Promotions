package promotion.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import promotion.entity.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

    Long countByPromotionId(Integer id);

    Page<Promotion> findByTitleContaining(String search, Pageable pageable);


}
