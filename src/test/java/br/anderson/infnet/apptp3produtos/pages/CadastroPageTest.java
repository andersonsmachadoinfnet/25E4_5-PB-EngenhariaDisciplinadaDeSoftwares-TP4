package br.anderson.infnet.apptp3produtos.pages;

import br.anderson.infnet.apptp3produtos.core.BaseTest;
import br.anderson.infnet.apptp3produtos.model.domain.Produto;
import br.anderson.infnet.apptp3produtos.model.domain.builder.ProdutoBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CadastroPageTest extends BaseTest {
    private CadastroPage cadastroPage;

    @BeforeEach
    public void setUp() {
        this.cadastroPage = new CadastroPage(driver, DURATION);
        this.cadastroPage.abrir();
    }

    @Test
    @DisplayName("Testar abertura do browser na página")
    public void testa()  {
        Assertions.assertTrue(cadastroPage.isOnPage());
    }

    @Test
    @DisplayName("Testar preenchimento da tela de cadastro")
    public void testaPreenchimentoFormulario() {
        Produto produto = ProdutoBuilder.aProduto().build();
        cadastrarProduto(produto);
        try {
            Thread.sleep(30000l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(1,1);
    }

    public void cadastrarProduto(Produto produto) {
        cadastroPage.cadastrarProduto(produto);
    }
}
