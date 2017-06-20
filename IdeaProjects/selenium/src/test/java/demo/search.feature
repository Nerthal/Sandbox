Feature: search
Scenario Outline: searching city
Given city name <name> is typed in search field
When search button is clicked
Then results found should equal <resultCount>

Examples:
|name             | resultCount |
|"szczebrzeszyn"  |  2040000    |
|"Piekary Śląskie"|  5150000    |
|"Tychy"          |  17200000   |
|"Bytom"          |  19700000   |
|"Katowice"       |  62000000   |