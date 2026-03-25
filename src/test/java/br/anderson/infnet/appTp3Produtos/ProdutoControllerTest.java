package br.anderson.infnet.appTp3Produtos;

import br.anderson.infnet.appTp3Produtos.controller.ProdutoController;
import br.anderson.infnet.appTp3Produtos.model.domain.builder.ProdutoBuilder;
import org.junit.jupiter.api.*;
import org.springframework.ui.Model;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProdutoControllerTest {
    @Autowired
    private ProdutoController produtoController;
    private Model model;

    @BeforeEach
    public void setUp() {
        this.model = Mockito.mock(Model.class);
    }

    @Test
    @Order(1)
    @DisplayName("Testa Controller, telaCadastro;")
    public void testeTelaCadastro() {
        Assertions.assertEquals(produtoController.telaCadastro(), "produto/cadastro");
    }

    @Test
    @Order(2)
    @DisplayName("Testa Controller, telaLista;")
    public void testeTelaLista() {
        Assertions.assertEquals(produtoController.telaLista(model), "produto/lista");
    }

    @Test
    @Order(999)
    @DisplayName("Testa Controller, excluir;")
    public void testeExcluir() {
        Assertions.assertEquals(produtoController.excluir(2), "redirect:/produto/lista");
    }

    @Test
    @DisplayName("Testa Controller, excluir inexistente;")
    public void testeExcluirInexistente() {
        Assertions.assertEquals(produtoController.excluir(9999), "redirect:/produto/lista");
    }

//    @Test
//    @Order(3)
//    @DisplayName("Testa Controller, editar;")
//    public void testeEditar() {
//        Assertions.assertEquals(produtoController.editar(2, model), "produto/cadastro");
//    }

    @Test
    @Order(4)
    @DisplayName("Testa Controller, editar inexistente;")
    public void testeEditarInexistente() {
        Assertions.assertEquals(produtoController.editar(999, model), "redirect:/produto/lista");
    }

    @Test
    @Order(5)
    @DisplayName("Testa Controller, incluir;")
    public void testeIncluir() {
        Assertions.assertEquals(produtoController.incluir(ProdutoBuilder.aProduto().build()), "redirect:/produto/lista");
    }
}
