package za.co.mahadew.damien.services.impl;

import za.co.mahadew.damien.services.DatabaseService;
import za.co.mahadew.damien.services.HelperService;
import za.co.mahadew.damien.services.HouseService;
import za.co.mahadew.damien.services.OptionalService;

import java.math.BigDecimal;

/**
 * Created by DAMIEN6 on 18/09/2016.
 */
public class HouseServiceImpl implements HouseService {


    /**
     * This field will be injected via xml configuration
     */
    private HelperService helperService;

    private DatabaseService databaseService;

    private OptionalService optionalService;

    private String passValueString;

    private BigDecimal bigDecimal;



    /**
     * The database service field will be injected via constructor-arg xml config
     * @param databaseService
     */
    HouseServiceImpl (DatabaseService databaseService, OptionalService optionalService) {
        this.databaseService = databaseService;
        this.optionalService = optionalService;
    }

    public HelperService getHelperService() {
        return helperService;
    }

    public void setHelperService(HelperService helperService) {
        this.helperService = helperService;
    }

    public String getPassValueString() {
        return passValueString;
    }

    public void setPassValueString(String passValueString) {
        this.passValueString = passValueString;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }
}
