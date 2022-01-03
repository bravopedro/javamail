import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;


public class Scraper {
    public static void main(String[] args) throws IOException {
        String [] SandPCos = new String[505];
        String [] EPS = new String [505];
        int i = 0;


        final Document urlofSandPlist = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_S%26P_500_companies").get();

        for(Element row : urlofSandPlist.select("wikitable sortable jquery-tablesorter")){
            final String companyNames = row.select("noFollow").text();
            SandPCos[i] = companyNames;
            System.out.print(companyNames + " ");
            // the goal is to have this website parsed for the companies' ticker so that these Strings can then be thrown
            // into the {} in our FinWiz website to search for data on these companies.
        }

        final Document document = Jsoup.connect("https://finviz.com/quote.ashx?t={SandPCcos[i]}").get();

        for(Element row : document.select("table-dark-row tr") ){ // this loop is meant to scrape the EPS from each share
            final String EarningPS = row.select(".snapshot-td2").text();
            EPS[i] = EarningPS;
            System.out.println(EarningPS); // this should work however I am not the greatest with parsing HTML
        }

    }

}
