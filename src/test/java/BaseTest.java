import com.unmsm.software.selenium.lambdaapp.utils.ConstantUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        if (ConstantUtils.NAVEGADOR.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
        }
        else if (ConstantUtils.NAVEGADOR.equals("Edge")) {
            WebDriverManager.edgedriver().setup();
        }
        else {
            WebDriverManager.chromedriver().setup();
        }
    }

    @BeforeEach
    void setUp() {
        if (ConstantUtils.NAVEGADOR.equals("Firefox")) {
            driver = new FirefoxDriver();
        }
        else if (ConstantUtils.NAVEGADOR.equals("Edge")) {
            driver = new EdgeDriver();
        }
        else {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}