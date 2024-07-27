package pages;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;

import framework.Constants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GenerateData extends BasePage{
    WebDriver driver;
    WebDriverWait wait;
    WebElement element;
    WebElement element1;
    WebElement element2;
    WebElement element3;
    WebElement element4;
    WebElement element5;
    WebElement element6;
    WebElement element7;
    WebElement element8;
    WebElement element9;
    WebElement element10;
    WebElement element11;
    WebElement detailsButtonElement;
    WebElement element12;
    Actions action;

    @FindBy(xpath = "//div[@id='example-content']//div[contains(@class, 'search-list-item')]//a[contains(@href, '/company-profile/') and contains(.,'More Details')]")
    WebElement detailsButton;

    @FindBy(xpath = "//div[@class='companyDetails']/h1")
    WebElement companyNameKey;
    @FindBy(xpath = "//div[@class='companyDetails']/p")
    WebElement companyAddressKey;
    @FindBy(xpath = "//div[contains(@class, 'company-footer')]//p[contains(.,'Email:')]")
    WebElement companyEmailKey;
    @FindBy(xpath = "//div[contains(@class, 'company-footer')]//p[contains(.,'Phone:')]")
    WebElement companyPhoneKey;
    @FindBy(xpath = "//div[contains(@class, 'company-footer')]//p[contains(.,'Web:')]/a[normalize-space()]")
    WebElement companyWebAddressKey;
    @FindBy(xpath = "//div[@class='profile-banner-caption']//div[@class='member-details']//h1/big[normalize-space()]")
    WebElement affiliateNumberIDKey;
    @FindBy(xpath = "//div[@class='profile-banner-caption']//div[@class='member-details']//p/b[contains(.,'Member Since')]")
    WebElement memberFromKey;
    @FindBy(xpath = "//div[@class='profile-banner-caption']//div[@class='member-details']//p/b[contains(.,'Valid Till')]")
    WebElement validTillKey;
    @FindBy(xpath = "//div[contains(@class, 'banner-bottom')]//div[@class='col-lg-4']//div[contains(@class, 'card-body')]/h1[normalize-space()]")
    WebElement representatorNameKey;
    @FindBy(xpath = "//div[contains(@class, 'banner-bottom')]//div[@class='col-lg-4']//div[contains(@class, 'card-body')]/p[contains(.,'Designation')]/span")
    WebElement representatorDesignationKey;
//    @FindBy(xpath = "//div[contains(@class, 'banner-bottom')]//div[@class='col-lg-4']//div[contains(@class, 'card-body')]/p[contains(.,'Contact')]/span")
//    WebElement representatorPhoneKey;
    @FindBy(xpath = "//div[contains(@class, 'banner-bottom')]//div[@class='col-lg-4']//div[contains(@class, 'card-body')]/p[contains(.,'Email')]/span")
    WebElement representatorEmailKey;
    @FindBy(xpath = Constants.NEXT_BUTTON)
    WebElement nextButton;


    public GenerateData(WebDriver driver) {
        super(driver);
        this.driver = BasePage.driver;
        this.action = new Actions(driver);
    }
    public void generate() throws IOException, ParseException, InterruptedException {
        //Create workbook in .xlsx format
        Workbook workbook = new XSSFWorkbook();
        //For .xsl workbooks use new HSSFWorkbook();
        //Create Sheet
        Sheet sh = workbook.createSheet("CompanyInfo");
        //Create top row with column headings
        String[] columnHeadings = {"Company Name", "Company Address", "Company Email", "Company Phone", "Company WebAddress", "Affiliate Number", "Member From", "Valid Till", "Representator Name", "Representator Designation", "Representator Email"};
        //We want to make it bold with a foreground color.
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.BLACK.index);
        //Create a CellStyle with the font
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
        //Create the header row
        Row headerRow = sh.createRow(0);
        //Iterate over the column headings to create columns
        for (int i = 0; i < columnHeadings.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnHeadings[i]);
            cell.setCellStyle(headerStyle);
        }
        //Freeze Header Row
        sh.createFreezePane(0, 1);

        //Fill data
        // This is where my function is call and return an array list like createData() style.
        ArrayList<CompanyInfo> a = createData();
        CreationHelper creationHelper = workbook.getCreationHelper();
        CellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setDataFormat(creationHelper.createDataFormat().getFormat("MM/dd/yyyy"));
        int rownum = 1;

        for (CompanyInfo i : a) {
//            System.out.println("rownum-before"+(rownum));
//            System.out.println("CompanyName=>"+i.getCompanyName());
            Row row = sh.createRow(rownum++);
//            System.out.println("rownum-after"+(rownum));
//            System.out.println("CompanyName=>"+i.getCompanyAddress());
            row.createCell(0).setCellValue(i.getCompanyName());
            row.createCell(1).setCellValue(i.getCompanyAddress());
            row.createCell(2).setCellValue(i.getCompanyEmail());
            row.createCell(3).setCellValue(i.getCompanyPhone());
            row.createCell(4).setCellValue(i.getCompanyWebAddress());
            row.createCell(5).setCellValue(i.getAffiliateNumber());
            row.createCell(6).setCellValue(i.getMemberFrom());
            row.createCell(7).setCellValue(i.getValidTill());
            row.createCell(8).setCellValue(i.getRepresentatorName());
            row.createCell(9).setCellValue(i.getRepresentatorDesignation());
            row.createCell(10).setCellValue(i.getRepresentatorEmail());
            //row.createCell(11).setCellValue(i.getRepresentatorContact());
        }

        //Autosize columns
        for (int i = 0; i < columnHeadings.length; i++) {
            sh.autoSizeColumn(i);
        }
        Sheet sh2 = workbook.createSheet("Second");
        //Write the output to file
        FileOutputStream fileOut = new FileOutputStream("src/test/ComInfo.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        System.out.println("Completed");

    }

//    private static ArrayList<CompanyInfo> createData() throws ParseException {
//        ArrayList<CompanyInfo> a = new ArrayList();
//        a.add(new CompanyInfo("comName111", "Dhaka1", "abc@email.com", "abc.com", "01111111111", "123", "11 Nov 23", "14 Nov 24", "abc", "Member1", "mem1@email.com", "01111111114"));
//        a.add(new CompanyInfo("comName222", "Dhaka2", "def@email.com", "abc.com", "01111111112", "456", "12 Nov 23", "15 Nov 24", "def", "Member2", "mem2@email.com", "01111111115"));
//        a.add(new CompanyInfo("comName333", "Dhaka3", "ghi@email.com", "abc.com", "01111111113", "789", "13 Nov 23", "16 Nov 24", "ghi", "Member3", "mem3@email.com", "01111111116"));
//        return a;
//    }

    public void clickOnDetailsButton() throws InterruptedException {
        element = waitUntilElementVisible(detailsButton);
        element.click();
        Thread.sleep(2000);
    }

    ArrayList<CompanyInfo> a = new ArrayList();

    private ArrayList<CompanyInfo> createData() throws InterruptedException {
        return this.a;
    }

    private void detailsButtonCustom(int c) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(0,155)");
        Thread.sleep(1000);
        detailsButtonElement = driver.findElement(By.xpath("(//div[@id='example-content']//div[contains(@class, 'search-list-item')]//a[contains(@href, '/company-profile/') and contains(.,'More Details')])["+c+"]"));
        detailsButtonElement.click();

        Thread.sleep(1000);
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", gg);
    }
    int flag=1;

    public void prepareArrayListOfCompanyDataFull(int howManyPage) throws InterruptedException {
        int t=0;
        int page = howManyPage;
        int list = 15;
        for(t = 1; t <= list; t++){
            prepareArrayListOfCompanyDataSingle(this.a);
            Thread.sleep(1000);
            //clickOnDetailsButton();
            if(t < list){
                detailsButtonCustom(t+1);
            }

        }

        if (flag < howManyPage)
        {
            clickNextButton(flag+1);
            Thread.sleep(1000);
            detailsButtonCustom(1);
            flag +=1;
            prepareArrayListOfCompanyDataFull(howManyPage);
        }

    }
    private void clickNextButton(int pageNum) throws InterruptedException {
        Thread.sleep(500);

        element11 = driver.findElement(By.xpath("(//div[@id='example-content']//li[contains(@class, 'page-item') and contains(.,"+pageNum+")])[1]"));
        element11.click();

        //element11 = waitUntilElementVisible(nextButton);
        //element11.click();
        Thread.sleep(1000);
    }
    private ArrayList<CompanyInfo> prepareArrayListOfCompanyDataSingle(ArrayList<CompanyInfo> b) throws InterruptedException {
        Thread.sleep(1000);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        element = waitUntilElementVisible(companyNameKey);
        String companyNameText = element.getText().toString().trim();

        element1 = waitUntilElementVisible(companyAddressKey);
        String companyAddressText = element1.getText().toString().trim();

        element2 = waitUntilElementVisible(companyEmailKey);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element2);
        String companyEmailText = element2.getText().toString().trim();
        companyEmailText = companyEmailText.replace("Email:", "");

        element3 = waitUntilElementVisible(companyPhoneKey);
        String companyPhoneText = element3.getText().toString().trim();
        companyPhoneText = companyPhoneText.replace("Phone:", "");

        element4 = waitUntilElementVisible(companyWebAddressKey);
        String companyWebAddressText = element4.getText().toString().trim();

        element5 = waitUntilElementVisible(affiliateNumberIDKey);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element5);
        String companyRegNumberText = element5.getText().toString().trim();

        element6 = waitUntilElementVisible(memberFromKey);
        String memberFromText = element6.getText().toString().trim();
        memberFromText = memberFromText.replace("Member Since :", "");

        element7 = waitUntilElementVisible(validTillKey);
        String validTilText = element7.getText().toString().trim();
        validTilText = validTilText.replace("Valid Till :", "");

        element8 = waitUntilElementVisible(representatorNameKey);
        String representatorNameText = element8.getText().toString().trim();

        element9 = waitUntilElementVisible(representatorDesignationKey);
        String representatorDesignationText = element9.getText().toString().trim();

        element10 = waitUntilElementVisible(representatorEmailKey);
        String representatorEmailText = element10.getText().toString().trim();

//        element11 = waitUntilElementVisible(representatorPhoneKey);
//        String representatorPhoneNumberText = element11.getText().toString().trim();

        Thread.sleep(1000);
        b.add(new CompanyInfo(companyNameText, companyAddressText, companyEmailText, companyWebAddressText,
                companyPhoneText, companyRegNumberText, memberFromText, validTilText, representatorNameText,
                representatorDesignationText, representatorEmailText));
        Thread.sleep(1000);

        driver.switchTo().window(tabs.get(1)).close();
        Thread.sleep(1000);
        driver.switchTo().window(tabs.get(0));

        return b;
    }




}
