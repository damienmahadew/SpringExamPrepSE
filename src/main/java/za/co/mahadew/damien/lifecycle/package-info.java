/**
 * Created by damien.mahadew on 2016-09-19.
 */
package za.co.mahadew.damien.lifecycle;

/**
 * The bean lifecycle
 *
 * 1. Initialization phase
 *      Prepares for use
 *      Application services are created, configured and resources are allocated
 *      app is not usable until this phase is complete
 *
 * 2. Use phase
 *      used by clients
 *      app services process client requests and carry out behaviours
 *      99.9% of the time is spent in this phase
 *
 * 3. Destruction phase
 *      Shuts down
 *      Application services release system resources and are eligible for garbage collection
 *
 * The bean lifecycle is the same for all 3 dependency injection styles i.e. xml, java and annotations
 *
 * Initialization phase
 *
 * [Bean definitions loaded -> PostProcess Bean Definitions]
 * ->
 * for each bean
 * [Instantiate beans -> setters called -> [BPP -> Initializer -> BPP]]
 * ->
 * Bean ready for use
 *
 *
 * In the use phase -- spring wraps each bean in a proxy which happens in the init phase by dedicated bean post processors
 * JDK used to create proxy if interfaces are used -- also called dynamic proxies
 * CGLIB used when no interface is present. A subclass is created, not built in JDK but included in Spring jars
 *
 * The destruction phase
 * happens when you close the context
 * Beans are destroyed but clean up or @PreDestroy methods are called before beans are destroyed
 */