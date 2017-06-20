Feature: search
Scenario Outline: searching city
Given city name <name> is typed in search field
When search button is clicked
Then results found should equal <resultCount>

Examples:
|name             | resultCount |
|szczebrzeszyn  |  1630000    |
|Piekary Śląskie|  4490000    |
|Tychy          |  16400000   |
|Bytom          |  18700000   |
|Katowice       |  62000000   |