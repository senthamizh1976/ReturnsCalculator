Feature: FX Calculator for BestDeals Bank

Scenario: Get FX Rate for single currency
    Given sourceCurrency is GBP and targetCurrency is USD
    Then The conversionRate is 1.28864
Scenario: Calculate FX conversion amount in USD
    Given sourceCurrency is GBP, targetCurrency is USD and conversionAmount given as 100.00
    Then result must be 128.864

Scenario Outline: Get FX Rate for multiple currencies
    Given sourceCurrency is <sourceCurrency1> and targetCurrency is <targetCurrency1>
    Then The conversionRate is <conversionRate1>

    Examples:
        | sourceCurrency1 | targetCurrency1 | conversionRate1 |
        | GBP | USD | 1.28864 |
        | GBP | INR | 82.7989 |
        | GBP | EUR | 1.17890 |

Scenario Outline: Calculate FX conversion amount for multiple currencies
    Given sourceCurrency is <sourceCurrency1>, targetCurrency is <targetCurrency1> and conversionAmount given as <conversionAmount1>
    Then result must be <convertedAmount1>

    Examples:
        | sourceCurrency1 | targetCurrency1 | conversionAmount1 | convertedAmount1 |
        | GBP | USD | 1000.00 | 1288.74 |
        | GBP | INR | 9999.99 | 827988.172011 |
        | GBP | EUR | 8546.58 | 10075.563162 |