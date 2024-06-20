package searchengine.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import searchengine.model.LemmaEntity;
import searchengine.model.SiteEntity;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

@Repository
public interface LemmaRepository extends JpaRepository<LemmaEntity, Long> {
//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    @Transactional
    @Query("SELECT l FROM LemmaEntity l WHERE l.lemma = :lemma AND l.siteId = :siteEntity ")
    Optional<LemmaEntity> findByLemma(String lemma, SiteEntity siteEntity);

//    @Query("SELECT l FROM LemmaEntity l WHERE l.lemma = :lema FOR UPDATE")
//    Optional<LemmaEntity> findByLemma(@Param("lema") String lema);

    @Query("SELECT COUNT(*) FROM LemmaEntity l WHERE l.siteId = :siteEntity")
    int getLemmasBySiteId(SiteEntity siteEntity);
    @Query("SELECT COUNT(*) FROM LemmaEntity l")
    int getTotalLemmas();
    @Modifying
    @Transactional
    void deleteAllBySiteId(SiteEntity siteEntity);
    List<LemmaEntity> findAllBySiteId(SiteEntity siteEntity);

}
