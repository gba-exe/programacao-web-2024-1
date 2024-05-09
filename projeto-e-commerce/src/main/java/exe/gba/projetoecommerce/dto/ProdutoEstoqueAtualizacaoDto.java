package exe.gba.projetoecommerce.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProdutoEstoqueAtualizacaoDto {

    @NotNull
    @Positive
    private int novaQuantidade;

    public int getNovaQuantidade() {
        return novaQuantidade;
    }

    public void setNovaQuantidade(int novaQuantidade) {
        this.novaQuantidade = novaQuantidade;
    }
}
