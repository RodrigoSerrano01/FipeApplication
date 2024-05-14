package br.com.rodrigo.fipeApplication.FipeApplication.principal;
import br.com.rodrigo.fipeApplication.FipeApplication.model.Dados;
import br.com.rodrigo.fipeApplication.FipeApplication.model.DadosVeiculo;
import br.com.rodrigo.fipeApplication.FipeApplication.model.Modelos;
import br.com.rodrigo.fipeApplication.FipeApplication.service.ConsumoAPI;
import br.com.rodrigo.fipeApplication.FipeApplication.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal  {
    private Scanner scanner = new Scanner(System.in);
    private ConverteDados conversor = new ConverteDados();
	private ConsumoAPI consumo= new ConsumoAPI();

    private final String URL = "https://parallelum.com.br/fipe/api/v1/";
public void exibirMenu(){

//    var json = consumo.obterDados(validaTipo());
//		var dados = conversor.obterlista(json, DadosVeiculo.class);
//
//		dados.forEach(System.out::println);
//    var json = consumo.obterDados("https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/anos/");
    //System.out.println(json);

//    var dados = conversor.obterlista(json, br.com.rodrigo.fipeApplication.FipeApplication.model.Dados.class);

//
        System.out.println("Digite o tipo do veiculo: " +
            "\nCarro. \nMoto. \nCaminhão.");

        var tipo = scanner.nextLine();

    var json = consumo.obterDados("https://parallelum.com.br/fipe/api/v1/"+tipo+"/marcas/");

    var dados = conversor.obterlista(json, Dados.class);
    System.out.println(dados);

    System.out.println("Digite o codigo da marca: ");
        var marca = scanner.nextLine();

    var jsonMarca = consumo.obterDados("https://parallelum.com.br/fipe/api/v1/"+tipo+"/marcas/"+marca+"/modelos");
    System.out.println(jsonMarca);
    var dadosModelos = conversor.obterDados(jsonMarca, Modelos.class);

    dadosModelos.modelos().stream().forEach(System.out::println);

    System.out.println("Digite o codigo do veiculo: ");
    var codigoVeiculo = scanner.nextLine();

    //https://parallelum.com.br/fipe/api/v1/carros/marcas/59/modelos/5940/anos
    var jsonCodigoVeiculo = consumo.obterDados("https://parallelum.com.br/fipe/api/v1/"+tipo+"/marcas/"+marca+"/modelos/"+codigoVeiculo+"/anos/");
    var dadosVeiculos = conversor.obterlista(jsonCodigoVeiculo, Dados.class);

    List<DadosVeiculo> listaVeiculos = new ArrayList<>();
    for (int i =0 ; i< dadosVeiculos.size();i++){
        var jsonDetalhesVeiculo = consumo.obterDados("https://parallelum.com.br/fipe/api/v1/"+tipo+"/marcas/"+marca+"/modelos/"+codigoVeiculo+"/anos/"+dadosVeiculos.get(i).codigo());
        var dadosVeiculo = conversor.obterDados(jsonDetalhesVeiculo, DadosVeiculo.class);
        listaVeiculos.add(dadosVeiculo);

    }

    listaVeiculos.forEach(System.out::println);
//
//        System.out.println("Digite o codigo do modelo: ");
//        var codigoModelo = scanner.nextLine();
//

}

//public String validaTipo(){
//    System.out.println("Digite o tipo do veiculo: " +
//            "\nCarro. \nMoto. \nCaminhão.");
//
//    var tipo = scanner.nextLine();
//
//    if (tipo.toLowerCase().contains("carr")){
//        return montaURL("carros");
//    }
//    else if (tipo.toLowerCase().contains("mot")) {
//        return montaURL("motos");
//    } else {
//        return montaURL("caminhoes");
//    }
//}
//
//public String montaURL (String tipo){
//    return URL+tipo+URL_COMPLEMENTO;
//}



}
