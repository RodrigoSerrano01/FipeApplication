package br.com.rodrigo.fipeApplication.FipeApplication.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculo(@JsonAlias("TipoVeiculo")Integer tipo,
                           @JsonAlias("Valor") String valor,
                           @JsonAlias("Marca") String marca,
                           @JsonAlias("Modelo") String modelo,
                           @JsonAlias("AnoModelo")Integer ano,
                           @JsonAlias("Combustivel")String combustivel,
                           @JsonAlias("CodigoFipe")String codigoFipe,
                           @JsonAlias("MesReferencia")String mesReferencia,
                           @JsonAlias("SiglaCombustivel")String siglaCombustivel) {

    @Override
    public String toString() {
        return "Veiculo: "+
                "\nmodelo: " +modelo+
                "\nMarca: " +marca+
                "\nPreço: " +valor+
                "\nAno: " +ano+
                "\nCombustivel: " +combustivel+
                "\nCodigo Fipe: " +codigoFipe+
                "\nMes: "+mesReferencia;
    }
}
