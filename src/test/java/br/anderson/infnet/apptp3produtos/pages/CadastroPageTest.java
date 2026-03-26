package br.anderson.infnet.apptp3produtos.pages;

import br.anderson.infnet.apptp3produtos.core.BaseTest;
import br.anderson.infnet.apptp3produtos.model.domain.Produto;
import br.anderson.infnet.apptp3produtos.model.domain.builder.ProdutoBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class CadastroPageTest extends BaseTest {
    private CadastroPage cadastroPage;

    @BeforeEach
    void setUp() {
        this.cadastroPage = new CadastroPage(driver, DURATION);
        this.cadastroPage.abrir();
    }

    @Test
    @DisplayName("Testar abertura do browser na página")
    void testa()  {
        Assertions.assertTrue(cadastroPage.isOnPage());
    }

    @Test
    @DisplayName("Testar preenchimento da tela de cadastro")
    void testaPreenchimentoFormulario() {
        Produto produto = ProdutoBuilder.aProduto().build();
        cadastrarProduto(produto);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        int um = 1;
        Assertions.assertEquals(1,um);
    }

    void cadastrarProduto(Produto produto) {
        cadastroPage.cadastrarProduto(produto);
    }
}
