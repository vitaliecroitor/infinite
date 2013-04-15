package md.vcroitor.licenta.server.dao.impl;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * User: Vitalie Croitor
 * Date: 4/15/13
 * Time: 4:47 PM
 */
@RunWith(MockitoJUnitRunner.class)
public class PromotionDAOImplTest{

    @Mock
    private MongoDbFactory factory;

    @Mock
    private Mongo mongo;

    @Mock
    private DB db;

    @Mock
    private DBCollection collection;

    private MappingMongoConverter converter;
    private MongoMappingContext mappingContext;
    private MongoTemplate template;

    @Before
    public void setUp() {

        this.mappingContext = new MongoMappingContext();
        this.converter = new MappingMongoConverter(factory, mappingContext);
        this.template = new MongoTemplate(factory, converter);

        Mockito.when(factory.getDb()).thenReturn(db);
        Mockito.when(db.getCollection(Mockito.any(String.class))).thenReturn(collection);
    }

    @Test
    public void testGetByShopId() throws Exception {
    }
}
