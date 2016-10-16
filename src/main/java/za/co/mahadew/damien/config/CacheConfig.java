package za.co.mahadew.damien.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.co.mahadew.damien.repositories.PersonRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by damien.mahadew on 2016-10-16.
 */
@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public PersonRepository personRepository() {
        //
        return new PersonRepository();
    }

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        Set<Cache> caches = new HashSet<Cache>();
        caches.add(new ConcurrentMapCache("topPersons"));
        simpleCacheManager.setCaches(caches);
        return simpleCacheManager;
    }

    /**
     * Third party cache manager
     */

    @Bean
    public CacheManager cacheManager(CacheManager ehCache) {
        EhCacheCacheManager cmgr = new EhCacheCacheManager();
//        cmgr.setCacheManager(ehCache);
        //The above line requires net.sf.ehcache.CacheManager not the spring version
        return cmgr;
    }

    @Bean
    EhCacheManagerFactoryBean ehCacheManagerFactoryBean(@Value("#someValue") String location) {
        EhCacheManagerFactoryBean eh = new EhCacheManagerFactoryBean();
        //The line below is just for demonstration purposes, this should not be done normalyy
        ApplicationContext context = null;
        eh.setConfigLocation(context.getResource(location));
        return eh;
    }

    //TODO - Third party caching - gemfire - page 177 till the end of the chapter
}
