package pages;

import base.BasePage;

public class ThingsBoardHomePage extends BasePage {

    public ThingsBoardHomePage() {
        super();
    }

    public SidePanelFragmentPage getSidePanel() {
        return new SidePanelFragmentPage();
    }
}
