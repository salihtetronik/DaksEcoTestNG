package daks.tests.rundrufe;

import daks.pages.RundrufePage;
import daks.utilities.ReusableMethods;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GruppenspezifischeEinstellungen {

    RundrufePage rundruf = new RundrufePage();

    @BeforeMethod
    void beforeMethod(){

        ReusableMethods.getLogin();
    }

    @Test
    public void allgemeinesTest1(){

        ReusableMethods.getVisibilityOfWait(rundruf.rundrufButton).click();
        ReusableMethods.getVisibilityOfWait(rundruf.tr1);
        ReusableMethods.doubleClick(rundruf.tr1);
        ReusableMethods.sleep(500);
        ReusableMethods.getVisibilityOfWait(rundruf.id).clear();
        rundruf.id.sendKeys("1001");
        rundruf.bezeichnung.clear();
        rundruf.bezeichnung.sendKeys("Prio");
        rundruf.sichernButton.click();
    }

}
