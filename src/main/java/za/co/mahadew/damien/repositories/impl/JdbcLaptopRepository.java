package za.co.mahadew.damien.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import za.co.mahadew.damien.models.Laptop;
import za.co.mahadew.damien.models.Person;
import za.co.mahadew.damien.repositories.LaptopRepository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by damien.mahadew on 2016-10-16.
 */
public class JdbcLaptopRepository implements LaptopRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcLaptopRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getLaptopCount() {
        String sql = "SELECT COUNT(*) FROM LAPTOP";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    /**
     * Can query using bind variables
     */

    public int getLaptopCountOfMake(String make) {
        String sql = "SELECT COUNT(*) FROM LAPTOP WHERE MAKE = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, make);
    }


    /**
     * One row expected, returns a map of column(key) and its value
     * @param id
     * @return
     */
    public Map<String, Object> getLaptopInfo(String id) {
        String sql = "...";
        return jdbcTemplate.queryForMap(sql, id);

    }

    /**
     * List of maps of the above
     * @param type
     * @return
     */
    public List<Map<String, Object>> getLaptops(String type) {
        String sql = "...";
        return jdbcTemplate.queryForList(sql, type);
    }

    /**
     * Row Mapper example
     */

    //First create a mapper  - maps result set to an object
    class LaptopMapper implements RowMapper<Laptop>  {
        public Laptop mapRow(ResultSet resultSet, int i) throws SQLException {
            Laptop laptop = new Laptop();
            laptop.setMake(resultSet.getString("make"));
            laptop.setModel(resultSet.getString("model"));
            return laptop;
        }
    }

    public Laptop getLaptop(String id) {
        String sql = "SELECT * FROM LAPTOP WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new LaptopMapper(), id);
    }

    public List<Laptop> getAllLaptops() {
        String sql = "SELECT * FROM LAPTOP";
        return jdbcTemplate.query(sql, new LaptopMapper());
        // NOTE that query is used for the above and not query for object
    }

    /**
     * RowcallbackHandler example
     */

    public void generateReport() {
        String sql = "...";
        jdbcTemplate.query(sql, new ReportWriter());
    }

    class ReportWriter implements RowCallbackHandler {
        public void processRow(ResultSet resultSet) throws SQLException {
            //do something here
        }
        //NOTE : THIS IS A STATEFUL OBJECT - may add convenience methods like getCount(), getResults() etc
    }
    //Look at page 192 for example of lambda expressions

    /**
     * ResultSetExtractor example
     */

    public Person getPersonsOwningLaptop(String laptop) {
        String sql = "";
        return jdbcTemplate.query(sql, new PersonsResultSetExtractor(), laptop);
    }

    class PersonsResultSetExtractor implements ResultSetExtractor<Person> {
        public Person extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            return null;
        }
    }

    /**
     * Examples of inserting and updating
     */

    public int addLaptop(Laptop laptop) {
        String sql = "";
        return jdbcTemplate.update(sql, laptop.getMake(), laptop.getModel());
    }

    public int updateLaptop(Laptop laptop) {
        String sql = "";
        return jdbcTemplate.update(sql, laptop.getMake(), laptop.getModel());
    }
}
