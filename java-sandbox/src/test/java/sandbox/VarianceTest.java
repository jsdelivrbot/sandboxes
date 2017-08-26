package sandbox;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class VarianceTest {

    @Test
    public void varianceTest() {
        List<String> test = new ArrayList<String>();
        test.add("First item");
        List<? extends String> covarianceTest = test;
        List<? super String> contravarianceTest = test;

        String invariantVal = test.get(0);

        //COVARIANCE - ? extends String
        //Can retrieve as a String type as covariant can be of type String or any
        //subtype of String, all of which can be cast to a String.
        String covariantVal = covarianceTest.get(0);
        //Can't add string because covarianceTest could be a subtype of String
        //covarianceTest.add("Second item");

        //CONTRAVARIANCE - ? super String
        //Can't get as a String type as contravarianceTest could be String or Object.
        //String contravariantVal = contravarianceTest.get(0);
        Object contravariantVal = contravarianceTest.get(0);    //Retrieving as Object does work though
        //Can add string because contravarianceTest could either be only of type
        //String or type Object, both of which can take in a String item.
        contravarianceTest.add("Second item");
    }
}