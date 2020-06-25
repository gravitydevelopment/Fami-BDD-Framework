$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("AirAsiaWebApplication/RegistrationAndLogin/visitAirAsiaWebpage.feature");
formatter.feature({
  "line": 1,
  "name": "airAsiaHomePage",
  "description": "Accessing the Air Asia web page and verify its validity",
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
  "duration": 1226801800,
  "status": "passed"
});
formatter.match({
  "location": "airasiaHomepage.verifyTopPanel()"
});
formatter.result({
  "duration": 4133150500,
  "status": "passed"
});
formatter.match({
  "location": "airasiaHomepage.verifyBookingPanel()"
});
formatter.result({
  "duration": 2653072400,
  "status": "passed"
});
formatter.match({
  "location": "airasiaHomepage.verifyLoginPanel()"
});
formatter.result({
  "duration": 329393300,
  "status": "passed"
});
formatter.scenario({
  "line": 10,
  "name": "Login with without providing the credential information",
  "description": "",
  "id": "airasiahomepage;login-with-without-providing-the-credential-information",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 11,
  "name": "I access the Air Asia web application home page",
  "keyword": "Given "
});
formatter.step({
  "line": 12,
  "name": "I verify that the login panel is available",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I attemp to login with a blank username and password",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "I very that the login attempt is failing with a notification message \"Please enter your Email address.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "airasiaHomepage.accessHomePage()"
});
formatter.result({
  "duration": 2811296800,
  "status": "passed"
});
formatter.match({
  "location": "airasiaHomepage.verifyLoginPanel()"
});
formatter.result({
  "duration": 1256432200,
  "status": "passed"
});
formatter.match({
  "location": "airasiaHomepage.accessLoginPanelwithBlankUsernameandPassword()"
});
formatter.result({
  "duration": 298037100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Please enter your Email address.",
      "offset": 70
    }
  ],
  "location": "airasiaHomepage.verifyLoginFail(String)"
});
formatter.result({
  "duration": 175446000,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "Login with invalid user credential",
  "description": "",
  "id": "airasiahomepage;login-with-invalid-user-credential",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "I access the Air Asia web application home page",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "I verify that the login panel is available",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I attemp to login with an invalid username and password",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "I very that the login attempt is failing with a notification message \"Please enter a valid email (e.g: example@email.com)\"",
  "keyword": "Then "
});
formatter.match({
  "location": "airasiaHomepage.accessHomePage()"
});
formatter.result({
  "duration": 240442100,
  "status": "passed"
});
formatter.match({
  "location": "airasiaHomepage.verifyLoginPanel()"
});
formatter.result({
  "duration": 1119922300,
  "status": "passed"
});
formatter.match({
  "location": "airasiaHomepage.accessLoginPanelwithInvalidCredential()"
});
formatter.result({
  "duration": 1487618000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Please enter a valid email (e.g: example@email.com)",
      "offset": 70
    }
  ],
  "location": "airasiaHomepage.verifyLoginFail(String)"
});
formatter.result({
  "duration": 414433800,
  "status": "passed"
});
});