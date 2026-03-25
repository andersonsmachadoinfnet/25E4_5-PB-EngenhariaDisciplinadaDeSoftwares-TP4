package br.anderson.infnet.apptp3produtos.pages;

import br.anderson.infnet.apptp3produtos.core.BasePage;
import br.anderson.infnet.apptp3produtos.model.domain.Produto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ProdutosPage  extends BasePage<HomePage> {
    private static final String URL = "http://localhost:8080/produto/lista";
    private static final By linhasTabelas = By.cssSelector("tbody tr");
    private static final By celulasTabelas = By.cssSelector("tbody tr td");
    private static final By textoQtd = By.tagName("h5");
    private static final By linkExcluir = By.className("link-excluir");
    private static final By linkBtnNovo = By.id("link-novo");
    private static final By linkBtnEditar = By.className("link-editar");

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
            if (linha.getText().equals(produto.getNome())) {
                return true;
            }
        }
        return false;
    }
}
