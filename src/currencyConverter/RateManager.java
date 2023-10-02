package currencyConverter;

import java.util.HashMap;

public class RateManager {
    private static RateManager instance = null;
    private HashMap<String, HashMap<String, Double>> exchangeRates;

    private RateManager() {
        exchangeRates = new HashMap<>();
    }

    public static RateManager getInstance() {
        if (instance == null) {
            instance = new RateManager();
        }
        return instance;
    }

    public void addExchangeRate(String fromCurrency, String toCurrency, Double rate) {
        exchangeRates.computeIfAbsent(fromCurrency, k -> new HashMap<>()).put(toCurrency, rate);
    }

    public Double getExchangeRate(String fromCurrency, String toCurrency) {
        if (exchangeRates.containsKey(fromCurrency)) {
            HashMap<String, Double> rates = exchangeRates.get(fromCurrency);
            if (rates.containsKey(toCurrency)) {
                return rates.get(toCurrency);
            }
        }
        return 0.0; // 0 if no exchanges somehow
    }
}
