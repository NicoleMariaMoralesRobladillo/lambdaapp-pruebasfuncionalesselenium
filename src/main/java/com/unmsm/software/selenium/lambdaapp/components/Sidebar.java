package com.unmsm.software.selenium.lambdaapp.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Sidebar {
    protected WebDriver driver;
    private final By sideBarButton = By.cssSelector("button.navbar-toggler.collapsed");
    private final By reportarButton = By.cssSelector("a.nav-link.active.text.fw-bold[href='/LambdaApp/reportes']");
    private final By cerrarSesionButton = By.cssSelector("a.my-2.list-group-item.list-group-item-action.left-bar-color[href='/LambdaApp/logout']");

    public Sidebar(WebDriver driver) {
        this.driver = driver;
    }

    public void cerrarSesion() {
        driver.findElement(this.sideBarButton).click();
        driver.findElement(this.cerrarSesionButton).click();
    }

    public void reportarBasura() {
        driver.findElement(this.sideBarButton).click();
        driver.findElement(this.reportarButton).click();
    }
}