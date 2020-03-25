package testBBC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import webDriverSettings.WebDriverSettings;

public class TestQuestionSubmit extends WebDriverSettings {
    @Test
    public void Aberdeen(){
        driver.get("https://www.bbc.com/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='orb-nav-links']//a[contains(text(),'Sport')]")));

        driver.findElement(By.xpath("//div[@id='orb-nav-links']//a[contains(text(),'Sport')]")).click();
        driver.findElement(By.xpath("//a[@href='/sport/football'][@data-stat-name='primary-nav-v2']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'All Teams')]")));

        driver.findElement(By.xpath("//a[contains(text(),'All Teams')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Aberdeen')]")));

        driver.findElement(By.xpath("//a[contains(text(),'Aberdeen')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class,'secondary-nav__item--first-non-crumb')]//a[@class='secondary-nav__link']")));

        driver.findElement(By.xpath("//li[contains(@class,'secondary-nav__item--first-non-crumb')]//a[@class='secondary-nav__link']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Hibernian')]")));

        boolean teamOneDisplay = driver.findElement(By.xpath("//span[@class='sp-c-fixture__team-name sp-c-fixture__team-name--home']//span[@class='gs-u-display-none gs-u-display-block@m qa-full-team-name sp-c-fixture__team-name-trunc'][contains(text(),'Aberdeen')]")).getText().equals("Aberdeen");
        boolean teamTwoDisplay = driver.findElement(By.xpath("//span[contains(text(),'Hibernian')]")).getText().equals("Hibernian");
        boolean teamOneScore = driver.findElement(By.xpath("//span[contains(text(),'3')]")).getText().equals("3");
        boolean teamTwoScore = driver.findElement(By.xpath("//span[@class='sp-c-fixture__number sp-c-fixture__number--away sp-c-fixture__number--ft'][contains(text(),'1')]")).getText().equals("1");

        Assert.assertTrue((teamOneDisplay && teamTwoDisplay) && (teamOneScore && teamTwoScore));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/sport/football/51685369']")));

        driver.findElement(By.xpath("//a[@href='/sport/football/51685369']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fixture__number fixture__number--home fixture__number--ft']")));

        String expectedScoreAberdeen = "3";
        WebElement actualScoreAberdeen = driver.findElement(By.xpath("//span[@class='fixture__number fixture__number--home fixture__number--ft']"));

        String actualScoreAberdeenText = actualScoreAberdeen.getText();
        String expectedScoreHibernian = "1";
        String actualScoreHibernian = driver.findElement(By.xpath("//span[@class='fixture__number fixture__number--away fixture__number--ft']")).getText();

        Assert.assertEquals(expectedScoreAberdeen,actualScoreAberdeenText,"Results is not as expected!");
        Assert.assertEquals(expectedScoreHibernian,actualScoreHibernian,"Results is not as expected!");
    }

    @Test
    public void Celtic(){
        driver.get("https://www.bbc.com/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='orb-nav-links']//a[contains(text(),'Sport')]")));
        driver.findElement(By.xpath("//div[@id='orb-nav-links']//a[contains(text(),'Sport')]")).click();
        driver.findElement(By.xpath("//a[@href='/sport/football'][@data-stat-name='primary-nav-v2']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'All Teams')]")));

        driver.findElement(By.xpath("//a[contains(text(),'All Teams')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Celtic')]")));

        driver.findElement(By.xpath("//a[contains(text(),'Celtic')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class,'secondary-nav__item--first-non-crumb')]//a[@class='secondary-nav__link']")));

        driver.findElement(By.xpath("//li[contains(@class,'secondary-nav__item--first-non-crumb')]//a[@class='secondary-nav__link']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Celtic')]")));

        boolean teamOneDisplay = driver.findElement(By.xpath("//a[@class='sp-c-fixture__block-link']//span[@class='sp-c-fixture__team sp-c-fixture__team--home']//span[@class='gs-u-display-none gs-u-display-block@m qa-full-team-name sp-c-fixture__team-name-trunc'][contains(text(),'Celtic')]")).getText().equals("Celtic");
        boolean teamTwoDisplay = driver.findElement(By.xpath("//span[contains(text(),'St Mirren')]")).getText().equals("St Mirren");
        boolean teamOneScore = driver.findElement(By.xpath("//span[contains(text(),'5')]")).getText().equals("5");
        boolean teamTwoScore = driver.findElement(By.xpath("//span[@class='sp-c-fixture__number sp-c-fixture__number--away sp-c-fixture__number--ft'][contains(text(),'0')]")).getText().equals("0");

        Assert.assertTrue((teamOneDisplay && teamTwoDisplay) && (teamOneScore && teamTwoScore));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/sport/football/51685365']")));

        driver.findElement(By.xpath("//a[@href='/sport/football/51685365']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fixture__number fixture__number--home fixture__number--ft']")));

        String expectedScoreAberdeen = "5";
        WebElement actualScoreAberdeen = driver.findElement(By.xpath("//span[@class='fixture__number fixture__number--home fixture__number--ft']"));

        String actualScoreAberdeenText = actualScoreAberdeen.getText();
        String expectedScoreHibernian = "0";
        String actualScoreHibernian = driver.findElement(By.xpath("//span[@class='fixture__number fixture__number--away fixture__number--ft']")).getText();

        Assert.assertEquals(expectedScoreAberdeen,actualScoreAberdeenText,"Results is not as expected!");
        Assert.assertEquals(expectedScoreHibernian,actualScoreHibernian,"Results is not as expected!");
    }

    @Test
    public void HeartOfMidlothian(){
        driver.get("https://www.bbc.com/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='orb-nav-links']//a[contains(text(),'Sport')]")));

        driver.findElement(By.xpath("//div[@id='orb-nav-links']//a[contains(text(),'Sport')]")).click();
        driver.findElement(By.xpath("//a[@href='/sport/football'][@data-stat-name='primary-nav-v2']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'All Teams')]")));

        driver.findElement(By.xpath("//a[contains(text(),'All Teams')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Heart of Midlothian')]")));

        driver.findElement(By.xpath("//a[contains(text(),'Heart of Midlothian')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class,'secondary-nav__item--first-non-crumb')]//a[@class='secondary-nav__link']")));

        driver.findElement(By.xpath("//li[contains(@class,'secondary-nav__item--first-non-crumb')]//a[@class='secondary-nav__link']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Heart of Midlothian')]")));

        boolean teamOneDisplay = driver.findElement(By.xpath("//div[3]//span[3]//span[1]//span[1]//span[1]")).getText().equals("Heart of Midlothian");
        boolean teamTwoDisplay = driver.findElement(By.xpath("//span[contains(text(),'St Mirren')]")).getText().equals("St Mirren");
        boolean teamOneScore = driver.findElement(By.xpath("//div[3]//ul[1]//a[1]//article[1]//div[1]//span[1]//span[2]//span[1]")).getText().equals("1");
        boolean teamTwoScore = driver.findElement(By.xpath("//span[@class='sp-c-fixture__number sp-c-fixture__number--away sp-c-fixture__number--ft'][contains(text(),'0')]")).getText().equals("0");

        Assert.assertTrue((teamOneDisplay && teamTwoDisplay) && (teamOneScore && teamTwoScore));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/sport/football/51498748']")));

        driver.findElement(By.xpath("//a[@href='/sport/football/51498748']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fixture__number fixture__number--home fixture__number--ft']")));

        String expectedScoreAberdeen = "1";
        WebElement actualScoreAberdeen = driver.findElement(By.xpath("//span[@class='fixture__number fixture__number--home fixture__number--ft']"));

        String actualScoreAberdeenText = actualScoreAberdeen.getText();
        String expectedScoreHibernian = "0";
        String actualScoreHibernian = driver.findElement(By.xpath("//span[@class='fixture__number fixture__number--away fixture__number--ft']")).getText();

        Assert.assertEquals(expectedScoreAberdeen,actualScoreAberdeenText,"Results is not as expected!");
        Assert.assertEquals(expectedScoreHibernian,actualScoreHibernian,"Results is not as expected!");
    }

    @Test
    public void Livingston(){
        driver.get("https://www.bbc.com/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='orb-nav-links']//a[contains(text(),'Sport')]")));

        driver.findElement(By.xpath("//div[@id='orb-nav-links']//a[contains(text(),'Sport')]")).click();
        driver.findElement(By.xpath("//a[@href='/sport/football'][@data-stat-name='primary-nav-v2']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'All Teams')]")));

        driver.findElement(By.xpath("//a[contains(text(),'All Teams')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Livingston')]")));

        driver.findElement(By.xpath("//a[contains(text(),'Livingston')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class,'secondary-nav__item--first-non-crumb')]//a[@class='secondary-nav__link']")));

        driver.findElement(By.xpath("//li[contains(@class,'secondary-nav__item--first-non-crumb')]//a[@class='secondary-nav__link']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'St Johnstone')]")));

        boolean teamOneDisplay = driver.findElement(By.xpath("//span[@class='sp-c-fixture__team-name sp-c-fixture__team-name--away']//span[contains(text(),'Livingston')]")).getText().equals("Livingston");
        boolean teamTwoDisplay = driver.findElement(By.xpath("//span[contains(text(),'St Johnstone')]")).getText().equals("St Johnstone");
        boolean teamOneScore = driver.findElement(By.xpath("//span[contains(@class,'sp-c-fixture__number--ft')][contains(text(),'1')]")).getText().equals("1");
        boolean teamTwoScore = driver.findElement(By.xpath("//span[contains(@class,'sp-c-fixture__number--ft')][contains(text(),'0')]")).getText().equals("0");

        Assert.assertTrue((teamOneDisplay && teamTwoDisplay) && (teamOneScore && teamTwoScore));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/sport/football/51685367']")));

        driver.findElement(By.xpath("//a[@href='/sport/football/51685367']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fixture__number fixture__number--home fixture__number--ft']")));

        String expectedScoreAberdeen = "1";
        WebElement actualScoreAberdeen = driver.findElement(By.xpath("//span[@class='fixture__number fixture__number--home fixture__number--ft']"));

        String actualScoreAberdeenText = actualScoreAberdeen.getText();
        String expectedScoreHibernian = "0";
        String actualScoreHibernian = driver.findElement(By.xpath("//span[@class='fixture__number fixture__number--away fixture__number--ft']")).getText();

        Assert.assertEquals(expectedScoreAberdeen,actualScoreAberdeenText,"Results is not as expected!");
        Assert.assertEquals(expectedScoreHibernian,actualScoreHibernian,"Results is not as expected!");
    }
}
