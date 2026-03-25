package br.anderson.infnet.apptp3produtos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppTp3ProdutosApplicationTest {
    @Test
    @DisplayName("Testa Produto, campos;")
    void testeMain() {
        Assertions.assertDoesNotThrow(
                () -> {
                    String[] args = new String[] {""};
                    AppTp3ProdutosApplication.main(args);
                }
        );
    }
}
