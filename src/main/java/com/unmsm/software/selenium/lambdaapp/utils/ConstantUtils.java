package com.unmsm.software.selenium.lambdaapp.utils;

public final class ConstantUtils {
    private ConstantUtils() {
        throw new IllegalStateException("Utility class");
    }
    public static final String MANAGER_CORREO = "jsapo@lambda.pe";
    public static final String MANAGER_CONTRASENIA = "123456";
    public static final String REPORTE_RESIDUO_TITULO = "Lambda Project";
    public static final String INICIAR_SESION_TITULO = "Lambda Project";
    public static final String URL = "http://64.23.217.53:8080";
    public static final String REPORTE_RESIDUO_URL = URL + "/LambdaApp/reportes";
    public static final String INICIAR_SESION_URL = URL + "/LambdaApp/login";
    public static final String MANAGER_HOME_URL = URL + "/LambdaApp/home";
    public static final String TIPO_ALERT = "Alert";
    public static String NAVEGADOR = "Firefox";
}