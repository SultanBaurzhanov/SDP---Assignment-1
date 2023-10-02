package currencyConverter;

import java.util.ArrayList;

public class Currency {
    private String name;
    private String shortName;

    // "Currency" Constructor
    public Currency(String nameValue, String shortNameValue) {
        this.name = nameValue;
        this.shortName = shortNameValue;
    }
	
	// Getter for name
	public String getName() {
		return this.name;
	}
	
	// Setter for name
	public void setName(String name) {
		this.name = name;
	}
	
	// Getter for shortName
	public String getShortName() {
		return this.shortName;
	}
	
	// Setter for shortName
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	// Set default values for a currency
	public void defaultValues() {
        RateManager rateManager = RateManager.getInstance();
        String currency = this.name;

        switch (currency) {
            case "US Dollar":
                rateManager.addExchangeRate("USD", "USD", 1.00);
                rateManager.addExchangeRate("USD", "EUR", 0.93);
                rateManager.addExchangeRate("USD", "GBP", 0.66);
                rateManager.addExchangeRate("USD", "CHF", 1.01);
                rateManager.addExchangeRate("USD", "CNY", 6.36);
                rateManager.addExchangeRate("USD", "JPY", 123.54);
                break;
            case "Euro":
                rateManager.addExchangeRate("EUR", "USD", 1.073);
                rateManager.addExchangeRate("EUR", "EUR", 1.00);
                rateManager.addExchangeRate("EUR", "GBP", 0.71);
                rateManager.addExchangeRate("EUR", "CHF", 1.08);
                rateManager.addExchangeRate("EUR", "CNY", 6.83);
                rateManager.addExchangeRate("EUR", "JPY", 132.57);
                break;
			case "British Pound":
                rateManager.addExchangeRate("GBP", "USD", 1.51);
                rateManager.addExchangeRate("GBP", "EUR", 1.41);
                rateManager.addExchangeRate("GBP", "GBP", 1.00);
                rateManager.addExchangeRate("GBP", "CHF", 1.52);
                rateManager.addExchangeRate("GBP", "CNY", 9.60);
                rateManager.addExchangeRate("GBP", "JPY", 186.41);
                break;
			case "Swiss Franc":
                rateManager.addExchangeRate("CHF", "USD", 0.99);
                rateManager.addExchangeRate("CHF", "EUR", 0.93);
                rateManager.addExchangeRate("CHF", "GBP", 0.66);
                rateManager.addExchangeRate("CHF", "CHF", 1.00);
                rateManager.addExchangeRate("CHF", "CNY", 6.33);
                rateManager.addExchangeRate("CHF", "JPY", 122.84);
                break;
			case "Chinese Yuan Renminbi":
                rateManager.addExchangeRate("CNY", "USD", 0.16);
                rateManager.addExchangeRate("CNY", "EUR", 0.15);
                rateManager.addExchangeRate("CNY", "GBP", 0.11);
                rateManager.addExchangeRate("CNY", "CHF", 0.16);
                rateManager.addExchangeRate("CNY", "CNY", 1.00);
                rateManager.addExchangeRate("CNY", "JPY", 19.41);
                break;
			case "Japanese Yen":
                rateManager.addExchangeRate("JPY", "USD", 0.008);
                rateManager.addExchangeRate("JPY", "EUR", 0.007);
                rateManager.addExchangeRate("JPY", "GBP", 0.005);
                rateManager.addExchangeRate("JPY", "CHF", 0.008);
                rateManager.addExchangeRate("JPY", "CNY", 0.051);
                rateManager.addExchangeRate("JPY", "JPY", 1.000);
                break;
		}
	}
	
	// Initialize currencies
	public static ArrayList<Currency> init() {
		ArrayList<Currency> currencies = new ArrayList<Currency>();

		currencies.add(new Currency("US Dollar", "USD"));
		currencies.add(new Currency("Euro", "EUR"));
		currencies.add(new Currency("British Pound", "GBP"));
		currencies.add(new Currency("Swiss Franc", "CHF"));
		currencies.add(new Currency("Chinese Yuan Renminbi", "CNY"));
		currencies.add(new Currency("Japanese Yen", "JPY"));

		for (Currency currency : currencies) {
			currency.defaultValues();
		}

		return currencies;
	}
	
	// Convert a currency to another
    public static Double convert(Double amount, Double exchangeRate) {
        Double convertedAmount = amount * exchangeRate;
        return Math.round(convertedAmount * 100d) / 100d;
    }

}