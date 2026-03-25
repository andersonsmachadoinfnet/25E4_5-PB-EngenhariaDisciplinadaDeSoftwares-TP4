package br.anderson.infnet.apptp3produtos.pages;

import br.anderson.infnet.apptp3produtos.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage extends BasePage<HomePage> {
    private final static String URL = "http://localhost:8080/";
    private final By linkProduto = By.id("linkProduto");


	public HomePage(WebDriver driver, Duration duration) {
        super(driver, duration, URL);
    }

//    public ProdutosPage navegarParaListaDeProdutos() {
//        click(linkProduto);
//        return new ProdutosPage(driver, duration);
//    }
}
