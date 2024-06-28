package com.unmsm.software.selenium.lambdaapp.components;

import com.unmsm.software.selenium.lambdaapp.utils.ConstantUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class Formulario extends WebPage {
    protected Formulario(WebDriver driver, String titulo, String url) {
        super(driver, titulo, url);
    }

    private String obtenerMensajeResultado() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String mensaje = alert.getText();
            alert.accept();
            return mensaje;
        }
        catch (NoAlertPresentException noAlertPresentException) {
            noAlertPresentException.getMessage();
        }
        return null;
    }

    private String obtenerMensajeValidacion(String idMensajeElemento) {
        By mensajeElemento = By.id(idMensajeElemento);
        return driver.findElement(mensajeElemento).getText();
    }

    public String obtenerMensaje(String tipoMensaje, String idMensajeElemento) {
        if (tipoMensaje.equals(ConstantUtils.TIPO_ALERT)) {
            return obtenerMensajeResultado();
        }
        return obtenerMensajeValidacion(idMensajeElemento);
    }
}
