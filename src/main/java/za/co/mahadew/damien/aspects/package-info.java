/**
 * Created by damien.mahadew on 2016-09-20.
 */
package za.co.mahadew.damien.aspects;

/**
 * Aspect oriented programming
 * Enables modularization of cross cutting concerns
 *
 * Cross cutting concerns
 *      Generic functionality that is needed in many places i.e. boilerplate code
 *      e.g.
 *              logging
 *              transaction management
 *              security
 *              caching
 *              performance monitoring
 *              custom business rules
 * Failure to modularize cross cutting concerns may lead to
 *      Code tangling
 *          A coupling of concerns
 *      Code scattering
 *          The same concern spread across modules
 *
 * How AOP works
 *      Implement your mainline app logic - focus on the core problem
 *      Write aspects to implement your cross cutting concerns
 *      Weave aspects into your application
 *
 * AOP Technologies
 * AspectJ
 *      Original AOP
 *      Uses byte code modification for aspect weaving
 * Spring AOP
 *      Java based AOP with AspectJ integration
 *      Focuses on AOP to solve enterprise problems
 *
 * Core AOP Concepts
 *      Join Point - point in the execution of a program e.g. method call or exception thrown
 *      PointCut - An expression that selects one or more Join Points
 *      Advice - Code to be executed at each selected join point
 *      Aspect - module the encapsulates pointcuts and advice
 *      Weaving - technique where aspects are combined with main code
 *
 * How Aspects are applied
 *      1.Spring creates a proxy weaving aspect and target
 *      2. Proxy implements target interface
 *      3. All calls routed through proxy interceptor
 *      4. Matching advice is executed
 *      5. Target method is executed
 */