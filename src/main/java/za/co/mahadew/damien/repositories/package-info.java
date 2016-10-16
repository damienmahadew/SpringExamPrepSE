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
 */
