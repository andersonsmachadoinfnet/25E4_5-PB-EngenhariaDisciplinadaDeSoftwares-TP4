package br.anderson.infnet.appTp3Produtos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTp3ProdutosApplicationTest {
    @Test
    @DisplayName("Testa Produto, campos;")
    public void testeMain() {
        Assertions.assertDoesNotThrow(
                () -> {
                    String[] args = new String[] {""};
                    AppTp3ProdutosApplication.main(args);
                }
        );
    }
}
