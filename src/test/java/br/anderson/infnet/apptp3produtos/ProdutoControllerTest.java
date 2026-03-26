package br.anderson.infnet.apptp3produtos;

import br.anderson.infnet.apptp3produtos.controller.ProdutoController;
import br.anderson.infnet.apptp3produtos.model.domain.builder.ProdutoBuilder;
import org.junit.jupiter.api.*;
import org.springframework.ui.Model;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProdutoControllerTest {
    private static final String LNK_PRODUTO_LISTA = "redirect:/produto/lista";
    @Autowired
    private ProdutoController produtoController;
    private Model model;

    @BeforeEach
    void setUp() {
        this.model = Mockito.mock(Model.class);
    }

    @Test
    @Order(1)
    @DisplayName("Testa Controller, telaCadastro;")
    void testeTelaCadastro() {
        Assertions.assertEquals("produto/cadastro", produtoController.telaCadastro());
    }

    @Test
    @Order(2)
    @DisplayName("Testa Controller, telaLista;")
    void testeTelaLista() {
        Assertions.assertEquals("produto/lista", produtoController.telaLista(model));
    }

    @Test
    @Order(999)
    @DisplayName("Testa Controller, excluir;")
    void testeExcluir() {
        Assertions.assertEquals(LNK_PRODUTO_LISTA, produtoController.excluir(2));
    }

    @Test
    @DisplayName("Testa Controller, excluir inexistente;")
    void testeExcluirInexistente() {
        Assertions.assertEquals(LNK_PRODUTO_LISTA, produtoController.excluir(9999));
    }

    @Test
    @Order(4)
    @DisplayName("Testa Controller, editar inexistente;")
    void testeEditarInexistente() {
        Assertions.assertEquals(LNK_PRODUTO_LISTA, produtoController.editar(999, model));
    }

    @Test
    @Order(5)
    @DisplayName("Testa Controller, incluir;")
    void testeIncluir() {
        Assertions.assertEquals(LNK_PRODUTO_LISTA, produtoController.incluir(ProdutoBuilder.aProduto().buildDTO()));
    }
}
