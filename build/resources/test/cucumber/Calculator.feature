Feature: Returns Calculator for BestDeals Bank

Scenario: Calculate Compound Interest Return
    Given principal is 3400, time is 3, interestRate is 4 and numberOfTime is 2
    Then The Compound Interest is 2475200.0

Scenario Outline: Calculate Compound Interest Return for multiple input parameters
    Given principal is <principal>, time is <time>, interestRate is <rate> and numberOfTime is <ntimes>
    Then The Compound Interest is <CompoundInterestReturn>

    Examples:
        | principal | time | rate | ntimes | CompoundInterestReturn |
        | 3400 | 3 | 4 | 2 | 2475200.0 |
        | 2000 | 5 | 2 | 3 | 4251644.981460951 |
        | 6400 | 2 | 1.4 | 3 | 57304.26430507543 |


Scenario: Calculate Simple Interest Return
    Given principal is 3400, interestRate is 4 and numberOfTime is 2
    Then The Simple Interest Return for single currency is 27200.0

Scenario Outline: Calculate Simple Interest Return for multiple input parameters
    Given principal is <principal>, interestRate is <rate> and numberOfTime is <ntimes>
    Then The Simple Interest Return for single currency is <SimpleInterestReturn>

    Examples:
        | principal | rate | ntimes | SimpleInterestReturn |
        | 3400 | 4 | 2 | 27200.0 |
        | 2000 | 2 | 3 | 12000.0 |
        | 6400 | 1.4 | 3 | 26880.0 |