package br.anderson.infnet.apptp3produtos.pages;

import br.anderson.infnet.apptp3produtos.core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class HomePageTest extends BaseTest {

    @Test
    @DisplayName("Testar abertura do browser na página")
    void testa()  {
        HomePage homepage = new HomePage(driver, DURATION);
        homepage.abrir();
        Assertions.assertTrue(homepage.isOnPage());
    }
}
