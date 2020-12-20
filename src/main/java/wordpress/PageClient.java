package wordpress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import wordpress.elements.BarHeader;
import wordpress.elements.BarNavigation;
import wordpress.pages.PageAuthorization;
import wordpress.pages.PagePostEdit;
import wordpress.pages.PagePostsList;

public class PageClient {

    public PageAuthorization pageAuthorization;
    public BarHeader barHeader;
    public BarNavigation barNavigation;

    public PagePostsList pagePostsList;
    public PagePostEdit pagePostEdit;

    public PageClient(WebDriver _wd, WebDriverWait _waiter)
    {
        pageAuthorization = new PageAuthorization(_wd, _waiter);
        barHeader = new BarHeader(_wd, _waiter);
        barNavigation = new BarNavigation(_wd, _waiter);
        pagePostEdit = new PagePostEdit(_wd, _waiter);
        pagePostsList = new PagePostsList(_wd, _waiter);
    }
}
