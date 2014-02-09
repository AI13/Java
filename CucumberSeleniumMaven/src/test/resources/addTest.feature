Feature: Test Add
	
Scenario: Get search result from Google
	Given Go to URL http://www.google.co.th
	When search using keyword "cucumber java"
	Then get all results