import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.firefox.MarionetteDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver

waiting {
    timeout = 10
    retryInterval = 0.5
}

environments {

	// run via “./gradlew chromeTest”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		System.setProperty("webdriver.chrome.driver","/home/raul/geb-demo/chromedriver")
		driver = { new ChromeDriver() }
	}

	// run via “./gradlew firefoxTest”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		System.setProperty("webdriver.gecko.driver","/home/raul/geb-demo/geckodriver")
		driver = {new MarionetteDriver()}
	}

    phantomJs {
        driver = { new PhantomJSDriver() }
    }

}

// To run the tests with all browsers just run “./gradlew test”

reportsDir = "build/geb/${System.getProperty('geb.env')}"
//baseUrl = "http://localhost:5050"