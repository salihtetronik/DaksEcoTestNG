package daks.tests.endgeräte;

import daks.pages.EndgerätePage;
import daks.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class EndgeräteTeilnehmerReferenzTest {

    EndgerätePage endgeräte =new EndgerätePage();


    @Test
    public void teilnehmerReferenzLoschen(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(endgeräte.endgeräteButton).click();
        ReusableMethods.waitForPageToLoad(10);
    }
}
