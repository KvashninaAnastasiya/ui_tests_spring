**1**    **Agile testing** is a flexible approach to software quality assurance where testing is integrated into every stage of development, rather than being a separate phase at the end.
Continuous Integration (CI) means that the code is automatically built and tested after each change.
QA automation engineer writes automated tests.
manual tester tests the product manually.

**2**    **Test specification** is a detailed document that describes how, what, and under what conditions testing will be performed. It defines the objectives, scope, test scenarios, data, expected results, and pass/fail criteria for testing.

To translate manual script to the automation we need to prepare the testing scope : prioritize repeatable, stable, and critical scenarios.  To prepare test data, write tests, deploy them in CI, and monitor the process.

Challenges:

    Dynamic interface
    Unstable environment
    Code maintenance

**3**.Automation script is a script that performs checks on an application without human intervention, compares actual results with expected ones, and generates reports.
A manual test case is a detailed document outlining the steps a human tester must perform on a product. Performed manually.
tests that benefit from automation:

    regression
    smoke
    performance
    data-driven
Example: registration form validation. Automating negative tests will primarily allow for early detection of serious validation errors.

**4.** A framework is a structure that helps write and maintain automated tests.
   Popular Java frameworks: 
    
    JUnit, TestNG, Selenium, Cucumber, RestAssured, Allure.
   A good framework must be modular and Maintainable. It should have:
    
    Page Object Model.
    Reusable code.
    Store configurations and data separately.
    Be easy to maintain and support CI/CD.
**5.** **Severity:** how severely the bug breaks functionality. It describes how critical the defect is from a technical standpoint

   **Priority:** how urgently the fix needs to be.

   Automated tests help find regression errors immediately after code changes.
6. **Pros:** fast, stable, no human error.  Allows for more comprehensive testing and better cross-platform consistency.

   **Cons:** expensive to start, requires maintenance, not well-suited for visual inspections.Can be difficult to adapt to constant changes, especially if they are in the user interface, leading to frequent test failures.
   
   When automation should be avoided:
      
     
      Usability and exploratory tests
      Tests for unstable applications
      Low-value tests
      Tests that require visual inspection
      Highly complex or unpredictable scenarios

**Practice:**
**3.** Combination of decision table and equivalence classes
  ``` private Map<Integer,String> levels;
   @BeforeClass
   public void setUp(){
   levels=new HashMap<>();
   levels.put(1,"G");
   levels.put(2,"PG");
   levels.put(3,"P");
   levels.put(4,"NC-17");
   levels.put(5,"18+");
   }
   @DataProvider(name = "decisionTable")
   public Object[][] decisionTable() {
   List<Object[]> cases = new ArrayList<>();
   for (Integer rank : levels.keySet()) {
   cases.add(new Object[]{ rank, rank, true });
   if (rank!=1) cases.add(new Object[]{ rank, rank-1, true });
   if (rank!=5) cases.add(new Object[]{ rank, rank+1, false });
   }
   return cases.toArray(new Object[0][]);
   }

   @Test(dataProvider = "decisionTable")
   public void verifyDecisionTable(Integer row, Integer col, boolean expected) {
   System.out.println("Enter channel logic for set rating for user: "+levels.get(row)+"; rating of the channel: "+levels.get(col)+" And expected result: "+ expected);
   }
   ```
15 test cases. Plus cases when user rank is unknown or Channel rank is not set -- 10 cases. In common 25 tc. The number of the channels doesn't matter.
**4.** Should be defined the target matrix (risk-based)

      Browsers/engines: Chromium (Chrome + Edge), Firefox, WebKit/Safari.
      OS: Windows, macOS, Linux (for headless grid), plus iOS/Android for mobile Safari/Chrome.
      Viewports: pick 6–8 covering breakpoints.(e.g., 360×740, 390×844)
      Prioritize by traffic & risk
Tools that can be used: Selenium+Selenium Grid, Browserstack

**5**

      Player Initialization and Loading
      Basic Playback Controls
      Seek/Progress Bar Interaction
      Fullscreen Functionality   
      Error Handling
**6**
**Steps:**
Explore: Navigate the site manually to identify critical workflows (e.g., “Sign Up,” “Plans & Pricing,” “Add to Cart”).

Identify Bug: Suppose the “Internet Plans” page fails to load on Safari.

Script: Create an automated test in Selenium to open the page, wait for elements, and assert their visibility.

Report: Capture screenshots, console logs, and test output. Document steps to reproduce and expected vs actual results.

Example outcome:
“The Internet Plans section fails to render in Safari 17. The loading spinner remains visible indefinitely, while network logs show a 404 on the ‘plans.json’ resource.”