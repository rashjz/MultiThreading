package rashjz.info.test;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;

import java.io.File;


/**
 * BDD tests
 * @author Rashad Javdov
 *
 */
public class CheckFileSizeWithName extends Steps {

    private File fNameS;
    private boolean isFile;

    @Given("a file, $filename")
    public void setFileName(@Named("filename") String filename) {
        fNameS = new File(getClass().getResource("/" + filename).getFile());

    }

    @When("check is file isFile")
    public void checkFileforBehave() {
        isFile = fNameS.isFile();
        System.out.println(fNameS.length());
        Assert.assertTrue(isFile);
    }

    @Then("file size should be $length bytes.")
    public void checkFilelength(@Named("length") long length) {
        Assert.assertEquals(length,fNameS.length());
    }


}
