package pages;

import org.openqa.selenium.support.PageFactory;

public class ThingsBoardHomePage extends BasePage{

    private SidePanelFragmentPage sidePanelFragmentPage;

    public ThingsBoardHomePage() {
        PageFactory.initElements(driver, this);
        sidePanelFragmentPage = new SidePanelFragmentPage(driver);
    }

    public SidePanelFragmentPage getSidePanel(){
        return sidePanelFragmentPage;
    }
}
