/**
 * Created by damien.mahadew on 2016-10-16.
 */
package za.co.mahadew.damien.repositories;

/**
 * Spring works with many leading data access technologies
 * Hibernate
 * Jdbc
 * Mybaits
 * JPA
 *
 * Advantages of using spring data access
 *  1. No code to implement
 *  2. No onnection or session leakage
 *  3. Throws own runtime expections dependent of API
 *
 *
 *  Spring has a Transaction Management -- Uses Spring TransactionInterceptor
 *  -- TO use this feature - add @Transaction to a method
 *      -- This establishes connection, commit/rollback and close connection
 *
 *
 * Template design pattern
 *  - Degine the outline or skeleton of an algorithm
 *  -   - leaves details for specific implementation s later
*       - hides boiler plate code
 *  -Spring provides many template classes
 *      - JDBC
*       -JMS Template, Rest Template, WebService Template
 *      - Most hide low level resource management
 *
 * Where are my transactions?
 *  - every thread needs its own transaction -- typically web driven request
 *  - Spring transaction management - handles transaction  - puts it into thread-local storage
 *      - Data access code like JDBC finds it automatically
 *      - Or get it yourself -- DataSourceUtils.getConnection(dataSource);
 *      - Hibernate sessions. JTA(JAVA EE) work similarly
 *
 * Data access in a layered architecture
 * - 3 levels -
 *  1. Service layer - business logic
 *  2. Data access later - defines interface to applications repository
 *  3. Infrastructure layer - expose low level services to other layers
 *
 *  EXAM--
 *  Springs data exception hierarchy
 *
 *  Checked excpetions
 *      - Bad - intermediate methods must throw or catch exceptions
 *      - tight coupling
 *  Unchecked excpetions
 *      - Can be thrown up the ladder for the best place to catch it
 *      - GOod - methods inbetween dont know about it
 *      = Spring throws runtime exceptions
 *
 *  Data access exceptions
 *  - SQL exception
 *      - Too general, one exception for every database error
 *      - Calling class knows you are using JDBC
 *      - Tight coupling
 *  - Spring provides DataAccessException hierarchy
 *      - Hides which ORM you are using
 *      - Consistent accross all supported data access technologies
 *      - Unchecked
 *
 * Runtime Exception
 *      DataAccessException
 *              DataAccessResourceFailureException
 *              CleanupFailureDataAccessException
 *              OptimisticLockingFailureException
 *              DataIntegrityViolationException
 *              BadSqlGrammarException
 *
 *
 * Using Test Databases - embedded db's
 * -- See DataAccessConfig + database-config.xml
 *
 *
 * Caching
 *  - Cache is a key value store = map
 *  - Where do we use caching?
 *      Any method that returns the same result for the same arguments
 *          e.g.    Calculate data on the fly
 *                  Execute a database query
 *                  Request data via RMI, JMS, web service
 *      A unique key must be generated from the arguments - that is the cache key
 *
 *  Caching Support
 *  - Transparently applies caching to Spring beans AOP
 *      - Mark methods cacheable
 *          -Indicate caching keys
 *          -Name of cache to use - multiple caches supported
 *      - Define one or more caches in spring configuration
 *
 *
 *
 *  Spring JDBC
 *
 *  Problems with traditional JDBC
 *          Results in redundant, error prone code
 *          Leads to poor exception handling
 *  Springs JdbcTemplate
 *          Configuration
 *          Query execution
 *          Working with result sets
 *          Exception handling
 *
 *  Advantages of Spring JdbcTemplate
 *      1. Greatly simplifies use of JDBC API
 *          a. Eliminates repetitive boilerplate code
 *          b. Alleviates common causes of Bugs
 *          c. Handles SQLExceptions properly
*       2. Without sacrificing power
 *          a. provides full access to standard JDBC constructs
 *
 *  e.g. int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM CUSTOMER", Integer.class);
 *
 *  What is handled by spring?
 *      1. Acquisition of the connection
 *      2. Participation of the transaction
 *      3. Execution of the statement
 *      4. Processing the result set
 *      5. Handling any exceptions
 *      6. Release the connection
 *
 *  Jdbc Template
 *      Requires a datasource
 *      Create a template once and reuse it
 *          Do not create one for each thread
 *          Thread safe after construction
 *   When to use Jdbc template
 *      1. Useful standalone
 *          -Anytime JDBC is needed
 *          -In utility or test code
 *          -To clean up messy legacy code
 *      2. Useful for implementing a repository in a layered application
 *      AKA DataAccessObject (DAO)
 *
 *   JDBC can query for :
 *      1. Simple types (integer, string date etc)
 *      2. Generic Maps
 *      3. Domain objects
 *
 *       * Generic queries
 * Jdbc template returns each row of a resultset as a map
 * When expecting a sing row
 *      Use queryForMap
 * When expecting multiple rows
 *      Use queryForList
 * Useful for reporting, testing, and 'window-on-data' use cases
 *      The data fetched does not need mapping to java object
 *      Be careful with very large data sets
 *
 *
 * /**
 * Domain object queries
 * -Often needed to map relational data to domain objects
 *      e.g. result set into a Laptop object
 * - Spring supports this using a callback approach
 * You may prefer to use ORM for this
 *      Need to decide between JdbcTemplate queries and JPA mappings
 *      Some tables may be too hard to map with JPA
 *
 *  Rowmapper
 *  Spring provides a rowmapper interface for mapping a single row of a result set to an object,
 *  can be used for single/multiple result queries
 *  Parameterized as of Spring 3.0
 *
 *  See {@link za.co.mahadew.damien.repositories.impl.JdbcLaptopRepository} for Rowmapper example
 *
 *  RowCallbackHandler
 *
 *  Spring provides a simple RowCallbackHandler interface when there is no return object
 *      - Streaming rows to a file
 *      - COnverting rows to XML
 *      - Filtering rows before adding to a collection
 *      - Faster than JPA equivalent for big queries
 *  See {@link za.co.mahadew.damien.repositories.impl.JdbcLaptopRepository} for RowCallbackHandler example
 *
 *  Spring provides a ResultSetExtractor interface for processing an entire ResultSet at once
 *      - Used when you are responsible for iterating through the result set
 *      - Or mapping an entire result set to a single object
 *
*   See {@link za.co.mahadew.damien.repositories.impl.JdbcLaptopRepository} for ResultSetExtractor example
 *
 *   JDBC Template transforms sqlExceptions into
 *   DataAccessExceptions
 *
 *
 * Transactions
 *  - A set of tasks which take place as a single, indivisible action
 *      - An atomic, consistent, isolated, durable operation
 *      - Acronym - ACID
 *  - Why?
 *      1. Atomic - each unit of work is in an all or nothing operation
 *      2. Consistent - database integrity constraints are never violated
 *      3. Isolated - isolating transactions from each other
 *      4. Durable - committed changes are permanent
 *
 *  Naive approach - e.g. if there are 4 queries in a single business method, then 4 data access operations are performed
 *                          each acquires, uses and releases a distinct connection
 *                          - This is non-transactional
 *                          - Can lead to partial failures - one data access can fail, then there is inconsistent data
 *
 *  Transactions use the same connection for all data access operations for the method
 *
 *  Java Transaction Management
 *      Several API's
 *          - JDBC, JMS, JTA, Hibernate, JPA
*       Each uses program code to mark the start and end of a transaction
 *
 *      *Different API's for Global and local transactions
 *
 *      Local transaction - single resource(e.g. 1 DB), transactions managed by underlying resource
 *      Global transaction - multiple resources(e.g. 1 DB, JMS, another DB) - transactions managed by a transaction manager
 *
 *
 *  E.g. of JDBC transaction management
 *      try {
 *          conn = ...;
 *          conn.setAutoCommit(false);
 *          ...
 *          ...
 *          conn.commit();
 *      } catch (Exception e) {
 *          conn.rollback();
 *      }
 *
 * ** Code cannot join a transaction already in progress
 * ** Code cannot be used with a global transaction
 *
 *      e.g. Hibernate
 *      Transaction tx = session.beginTransaction();
 *      .
 *      .
 *      tx.commit();
 *
 *      e.g. JPA
 *      Transaction tx = entityManager.getTransaction();
 *      tx.begin();
 *      .
 *      .
 *      tx.commit();
 *
 *
 *      For JTA implementation look at page 205
 *
 * PROBLEMS with java transaction management:
 *  - Multiple API's for different local resources
 *  - Programatic transaction demarcation
 *      - Typically performed in the repo layer - wrong place
 *      - usually repeated, cross cutting concerns
 *  - Service layer more appropriate
 *      - Multiple data access methods often called within a single transcation
 *      - but dont want data access methods in the service layer
 *  -Orthogonal concerns
 *      - Transactions demarcations should be independent of transaction implementation
 *
 * Spring Transaction Management
 *      - Separates transaction demarcation from implementation
 *          - Demarcation expressed by AOP
 *          - PlatformTransactionManager abstraction hides implementation details
 *              - Several implementations available
 *      - Spring uses the same API for global vs local
 *          - Just change the transaction manager
 *
 *      - There are 2 steps
 *          1. Declare a PlatformTransactionManager Bean
 *          2. Declare the transactional methods
 *              -Using annotations, XML, Programmatic
 *              - Can mix and match
 *
 *
*      PlatformTransactionManager
 *          - Base interface for the abstraction
 *          - Several implementations
 *              1. DataSourceTransactionManager
 *              2. HibernateTransactionManager
 *              3. JpaTransactionManager
 *              4. JtaTransactionManager
 *              5. WeblogicJtaTransactionManager
 *              6. WebSphereUowTransactionManager
 *              etc..
 *   {@link za.co.mahadew.damien.config.DataAccessConfig} -- has an example of TransactionManager
 *
 *
 *   What exactly happens in a @Transactional
 *      1. Target object wrapped in a proxy
 *          - Uses an around service
*       2. Proxy implements the ffg behavior:
 *          a. Transaction started before entering the method
 *          b. Commit at the end of the method
 *          c. rollback if method throws a runtime exception
 *              - default behavior
 *              - can be overridden
 *      3. Transaction context bound to current thread
 *      4. All controlled by configuration
 *
 *  @Transactional - on a class level - applies @Transcational to all methods of the class
 *
 *
 *  Isolation Levels :
 *      1. READ_UNCOMMITTED
 *      2. READ_COMMITTED
 *      3. REPEATABLE_READ
 *      4. SERIALIZABLE
 *  Some DBMS do not support all levels, and isolation is a complicated subject
 *      - DBMS have different ways of implementation of isolation
 *
 *  Dirty Read - when a select is done before another transaction is complete, the value read is different from what the actual value is
 *
 *  {@link za.co.mahadew.damien.services.impl.DatabaseServiceImpl} - has examples of the isolation levels
 *
 *  Transaction propagation
 *      - when there are nested transactions, what should happen?
 *
 *  Spring has 7 levels of propagation
 *      1. REQUIRED (default)
 *      2. REQUIRES_NEW
 *
 * {@link za.co.mahadew.damien.services.impl.DatabaseServiceImpl} - has examples of the propagation levels
 *
 *
 * Rollback rules
 *      - by default a transaction is rolled back if a runtime exception is thrown
 *              - e.g. DataAccessException, HibernateException
 *      - can specify conditions where rollback is not performed for thrown exceptions
 *      see {@link za.co.mahadew.damien.services.impl.DatabaseServiceImpl} for examples
 *
 * Testing transactions --
 *      - Add @Transactional to @Test method
 *      - Runs test method in a transaction
 *          No need to clean up your database after testing
 *
 *  JPA with Spring and Spring data
 *
 *      JPA
 *          -Java persistence API is designed for operating on domain objects
 *              - Defined as POJO entities
 *              - No special interface required
 *          -Replaces previous persistence mechanisms
 *              -EJB entity beans
 *              -Java Data Objects(JDO)
 *          -A common API for ORM
 *              - derived from the experience of existing products such as Jboss hibernate oracle top link
 *          -Key concepts
 *              -Entity Manager
 *              -Entity Manager factory
 *              -Persistence context
 *      Entity Manager
 *          - Manages a unit of work and persistence objects therein: the persistence context
 *          - lifecyle often bound to a transaction - usually container managed
 *      Entity Manager factory
 *          - thread-safe, shareable object that represents a single data source / persistence unit
 *          - provides access to new application managed entity managers
 *      Persistence Unit
 *          - describes a group of persistence classes(entities)
 *          - defines providers
 *          - defines transactional types (local vs JTA)
 *          - multiple units per application are allowed
 *      Spring JPA Application
 *          - configuration can be in the persistence unit
 *          - or in the sprin bean file
 *          - or a combination of the two
 *    **EntityManager API
 *      -persist(Object o)
 *      -remove(Object o)
 *      -find(Class entity, Object primaryKey)
 *      -Query createQuery(String query)
 *      -flush() = force changed entity state to be written to the DB immediately
 *
 *      Several implementations of JPA
 *          -Hibernate EntityManager
 *              -used inside Jboss
 *          -EclipseLink (RI)
 *              -used inside Glassfish
 *          -Apache OpenJPA
 *              -used inside Oracle Weblogic and IBM Websphere
 *          -Data neclues
 *              -used by google app engine
 *        ***Can all be used without application server as well
 *          -independent part of EJB3 spec
 *
 *    Hibernate JPA
 *      -Adds support through an additional library
 *          -Hibernate EntityManager
 *          -Hibernate sessions used behind JPA interfaces
 *          -Custom annotations for Hibernate specific extensions not covered by JPA
 *
 *    JPA Mapping
 *      -Jpa requires metadata for mapping classes/fields to database tables/columns
 *          -usually provided as annotations
 *          -XML mappings also supported(orm.xml)
 *              -intended for overrides only
 *      -JPA metadata relies on defaults
 *          - no need to supply meta data for the obvious
 *
 *     What can you annotate:
 *      - Classes e.g. table properties
 *      - Fields e.g column - by default all are treated as columns unless @Transient (non-persistent), Access directly via reflection
 *      - Properties (getters) - also mapped to a column, annotate getters instead of fields
 *
 *      JPA Querying
 *      -JPA provides several options for accessing data
 *          -retrieve data using primary key
 *          -query for objects using JPA Query language
 *           - similar to SQL and HQL
 *          -query for objects using criteria queries
 *              -api for creating ad hoc queries
 *          -execute sql directly to underlying database
 *              -native queries
 *              -consider JDBC template instead when not using managed objects
 *
 *
 *      Steps to using JPA with spring
 *
 *          -define an entityManager
 *          -define a dataSource bean
 *          -define a transaction Manager bean
 *          -define  mapping metadata
 *          -define DAO's
 */
