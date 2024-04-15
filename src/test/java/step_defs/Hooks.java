package step_defs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverUtils;

public class Hooks {

    //will run before EVERY scenario in any feature file
    @Before
    public void setup(){
        System.out.println("Setup step in Before hook");
    }


    //will run after every scenario
    @After
    public void teardown(){
//        DriverUtils.getDriver("chrome").quit();
    }





}
