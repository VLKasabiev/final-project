package searchengine.services;

import org.springframework.beans.factory.annotation.Autowired;
import searchengine.model.IndexEntity;
import searchengine.model.LemmaEntity;
import searchengine.model.PageEntity;
import searchengine.repositories.IndexRepository;
public class IndexService {
    private final IndexRepository indexRepository;
    private StringBuilder builder;
    public IndexService(IndexRepository indexRepository, StringBuilder builder) {
        this.indexRepository = indexRepository;
        this.builder = builder;
    }

    public void fillIndexEntity(PageEntity pageEntity, LemmaEntity lemmaEntity, Float rank) {
        IndexEntity indexEntity = new IndexEntity();
        indexEntity.setPageId(pageEntity);
        indexEntity.setLemmaId(lemmaEntity);
        indexEntity.setRank(rank);
        indexRepository.save(indexEntity);
    }
}
