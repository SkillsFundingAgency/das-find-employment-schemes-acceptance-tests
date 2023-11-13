package sfa.das;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import sfa.das.driver.DriverFactory;
import java.time.Duration;
import java.util.*;
@Slf4j
public class StepDefinitions {
    public static final String ANCHOR_APPRENTICESHIPS = "Apprenticeships";
    public static final String ANCHOR_T_LEVELS = "T Levels: industry placements";
    public static final String ANCHOR_SWAP = "Sector-based Work Academy Programme (SWAP)";
    public static final String ANCHOR_BOOTCAMPS = "Skills Bootcamps";
    public static final String ANCHOR_MULTIPLY = "Multiply";
    public static final String ANCHOR_TRAINEESHIPS = "Traineeships";
    private static final String ANCHOR_HTQ = "Higher Technical Qualifications (HTQs)";
    public static final String ANCHOR_INTERNSHIPS = "Supported Internships for learners with an education, health and care plan";
    public static final String ANCHOR_CARE_LEAVER_COVENANT = "Care-Leaver covenant";
    public static final String ANCHOR_PRISONERS = "Employing prisoners and prison leavers";
    public static final String ANCHOR_FREE_COURSES = "Free courses and additional training for your employees";
    public static final String ANCHOR_HEADER_SERVICE_NAME = "Find schemes for your business";
    public static final String ANCHOR_HEADER_SKIP_TO_MAIN_CONTENT = "Skip to main content";
    public static final String ANCHOR_HEADER_VIEW_COOKIES = "View cookies";
    public static final String ANCHOR_HEADER_BETA_BANNER_FEEDBACK = "feedback";
    public static final String ANCHOR_HOME = "Home";
    public static final String ANCHOR_BACK = "Back";
    public static final String ANCHOR_COMPARED_PAGE_RETURN_TO_LIST = "Return to list of all schemes";
    public static final String ANCHOR_HOME_PAGE_COMPARE_SCHEMES_IN_A_TABLE = "Compare schemes in a table";
    public static final String ANCHOR_HOME_PAGE_FILTER_SCHEMES = "Filter schemes";
    public static final String ANCHOR_HOME_PAGE_CLEAR_FILTERS = "Clear filters";
    public static final String ANCHOR_HOME_PAGE_HIDE_FILTER = "Hide filter";
    public static final String ANCHOR_FOOTER_PRIVACY = "Privacy";
    public static final String ANCHOR_FOOTER_CONTACT = "Contact";
    public static final String ANCHOR_FOOTER_COOKIES = "Cookies";
    public static final String ANCHOR_FOOTER_ACCESSIBILITY_STATEMENT = "Accessibility statement";
    public static final String ANCHOR_FOOTER_OPEN_GOVERNMENT_LICENCE_V_3_0 = "Open Government Licence v3.0";
    public static final String ANCHOR_FOOTER_CROWN_COPYRIGHT = "© Crown copyright";
    public static final String ANCHOR_APPRENTICESHIP_TELEPHONE = "08000 150 400";
    public static final String ANCHOR_APPRENTICESHIP_THE_MINIMUM_WAGE = "the minimum wage";
    public static final String ANCHOR_APPRENTICESHIP_HOW_APPRENTICESHIPS_CAN_BENEFIT_YOUR_BUSINESS = "how apprenticeships can benefit your business";
    public static final String ANCHOR_APPRENTICESHIP_AUTHORITY_IN_SCOTLAND = "Apprenticeship authority in Scotland";
    public static final String ANCHOR_APPRENTICESHIP_AUTHORITY_IN_WALES = "Apprenticeship authority in Wales";
    public static final String ANCHOR_APPRENTICESHIP_AUTHORITY_IN_NORTHERN_IRELAND = "Apprenticeship authority in Northern Ireland";
    public static final String ANCHOR_TLEVEL_ACCELERATE_THEIR_APPRENTICESHIPS = "accelerate their apprenticeships";
    public static final String ANCHOR_TLEVEL_GET_MORE_INFORMATION_ABOUT_T_LEVELS_AND_INDUSTRY_PLACEMENTS = "Get more information about T Levels and industry placements";
    public static final String ANCHOR_SWAP_HOW_SWAP_COULD_BENEFIT_YOUR_BUSINESS = "how SWAP could benefit your business";
    public static final String ANCHOR_SWAP_HOW_EMPLOYERS_ARE_USING_SECTOR_BASED_WORK_ACADEMY_PROGRAMMES = "how employers are using sector-based work academy programmes";
    public static final String ANCHOR_SWAP_TELEPHONE = "0800 169 0178";
    public static final String ANCHOR_BOOTCAMP_ACCELERATE_THEIR_APPRENTICESHIPS = "accelerate their apprenticeships";
    public static final String ANCHOR_SWAP_FINDING_TRAINING_PROVIDERS_WHO_ARE_CURRENTLY_BEING_FUNDED_TO_DELIVER_SKILLS_BOOTCAMPS = "finding training providers who are currently being funded to deliver Skills Bootcamps";
    public static final String ANCHOR_MULTIPLE_FIND_A_COURSE = "Find a course";
    public static final String ANCHOR_MULTIPLE_EMAIL = "multiply.localallocations@education.gov.uk";
    public static final String ANCHOR_MULTIPLE_READ_MORE_ABOUT_MULTIPLY_SKILLS_FOR_LIFE = "read more about Multiply - Skills for Life";
    public static final String ANCHOR_HTQ_LEARN_MORE_AND_GET_STARTED_WITH_HTQS = "Learn more and get started with HTQs.";
    public static final String ANCHOR_INTERNSHIPS_EDUCATION_HEALTH_AND_CARE_EHC_PLAN = "education health and care (EHC) plan";
    public static final String ANCHOR_INTERNSHIPS_GUIDANCE_ON_SUPPORTED_INTERNSHIPS = "guidance on supported internships";
    public static final String ANCHOR_CARERLEAVERCOVENANT_FIND_OUT_HOW_TO_JOIN_THE_CARE_LEAVERS_COVENANT = "Find out how to join the Care Leavers Covenant";
    public static final String ANCHOR_PRISONERS_THE_MINIMUM_WAGE = "the minimum wage";
    public static final String ANCHOR_PRISONERS_HOW_BUSINESSES_ARE_WORKING_WITH_SERVING_PRISONERS_AND_HIRING_PRISON_LEAVERS = "how businesses are working with serving prisoners and hiring prison leavers";
    public static final String ANCHOR_PRISONERS_REGISTER_YOUR_INTEREST_ON_THE_NEW_FUTURES_NETWORK_WEBSITE = "Register your interest on the New Futures Network website.";
    public static final String ANCHOR_FREECOURSES_THE_NATIONAL_CAREERS_SERVICE_AND_HOW_TO_CONTACT_THEM = "the National Careers Service and how to contact them";
    public static final String ANCHOR_FREECOURSES_FOR_JOBS = "Free Courses for Jobs";
    public static final String ANCHOR_APPRENTICESHIP_HIRE_AN_APPRENTICE = "Hire an apprentice";
    private WebDriver driver;
    private WebDriverWait wait;
    private Environments.Environment environment;
    Map<String, String> headersMap = new HashMap<>();
    Map<String, String> homeMap = new HashMap<>();
    Map<String, String> footerMap = new HashMap<>();
    Map<String, String> schemesMap = new HashMap<>();
    Map<String, String> backMap = new HashMap<>();
    Map<String, String> apprenticeshipsMap = new HashMap<>();
    Map<String, String> tLevels = new HashMap<>();
    Map<String, String> swap = new HashMap<>();
    Map<String, String> bootcamps = new HashMap<>();
    Map<String, String> multiply = new HashMap<>();
    Map<String, String> traineeships = new HashMap<>();
    Map<String, String> htq = new HashMap<>();
    Map<String, String> internships = new HashMap<>();
    Map<String, String> careLeaverCovenant = new HashMap<>();
    Map<String, String> prisoners = new HashMap<>();
    Map<String, String> freeCourses = new HashMap<>();

    @Before(order = 1)
    public void setup(Scenario scenario) {
        if (driver == null) {
            var webdriver = System.getProperty("browser", "htmlunit").toLowerCase();
            try {
                driver = DriverFactory.getBaseDriver(DriverFactory.DriverType.value(webdriver));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        final var env = System.getProperty("env", "at");
        environment = Environments.get(env);
        driver.get(environment.getUrl());

        headersMap.put(ANCHOR_HEADER_VIEW_COOKIES, "Cookies");
        headersMap.put(ANCHOR_HEADER_SKIP_TO_MAIN_CONTENT, "Find training and employment schemes for your business");
        headersMap.put(ANCHOR_HEADER_SERVICE_NAME, "Find training and employment schemes for your business");
        headersMap.put(ANCHOR_HEADER_BETA_BANNER_FEEDBACK, "Feedback on 'Find Schemes for your Business' Service");

        homeMap.put(ANCHOR_HOME_PAGE_FILTER_SCHEMES, "Find training and employment schemes for your business");
        homeMap.put(ANCHOR_HOME_PAGE_COMPARE_SCHEMES_IN_A_TABLE, "Find training and employment schemes for your business");

        footerMap.put(ANCHOR_FOOTER_PRIVACY, "Privacy Notice");
        footerMap.put(ANCHOR_FOOTER_COOKIES, "Cookies");
        footerMap.put(ANCHOR_FOOTER_ACCESSIBILITY_STATEMENT, "Accessibility statement");
        footerMap.put(ANCHOR_FOOTER_CONTACT, "");
        footerMap.put(ANCHOR_FOOTER_OPEN_GOVERNMENT_LICENCE_V_3_0, "Open Government Licence");
        footerMap.put(ANCHOR_FOOTER_CROWN_COPYRIGHT, "Crown copyright - Re-using PSI");

        schemesMap.put(ANCHOR_APPRENTICESHIPS, "Apprenticeships");
        schemesMap.put(ANCHOR_T_LEVELS, "T Levels: industry placements");
        schemesMap.put(ANCHOR_SWAP, "Sector-based Work Academy Programme (SWAP)");
        schemesMap.put(ANCHOR_BOOTCAMPS, "Skills Bootcamps");
        schemesMap.put(ANCHOR_MULTIPLY, "Multiply");
        schemesMap.put(ANCHOR_TRAINEESHIPS, "Traineeships");
        schemesMap.put(ANCHOR_HTQ, "Higher Technical Qualifications (HTQs)");
        schemesMap.put(ANCHOR_INTERNSHIPS, "Supported Internships for learners with an education, health and"); //todo title not complete
        schemesMap.put(ANCHOR_CARE_LEAVER_COVENANT, "Care-Leaver covenant");
        schemesMap.put(ANCHOR_PRISONERS, "Employing prisoners and prison leavers");
        schemesMap.put(ANCHOR_FREE_COURSES, "Free courses and additional training for your employees");

        backMap.put(ANCHOR_HOME, "Find training and employment schemes for your business");

        apprenticeshipsMap.put(ANCHOR_APPRENTICESHIP_THE_MINIMUM_WAGE, "National Minimum Wage and National Living Wage rates - GOV.UK");
        apprenticeshipsMap.put(ANCHOR_APPRENTICESHIP_HOW_APPRENTICESHIPS_CAN_BENEFIT_YOUR_BUSINESS, "What are the benefits of hiring an apprentice?");
        apprenticeshipsMap.put(ANCHOR_APPRENTICESHIP_HIRE_AN_APPRENTICE, "Recruiting an apprentice");
        apprenticeshipsMap.put(ANCHOR_APPRENTICESHIP_TELEPHONE, ""); //todo opens facetime
        apprenticeshipsMap.put(ANCHOR_APPRENTICESHIP_AUTHORITY_IN_SCOTLAND, "Apprenticeships.scot Homepage");
        apprenticeshipsMap.put(ANCHOR_APPRENTICESHIP_AUTHORITY_IN_WALES, "Apprenticeships | Business Wales Skills Gateway");
        apprenticeshipsMap.put(ANCHOR_APPRENTICESHIP_AUTHORITY_IN_NORTHERN_IRELAND, "Apprenticeships | nidirect");

        tLevels.put(ANCHOR_TLEVEL_ACCELERATE_THEIR_APPRENTICESHIPS, "How can apprenticeships be delivered for your business? - GOV.UK");
        tLevels.put(ANCHOR_TLEVEL_GET_MORE_INFORMATION_ABOUT_T_LEVELS_AND_INDUSTRY_PLACEMENTS, "T Levels and industry placement support for employers");

        swap.put(ANCHOR_SWAP_HOW_SWAP_COULD_BENEFIT_YOUR_BUSINESS, "Sector-based work academy programme: employer guide - GOV.UK");
        swap.put(ANCHOR_SWAP_HOW_EMPLOYERS_ARE_USING_SECTOR_BASED_WORK_ACADEMY_PROGRAMMES, "How employers are benefitting from sector-based work academies - Case study - GOV.UK");
        swap.put(ANCHOR_SWAP_TELEPHONE, ""); //todo opens facetime

        bootcamps.put(ANCHOR_BOOTCAMP_ACCELERATE_THEIR_APPRENTICESHIPS, "How can apprenticeships be delivered for your business? - GOV.UK");
        bootcamps.put(ANCHOR_SWAP_FINDING_TRAINING_PROVIDERS_WHO_ARE_CURRENTLY_BEING_FUNDED_TO_DELIVER_SKILLS_BOOTCAMPS, "Skills Bootcamps training providers - GOV.UK");

        multiply.put(ANCHOR_MULTIPLE_FIND_A_COURSE, "Results | Find a course | National Careers Service");
        multiply.put(ANCHOR_MULTIPLE_EMAIL, ""); //todo tries to open mail
        multiply.put(ANCHOR_MULTIPLE_READ_MORE_ABOUT_MULTIPLY_SKILLS_FOR_LIFE, "Multiply - Skills for Life");


        traineeships.put("written ministerial statement on the skills update", "Written statements - Written questions, answers and statements - UK Parliament");
        traineeships.put("how traineeships can benefit your business", "[Withdrawn] Traineeship information for employers - GOV.UK");
        traineeships.put("accelerate their apprenticeships", "How can apprenticeships be delivered for your business? - GOV.UK");
        traineeships.put("written ministerial statement on the skills update", "Written statements - Written questions, answers and statements - UK Parliament");

        htq.put(ANCHOR_HTQ_LEARN_MORE_AND_GET_STARTED_WITH_HTQS, "Providers delivering Higher Technical Qualifications - GOV.UK");

        internships.put(ANCHOR_INTERNSHIPS_EDUCATION_HEALTH_AND_CARE_EHC_PLAN, "Children with special educational needs and disabilities (SEND): Extra help - GOV.UK");
        internships.put(ANCHOR_INTERNSHIPS_GUIDANCE_ON_SUPPORTED_INTERNSHIPS, "Providing supported internships for young people with an EHC plan - GOV.UK");

        careLeaverCovenant.put(ANCHOR_CARERLEAVERCOVENANT_FIND_OUT_HOW_TO_JOIN_THE_CARE_LEAVERS_COVENANT, "Companies & Charities - Care Leaver Covenant");

        prisoners.put(ANCHOR_PRISONERS_THE_MINIMUM_WAGE, "National Minimum Wage and National Living Wage rates - GOV.UK");
        prisoners.put(ANCHOR_PRISONERS_HOW_BUSINESSES_ARE_WORKING_WITH_SERVING_PRISONERS_AND_HIRING_PRISON_LEAVERS, "https://newfuturesnetwork.gov.uk/case-studies/#"); //todo link doesn't work
        prisoners.put(ANCHOR_PRISONERS_REGISTER_YOUR_INTEREST_ON_THE_NEW_FUTURES_NETWORK_WEBSITE, "https://newfuturesnetwork.gov.uk/register/"); //todo link doesn't work

        freeCourses.put(ANCHOR_FREECOURSES_THE_NATIONAL_CAREERS_SERVICE_AND_HOW_TO_CONTACT_THEM, "Careers advice - job profiles, information and resources | National Careers Service");
        freeCourses.put(ANCHOR_FREECOURSES_FOR_JOBS, "Free courses for jobs - GOV.UK");

    }
    public WebElement getAnchor(String text) {
        return driver.findElement(By.xpath(String.format("//a[normalize-space()='%s']", text)));
    }
    @Then("all APPRENTICESHIPS anchors link to the correct pages")
    public void allAPPRENTICESHIPSAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(apprenticeshipsMap);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_APPRENTICESHIP_TELEPHONE);  //todo tries to open facetime
        anchorsToRemove.add(ANCHOR_APPRENTICESHIPS);

        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }
    @Then("all SWAP anchors link to the correct pages")
    public void allSWAPAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(swap);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_SWAP_TELEPHONE); //todo tries to open facetime
        anchorsToRemove.add(ANCHOR_SWAP);

        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }
    @Then("all BOOTCAMPS anchors link to the correct pages")
    public void allBOOTCAMPSAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(bootcamps);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_BOOTCAMPS);

        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }
    @Then("all MULTIPLY anchors link to the correct pages")
    public void allMULTIPLYAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(multiply);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_MULTIPLE_EMAIL); //todo tries to open mail
        anchorsToRemove.add(ANCHOR_MULTIPLY);

        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }
    @Then("all TRAINEESHIPS anchors link to the correct pages")
    public void allTRAINEESHIPSAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(traineeships);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_TRAINEESHIPS);

        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }
    @Then("all HTQ anchors link to the correct pages")
    public void allHTQAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(htq);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.remove(ANCHOR_HTQ);

        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }
    @Then("all INTERNSHIPS anchors link to the correct pages")
    public void allINTERNSHIPSAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(internships);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.remove(ANCHOR_INTERNSHIPS);

        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }
    @Then("all CARE_LEAVER_COVENANT anchors link to the correct pages")
    public void allCARE_LEAVER_COVENANTAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(careLeaverCovenant);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.remove(ANCHOR_CARE_LEAVER_COVENANT);

        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }
    @Then("all PRISONERS anchors link to the correct pages")
    public void allPRISONERSAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(prisoners);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.remove(ANCHOR_PRISONERS);

        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }

    @Then("all FREE_COURSES anchors link to the correct pages")
    public void allFREE_COURSESAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(freeCourses);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.remove(ANCHOR_FREE_COURSES);

        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }
    @Then("all T_LEVELS anchors link to the correct pages")
    public void allT_LEVELSAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(tLevels);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.remove(ANCHOR_T_LEVELS);

        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }
    private void confirmPageAnchorsLite(Map<String, String> expectedAnchorsMap, List<String> anchorsToRemove) throws InterruptedException {
        //expectedAnchorsMap.putAll(headersMap);
        //expectedAnchorsMap.putAll(schemesMap);
        //expectedAnchorsMap.putAll(footerMap);

        anchorsToRemove.addAll(headersMap.keySet());
        anchorsToRemove.addAll(schemesMap.keySet());
        anchorsToRemove.addAll(footerMap.keySet());

        anchorsToRemove.add(ANCHOR_HEADER_SERVICE_NAME); //todo not always a link
        anchorsToRemove.add(ANCHOR_HEADER_SKIP_TO_MAIN_CONTENT); //stays on same page
        anchorsToRemove.add(ANCHOR_FOOTER_CONTACT); //todo depends on having an Outlook account

        compareAndClickAnchors(expectedAnchorsMap, anchorsToRemove);
    }
    private void compareAndClickAnchors(Map<String, String> expectedAnchorsMap, List<String> anchorsToRemove) throws InterruptedException {
        List<String> mutableNonEmptyActualAnchors = confirmActualAnchors(new ArrayList<>(expectedAnchorsMap.keySet()), anchorsToRemove);

        for (String anchorText : mutableNonEmptyActualAnchors) {
            log.info("link " + anchorText + " : title " + driver.getTitle());
            WebElement anchorElement = getAnchor(anchorText);
            anchorElement.click();
            int retryCount = 3;
            try {
                Assert.assertEquals("Wrong title for anchor " + anchorText, expectedAnchorsMap.get(anchorText), driver.getTitle());
                driver.navigate().back();
            } catch (AssertionError e) {
                log.info("title " + driver.getTitle());
                //check href instead as
                if (driver.getTitle().equals("Just a moment...") || //T Levels: security prevents automation to going to linked website --
                        driver.getTitle().equals("Privacy error"))  //Prisoner: 503 error
                {
                    Thread.sleep(1000);
                    driver.navigate().back();
                    Assert.assertEquals("Href not as expected " + anchorText, expectedAnchorsMap.get(anchorText), anchorElement.getAttribute(("href")).trim());
                } else {
                    for (int i = 0; i < retryCount; i++) {
                        //sometimes there's a delay in getting the title
                        Thread.sleep(1000);
                        Assert.assertEquals("Wrong title for anchor " + anchorText, expectedAnchorsMap.get(anchorText), driver.getTitle());
                    }
                    driver.navigate().back();
                }
            }
        }
    }
    @NotNull
    private List<String> confirmActualAnchors(List<String> expectedAnchors, List<String> anchorsToRemove) {
        List<String> actualAnchors = new ArrayList<>();
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        for (WebElement anchor : anchors) {
            String anchorText = anchor.getText();
            actualAnchors.add(anchorText);
        }

        for (String anchor : anchorsToRemove) {
            removeAnchorToCompare(actualAnchors, expectedAnchors, anchor); //stays on same page
        }

        List<String> nonEmptyActualAnchors = actualAnchors.stream().filter(anchor -> !anchor.isEmpty()).toList();
        Collections.sort(expectedAnchors);
        List<String> mutableNonEmptyActualAnchors = new ArrayList<>(nonEmptyActualAnchors);
        Collections.sort(mutableNonEmptyActualAnchors);

        log.info("mutableNonEmptyActualAnchors.toString()");
        log.info(mutableNonEmptyActualAnchors.toString()
                .replace(ANCHOR_APPRENTICESHIPS, "APPRENTICESHIPS")
                .replace(ANCHOR_T_LEVELS, "T_LEVELS")
                .replace(ANCHOR_SWAP, "SWAP")
                .replace(ANCHOR_BOOTCAMPS, "BOOTCAMPS")
                .replace(ANCHOR_MULTIPLY, "MULTIPLY")
                .replace(ANCHOR_TRAINEESHIPS, "TRAINEESHIPS")
                .replace(ANCHOR_HTQ, "HTQ")
                .replace(ANCHOR_INTERNSHIPS, "INTERNSHIPS")
                .replace(ANCHOR_CARE_LEAVER_COVENANT, "CARE_LEAVER_COVENANT")
                .replace(ANCHOR_PRISONERS, "PRISONERS")
                .replace(ANCHOR_FREE_COURSES, "FREE_COURSES")
        );

        Assert.assertEquals("anchors list should be the same", expectedAnchors, mutableNonEmptyActualAnchors);
        return mutableNonEmptyActualAnchors;
    }

    @Then("all HOME anchors link to the correct pages")
    public void allHOMEAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(homeMap);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_HOME_PAGE_FILTER_SCHEMES); //stays on same page

        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }
    private static void removeAnchorToCompare(List<String> actualAnchors, List<String> expectedAnchors, String link) {
        actualAnchors.remove(link); //stays on same page
        expectedAnchors.remove(link); //stays on same page
    }
    @When("the user navigates to the {string} page")
    public void theUserNavigatesToThePage(String destination) {
        switch (destination) {
            case "HOME" -> Assert.assertEquals(driver.getTitle(), backMap.get(ANCHOR_HOME));
            case "APPRENTICESHIPS" -> {
                getAnchor(ANCHOR_APPRENTICESHIPS).click();
                Assert.assertEquals(driver.getTitle(), schemesMap.get(ANCHOR_APPRENTICESHIPS));
            }
            case "T_LEVELS" -> {
                getAnchor(ANCHOR_T_LEVELS).click();
                Assert.assertEquals(driver.getTitle(), schemesMap.get(ANCHOR_T_LEVELS));
            }
            case "SWAP" -> {
                getAnchor(ANCHOR_SWAP).click();
                Assert.assertEquals(driver.getTitle(), schemesMap.get(ANCHOR_SWAP));
            }
            case "BOOTCAMPS" -> {
                getAnchor(ANCHOR_BOOTCAMPS).click();
                Assert.assertEquals(driver.getTitle(), schemesMap.get(ANCHOR_BOOTCAMPS));
            }
            case "MULTIPLY" -> {
                getAnchor(ANCHOR_MULTIPLY).click();
                Assert.assertEquals(driver.getTitle(), schemesMap.get(ANCHOR_MULTIPLY));
            }
            case "TRAINEESHIPS" -> {
                getAnchor(ANCHOR_TRAINEESHIPS).click();
                Assert.assertEquals(driver.getTitle(), schemesMap.get(ANCHOR_TRAINEESHIPS));
            }
            case "HTQ" -> {
                getAnchor(ANCHOR_HTQ).click();
                Assert.assertEquals(driver.getTitle(), schemesMap.get(ANCHOR_HTQ));
            }
            case "INTERNSHIPS" -> {
                getAnchor(ANCHOR_INTERNSHIPS).click();
                Assert.assertEquals(driver.getTitle(), schemesMap.get(ANCHOR_INTERNSHIPS));
            }
            case "CARE_LEAVER_COVENANT" -> {
                getAnchor(ANCHOR_CARE_LEAVER_COVENANT).click();
                Assert.assertEquals(driver.getTitle(), schemesMap.get(ANCHOR_CARE_LEAVER_COVENANT));
            }
            case "PRISONERS" -> {
                getAnchor(ANCHOR_PRISONERS).click();
                Assert.assertEquals(driver.getTitle(), schemesMap.get(ANCHOR_PRISONERS));
            }
            case "FREE_COURSES" -> {
                getAnchor(ANCHOR_FREE_COURSES).click();
                WebElement button = driver.findElement(By.xpath("//*[text()='Show all sections']"));
                button.click();
                Assert.assertEquals(driver.getTitle(), schemesMap.get(ANCHOR_FREE_COURSES));
            }
            default -> Assert.fail("unknown page");
        }
    }
    @After()
    public void after(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {

            String pageSource = this.driver.getPageSource();
            scenario.log(pageSource);
            log.error("++++ Scenario '{}': {} ++++", scenario.getName(), scenario.getStatus());

        } else {
            log.info("++++ Scenario '{}': {} ++++", scenario.getName(), scenario.getStatus());
        }
        driver.quit();
    }
    @Then("filter reports the correct data")
    public void filterReportsTheCorrectData() {
        getAnchor(ANCHOR_HOME_PAGE_FILTER_SCHEMES).click();

        WebElement numberOfSchemesHeading = driver.findElement(By.id("number-of-schemes-heading"));
        log.info("numberOfSchemesHeading : " + numberOfSchemesHeading.getText());

        Assert.assertEquals("When nothing is filtered, scheme count is wrong ", "Number of Schemes: 11", numberOfSchemesHeading.getText().trim());

        List<String> anchorsToRemove = new ArrayList<>();
        anchorsToRemove.addAll(headersMap.keySet());
        anchorsToRemove.addAll(footerMap.keySet());
        anchorsToRemove.add(ANCHOR_HOME_PAGE_FILTER_SCHEMES);
        anchorsToRemove.add(ANCHOR_HOME_PAGE_CLEAR_FILTERS);
        anchorsToRemove.add(ANCHOR_HOME_PAGE_COMPARE_SCHEMES_IN_A_TABLE);
        anchorsToRemove.add(ANCHOR_HOME_PAGE_HIDE_FILTER);

        confirmActualAnchors(new ArrayList<>(schemesMap.keySet()), anchorsToRemove);
        checkboxCombo();
    }

    public void checkboxCombo() {
        By checkBox1Locator = By.id("motivations--full-time-role");
        By checkBox2Locator = By.id("motivations--unpaid-placement");
        By checkBox3Locator = By.id("motivations--diversity-or-responsibility");

        By checkBox4Locator = By.id("scheme-length--up-to-4-months");
        By checkBox5Locator = By.id("scheme-length--4-months-to-12-months");
        By checkBox6Locator = By.id("scheme-length--a-year-or-more");

        By checkBox7Locator = By.id("pay--minimum-wage");
        By checkBox8Locator = By.id("pay--unpaid");

        // Create a Map to store the checkbox combinations
        Map<List<Boolean>, List<String>> combinationsMap = new LinkedHashMap<>();

        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, true, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, true, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, true, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, true, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, true, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, true, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, true, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, true, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, true, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, true, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, false, true, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, false, false, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_FREE_COURSES, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_HTQ, ANCHOR_MULTIPLY, ANCHOR_SWAP, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_T_LEVELS, ANCHOR_TRAINEESHIPS));

        List<String> anchorsToRemove = new ArrayList<>();

        anchorsToRemove.addAll(headersMap.keySet());
        anchorsToRemove.addAll(footerMap.keySet());
        anchorsToRemove.add(ANCHOR_HOME_PAGE_FILTER_SCHEMES);
        anchorsToRemove.add(ANCHOR_HOME_PAGE_CLEAR_FILTERS);
        anchorsToRemove.add(ANCHOR_HOME_PAGE_COMPARE_SCHEMES_IN_A_TABLE);
        anchorsToRemove.add(ANCHOR_HOME_PAGE_HIDE_FILTER);

        // Iterate over the Set of unique checkbox combinations and check the corresponding checkboxes
        for (List<Boolean> combination : combinationsMap.keySet()) {
            getAnchor(ANCHOR_HOME_PAGE_CLEAR_FILTERS).click();
            // Check the checkboxes
            if (combination.get(0)) {
                driver.findElement(checkBox1Locator).click();
            }
            if (combination.get(1)) {
                driver.findElement(checkBox2Locator).click();
            }
            if (combination.get(2)) {
                driver.findElement(checkBox3Locator).click();
            }
            if (combination.get(3)) {
                driver.findElement(checkBox4Locator).click();
            }
            if (combination.get(4)) {
                driver.findElement(checkBox5Locator).click();
            }
            if (combination.get(5)) {
                driver.findElement(checkBox6Locator).click();
            }
            if (combination.get(6)) {
                driver.findElement(checkBox7Locator).click();
            }
            if (combination.get(7)) {
                driver.findElement(checkBox8Locator).click();
            }

            log.info(combination.toString());
            log.info(combinationsMap.get(combination).toString());
            confirmActualAnchors(combinationsMap.get(combination), anchorsToRemove);
        }
    }
    @When("the user wants to compare the schemes")
    public void theUserWantsToCompareTheSchemes() {
        getAnchor(ANCHOR_HOME_PAGE_COMPARE_SCHEMES_IN_A_TABLE).click();
    }
    @And("selects the schemes to compare")
    public void selectsTheSchemesToCompare() {
        driver.findElement(By.id("apprenticeships")).click();
        driver.findElement(By.id("t-levels-industry-placements")).click();
        driver.findElement(By.id("sector-based-work-academy-programme-swap")).click();
        driver.findElement(By.id("skills-bootcamps")).click();
        driver.findElement(By.id("multiply")).click();
        driver.findElement(By.id("traineeships")).click();
        driver.findElement(By.id("higher-technical-qualifications")).click();
        driver.findElement(By.id("supported-internships")).click();
        driver.findElement(By.id("care-leaver-covenant")).click();
        driver.findElement(By.id("employing-prisoners-and-prison-leavers")).click();
        driver.findElement(By.id("free-courses-and-additional-training-for-your-employees")).click();
    }
    @Then("they see the selected schemes compared")
    public void theySeeTheSelectedSchemesCompared() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("//button[normalize-space(text())='Continue']"));
        button.click();

        List<String> anchorsToRemove = new ArrayList<>();
        anchorsToRemove.add(ANCHOR_BACK);
        anchorsToRemove.add(ANCHOR_COMPARED_PAGE_RETURN_TO_LIST);
        anchorsToRemove.add(ANCHOR_HEADER_SKIP_TO_MAIN_CONTENT); //stays on same page
        anchorsToRemove.add(ANCHOR_FOOTER_CONTACT); //todo depends on having an Outlook account

        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(headersMap);
        expectedAnchorsMap.putAll(schemesMap);
        expectedAnchorsMap.putAll(footerMap);

        compareAndClickAnchors(expectedAnchorsMap, anchorsToRemove);
    }
}