import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // Conecting IMBD-API
        // String url = "https://imdb-api.com/en/API/Top250TVs/k_yourkey";

        // Conecting Nasa-API
        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-07-22&end_date=2022-07-24";

        var client = new ClientHttp();
        String json = client.searchData(url);

        // Manipulating and displaying db
        // ContentExtractor extractor = new ImdbContentExtractor();
        ContentExtractor extractor = new NasaContentExtractor();
        List<Content> contents = extractor.extractContents(json);

        var generate = new StickersGenerator();
        // for (Map<String,String> content : contentList()   // To get all contentList (250 top series)
        for (int i = 0; i < 3; i++) {                      // To get just 3 contents of the contentList 
            Content content = contents.get(i);  

            InputStream inputStream = new URL(content.getImageUrl()).openStream();
            String fileName = "exit/" + content.getTitle() + ".png";
            
            generate.create(inputStream, fileName);
    
            System.out.println(content.getTitle());
            System.out.println();
        }
    }
}
