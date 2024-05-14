package br.com.rodrigo.fipeApplication.FipeApplication.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Modelos(List<Dados> modelos) {


}


//public record DadosModelo(@JsonAlias("codigo")int codigo, @JsonAlias ("nome")String nome) {
//
//    @Override
//    public String toString() {
//        return "\nVeiculo=> Codigo: "+codigo+ " Modelo: "+ nome;
//    }
//}
