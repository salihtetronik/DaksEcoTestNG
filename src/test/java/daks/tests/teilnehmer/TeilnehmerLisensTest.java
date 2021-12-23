package daks.tests.teilnehmer;

import daks.pages.TeilnehmerPage;
import daks.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TeilnehmerLisensTest {

    TeilnehmerPage teilnehmer = new TeilnehmerPage();


    @Test(dataProvider = "getData")
    public void teilnehmerLisensTest1(String name) {

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(teilnehmer.teilnehmerButton).click();
        ReusableMethods.sleep(2000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton).click();
        ReusableMethods.waitForPageToLoad(5);
        ReusableMethods.sleep(1000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.nameOrt).sendKeys(name);
        ReusableMethods.sleep(1000);
        ReusableMethods.getVisibilityOfWait(teilnehmer.sichernButton).click();
        ReusableMethods.sleep(2000);
        ReusableMethods.waitForPageToLoad(5);
        ReusableMethods.getVisibilityOfWait(teilnehmer.neuButton);
        ReusableMethods.sleep(2000);
        Assert.assertTrue(teilnehmer.neuButton.isEnabled());
    }


    @DataProvider
    public Object[] getData(){

        Object[] data={
             "s204",
             "s205",
             "s206",


        };
        return data;
    }
}
