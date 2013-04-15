package md.vcroitor.licenta.server.dao;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.transaction.annotation.Propagation.REQUIRED;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 4:23 PM
 */
@Repository
@Transactional(propagation = REQUIRED, readOnly = true)
public class AbstractDAO<T> {

    @Resource(name = "mongoTemplate")
    private MongoOperations mongoOperations;
    private Class<T> clazz;

    public AbstractDAO() {
    }

    public AbstractDAO(final Class<T> clazz) {
        this.clazz = clazz;
    }

    public void create(final T entity) {
        getMongoOperations().save(entity);
    }

    public void delete(final T entity) {
        getMongoOperations().remove(entity);
    }

    public T getById(final String id) {
        return getMongoOperations().findById(id, clazz);
    }

    public void deleteById(final String id) {
        getMongoOperations().remove(query(where("_id").is(id)), clazz);
    }

    public MongoOperations getMongoOperations() {
        return mongoOperations;
    }
}
