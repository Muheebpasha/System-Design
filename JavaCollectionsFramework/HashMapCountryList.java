import java.util.HashMap;
import java.util.Map;

class Country {
	private String id;
	private String country_name;
    private String capital_city;
    
    public Country(String country_name, String capital_city) {
		this.country_name = country_name;
        this.capital_city = capital_city;
	}
    
    public String getId() {
    	return id;
    }
    
    public String getCountryName() {
    	return country_name;
    }
    
    public String getCapitalCity() {
    	return capital_city;
    }

}

public class HashMapCountryList {
  public static void main(String[] args) {
    HashMap<String, Country> capitalCities = new HashMap<>();

	capitalCities.put("101", new Country("Saudi Arabia", "Riyadh"));
    capitalCities.put("102", new Country("England", "London"));
    capitalCities.put("103", new Country("India", "New Dehli"));
    capitalCities.put("104", new Country("Pakistan", "Islamabad")); 
    capitalCities.put("105", new Country("Afganistan", "Kabul"));
    capitalCities.put("106", new Country("France", "Paris"));
    
    

    System.out.println(capitalCities.size());
    
    capitalCities.entrySet()
    .stream()
    .filter(entry -> entry.getValue().getCountryName().startsWith("A")) // Example filter
    .forEach(entry -> {
        Country c = entry.getValue();
        System.out.println("Country ID: " + entry.getKey() +
                           " | Name: " + c.getCountryName() +
                           " | Capital: " + c.getCapitalCity());
    });

    
 
    
  }
}

