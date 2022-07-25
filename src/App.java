import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // Conecting IMBD-API
        String url = "https://imdb-api.com/en/API/Top250TVs/12345678";
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

        // Manipulating and displaying db
        for (Map<String,String> serie : seriesList) {
            System.out.println(serie.get("title"));
            System.out.println(serie.get("image"));
            System.out.println(serie.get("imDbRating"));
            System.out.println();
        }

    }
}
