import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // HTTP conection to get db from IMDB APPI
        String url = "https://imdb-api.com/en/API/Top250TVs/k_sc0cjtqb";
        URI address = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // Extracting db
        var parser = new JsonParser();
        List<Map<String, String>> seriesList = parser.parse(body);
        System.out.println(seriesList.size());
        System.out.println(seriesList.get(0));
    }
}
