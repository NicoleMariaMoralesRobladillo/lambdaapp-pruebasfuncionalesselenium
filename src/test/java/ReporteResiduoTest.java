import com.unmsm.software.selenium.lambdaapp.components.Sidebar;
import com.unmsm.software.selenium.lambdaapp.pages.InicioSesion;
import com.unmsm.software.selenium.lambdaapp.pages.ReporteResiduo;
import com.unmsm.software.selenium.lambdaapp.utils.ConstantUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class ReporteResiduoTest extends BaseTest{
    @BeforeEach
    void setUp() {
        super.setUp();
        InicioSesion inicioSesion = new InicioSesion(driver);
        inicioSesion.iniciarSesion(
                ConstantUtils.MANAGER_CORREO,
                ConstantUtils.MANAGER_CONTRASENIA,
                ConstantUtils.MANAGER_HOME_URL);
        Sidebar sidebar = new Sidebar(driver);
        sidebar.reportarBasura();
    }

    @AfterEach
    void tearDown() {
        Sidebar sidebar = new Sidebar(driver);
        sidebar.cerrarSesion();
        super.tearDown();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/dataPrueba.csv",
            numLinesToSkip = 1)
    void solicitudPerfilTest(String comentario,
                             String referencia,
                             String imagePath) {
        ReporteResiduo reporteResiduo = new ReporteResiduo(driver);
        reporteResiduo.registrarResiduo(comentario, referencia, imagePath);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(reporteResiduo.getComentario(), "value", ""));
        Assertions.assertEquals("", driver.findElement(reporteResiduo.getComentario()).getAttribute("value"), "The text input field is not empty.");
    }
}