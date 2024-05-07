import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitura = new Scanner(System.in);
        
        System.out.println("Digite uma criptomoeda:");
        var busca = leitura.nextLine().toLowerCase(); // Converter para minúsculas para comparar sem distinção de maiúsculas/minúsculas
        
        String endereco = "https://api.coingecko.com/api/v3/coins/list";
    
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response;

        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        // Verificando se a solicitação foi bem-sucedida (status code 200)
        if (response.statusCode() == 200) {
            // Criando o objeto Gson
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            
            // Convertendo a resposta para um array de objetos Coin
            Coin[] coins = gson.fromJson(response.body(), Coin[].class);
            
            // Iterando sobre o array de moedas para encontrar as que contêm "bit" no nome
            for (Coin coin : coins) {
                String name = coin.getName().toLowerCase(); // Convertendo para minúsculas para comparar
                if (name.contains(busca)) {
                    // Se o nome contém a string buscada, imprime o nome e o símbolo
                    System.out.println("Name: " + coin.getName() + ", ID: " + coin.getId());
                }
            }
        } else {
            System.out.println("Falha na solicitação: " + response.statusCode());
        }

        Scanner leitura2 = new Scanner(System.in);
        System.out.println("Digite o nome da receita para a busca: ");
        var criptoNome = leitura2.nextLine();

        String endereco2 = "https://api.coingecko.com/api/v3/simple/price?ids=" + criptoNome + "&vs_currencies=usd";

        HttpClient client2 = HttpClient.newHttpClient();
        HttpRequest request2 = HttpRequest.newBuilder().uri(URI.create(endereco2)).build();
        HttpResponse<String> response2 = client2.send(request2, HttpResponse.BodyHandlers.ofString());

        System.out.println(response2.body());
    }
}