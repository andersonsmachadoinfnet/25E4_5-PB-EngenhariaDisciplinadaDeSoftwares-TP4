package br.anderson.infnet.appTp3Produtos.pages;

import br.anderson.infnet.appTp3Produtos.core.BasePage;
import br.anderson.infnet.appTp3Produtos.model.domain.Produto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ProdutosPage  extends BasePage<HomePage> {
    private final static String URL = "http://localhost:8080/produto/lista";
    private final By linhasTabelas = By.cssSelector("tbody tr");
    private final By celulasTabelas = By.cssSelector("tbody tr td");
    private final By textoQtd = By.tagName("h5");
    private final By linkExcluir = By.className("link-excluir");
    private final By linkBtnNovo = By.id("link-novo");
    private final By linkBtnEditar = By.className("link-editar");

    protected ProdutosPage(WebDriver driver, Duration duration) {
        super(driver, duration, URL);
    }

    public Integer quantidadeDeItensNaTabela() {
        return $$(linhasTabelas).size();
    }

    public Integer quantidadeVisualizadaNoTitulo() {
        String texto = $(textoQtd).getText();
        texto = texto.split(":")[1];
        return Integer.parseInt(texto.trim());
    }

    public void deletaUmItemDaTabela(int idx) {
        $$(linhasTabelas).get(idx).findElement(linkExcluir).click();
    }

    public CadastroPage editaUmItemDaTabela(int idx) {
        $$(linhasTabelas).get(idx).findElement(linkBtnEditar).click();
        return new CadastroPage(driver, duration);
    }

    public CadastroPage navegarParaPaginaDeCadastro() {
        click(linkBtnNovo);
        return new CadastroPage(driver, duration);
    }

    public Boolean hasProdutoNomeNaTabela(Produto produto) {
        for(WebElement linha : $$(celulasTabelas)) {
            String texto = linha.getText();
            if (linha.getText().equals(produto.getNome())) {
                return true;
            }
        }
        return false;
    }
}
