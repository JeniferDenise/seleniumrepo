package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;

public class CasosDePrueba {
    //Atributos
    private WebDriver driver;
    private WebDriverWait wait;

    private JavascriptExecutor js;

    private String rutaDriver = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
    private String propertyDriver = "webdriver.chrome.driver";

    @AfterMethod
    public void posCondicion() {
        driver.close();
    }

    @BeforeMethod
    public void preCondiciones() {

        System.setProperty(propertyDriver, rutaDriver);

        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 10);

        js = (JavascriptExecutor) driver;

        driver.navigate().to("https://open.spotify.com/");

        driver.manage().window().maximize();
    }

    @Test
    public void CP001_Contraseña_muy_corta() {

        By localizadorBtnRegistrase = By.xpath("//button[contains(text(),'Registrarte')]");

        WebElement btnRegistrarse = driver.findElement(localizadorBtnRegistrase);

        btnRegistrarse.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("espeche.jenifer@tsoftglobal.com");

        driver.findElement(By.name("confirm")).sendKeys("espeche.jenifer@tsoftglobal.com");

        driver.findElement(By.name("password")).sendKeys("123");

        driver.findElement(By.name("displayname")).sendKeys("Yuyo");

        driver.findElement(By.id("day")).sendKeys("3");

        Select cmbMes = new Select(driver.findElement(By.id("month")));

        cmbMes.selectByValue("09");

        driver.findElement(By.name("year")).sendKeys("1994");

        WebElement optionFemale = driver.findElement(By.xpath("//label[@for='gender_option_female']"));

        js.executeScript("arguments[0].scrollIntoView();", optionFemale);

        optionFemale.click();

        driver.findElement(By.xpath("//label[@for='gender_option_female']"));

        driver.findElement(By.xpath("//label[@for='marketing-opt-checkbox']")).click();


        driver.findElement(By.xpath("//label[@for='third-party-checkbox']")).click();


        Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='Indicador de error']")).getText(), "Tu contraseña es demasiado corta.");

    }



    @Test
    public void CP002_Mail_Incorrecto() {

        By localizadorBtnRegistrase = By.xpath("//button[contains(text(),'Registrarte')]");

        WebElement btnRegistrarse = driver.findElement(localizadorBtnRegistrase);

        btnRegistrarse.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("@tsoftglobal.com");

        driver.findElement(By.name("confirm")).sendKeys("espeche.jenifer@tsoftglobal.com");

        driver.findElement(By.name("password")).sendKeys("123456789");

        driver.findElement(By.name("displayname")).sendKeys("Yuyo");

        driver.findElement(By.id("day")).sendKeys("3");

        Select cmbMes = new Select(driver.findElement(By.id("month")));

        cmbMes.selectByValue("09");

        driver.findElement(By.name("year")).sendKeys("1994");

        WebElement optionFemale = driver.findElement(By.xpath("//label[@for='gender_option_female']"));

        js.executeScript("arguments[0].scrollIntoView();", optionFemale);

        optionFemale.click();

        driver.findElement(By.xpath("//label[@for='gender_option_female']"));

        driver.findElement(By.xpath("//label[@for='marketing-opt-checkbox']")).click();


        driver.findElement(By.xpath("//label[@for='third-party-checkbox']")).click();


        Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='Indicador de error']")).getText(), "Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");

    }

    @Test
    public void CP003_Mail_No_Coincide() {

        By localizadorBtnRegistrase = By.xpath("//button[contains(text(),'Registrarte')]");

        WebElement btnRegistrarse = driver.findElement(localizadorBtnRegistrase);

        btnRegistrarse.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("espeche@tsoftglobal.com");

        driver.findElement(By.name("confirm")).sendKeys("espeche.jenifer@tsoftglobal.com");

        driver.findElement(By.name("password")).sendKeys("123456789");

        driver.findElement(By.name("displayname")).sendKeys("Yuyo");

        driver.findElement(By.id("day")).sendKeys("3");

        Select cmbMes = new Select(driver.findElement(By.id("month")));

        cmbMes.selectByValue("09");

        driver.findElement(By.name("year")).sendKeys("1994");

        WebElement optionFemale = driver.findElement(By.xpath("//label[@for='gender_option_female']"));

        js.executeScript("arguments[0].scrollIntoView();", optionFemale);

        optionFemale.click();

        driver.findElement(By.xpath("//label[@for='gender_option_female']"));

        driver.findElement(By.xpath("//label[@for='marketing-opt-checkbox']")).click();


        driver.findElement(By.xpath("//label[@for='third-party-checkbox']")).click();


        Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='Indicador de error']")).getText(), "Las direcciones de correo electrónico no coinciden.");
    }

    @Test
    public void CP004_CampoVacio() {

        By localizadorBtnRegistrase = By.xpath("//button[contains(text(),'Registrarte')]");

        WebElement btnRegistrarse = driver.findElement(localizadorBtnRegistrase);

        btnRegistrarse.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("espeche@tsoftglobal.com");

        driver.findElement(By.name("confirm")).sendKeys("espeche@tsoftglobal.com");

        driver.findElement(By.name("password")).sendKeys("123456789lkjA");

        driver.findElement(By.name("displayname")).sendKeys("");

        driver.findElement(By.id("day")).sendKeys("3");

        Select cmbMes = new Select(driver.findElement(By.id("month")));

        cmbMes.selectByValue("09");

        driver.findElement(By.name("year")).sendKeys("1994");

        WebElement optionFemale = driver.findElement(By.xpath("//label[@for='gender_option_female']"));

        js.executeScript("arguments[0].scrollIntoView();", optionFemale);

        optionFemale.click();

        driver.findElement(By.xpath("//label[@for='gender_option_female']"));

        driver.findElement(By.xpath("//label[@for='marketing-opt-checkbox']")).click();


        driver.findElement(By.xpath("//label[@for='third-party-checkbox']")).click();


        Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='Indicador de error']")).getText(), "Indica un nombre para tu perfil.");
    }

    @Test
    public void CP005_DiaValido() {

        By localizadorBtnRegistrase = By.xpath("//button[contains(text(),'Registrarte')]");

        WebElement btnRegistrarse = driver.findElement(localizadorBtnRegistrase);

        btnRegistrarse.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("espeche@tsoftglobal.com");

        driver.findElement(By.name("confirm")).sendKeys("espeche@tsoftglobal.com");

        driver.findElement(By.name("password")).sendKeys("123456789lkjA");

        driver.findElement(By.name("displayname")).sendKeys("cheni");

        driver.findElement(By.id("day")).sendKeys("a");

        Select cmbMes = new Select(driver.findElement(By.id("month")));

        cmbMes.selectByValue("09");

        driver.findElement(By.name("year")).sendKeys("1994");

        WebElement optionFemale = driver.findElement(By.xpath("//label[@for='gender_option_female']"));

        js.executeScript("arguments[0].scrollIntoView();", optionFemale);

        optionFemale.click();

        driver.findElement(By.xpath("//label[@for='gender_option_female']"));

        driver.findElement(By.xpath("//label[@for='marketing-opt-checkbox']")).click();


        driver.findElement(By.xpath("//label[@for='third-party-checkbox']")).click();


        Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='Indicador de error']")).getText(), "Indica un día válido del mes.");
    }

    @Test
    public void CP006_crear() {

        By localizadorBtnRegistrase = By.xpath("//button[contains(text(),'Registrarte')]");

        WebElement btnRegistrarse = driver.findElement(localizadorBtnRegistrase);

        btnRegistrarse.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("espeche@tsoftglobal.com");

        driver.findElement(By.name("confirm")).sendKeys("espeche@tsoftglobal.com");

        driver.findElement(By.name("password")).sendKeys("123456789lkjA");

        driver.findElement(By.name("displayname")).sendKeys("cheni");

        driver.findElement(By.id("day")).sendKeys("a");

        Select cmbMes = new Select(driver.findElement(By.id("month")));

        cmbMes.selectByValue("09");

        driver.findElement(By.name("year")).sendKeys("1994");

        WebElement optionFemale = driver.findElement(By.xpath("//label[@for='gender_option_female']"));

        js.executeScript("arguments[0].scrollIntoView();", optionFemale);

        optionFemale.click();

        driver.findElement(By.xpath("//label[@for='gender_option_female']"));

        driver.findElement(By.xpath("//label[@for='marketing-opt-checkbox']")).click();


        driver.findElement(By.xpath("//label[@for='third-party-checkbox']")).click();


        Assert.assertEquals(driver.findElement(By.xpath("//div[@aria-label='Indicador de error']")).getText(), "Indica un día válido del mes.");
    }

}