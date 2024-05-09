package sptech.school.projetoserviceexception.entity;

import sptech.school.projetoserviceexception.dto.estabelecimento.EstabelecimentoCriacaoDto;
import sptech.school.projetoserviceexception.dto.estabelecimento.EstabelecimentoListagemDto;

import java.util.List;

public class EstabelecimentoMapper {

    public static Estabelecimento toEntity(EstabelecimentoCriacaoDto dto) {
        if (dto == null) return null;

        Estabelecimento estabelecimento = new Estabelecimento();

        estabelecimento.setNome(dto.getNome());
        estabelecimento.setCnpj(dto.getCnpj());

        return estabelecimento;
    }

    public static EstabelecimentoListagemDto toListagemDto(Estabelecimento entity) {
        if (entity == null) return null;

        EstabelecimentoListagemDto dto = new EstabelecimentoListagemDto();

        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setCnpj(entity.getCnpj());

        return dto;
    }
    
    public static List<EstabelecimentoListagemDto> toListagemDto(List<Estabelecimento> entities) {
        return entities.stream().map(EstabelecimentoMapper::toListagemDto).toList();
    }
}
