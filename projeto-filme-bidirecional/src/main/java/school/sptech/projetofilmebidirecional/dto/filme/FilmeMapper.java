package school.sptech.projetofilmebidirecional.dto.filme;

import school.sptech.projetofilmebidirecional.entity.Diretor;
import school.sptech.projetofilmebidirecional.entity.Filme;

import java.util.List;

public class FilmeMapper {

    public static Filme toEntity(FilmeCriacaoDto dto, Diretor diretor) {
        Filme entity = new Filme();
        entity.setTitulo(dto.getTitulo());
        entity.setGenero(dto.getGenero());
        entity.setAnoLancamento(dto.getAnoLancamento());
        entity.setSinopse(dto.getSinopse());
        entity.setDiretor(diretor);
        return entity;
    }

    public static FilmeListagemDto toListagemDto(Filme entity) {
        FilmeListagemDto dto = new FilmeListagemDto();

        dto.setId(entity.getId());
        dto.setTitulo(entity.getTitulo());
        dto.setGenero(entity.getGenero());
        dto.setAnoLancamento(entity.getAnoLancamento());
        dto.setSinopse(entity.getSinopse());

        FilmeDiretorListagemDto filmeDiretorDto = new FilmeDiretorListagemDto();
        filmeDiretorDto.setId(entity.getDiretor().getId());
        filmeDiretorDto.setNome(entity.getDiretor().getNome());
        filmeDiretorDto.setNacionalidade(entity.getDiretor().getNacionalidade());
        filmeDiretorDto.setDataNascimento(entity.getDiretor().getDataNascimento());

        dto.setDiretor(filmeDiretorDto);

        return dto;
    }

    public static List<FilmeListagemDto> toListagemDto(List<Filme> entities) {
        return entities.stream().map(FilmeMapper::toListagemDto).toList();
    }
}

