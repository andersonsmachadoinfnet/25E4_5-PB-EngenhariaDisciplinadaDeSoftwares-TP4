package br.anderson.infnet.apptp3produtos;

import br.anderson.infnet.apptp3produtos.controller.AppController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppControllerTest {
    @Autowired
    private AppController appController;

    @Test
    @DisplayName("Testa Controller, telaHome;")
    void testeTelaHome() {
        Assertions.assertEquals(appController.telaHome(), "index");
    }

    @Test
    @DisplayName("Testa Controller, telaIndex;")
    void testeTelaIndex() {
        Assertions.assertEquals(appController.telaIndex(), "index");
    }
}
