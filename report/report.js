$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("airAsiaHomePage.feature");
formatter.feature({
  "line": 1,
  "name": "airAsiaHomePage",
  "description": "Accessing the Air Asia web home page and verify its validity",
  "id": "airasiahomepage",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "User access the Air Asia Home Page",
  "description": "",
  "id": "airasiahomepage;user-access-the-air-asia-home-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I access the Air Asia web application home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I verify all the expected top panel link are available",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "I verify that the booking panel is available",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I verify that the login panel is available",
  "keyword": "And "
});
formatter.match({
  "location": "airasiaHomepage.accessHomePage()"
});
formatter.result({
  "duration": 948047100,
  "status": "passed"
});
formatter.match({
  "location": "airasiaHomepage.verifyTopPanel()"
});
formatter.result({
  "duration": 2364107000,
  "status": "passed"
});
formatter.match({
  "location": "airasiaHomepage.verifyBookingPanel()"
});
formatter.result({
  "duration": 3675960700,
  "status": "passed"
});
formatter.match({
  "location": "airasiaHomepage.verifyLoginPanel()"
});
formatter.result({
  "duration": 320385900,
  "status": "passed"
});
});