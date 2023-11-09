import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class WebPageDownloader {
    String htmlPage;
    String pageName;

    WebPageDownloader(String pageName) {
        this.pageName = pageName;
        htmlPage = "Salman";
    }

    synchronized void pageDownloader() {
        try {
            URL url = new URL("https://en.wikipedia.org/wiki/List_of_battles_by_geographic_location");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line;
            System.out.println("Downloading web page...");

            while((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

            htmlPage = stringBuilder.toString();
            System.out.println("Downloaded successfully...");
            notify();
        }
        catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    synchronized void pageWriter() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(pageName + ".txt"));
            wait();
            System.out.println("Writing into File...");
            writer.write(htmlPage);
            System.out.println("Written to file successfully..");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
