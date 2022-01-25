package daks.tests.endgerate;

import daks.pages.EndgeratePage;
import daks.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class EndgerateTeilnehmerReferenzTest {

    EndgeratePage endgerate =new EndgeratePage();


    @Test
    public void teilnehmerReferenzLoschen(){

        ReusableMethods.getLogin();
        ReusableMethods.getVisibilityOfWait(endgerate.endgerateButton).click();
        ReusableMethods.waitForPageToLoad(10);
    }
}
