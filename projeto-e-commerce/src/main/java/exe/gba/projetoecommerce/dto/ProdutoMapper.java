package exe.gba.projetoecommerce.dto;

import exe.gba.projetoecommerce.entity.Produto;

import java.util.List;

public class ProdutoMapper {

    public static Produto toEntity(ProdutoCriacaoDto dto) {
        if (dto == null) return null;

        Produto entity = new Produto();

        entity.setNome(dto.getNome());
        entity.setFabricante(dto.getFabricante());
        entity.setCategoria(dto.getCategoria());
        entity.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        entity.setPrecoVenda(dto.getPrecoVenda());
        entity.setPrecoCompra(dto.getPrecoCompra());

        return entity;
    }

    public static ProdutoListagemDto toDto(Produto entity) {
        if (entity == null) return null;

        ProdutoListagemDto dto = new ProdutoListagemDto();

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setFabricante(entity.getFabricante());
        dto.setCategoria(entity.getCategoria());
        dto.setQuantidadeEstoque(entity.getQuantidadeEstoque());
        dto.setQuantidadeVendidos(entity.getQuantidadeVendidos());
        dto.setPrecoVenda(entity.getPrecoVenda());
        dto.setPrecoCompra(entity.getPrecoCompra());

        return dto;
    }

    public static List<ProdutoListagemDto> toDto(List<Produto> entities) {
        return entities.stream().map(ProdutoMapper::toDto).toList();
    }

    public static ProdutoClienteListagemDto toClienteDto(Produto entity) {
        if (entity == null) return null;

        ProdutoClienteListagemDto dto = new ProdutoClienteListagemDto();

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setFabricante(entity.getFabricante());
        dto.setCategoria(entity.getCategoria());
        dto.setPreco(entity.getPrecoVenda());

        return dto;
    }

    public static List<ProdutoClienteListagemDto> toClienteDto(List<Produto> entities) {
        return entities.stream().map(ProdutoMapper::toClienteDto).toList();
    }
}
