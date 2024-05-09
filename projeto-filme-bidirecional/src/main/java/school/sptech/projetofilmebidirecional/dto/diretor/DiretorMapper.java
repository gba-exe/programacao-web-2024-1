package school.sptech.projetofilmebidirecional.dto.diretor;

import school.sptech.projetofilmebidirecional.entity.Diretor;

import java.util.List;

public class DiretorMapper {

    public static DiretorListagemDto toListagemDto(Diretor entity) {
        DiretorListagemDto dto = new DiretorListagemDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setNacionalidade(entity.getNacionalidade());
        dto.setDataNascimento(entity.getDataNascimento());

        List<DiretorFilmeListagemDto> filmesDto = entity.getFilmes().stream().map(f -> {
            DiretorFilmeListagemDto dtoFilme = new DiretorFilmeListagemDto();
            dtoFilme.setId(f.getId());
            dtoFilme.setTitulo(f.getTitulo());
            dtoFilme.setGenero(f.getGenero());
            dtoFilme.setSinopse(f.getSinopse());
            dtoFilme.setAnoLancamento(f.getAnoLancamento());

            return dtoFilme;
        }).toList();

        dto.setFilmes(filmesDto);

        return dto;
    }

    public static List<DiretorListagemDto> toListagemDto(List<Diretor> entities) {
        return entities.stream().map(DiretorMapper::toListagemDto).toList();
    }

    public static Diretor toEntity(DiretorCriacaoDto dto) {
        Diretor entity = new Diretor();
        entity.setNome(dto.getNome());
        entity.setNacionalidade(dto.getNacionalidade());
        entity.setDataNascimento(dto.getDataNascimento());
        return entity;
    }
}
