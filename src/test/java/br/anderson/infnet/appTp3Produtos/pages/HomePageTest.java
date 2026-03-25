package br.anderson.infnet.appTp3Produtos.pages;

import br.anderson.infnet.appTp3Produtos.core.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HomePageTest extends BaseTest {

    @Test
    @DisplayName("Testar abertura do browser na página")
    public void testa()  {
        HomePage homepage = new HomePage(driver, DURATION);
        homepage.abrir();
        Assertions.assertTrue(homepage.isOnPage());
    }

//    @Test
//    @DisplayName("Deve ir para a pagina de lista de produtos")
//    public void deveIrParaAPaginaDeListaDeProdutos() {
//        HomePage homepage = new HomePage(driver, DURATION);
//        ProdutosPage produtosPage = homepage.abrir().navegarParaListaDeProdutos();
//        Assertions.assertTrue(produtosPage.isOnPage());
//    }


}
