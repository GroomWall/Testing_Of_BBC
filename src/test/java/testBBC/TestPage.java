package testBBC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import webDriverSettings.WebDriverSettings;

import java.util.ArrayList;
import java.util.List;

public class TestPage extends WebDriverSettings {

    @Test
    public void testHeader() {
        driver.get("https://www.bbc.com/news");
        String headerXPath = "//h3[@class='gs-c-promo-heading__title gel-canon-bold nw-o-link-split__text']";
        String expectedResult = "Johnson announces strict new curbs on life in UK";
        System.out.println(driver.findElement(By.xpath(headerXPath)).getText());
        Assert.assertEquals(expectedResult, driver.findElement(By.xpath(headerXPath)).getText());
    }

    @Test
    public void testSecondaryHeaders() {
        List<String> list = new ArrayList<>();
        list.add("Life under coronavirus lockdown in Rome");
        list.add("Trump wants US open for business despite pandemic");
        list.add("Even more coronavirus myths to ignore");
        list.add("Spanish army finds care home residents 'abandoned'");
        list.add("Trump says coronavirus not Asian Americans' fault");
        driver.get("https://www.bbc.com/news");
        for (String listElement : list) {
            Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),\"" + listElement + "\")]")).isDisplayed(), "There is no such element on the page!");
            System.out.println("Нашел!!!!");
        }
    }

    @Test
    public void testSearch() {
        driver.get("https://www.bbc.com/news");
        String categoryLinkXpath = "//div[@class='gs-c-promo-body gel-1/3@m gel-1/4@l gel-2/5@xxl']//span[contains(text(),'UK')]";
        WebElement inputElement = driver.findElement(By.id("orb-search-q"));
        WebElement searchButton = driver.findElement(By.id("orb-search-button"));
        inputElement.sendKeys(driver.findElement(By.xpath(categoryLinkXpath)).getText());
        searchButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://www.bbc.co.uk/weather/forecast-video/36551059']/span")));
        WebElement firstHeader = driver.findElement(By.xpath("//a[@href='https://www.bbc.co.uk/weather/forecast-video/36551059']/span"));
        String actual = firstHeader.getText();
        String expected = "Weather forecast for the UK";
        Assert.assertEquals(expected, actual, "Headers are not the same");
    }

}
