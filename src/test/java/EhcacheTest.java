import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import net.sf.ehcache.CacheManager;


public class EhcacheTest {

	 CacheManager cacheManager = CacheManager.newInstance("src/main/resources/ehcache.xml");
	
	private Logger logger = Logger.getLogger(this.getClass());
	
//	@Autowired
//	CacheManager cacheManager;
	
	@Test
	public void test(){
		// 获得Cache的引用
        Cache cache = cacheManager.getCache("userCache");
		
     // 将一个Element添加到Cache
        cache.put(new Element("key1", "value1"));
        
        // 获取Element，Element类支持序列化，所以下面两种方法都可以用
        Element element1 = cache.get("key1");
        // 获取非序列化的值
        logger.debug("key:{}, value:{}"+ element1.getObjectKey()+element1.getObjectValue());
        // 获取序列化的值
        logger.debug("key:{}, value:{}"+ element1.getKey()+element1.getValue());

        // 更新Cache中的Element
        cache.put(new Element("key1", "value2"));
        Element element2 = cache.get("key1");
        logger.debug("key:{}, value:{}"+ element2.getObjectKey()+ element2.getObjectValue());

        // 获取Cache的元素数
        logger.debug("cache size:{}"+ cache.getSize());

        // 获取MemoryStore的元素数
        logger.debug("MemoryStoreSize:{}"+ cache.getMemoryStoreSize());

        // 获取DiskStore的元素数
        logger.debug("DiskStoreSize:{}"+ cache.getDiskStoreSize());

        // 移除Element
        cache.remove("key1");
        logger.debug("cache size:{}"+ cache.getSize());

        // 关闭当前CacheManager对象
        cacheManager.shutdown();

        // 关闭CacheManager单例实例
        CacheManager.getInstance().shutdown();
	}
}
