package md.vcroitor.licenta.server.dao.impl;

import org.springframework.data.mongodb.core.MongoOperations;

import javax.annotation.Resource;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * User: Vitalie Croitor
 * Date: 4/11/13
 * Time: 4:23 PM
 */
public class AbstractDAO<T> {

    @Resource(name = "mongoTemplate")
    MongoOperations mongoOperations;
    private Class<T> clazz;

    public AbstractDAO(final Class<T> clazz) {
        this.clazz = clazz;
    }

    public void create(final T entity) {
        getMongoOperations().save(entity);
    }

    public void delete(final T entity) {
        getMongoOperations().remove(entity);
    }

    public T getById(final long id) {
        return getMongoOperations().findById(id, clazz);
    }

    public void deleteById(final long id) {
        getMongoOperations().findAndRemove(query(where("id").is(id)), clazz);
    }

    public MongoOperations getMongoOperations() {
        return mongoOperations;
    }
}
