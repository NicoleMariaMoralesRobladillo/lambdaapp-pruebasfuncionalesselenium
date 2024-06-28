package com.unmsm.software.selenium.lambdaapp.pages;

import com.unmsm.software.selenium.lambdaapp.components.WebPage;
import com.unmsm.software.selenium.lambdaapp.utils.ConstantUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InicioSesion extends WebPage {
    private final By correo = By.id("correoIniciarSesion");
    private final By contrasenia = By.id("contraseniaIniciarSesion");
    private final By button = By.cssSelector("button[type='submit']");

    public InicioSesion(WebDriver driver) {
        super(driver,
                ConstantUtils.INICIAR_SESION_TITULO,
                ConstantUtils.INICIAR_SESION_URL);
        driver.get(this.url);
    }

    public void iniciarSesion(String correo,
                              String contrasenia,
                              String url) {
        wait.until(ExpectedConditions.elementToBeClickable(this.button));
        driver.findElement(this.correo).sendKeys(correo);
        driver.findElement(this.contrasenia).sendKeys(contrasenia);
        driver.findElement(this.button).submit();
        wait.until(ExpectedConditions.urlToBe(url));
        driver.navigate().refresh();
    }
}