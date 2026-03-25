package br.anderson.infnet.apptp3produtos.pages;

import br.anderson.infnet.apptp3produtos.core.BaseTest;
import br.anderson.infnet.apptp3produtos.model.domain.Produto;
import br.anderson.infnet.apptp3produtos.model.domain.builder.ProdutoBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ProdutosPageTest extends BaseTest {
    private ProdutosPage produtosPage;

    @BeforeEach
    void setUp() {
        this.produtosPage= new ProdutosPage(driver, DURATION);
        produtosPage.abrir();
    }

    @Test
    @DisplayName("Testar abertura do browser na página")
    void testa()  {
        Assertions.assertTrue(produtosPage.isOnPage());
    }

    @Test
    @DisplayName("Quantidade de itens igual a quantidade apresentada")
    void testaQuantidadeDeItensApresentadaComAQuantidadeDeLinhasDaTabela() {
        Assertions.assertTrue(produtosPage.isOnPage());
        Assertions.assertEquals(produtosPage.quantidadeDeItensNaTabela(), produtosPage.quantidadeVisualizadaNoTitulo());
    }

    @Test
    @DisplayName("Deletar um item da lista")
    void testaDeletarItemDaLista() {
        Assertions.assertTrue(produtosPage.isOnPage());
        Integer qtdInicial = produtosPage.quantidadeDeItensNaTabela();
        produtosPage.deletaUmItemDaTabela(1);
        Assertions.assertEquals(qtdInicial-1, produtosPage.quantidadeDeItensNaTabela());
    }

    @Test@DisplayName("Deve navegar para página de cadastro de novo item")
    void testaDeveNavegarParaCadastroDeNovoItem() {
        CadastroPage cadastropage = produtosPage.navegarParaPaginaDeCadastro();
        Assertions.assertTrue(cadastropage.isOnPage());
    }

    @Test
    @DisplayName("Deve abrir página de cadastro e cadastrar novo item")
    void testaDeveNavegarParaCadastrarNovoItem() {
        Produto produto = ProdutoBuilder.aProduto().build();
        CadastroPage cadastropage = produtosPage.navegarParaPaginaDeCadastro();
        Assertions.assertTrue(cadastropage.isOnPage());
        cadastropage.cadastrarProduto(produto);
        Assertions.assertTrue(produtosPage.hasProdutoNomeNaTabela(produto));
    }

    @Test
    @DisplayName("Edita um item")
    void testaEdicaoDeItemDaLista() {
        Assertions.assertTrue(produtosPage.isOnPage());
        CadastroPage cadastroPage = produtosPage.editaUmItemDaTabela(1);
        Produto produto = cadastroPage.getProduto();
        Assertions.assertNotNull(produto);
        Assertions.assertTrue(produto.getId()>0);
    }


}
