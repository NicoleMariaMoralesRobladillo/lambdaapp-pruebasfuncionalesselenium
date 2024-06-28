package com.unmsm.software.selenium.lambdaapp.pages;

import com.unmsm.software.selenium.lambdaapp.components.Formulario;
import com.unmsm.software.selenium.lambdaapp.utils.ConstantUtils;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class ReporteResiduo extends Formulario {
    private final By image = By.name("imagen");
    private final By comentario = By.name("comentario");
    private final By referencia = By.name("referencia");
    private final By button = By.cssSelector("button[type='submit']");

    public ReporteResiduo(WebDriver driver) {
        super(driver,
                ConstantUtils.REPORTE_RESIDUO_TITULO,
                ConstantUtils.REPORTE_RESIDUO_URL);
        driver.get(this.url);
    }

    public void registrarResiduo(String comentario,
                                 String referencia,
                                 String imagePath) {
        driver.findElement(this.comentario).sendKeys(comentario);
        driver.findElement(this.referencia).sendKeys(referencia);
        driver.findElement(this.image).sendKeys(imagePath);
        driver.findElement(this.button).submit();
    }
}
