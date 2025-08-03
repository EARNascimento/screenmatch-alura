package br.com.alura.screenmatch.model;


import br.com.alura.screenmatch.service.ConsultaChatGPT;

import java.util.OptionalDouble;

public class Serie {
    private String titulo;
    private Integer totalTemporadas;
    private Double avaliacao;
    private Categoria genero;
    private String atores;
    private String poster;
    private String sinopse;

    public Serie(DadosSerie dados){
        this.titulo =  dados.titulo();
        this.totalTemporadas = dados.totalTemporadas();
        this.avaliacao = OptionalDouble.of(Double.valueOf(dados.avaliacao())).orElse(0);
        this.genero = Categoria.fromString(dados.genero().split(",")[0].trim());
        this.atores = dados.atores();
        this.poster = dados.poster();
        this.sinopse = ConsultaChatGPT.obterTraducao(dados.sinopse()).trim();
    }

    @Override
    public String toString() {
        return
                "genero=" + genero +
                ", titulo='" + titulo + '\'' +
                ", totalTemporadas=" + totalTemporadas +
                ", avaliacao=" + avaliacao +
                ", atores='" + atores + '\'' +
                ", poster='" + poster + '\'' +
                ", sinopse='" + sinopse + '\'';

    }

    public Categoria getGenero() {
        return genero;
    }
}
