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
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import sfa.das.driver.DriverFactory;

import java.util.*;

@Slf4j
public class StepDefinitions {
    public static final String ANCHOR_APPRENTICESHIPS = "Apprenticeships";
    public static final String ANCHOR_T_LEVELS = "T Levels: industry placements";
    public static final String ANCHOR_SWAP = "Sector-based Work Academy Programme (SWAP)";
    public static final String ANCHOR_BOOTCAMPS = "Skills Bootcamps";
    public static final String ANCHOR_MULTIPLY = "Multiply";
    private static final String ANCHOR_HTQ = "Higher Technical Qualifications (HTQs)";
    public static final String ANCHOR_INTERNSHIPS = "Supported Internships for learners with an education, health and care plan";
    public static final String ANCHOR_CARE_LEAVER_COVENANT = "Care-Leaver covenant";
    public static final String ANCHOR_PRISONERS = "Employing prisoners and prison leavers";
    public static final String ANCHOR_FREE_COURSES = "Free courses and additional training for your employees";
    //todo  public static final String ANCHOR_HEADER_SERVICE_NAME = "Find schemes for your business";
    public static final String ANCHOR_HEADER_SKIP_TO_MAIN_CONTENT = "Skip to main content";
    public static final String ANCHOR_HEADER_VIEW_COOKIES = "View cookies";
    public static final String ANCHOR_HEADER_BETA_BANNER_FEEDBACK = "feedback";
    public static final String ANCHOR_HOME = "Business Home";
    public static final String ANCHOR_BACK = "Back";
    public static final String ANCHOR_COMPARED_PAGE_RETURN_TO_LIST = "Return to list of all schemes";
    public static final String ANCHOR_HOME_PAGE_COMPARE_SCHEMES_IN_A_TABLE = "Compare these schemes in a table";
    public static final String ANCHOR_SHARE_EMAIL = "Email";
    public static final String ANCHOR_SHARE_FACEBOOK = "Facebook";
    public static final String ANCHOR_SHARE_X = "X (formerly Twitter)";
    public static final String ANCHOR_SHARE_LINKEDIN = "LinkedIn";
    public static final String ANCHOR_HOME_PAGE_CLEAR_FILTERS = "Clear filters";
    public static final String ANCHOR_HOME_SKILLS_FOR_CAREERS = "Get career ideas and browse your training options";

    public static final String ANCHOR_FOOTER_PRIVACY = "Privacy";
    public static final String ANCHOR_FOOTER_COOKIES = "Cookies"; //todo needs to be confirmed

    public static final String ANCHOR_FOOTER_ACCESSIBILITY_STATEMENT = "Accessibility";

    public static final String ANCHOR_FOOTER_CONTACT = "Contact";

    public static final String ANCHOR_FOOTER_SCOTLAND = "Scotland";
    public static final String ANCHOR_FOOTER_WALES = "Wales";
    public static final String ANCHOR_FOOTER_NI = "Northern Ireland";
    public static final String ANCHOR_FOOTER_OPEN_GOVERNMENT_LICENCE_V_3_0 = "Open Government Licence v3.0";
    public static final String ANCHOR_FOOTER_CROWN_COPYRIGHT = "© Crown copyright";
    public static final String ANCHOR_APPRENTICESHIP_TELEPHONE = "08000 150 400";
    public static final String ANCHOR_APPRENTICESHIP_THE_MINIMUM_WAGE = "the minimum wage";
    public static final String ANCHOR_APPRENTICESHIP_HOW_APPRENTICESHIPS_CAN_BENEFIT_YOUR_BUSINESS = "how apprenticeships can benefit your business";
    public static final String ANCHOR_TLEVEL_ACCELERATE_THEIR_APPRENTICESHIPS = "accelerate their apprenticeships";
    public static final String ANCHOR_TLEVEL_GET_MORE_INFORMATION_ABOUT_T_LEVELS_AND_INDUSTRY_PLACEMENTS = "Get more information about T Levels and industry placements";
    public static final String ANCHOR_SWAP_HOW_SWAP_COULD_BENEFIT_YOUR_BUSINESS = "how SWAP could benefit your business";
    public static final String ANCHOR_SWAP_HOW_EMPLOYERS_ARE_USING_SECTOR_BASED_WORK_ACADEMY_PROGRAMMES = "how employers are using sector-based work academy programmes";
    public static final String ANCHOR_SWAP_TELEPHONE = "0800 169 0178";
    public static final String ANCHOR_BOOTCAMP_ACCELERATE_THEIR_APPRENTICESHIPS = "accelerate their apprenticeships";
    public static final String ANCHOR_SWAP_FINDING_TRAINING_PROVIDERS_WHO_ARE_CURRENTLY_BEING_FUNDED_TO_DELIVER_SKILLS_BOOTCAMPS = "finding training providers who are currently being funded to deliver Skills Bootcamps";
    public static final String ANCHOR_MULTIPLY_FIND_A_COURSE = "Find a course";
    public static final String ANCHOR_MULTIPLY_EMAIL = "multiply.localallocations@education.gov.uk";
    public static final String ANCHOR_MULTIPLY_READ_MORE_ABOUT_MULTIPLY_SKILLS_FOR_LIFE = "read more about Multiply - Skills for Life";
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
    public static final String ANCHOR_CONTACTS_CALL_CHARGES = "Call charges and phone numbers - GOV.UK (www.gov.uk)";
    public static final String ANCHOR_CONTACTS_APPRENTICESHIP_EMAIL = "employer.enquiries@education.gov.uk";
    public static final String ANCHOR_CONTACTS_APPRENTICESHIP_WEBSITE = "APPRENTICESHIP Scheme website";
    public static final String ANCHOR_CONTACTS_TLEVELS_EMAIL = "Tlevel.placement@education.gov.uk";
    public static final String ANCHOR_CONTACTS_TLEVELS_FORM = "TLEVELS Online contact form";
    public static final String ANCHOR_CONTACTS_TLEVELS_WEBSITE = "TLEVELS Scheme website";
    public static final String ANCHOR_CONTACTS_SWAP_WEBSITE = "SWAP Scheme website";
    public static final String ANCHOR_CONTACTS_MULTIPLY_EMAIL = "multiply.localallocations@education.gov.uk";
    public static final String ANCHOR_CONTACTS_MULTIPLY_FINDER = "Scheme course finder";
    public static final String ANCHOR_CONTACTS_CARERLEAVERCOVENANT_EMAIL = "info@mycovenant.org.uk";
    public static final String ANCHOR_CONTACTS_CARERLEAVERCOVENANT_FORM = "CARERLEAVERCOVENANT Online contact form";
    public static final String ANCHOR_CONTACTS_CARERLEAVERCOVENANT_WEBSITE = "Scheme website";
    public static final String ANCHOR_CONTACTS_BOOTCAMPS_WEBSITE = "BOOTCAMPS Scheme website";
    public static final String ANCHOR_CONTACTS_HTQ_WEBSITE = "HTQ Scheme website";
    public static final String ANCHOR_CONTACTS_INTERNSHIPS_WEBSITE = "INTERNSHIPS Scheme website";
    public static final String ANCHOR_CONTACTS_FREECOURSES_WEBSITE = "FREECOURSES Scheme website";
    public static final String ANCHOR_CONTACTS_PRISONERS_FORM = "PRISONERS Online contact form";
    public static final String ANCHOR_CONTACTS_PRISONERS_WEBSITE = "PRISONERS Scheme website";

    public static final String CURRENT_PAGE_URL = "CURRENT_PAGE_URL";

    private WebDriver driver;
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
    Map<String, String> htq = new HashMap<>();
    Map<String, String> internships = new HashMap<>();
    Map<String, String> careLeaverCovenant = new HashMap<>();
    Map<String, String> prisoners = new HashMap<>();
    Map<String, String> freeCourses = new HashMap<>();
    Map<String, String> contacts = new HashMap<>();

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
        final var env = System.getProperty("env", "at");
        environment = Environments.get(env);
        driver.get(environment.getUrl());

        headersMap.put(ANCHOR_HEADER_VIEW_COOKIES, "Cookies");
        headersMap.put(ANCHOR_HEADER_SKIP_TO_MAIN_CONTENT, "Find training and employment schemes for your business");
        headersMap.put(ANCHOR_HEADER_BETA_BANNER_FEEDBACK, "https://forms.office.com/r/JChsG8Ducg");

        homeMap.put(ANCHOR_HOME, "Find training and employment schemes for your business");
        homeMap.put(ANCHOR_HOME_PAGE_COMPARE_SCHEMES_IN_A_TABLE, "Find training and employment schemes for your business");
        homeMap.put(ANCHOR_HOME_PAGE_CLEAR_FILTERS, "Find training and employment schemes for your business");
        homeMap.put(ANCHOR_HOME_SKILLS_FOR_CAREERS, "https://www.skillsforcareers.education.gov.uk/");

        footerMap.put(ANCHOR_SHARE_EMAIL, "mailto:?body=" + CURRENT_PAGE_URL);
        footerMap.put(ANCHOR_SHARE_FACEBOOK, "https://www.facebook.com/sharer.php?u=" + CURRENT_PAGE_URL);
        footerMap.put(ANCHOR_SHARE_X, "https://twitter.com/intent/tweet?url=" + CURRENT_PAGE_URL);
        footerMap.put(ANCHOR_SHARE_LINKEDIN, "https://www.linkedin.com/sharing/share-offsite/?url=" + CURRENT_PAGE_URL);
        footerMap.put(ANCHOR_FOOTER_PRIVACY, "https://www.gov.uk/government/organisations/department-for-education/about/personal-information-charter");
        footerMap.put(ANCHOR_FOOTER_COOKIES, "Cookies");
        footerMap.put(ANCHOR_FOOTER_ACCESSIBILITY_STATEMENT, "Accessibility statement");
        footerMap.put(ANCHOR_FOOTER_CONTACT, "Contact");
        footerMap.put(ANCHOR_FOOTER_OPEN_GOVERNMENT_LICENCE_V_3_0, "Open Government Licence");
        footerMap.put(ANCHOR_FOOTER_CROWN_COPYRIGHT, "Crown copyright - Re-using PSI");

        footerMap.put(ANCHOR_FOOTER_SCOTLAND, "https://findbusinesssupport.gov.scot/service/training/get-funded-training-for-new-or-existing-staff-through-apprenticeships");
        footerMap.put(ANCHOR_FOOTER_WALES, "https://careerswales.gov.wales/employers");
        footerMap.put(ANCHOR_FOOTER_NI, "https://www.nibusinessinfo.co.uk/");


        schemesMap.put(ANCHOR_APPRENTICESHIPS, "Apprenticeships");
        schemesMap.put(ANCHOR_T_LEVELS, "T Levels: industry placements");
        schemesMap.put(ANCHOR_SWAP, "Sector-based Work Academy Programme (SWAP)");
        schemesMap.put(ANCHOR_BOOTCAMPS, "Skills Bootcamps");
        schemesMap.put(ANCHOR_MULTIPLY, "Multiply");
        schemesMap.put(ANCHOR_HTQ, "Higher Technical Qualifications (HTQs)");
        schemesMap.put(ANCHOR_INTERNSHIPS, "Supported Internships for learners with an education, health and"); //todo title not complete
        schemesMap.put(ANCHOR_CARE_LEAVER_COVENANT, "Care-Leaver covenant");
        schemesMap.put(ANCHOR_PRISONERS, "Employing prisoners and prison leavers");
        schemesMap.put(ANCHOR_FREE_COURSES, "Free courses and additional training for your employees");

        backMap.put(ANCHOR_BACK, "Find training and employment schemes for your business");

        apprenticeshipsMap.put(ANCHOR_APPRENTICESHIP_THE_MINIMUM_WAGE, "https://www.gov.uk/national-minimum-wage-rates");
        apprenticeshipsMap.put(ANCHOR_APPRENTICESHIP_HOW_APPRENTICESHIPS_CAN_BENEFIT_YOUR_BUSINESS, "https://www.apprenticeships.gov.uk/employers/benefits-of-hiring-apprentice");
        apprenticeshipsMap.put(ANCHOR_APPRENTICESHIP_HIRE_AN_APPRENTICE, "https://www.apprenticeships.gov.uk/employers/hiring-an-apprentice");
        apprenticeshipsMap.put(ANCHOR_APPRENTICESHIP_TELEPHONE, "tel:" + ANCHOR_APPRENTICESHIP_TELEPHONE.replace(" ", "")); //todo opens facetime

        tLevels.put(ANCHOR_TLEVEL_ACCELERATE_THEIR_APPRENTICESHIPS, "https://www.gov.uk/guidance/how-can-apprenticeships-be-delivered-for-your-business#accelerated-apprenticeships");
        tLevels.put(ANCHOR_TLEVEL_GET_MORE_INFORMATION_ABOUT_T_LEVELS_AND_INDUSTRY_PLACEMENTS, "https://employers.tlevels.gov.uk/hc/en-gb");

        swap.put(ANCHOR_SWAP_HOW_SWAP_COULD_BENEFIT_YOUR_BUSINESS, "Sector-based work academy programme: employer guide - GOV.UK");
        swap.put(ANCHOR_SWAP_HOW_EMPLOYERS_ARE_USING_SECTOR_BASED_WORK_ACADEMY_PROGRAMMES, "How employers are benefitting from sector-based work academies - Case study - GOV.UK");
        swap.put(ANCHOR_SWAP_TELEPHONE, "tel:" + ANCHOR_SWAP_TELEPHONE.replace(" ", ""));

        bootcamps.put(ANCHOR_BOOTCAMP_ACCELERATE_THEIR_APPRENTICESHIPS, "How can apprenticeships be delivered for your business? - GOV.UK");
        bootcamps.put(ANCHOR_SWAP_FINDING_TRAINING_PROVIDERS_WHO_ARE_CURRENTLY_BEING_FUNDED_TO_DELIVER_SKILLS_BOOTCAMPS, "Skills Bootcamps training providers - GOV.UK");

        multiply.put(ANCHOR_MULTIPLY_FIND_A_COURSE, "Results | Find a course | National Careers Service");
        multiply.put(ANCHOR_MULTIPLY_EMAIL, "mailto:" + ANCHOR_MULTIPLY_EMAIL);
        multiply.put(ANCHOR_MULTIPLY_READ_MORE_ABOUT_MULTIPLY_SKILLS_FOR_LIFE, "Multiply - Skills for Life");

        htq.put(ANCHOR_HTQ_LEARN_MORE_AND_GET_STARTED_WITH_HTQS, "Providers delivering Higher Technical Qualifications - GOV.UK");

        internships.put(ANCHOR_INTERNSHIPS_EDUCATION_HEALTH_AND_CARE_EHC_PLAN, "Children with special educational needs and disabilities (SEND): Extra help - GOV.UK");
        internships.put(ANCHOR_INTERNSHIPS_GUIDANCE_ON_SUPPORTED_INTERNSHIPS, "Providing supported internships for young people with an EHC plan - GOV.UK");

        careLeaverCovenant.put(ANCHOR_CARERLEAVERCOVENANT_FIND_OUT_HOW_TO_JOIN_THE_CARE_LEAVERS_COVENANT, "Companies & Charities - Care Leaver Covenant");

        prisoners.put(ANCHOR_PRISONERS_THE_MINIMUM_WAGE, "National Minimum Wage and National Living Wage rates - GOV.UK");
        prisoners.put(ANCHOR_PRISONERS_HOW_BUSINESSES_ARE_WORKING_WITH_SERVING_PRISONERS_AND_HIRING_PRISON_LEAVERS, "https://newfuturesnetwork.gov.uk/case-studies/#"); //todo link doesn't work
        prisoners.put(ANCHOR_PRISONERS_REGISTER_YOUR_INTEREST_ON_THE_NEW_FUTURES_NETWORK_WEBSITE, "https://newfuturesnetwork.gov.uk/register/"); //todo link doesn't work

        freeCourses.put(ANCHOR_FREECOURSES_THE_NATIONAL_CAREERS_SERVICE_AND_HOW_TO_CONTACT_THEM, "Careers advice - job profiles, information and resources | National Careers Service");
        freeCourses.put(ANCHOR_FREECOURSES_FOR_JOBS, "Free courses for jobs - GOV.UK");

        contacts.put(ANCHOR_CONTACTS_CALL_CHARGES, "https://www.gov.uk/call-charges");
        contacts.put(ANCHOR_CONTACTS_APPRENTICESHIP_EMAIL, "mailto:" + ANCHOR_CONTACTS_APPRENTICESHIP_EMAIL);
        contacts.put(ANCHOR_CONTACTS_APPRENTICESHIP_WEBSITE, "https://www.apprenticeships.gov.uk/");

        contacts.put(ANCHOR_CONTACTS_TLEVELS_EMAIL, "mailto:" + ANCHOR_CONTACTS_TLEVELS_EMAIL);
        contacts.put(ANCHOR_CONTACTS_TLEVELS_FORM, "https://employers.tlevels.gov.uk/hc/en-gb/requests/new");
        contacts.put(ANCHOR_CONTACTS_TLEVELS_WEBSITE, "https://employers.tlevels.gov.uk/hc/en-gb");

        contacts.put(ANCHOR_CONTACTS_SWAP_WEBSITE, "https://find-employer-schemes.education.gov.uk/schemes/sector-based-work-academy-programme-swap");

        contacts.put(ANCHOR_CONTACTS_MULTIPLY_EMAIL, "mailto:" + ANCHOR_CONTACTS_MULTIPLY_EMAIL);
        contacts.put(ANCHOR_CONTACTS_MULTIPLY_FINDER, "https://nationalcareers.service.gov.uk/find-a-course/page?searchTerm=maths%20mathematics%20numeracy%20multiply&distance=10%20miles&town=&orderByValue=Relevance&startDate=Anytime&courseType=&courseHours=&courseStudyTime=&filterA=true&page=1&D=0");

        contacts.put(ANCHOR_CONTACTS_CARERLEAVERCOVENANT_EMAIL, "mailto:" + ANCHOR_CONTACTS_CARERLEAVERCOVENANT_EMAIL);
        contacts.put(ANCHOR_CONTACTS_CARERLEAVERCOVENANT_FORM, "https://mycovenant.org.uk/contact/");
        contacts.put(ANCHOR_CONTACTS_CARERLEAVERCOVENANT_WEBSITE, "https://mycovenant.org.uk/");

        contacts.put(ANCHOR_CONTACTS_BOOTCAMPS_WEBSITE, "https://www.gov.uk/guidance/find-a-skills-bootcamp");
        contacts.put(ANCHOR_CONTACTS_HTQ_WEBSITE, "https://www.gov.uk/government/publications/higher-technical-qualification-overview");
        contacts.put(ANCHOR_CONTACTS_INTERNSHIPS_WEBSITE, "https://www.gov.uk/government/publications/supported-internships-for-young-people-with-learning-difficulties?_ga=2.140947824.39900855.1698662915-1634194323.1693994602");
        contacts.put(ANCHOR_CONTACTS_FREECOURSES_WEBSITE, "https://nationalcareers.service.gov.uk/find-a-course");

        contacts.put(ANCHOR_CONTACTS_PRISONERS_FORM, "https://newfuturesnetwork.gov.uk/register/");
        contacts.put(ANCHOR_CONTACTS_PRISONERS_WEBSITE, "https://newfuturesnetwork.gov.uk/");
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
        anchorsToRemove.add(ANCHOR_APPRENTICESHIPS);
        anchorsToRemove.add(ANCHOR_HOME);


        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }

    @Then("all SWAP anchors link to the correct pages")
    public void allSWAPAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(swap);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_SWAP);
        anchorsToRemove.add(ANCHOR_HOME);

        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }

    @Then("all BOOTCAMPS anchors link to the correct pages")
    public void allBOOTCAMPSAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(bootcamps);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_BOOTCAMPS);
        anchorsToRemove.add(ANCHOR_HOME);
        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }

    @Then("all MULTIPLY anchors link to the correct pages")
    public void allMULTIPLYAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(multiply);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_MULTIPLY);
        anchorsToRemove.add(ANCHOR_HOME);


        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }

    @Then("all HTQ anchors link to the correct pages")
    public void allHTQAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(htq);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_HTQ);
        anchorsToRemove.add(ANCHOR_HOME);


        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }

    @Then("all INTERNSHIPS anchors link to the correct pages")
    public void allINTERNSHIPSAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(internships);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_INTERNSHIPS);
        anchorsToRemove.add(ANCHOR_HOME);


        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }

    @Then("all CARE_LEAVER_COVENANT anchors link to the correct pages")
    public void allCARE_LEAVER_COVENANTAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(careLeaverCovenant);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_CARE_LEAVER_COVENANT);
        anchorsToRemove.add(ANCHOR_HOME);


        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }

    @Then("all PRISONERS anchors link to the correct pages")
    public void allPRISONERSAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(prisoners);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_PRISONERS);
        anchorsToRemove.add(ANCHOR_HOME);
        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }

    @Then("all FREE_COURSES anchors link to the correct pages")
    public void allFREE_COURSESAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(freeCourses);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_FREE_COURSES);
        anchorsToRemove.add(ANCHOR_HOME);
        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }

    @Then("all CONTACT anchors link to the correct pages")
    public void allCONTACTAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.put(ANCHOR_CONTACTS_CALL_CHARGES, contacts.get(ANCHOR_CONTACTS_CALL_CHARGES));
        expectedAnchorsMap.put(ANCHOR_CONTACTS_APPRENTICESHIP_EMAIL, contacts.get(ANCHOR_CONTACTS_APPRENTICESHIP_EMAIL));
        expectedAnchorsMap.put(ANCHOR_CONTACTS_TLEVELS_EMAIL, contacts.get(ANCHOR_CONTACTS_TLEVELS_EMAIL));
        expectedAnchorsMap.put(ANCHOR_CONTACTS_MULTIPLY_EMAIL, contacts.get(ANCHOR_CONTACTS_MULTIPLY_EMAIL));
        expectedAnchorsMap.put(ANCHOR_CONTACTS_MULTIPLY_FINDER, contacts.get(ANCHOR_CONTACTS_MULTIPLY_FINDER));
        expectedAnchorsMap.put(ANCHOR_CONTACTS_CARERLEAVERCOVENANT_EMAIL, contacts.get(ANCHOR_CONTACTS_CARERLEAVERCOVENANT_EMAIL));

        List<String> anchorsToRemove = populateAnchorsToRemove();

        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);

        //assure scheme websites
        ArrayList<WebElement> websites = (ArrayList<WebElement>) driver.findElements(By.xpath(String.format("//a[normalize-space()='%s']", "Scheme website")));
        Assert.assertEquals("Href not as expected " + ANCHOR_CONTACTS_APPRENTICESHIP_WEBSITE, contacts.get(ANCHOR_CONTACTS_APPRENTICESHIP_WEBSITE), websites.get(0).getAttribute("href").trim());
        Assert.assertEquals("Href not as expected " + ANCHOR_CONTACTS_TLEVELS_WEBSITE, contacts.get(ANCHOR_CONTACTS_TLEVELS_WEBSITE), websites.get(1).getAttribute("href").trim());
        Assert.assertEquals("Href not as expected " + ANCHOR_CONTACTS_SWAP_WEBSITE, contacts.get(ANCHOR_CONTACTS_SWAP_WEBSITE), websites.get(2).getAttribute("href").trim());
        Assert.assertEquals("Href not as expected " + ANCHOR_CONTACTS_CARERLEAVERCOVENANT_WEBSITE, contacts.get(ANCHOR_CONTACTS_CARERLEAVERCOVENANT_WEBSITE), websites.get(3).getAttribute("href").trim());
        Assert.assertEquals("Href not as expected " + ANCHOR_CONTACTS_BOOTCAMPS_WEBSITE, contacts.get(ANCHOR_CONTACTS_BOOTCAMPS_WEBSITE), websites.get(4).getAttribute("href").trim());
        Assert.assertEquals("Href not as expected " + ANCHOR_CONTACTS_HTQ_WEBSITE, contacts.get(ANCHOR_CONTACTS_HTQ_WEBSITE), websites.get(5).getAttribute("href").trim());
        Assert.assertEquals("Href not as expected " + ANCHOR_CONTACTS_INTERNSHIPS_WEBSITE, contacts.get(ANCHOR_CONTACTS_INTERNSHIPS_WEBSITE), websites.get(6).getAttribute("href").trim());
        Assert.assertEquals("Href not as expected " + ANCHOR_CONTACTS_FREECOURSES_WEBSITE, contacts.get(ANCHOR_CONTACTS_FREECOURSES_WEBSITE), websites.get(7).getAttribute("href").trim());
        Assert.assertEquals("Href not as expected " + ANCHOR_CONTACTS_PRISONERS_WEBSITE, contacts.get(ANCHOR_CONTACTS_PRISONERS_WEBSITE), websites.get(8).getAttribute("href").trim());

        //assure forms
        ArrayList<WebElement> forms = (ArrayList<WebElement>) driver.findElements(By.xpath(String.format("//a[normalize-space()='%s']", "Online contact form")));
        Assert.assertEquals("Href not as expected " + ANCHOR_CONTACTS_TLEVELS_FORM, contacts.get(ANCHOR_CONTACTS_TLEVELS_FORM), forms.get(0).getAttribute("href").trim());
        Assert.assertEquals("Href not as expected " + ANCHOR_CONTACTS_CARERLEAVERCOVENANT_FORM, contacts.get(ANCHOR_CONTACTS_CARERLEAVERCOVENANT_FORM), forms.get(1).getAttribute("href").trim());
        Assert.assertEquals("Href not as expected " + ANCHOR_CONTACTS_PRISONERS_FORM, contacts.get(ANCHOR_CONTACTS_PRISONERS_FORM), forms.get(2).getAttribute("href").trim());
    }

    @NotNull
    private static List<String> populateAnchorsToRemove() {
        List<String> anchorsToRemove = new ArrayList<>();

        anchorsToRemove.add(ANCHOR_FREE_COURSES);
        anchorsToRemove.add(ANCHOR_HOME);

        anchorsToRemove.add(ANCHOR_CONTACTS_APPRENTICESHIP_WEBSITE.replace("APPRENTICESHIP ", ""));
        anchorsToRemove.add(ANCHOR_CONTACTS_TLEVELS_WEBSITE.replace("TLEVELS ", ""));
        anchorsToRemove.add(ANCHOR_CONTACTS_SWAP_WEBSITE.replace("SWAP ", ""));
        anchorsToRemove.add(ANCHOR_CONTACTS_CARERLEAVERCOVENANT_WEBSITE.replace("CARERLEAVERCOVENANT ", ""));
        anchorsToRemove.add(ANCHOR_CONTACTS_BOOTCAMPS_WEBSITE.replace("BOOTCAMPS ", ""));
        anchorsToRemove.add(ANCHOR_CONTACTS_HTQ_WEBSITE.replace("HTQ ", ""));
        anchorsToRemove.add(ANCHOR_CONTACTS_INTERNSHIPS_WEBSITE.replace("INTERNSHIPS ", ""));
        anchorsToRemove.add(ANCHOR_CONTACTS_FREECOURSES_WEBSITE.replace("FREECOURSES ", ""));
        anchorsToRemove.add(ANCHOR_CONTACTS_PRISONERS_WEBSITE.replace("PRISONERS ", ""));

        anchorsToRemove.add(ANCHOR_CONTACTS_TLEVELS_FORM.replace("TLEVELS ", ""));
        anchorsToRemove.add(ANCHOR_CONTACTS_CARERLEAVERCOVENANT_FORM.replace("CARERLEAVERCOVENANT ", ""));
        anchorsToRemove.add(ANCHOR_CONTACTS_PRISONERS_FORM.replace("PRISONERS ", ""));
        return anchorsToRemove;
    }

    @Then("all T_LEVELS anchors link to the correct pages")
    public void allT_LEVELSAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(tLevels);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_T_LEVELS);
        anchorsToRemove.add(ANCHOR_HOME);
        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }

    private void confirmPageHeaderAndFooterAnchors(Map<String, String> expectedAnchorsMap, List<String> anchorsToRemove) throws InterruptedException {
        expectedAnchorsMap.putAll(headersMap);
        expectedAnchorsMap.putAll(footerMap);

        anchorsToRemove.add(ANCHOR_HEADER_SKIP_TO_MAIN_CONTENT); //stays on same page
        compareAndClickAnchors(expectedAnchorsMap, anchorsToRemove);

    }

    private void confirmPageAnchorsLite(Map<String, String> expectedAnchorsMap, List<String> anchorsToRemove) throws InterruptedException {
        anchorsToRemove.addAll(headersMap.keySet());
        anchorsToRemove.addAll(schemesMap.keySet());
        anchorsToRemove.addAll(footerMap.keySet());
        anchorsToRemove.add(ANCHOR_HEADER_SKIP_TO_MAIN_CONTENT); //stays on same page
        compareAndClickAnchors(expectedAnchorsMap, anchorsToRemove);
    }

    private void compareAndClickAnchors(Map<String, String> expectedAnchorsMap, List<String> anchorsToRemove) throws InterruptedException {
        List<String> mutableNonEmptyActualAnchors = confirmActualAnchors(new ArrayList<>(expectedAnchorsMap.keySet()), anchorsToRemove);

        for (String anchorText : mutableNonEmptyActualAnchors) {
            log.info("link " + anchorText);

            WebElement anchorElement = getAnchor(anchorText);
            int retryCount = 3;
            try {
                if (expectedAnchorsMap.get(anchorText).startsWith("http") || expectedAnchorsMap.get(anchorText).startsWith("mailto") || expectedAnchorsMap.get(anchorText).startsWith("tel:")) {

                    Assert.assertEquals("Href not as expected " + anchorText, expectedAnchorsMap.get(anchorText).replace(CURRENT_PAGE_URL, driver.getCurrentUrl()), anchorElement.getAttribute("href").trim());
                } else {
                    anchorElement.click();
                    Assert.assertEquals("Wrong title for anchor " + anchorText, expectedAnchorsMap.get(anchorText), driver.getTitle());
                    driver.navigate().back();
                }
            } catch (AssertionError e) {

                log.info("AssertionError");
                if (driver instanceof HtmlUnitDriver) {
                    //todo given javascript errors, htmlunit strictness means feedback changes to mailto: instead of MS forms link
                    if (anchorText.equals("feedback")) {
                        Assert.assertEquals("Href not as expected " + anchorText, "mailto:customer.experience@education.gov.uk?subject=Feedback%20on%20'Find%20Schemes%20for%20your%20Business'%20Service", anchorElement.getAttribute("href").trim());
                    } else {
                        throw new AssertionError();
                    }
                    continue;
                }

                for (int i = 0; i < retryCount; i++) {
                    //sometimes there's a delay in getting the title
                    if (expectedAnchorsMap.get(anchorText).startsWith("http") || expectedAnchorsMap.get(anchorText).startsWith("mailto")) {
                        Assert.assertEquals("Href not as expected " + anchorText, expectedAnchorsMap.get(anchorText), anchorElement.getAttribute("href").trim());
                    } else {
                        Assert.assertEquals("Wrong title for anchor " + anchorText, expectedAnchorsMap.get(anchorText), driver.getTitle());
                        driver.navigate().back();
                    }
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

        List<String> anchorsToRemove = new ArrayList<>();
        anchorsToRemove.add(ANCHOR_HOME);
        anchorsToRemove.add(ANCHOR_HOME_PAGE_CLEAR_FILTERS);

        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove);
    }

    private static void removeAnchorToCompare(List<String> actualAnchors, List<String> expectedAnchors, String link) {
        actualAnchors.remove(link); //stays on same page
        expectedAnchors.remove(link); //stays on same page
    }

    @When("the user navigates to the {string} page")
    public void theUserNavigatesToThePage(String destination) {
        switch (destination) {
            case "HOME" -> Assert.assertEquals(homeMap.get(ANCHOR_HOME), driver.getTitle());
            case "APPRENTICESHIPS" -> {
                getAnchor(ANCHOR_APPRENTICESHIPS).click();
                Assert.assertEquals(schemesMap.get(ANCHOR_APPRENTICESHIPS), driver.getTitle());
            }
            case "T_LEVELS" -> {
                getAnchor(ANCHOR_T_LEVELS).click();
                Assert.assertEquals(schemesMap.get(ANCHOR_T_LEVELS), driver.getTitle());
            }
            case "SWAP" -> {
                getAnchor(ANCHOR_SWAP).click();
                Assert.assertEquals(schemesMap.get(ANCHOR_SWAP), driver.getTitle());
            }
            case "BOOTCAMPS" -> {
                getAnchor(ANCHOR_BOOTCAMPS).click();
                Assert.assertEquals(schemesMap.get(ANCHOR_BOOTCAMPS), driver.getTitle());
            }
            case "MULTIPLY" -> {
                getAnchor(ANCHOR_MULTIPLY).click();
                Assert.assertEquals(schemesMap.get(ANCHOR_MULTIPLY), driver.getTitle());
            }
            case "HTQ" -> {
                getAnchor(ANCHOR_HTQ).click();
                Assert.assertEquals(schemesMap.get(ANCHOR_HTQ), driver.getTitle());
            }
            case "INTERNSHIPS" -> {
                getAnchor(ANCHOR_INTERNSHIPS).click();
                Assert.assertEquals(schemesMap.get(ANCHOR_INTERNSHIPS), driver.getTitle());
            }
            case "CARE_LEAVER_COVENANT" -> {
                getAnchor(ANCHOR_CARE_LEAVER_COVENANT).click();
                Assert.assertEquals(schemesMap.get(ANCHOR_CARE_LEAVER_COVENANT), driver.getTitle());
            }
            case "PRISONERS" -> {
                getAnchor(ANCHOR_PRISONERS).click();
                Assert.assertEquals(schemesMap.get(ANCHOR_PRISONERS), driver.getTitle());
            }
            case "FREE_COURSES" -> {
                getAnchor(ANCHOR_FREE_COURSES).click();
                WebElement button = driver.findElement(By.xpath("//*[text()='Show all sections']"));
                button.click();
                Assert.assertEquals(schemesMap.get(ANCHOR_FREE_COURSES), driver.getTitle());
            }
            case "CONTACT" -> {
                getAnchor(ANCHOR_FOOTER_CONTACT).click();
                Assert.assertEquals(footerMap.get(ANCHOR_FOOTER_CONTACT), driver.getTitle());
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
        filterSchemesClicked();

        WebElement numberOfSchemes = driver.findElement(By.id("schemes"));
        log.info("numberOfSchemes : " + numberOfSchemes.getText());

        Assert.assertTrue("When nothing is filtered, scheme count is wrong ", numberOfSchemes.getText().contains("Number of schemes: 10"));

        List<String> anchorsToRemove = new ArrayList<>();
        anchorsToRemove.addAll(headersMap.keySet());
        anchorsToRemove.addAll(footerMap.keySet());
        anchorsToRemove.add(ANCHOR_HOME_PAGE_CLEAR_FILTERS);
        anchorsToRemove.add(ANCHOR_HOME_PAGE_COMPARE_SCHEMES_IN_A_TABLE);
        anchorsToRemove.add(ANCHOR_HOME);
        anchorsToRemove.add(ANCHOR_HOME_SKILLS_FOR_CAREERS);

        confirmActualAnchors(new ArrayList<>(schemesMap.keySet()), anchorsToRemove);
        checkboxCombo();
    }

    private void filterSchemesClicked() {
        WebElement button = driver.findElement(By.xpath("//button[normalize-space(text())='Filter schemes']"));
        button.click();
    }

    public void checkboxCombo() {
        By checkBox1Locator = By.id("motivations--recruit-new-staff");
        By checkBox2Locator = By.id("motivations--retrain-or-upskill-existing-staff");
        By checkBox3Locator = By.id("motivations--offer-short-terms-work-experience-placements");

        By checkBox4Locator = By.id("scheme-length--less-than-6-months");
        By checkBox5Locator = By.id("scheme-length--between-6-months-and-1-year");
        By checkBox6Locator = By.id("scheme-length--longer-than-1-year");

        By checkBox7Locator = By.id("pay--free");
        By checkBox8Locator = By.id("pay--may-require-employer-contribution");

        // Create a Map to store the checkbox combinations
        Map<List<Boolean>, List<String>> combinationsMap = new LinkedHashMap<>();

        populateCombinationsMap(combinationsMap);

        List<String> anchorsToRemove = new ArrayList<>();

        anchorsToRemove.addAll(headersMap.keySet());
        anchorsToRemove.addAll(footerMap.keySet());
        anchorsToRemove.add(ANCHOR_HOME_PAGE_CLEAR_FILTERS);
        anchorsToRemove.add(ANCHOR_HOME_PAGE_COMPARE_SCHEMES_IN_A_TABLE);
        anchorsToRemove.add(ANCHOR_HOME);
        anchorsToRemove.add(ANCHOR_HOME_SKILLS_FOR_CAREERS);

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

            filterSchemesClicked();
            log.info(combination.toString());
            log.info("expected " + combinationsMap.get(combination).toString());
            confirmActualAnchors(combinationsMap.get(combination), anchorsToRemove);
        }
    }

    static void populateCombinationsMap(Map<List<Boolean>, List<String>> combinationsMap) {
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, false, false, true)), Arrays.asList());
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, false, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, false, false, true)), Arrays.asList());
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, false, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, false, false, true)), Arrays.asList());
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, false, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, false, false, true)), Arrays.asList());
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, false, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, true, true, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, false, true, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, true, true, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, false, true, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, true, true, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, false, true, true)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, false, true, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, false, false, true)), Arrays.asList());
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, false, false, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, true, true, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, false, true, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, false, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, true, true, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, false, true, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, true, true, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, false, true, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, true, true, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, false, true, true)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, false, true, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, false, false, true)), Arrays.asList());
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, false, false, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, true, true, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, false, true, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, false, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, true, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, true, true, false)), Arrays.asList(ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, true, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, true, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, false, true, false)), Arrays.asList(ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, true, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, true, true, false)), Arrays.asList(ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, true, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, true, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, false, true, false)), Arrays.asList(ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_SWAP));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, true, true, true)), Arrays.asList(ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, true, true, false)), Arrays.asList(ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, true, false, true)), Arrays.asList());
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, true, false, false)), Arrays.asList(ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, false, true, true)), Arrays.asList(ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, false, true, false)), Arrays.asList(ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, false, false, true)), Arrays.asList());
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, false, false, false)), Arrays.asList(ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, true, true, true)), Arrays.asList());
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, true, true, false)), Arrays.asList());
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, true, false, true)), Arrays.asList());
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, true, false, false)), Arrays.asList());
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, false, true, false)), Arrays.asList(ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, true, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_SWAP, ANCHOR_T_LEVELS, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_HTQ, ANCHOR_APPRENTICESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_SWAP, ANCHOR_T_LEVELS, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, true, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_HTQ, ANCHOR_APPRENTICESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, true, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_SWAP, ANCHOR_T_LEVELS, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS, ANCHOR_HTQ, ANCHOR_APPRENTICESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_SWAP, ANCHOR_T_LEVELS, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_SWAP, ANCHOR_T_LEVELS, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_SWAP, ANCHOR_T_LEVELS, ANCHOR_BOOTCAMPS, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, true, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_SWAP, ANCHOR_T_LEVELS, ANCHOR_BOOTCAMPS, ANCHOR_HTQ, ANCHOR_APPRENTICESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_SWAP, ANCHOR_T_LEVELS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, true, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS, ANCHOR_HTQ, ANCHOR_APPRENTICESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, true, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_SWAP, ANCHOR_T_LEVELS, ANCHOR_BOOTCAMPS, ANCHOR_HTQ, ANCHOR_APPRENTICESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_SWAP, ANCHOR_T_LEVELS, ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_SWAP, ANCHOR_T_LEVELS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_SWAP, ANCHOR_T_LEVELS, ANCHOR_BOOTCAMPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, true, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_INTERNSHIPS, ANCHOR_MULTIPLY, ANCHOR_HTQ, ANCHOR_APPRENTICESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_INTERNSHIPS, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, true, false, true)), Arrays.asList(ANCHOR_HTQ, ANCHOR_APPRENTICESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, true, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_INTERNSHIPS, ANCHOR_MULTIPLY, ANCHOR_HTQ, ANCHOR_APPRENTICESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_INTERNSHIPS, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_INTERNSHIPS, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, false, false, true)), Arrays.asList());
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_INTERNSHIPS, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, true, true, true)), Arrays.asList(ANCHOR_HTQ, ANCHOR_APPRENTICESHIPS, ANCHOR_FREE_COURSES, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, true, true, false)), Arrays.asList(ANCHOR_FREE_COURSES, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, true, false, true)), Arrays.asList(ANCHOR_HTQ, ANCHOR_APPRENTICESHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, true, false, false)), Arrays.asList(ANCHOR_HTQ, ANCHOR_APPRENTICESHIPS, ANCHOR_FREE_COURSES, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_MULTIPLY));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, false, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_HTQ));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS, ANCHOR_BOOTCAMPS, ANCHOR_CARE_LEAVER_COVENANT, ANCHOR_PRISONERS, ANCHOR_T_LEVELS, ANCHOR_SWAP, ANCHOR_INTERNSHIPS, ANCHOR_FREE_COURSES, ANCHOR_MULTIPLY, ANCHOR_HTQ));
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
        anchorsToRemove.add(ANCHOR_HOME); //stays on same page

        anchorsToRemove.add(ANCHOR_SHARE_EMAIL); //stays on same page
        anchorsToRemove.add(ANCHOR_SHARE_FACEBOOK); //stays on same page
        anchorsToRemove.add(ANCHOR_SHARE_X); //stays on same page
        anchorsToRemove.add(ANCHOR_SHARE_LINKEDIN); //stays on same page

        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(headersMap);
        expectedAnchorsMap.putAll(schemesMap);
        expectedAnchorsMap.putAll(footerMap);

        compareAndClickAnchors(expectedAnchorsMap, anchorsToRemove);
    }

    @Then("all home page header and footer anchors link to the correct pages")
    public void allHomePageHeaderAndFooterAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();

        List<String> anchorsToRemove = new ArrayList<>();
        anchorsToRemove.add(ANCHOR_HOME);
        anchorsToRemove.add(ANCHOR_HOME_PAGE_CLEAR_FILTERS);
        anchorsToRemove.addAll(homeMap.keySet());
        anchorsToRemove.addAll(schemesMap.keySet());

        confirmPageHeaderAndFooterAnchors(expectedAnchorsMap, anchorsToRemove);

    }
}