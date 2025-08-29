import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiFetcher {

    public String fetch(String originalUrl) {
        try {
            String encodedUrl = URLEncoder.encode(originalUrl, "UTF-8");
            String proxyUrl = "http://money2.greynium.com/src/get_url_content.php?url=" + encodedUrl;

            // Try proxy first
            String response = getContent(proxyUrl);
            if (response == null) {
                System.out.println("❌ Proxy failed, trying direct...");

                // Fallback to direct access
                response = getContent(originalUrl);
                if (response == null) {
                    System.out.println("❌ Direct access also failed.");
                    return null;
                }

                System.out.println("✅ Direct access success");
                return response;
            }

            System.out.println("✅ Proxy access success");
            return response;

        } catch (Exception e) {
            System.out.println("Exception in fetch: " + e.getMessage());
            return null;
        }
    }

    private String getContent(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Referer", url.getProtocol() + "://" + url.getHost());
            conn.setRequestProperty("Origin", url.getProtocol() + "://" + url.getHost());
            conn.setInstanceFollowRedirects(true);
            conn.setConnectTimeout(8000);
            conn.setReadTimeout(8000);

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.out.println("⚠️ HTTP error code: " + responseCode);
                return null;
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder responseContent = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                responseContent.append(inputLine).append("\n");
            }
            in.close();

            return responseContent.toString();

        } catch (Exception e) {
            System.out.println("CURL error: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        ApiFetcher fetcher = new ApiFetcher();
        String url = "https://aiapi-dev.greynium.com/liquorapi?type=brand&name=Bira+91&brandtype=whisky";

        String response = fetcher.fetch(url);

        if (response != null) {
            System.out.println("🔽 API Response:\n");
            System.out.println(response);
        } else {
            System.out.println("❌ Failed to fetch API data.");
        }
    }
}

