package de.hfu.residents.service;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepositoryStub;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * BaseResidentService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Juni 23, 2020</pre>
 */
@RunWith(value = Parameterized.class)
public class BaseResidentServiceTest {

    private DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    private ResidentRepositoryStub residentRepositoryStub;

    public BaseResidentServiceTest(String[] resident1, String[] resident2, String[] resident3) throws ParseException {
        List<Resident> residents =
                Arrays.asList(new Resident(resident1[0], resident1[1], resident1[2], resident1[3], format.parse(resident1[4])),
                            new Resident(resident2[0], resident2[1], resident2[2], resident2[3], format.parse(resident2[4])),
                            new Resident(resident3[0], resident3[1], resident3[2], resident3[3], format.parse(resident3[4])));
        this.residentRepositoryStub = new ResidentRepositoryStub(residents);
    }

    @Parameterized.Parameters
    public static Collection daten() {
        return Arrays.asList(new String[][][] {
            {{"max", "mustermann", "musterstraße", "musterstadt", "05-07-1995"},
            {"anna", "musterfrau", "musterstraße", "musterstadt", "10-05-1993"},
            {"john", "doe", "examplestreet", "examplecity", "03-11-1987"}}
        });
    }

    /**
     * Method: getUniqueResident(Resident filterResident)
     */
    @Test(expected = ResidentServiceException.class, timeout = 1000)
    public void testGetUniqueResidentWithWildcard() throws Exception {
        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryStub);
        Resident resident = new Resident("Te*", "", "", "", new Date());
        baseResidentService.getUniqueResident(resident);
    }

    @Test(expected = ResidentServiceException.class, timeout = 1000)
    public void testGetUniqueResidentNoResult() throws Exception {
        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryStub);
        Resident resident = new Resident("Te", "", "", "", new Date());
        baseResidentService.getUniqueResident(resident);
    }

    @Test
    public void testGetUniqueResident() throws Exception {
        BaseResidentService baseResidentService = new BaseResidentService();
        baseResidentService.setResidentRepository(residentRepositoryStub);
        Resident resident = new Resident("max", "mustermann", "musterstraße", "musterstadt", format.parse("05-07-1995"));
        Assert.assertEquals(resident.getFamilyName(), baseResidentService.getUniqueResident(resident).getFamilyName());
    }
} 
