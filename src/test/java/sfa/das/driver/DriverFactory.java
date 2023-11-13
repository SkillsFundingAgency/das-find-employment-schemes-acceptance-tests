package sfa.das.driver;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.javascript.SilentJavaScriptErrorListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Factory implementation to retrieve a suitable Selenium WebDriver.
 */
@Slf4j
public class DriverFactory {
    public enum DriverType {
        HTMLUNIT(""),
        CHROME("chrome");

        DriverType(String text) {
            this.text = text;
        }

        private String text;

        public static DriverType value(final String text) {
            for (DriverType value : DriverType.values()) {
                if (value.getText().equals(text)) {
                    return value;
                }
            }
            return DriverType.HTMLUNIT;
        }
        public String getText() {
            return this.text;
        }
    }

    /**
     * Default no-args constructor.
     */
    private DriverFactory() {
        // private constructor to prevent instantiation
    }

    /**
     * Get Web Driver based on current system properties. These can be set using the "-D"
     * flag, e.g.
     * mvn test -Dbrowser=chrome
     * <p>
     * Valid browser values are:
     * - htmlunit - fast and headless
     * - chrome - Google Chrome browser running in foreground
     * <p>
     * If no value is specified then htmlunit is assumed.
     *
     * @return selenium web driver.
     */

    public static WebDriver getBaseDriver(DriverType driverType) throws Exception {
        switch (driverType) {
            case HTMLUNIT:
                var htmlUnitDriver = new HtmlUnitDriver() {
                    @Override
                    protected WebClient modifyWebClient(WebClient webClient) {
                        webClient = super.modifyWebClient(webClient);
                        webClient.getOptions().setThrowExceptionOnScriptError(false);
                        webClient.getOptions().setJavaScriptEnabled(true);
                        webClient.setJavaScriptErrorListener(new SilentJavaScriptErrorListener());
                        return webClient;
                    }
                };
                return htmlUnitDriver;
            case CHROME:
                WebDriverManager.chromedriver().cachePath(System.getProperty("user.dir") + "/browser").setup();

                return new ChromeDriver();
            default:
                throw new DriverNotFoundException("Unsupported webdriver");
        }
    }


}

