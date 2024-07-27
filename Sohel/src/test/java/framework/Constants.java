package framework;

public class Constants {
    //credentials


    //xpaths
    public static final String USER_NAME_FIELD = "//input[@name='username']";
    public static final String PASSWORD_FIELD = "//input[@name='password']";
    public static final String LOGIN_BUTTON = "//button[@type='submit' and contains(.,'Login')]";
    public static final String MY_PROFILE_BUTTON = "//nav[@role='navigation']//li[contains(.,'My Info')]/a[@href='/web/index.php/pim/viewMyDetails']";
    public static final String PROFILE_PAGE_HEADER = "//h6[contains(@class, 'orangehrm-main-title') and contains(., 'Personal Details')]";
    public static final String MY_PROFILE_DATE_FIELD = "//div[contains(.,'Date of Birth')]/following-sibling::div//input[contains(@class,'oxd-input')]";
    public static final String MY_PROFILE_DATE_SAVE_BUTTON = "//div[contains(@class, 'orangehrm-horizontal-padding')]//button[@type='submit' and contains(.,'Save')]";
    public static final String PROFILE_PICTURE_BUTTON = "//header//img[@alt='profile picture']";
    public static final String LOGOUT_BUTTON = "//header//ul[@class='oxd-dropdown-menu']/li[contains(.,'Logout')]";
    public static final String NEXT_BUTTON = "//div[@id='example-content']//li[@class='page-item']/a[@aria-label='Next']";








}
