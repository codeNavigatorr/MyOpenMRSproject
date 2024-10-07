package openMRS;

import Utility.BaseDriver;
import Utility.Tools;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class openMRSsearch extends BaseDriver {

    @Test
    public void openMRS() {
        openMrsElements elements = new openMrsElements();
        elements.language.click();
        wait.until(ExpectedConditions.elementToBeClickable(elements.english)).click();
        elements.demobuttun.click();
        elements.enterDemo2.click();
        elements.username.sendKeys("admin");
        elements.password.sendKeys("Admin123");
        elements.location.click();
        elements.loginButton.click();
        elements.findPatient.click();
        for (WebElement ptnt : elements.patientsIdlist)
            System.out.println(ptnt.getText());

        int rdmsecim = Tools.random(elements.patientsIdlist.size());
        String arananhasta = elements.patientsIdlist.get(rdmsecim).getText();
        elements.searchByIdorName.sendKeys(arananhasta+Keys.ENTER);

        wait.until(ExpectedConditions.urlToBe("https://demo.openmrs.org/openmrs/coreapps/clinicianfacing/patient.page?patientId=019c5922-cc34-4fe0-9905-512aab21a01c"));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='PersonName-middleName']")));
        System.out.println(elements.patientDetail.getText());






//        driver.navigate().back();
//        elements.searchByIdorName.sendKeys("techno");
//        System.out.println(""+elements.nosucPatient.getText());

    }
}


