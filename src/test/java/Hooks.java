import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.CommonFunctions;

public class Hooks {

    CommonFunctions commonFunctions = new CommonFunctions();

    //importing annotation from cucumber
    @Before
    public void beforeTest()
    {
        commonFunctions.openBrowser();
    }

//importing annotation from cucumber
    @After
    public void  afterTest()
    {
        commonFunctions.closeBrowser();
    }


}
