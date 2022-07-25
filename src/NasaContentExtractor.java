import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtractor implements ContentExtractor {
  public List<Content> extractContents(String json) {
    // Extracting db
    var parser = new JsonParser();
    List<Map<String, String>> attributesList = parser.parse(json);

    List<Content> contents = new ArrayList<>();

    // populating contentList
    for (Map<String, String> attributes : attributesList) {
      String title = attributes.get("title");
      String imageUrl = attributes.get("url");
      var content = new Content(title, imageUrl);

      contents.add(content);
    }

    return contents;
  }
}
