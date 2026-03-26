package br.anderson.infnet.apptp3produtos.pages;

import br.anderson.infnet.apptp3produtos.core.BasePage;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage extends BasePage<HomePage> {
    private static final String URL = "http://localhost:8080/";

	public HomePage(WebDriver driver, Duration duration) {
        super(driver, duration, URL);
    }

}
