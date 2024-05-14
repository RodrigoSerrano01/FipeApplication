package br.com.rodrigo.fipeApplication.FipeApplication;

import br.com.rodrigo.fipeApplication.FipeApplication.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FipeApplication.class, args);
	}


//	private ConverteDados conversor = new ConverteDados();
//	private ConsumoAPI consumo= new ConsumoAPI();
	@Override
	public void run(String... args) throws Exception {

		Principal principal = new Principal();
		principal.exibirMenu();

//		var json = consumo.obterDados("https://parallelum.com.br/fipe/api/v1/motos/marcas");
//
//		//System.out.println(json);
//
//		var dados = conversor.obterlista(json, DadosVeiculo.class);
//
//		dados.forEach(System.out::println);
	}
}