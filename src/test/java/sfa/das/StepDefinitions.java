package sfa.das;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import sfa.das.driver.DriverFactory;
import sfa.das.sort.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

@Slf4j
public class StepDefinitions {

    public static final int SCHEME_ANCHOR_NAME_EXPLORE_SECTION = 0;
    public static final int SCHEME_ANCHOR_NAME_HOMEPAGE = 1;
    public static final int SCHEME_ANCHOR_NAME_COMPARISON_PAGE = 2;
    public static final List<String> ANCHOR_APPRENTICESHIPS = Arrays.asList("Apprenticeships","Find out more about apprenticeships","Apprenticeships");
    public static final List<String> ANCHOR_T_LEVELS = Arrays.asList("T Levels: industry placements","Find out more about T Levels and industry placements","T Levels");
    public static final List<String> ANCHOR_SWAP = Arrays.asList("Sector-based Work Academy Programme (SWAP)","Find out more about SWAPs","SWAPs");
    public static final List<String> ANCHOR_BOOTCAMPS = Arrays.asList("Skills Bootcamps","Find out more about Skills Bootcamps","Skills Bootcamps");
    public static final List <String>ANCHOR_MULTIPLY = Arrays.asList("Multiply","Find out more about Multiply","Multiply");
    public static final List<String> ANCHOR_HTQ = Arrays.asList("Higher Technical Qualifications (HTQs)","Find out more about Higher Technical Qualifications", "HTQs");
    public static final List<String> ANCHOR_INTERNSHIPS = Arrays.asList("Supported internships for learners with an education, health and care plan","Supported internships for people with SEND", "Supported internships");
    public static final List<String> ANCHOR_CARE_LEAVER_COVENANT = Arrays.asList("Care Leaver Covenant","Explore the Care Leaver Covenant","Care Leaver Covenant");
    public static final List<String> ANCHOR_PRISONERS = Arrays.asList("Employing prisoners and prison leavers","Employing prisoners and prison leavers","Employing prisoners and prison leavers");
    public static final List<String> ANCHOR_FREE_COURSES = Arrays.asList("Free courses and additional training for your employees","Find courses and additional training","Free courses for jobs");
    //todo  public static final String ANCHOR_HEADER_SERVICE_NAME = "Find schemes for your business";
    public static final String ANCHOR_HEADER_SKIP_TO_MAIN_CONTENT = "Skip to main content";
    public static final String ANCHOR_HEADER_VIEW_COOKIES = "View cookies";
    public static final String ANCHOR_HEADER_BETA_BANNER_FEEDBACK = "feedback";
    public static final String ANCHOR_HOME = "Business Home";
    public static final String ANCHOR_BACK = "Back";
    public static final String ANCHOR_COMPARED_PAGE_RETURN_TO_LIST = "Return to list of all schemes";
//todo- now a button    public static final String ANCHOR_HOME_PAGE_COMPARE_SCHEMES_IN_A_TABLE = "Compare these schemes in a table";
    public static final String ANCHOR_SHARE_EMAIL = "Email";
    public static final String ANCHOR_SHARE_FACEBOOK = "Facebook";
    public static final String ANCHOR_SHARE_X = "X (formerly Twitter)";
    public static final String ANCHOR_SHARE_LINKEDIN = "LinkedIn";
    public static final String ANCHOR_HOME_PAGE_CLEAR_FILTERS = "Clear filters";
    public static final String ANCHOR_HOME_PAGE_NO_SCHEMES_PRESENT_CLEAR_FILTERS = "clear all filters";
    public static final String ANCHOR_HOME_SKILLS_FOR_CAREERS = "Get career ideas and browse your training options";

    public static final String ANCHOR_FOOTER_ACCESSIBILITY_STATEMENT = "Accessibility";
    public static final String ANCHOR_FOOTER_PRIVACY = "Privacy";
    public static final String ANCHOR_FOOTER_COOKIES = "Cookies";
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
    public static final String SCHEME_SORT = "scheme-sort";

    public static final String ANCHOR_COMPARISON_PAGE_CLEAR_FILTERS = "Clear filters and show all schemes";


    private WebDriver driver;
    private Environments.Environment environment;
    Map<String, String> headersMap = new HashMap<>();
    Map<String, String> homeMap = new HashMap<>();
    Map<String, String> footerMap = new HashMap<>();
    public static Map<String, String> schemesExploreSectionMap = new LinkedHashMap<>();

    static {
        //explore section ordered list
        schemesExploreSectionMap.put(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesExploreSectionMap.put(ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesExploreSectionMap.put(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesExploreSectionMap.put(ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesExploreSectionMap.put(ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesExploreSectionMap.put(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesExploreSectionMap.put(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesExploreSectionMap.put(ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION), "Supported internships for learners with an education, health and"); //todo title not complete
        schemesExploreSectionMap.put(ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesExploreSectionMap.put(ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
    }

    public static Map<String, String> schemesHomePageDefaultMap = new LinkedHashMap<>();

    static {
        //default ordered list
        schemesHomePageDefaultMap.put(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageDefaultMap.put(ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageDefaultMap.put(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageDefaultMap.put(ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageDefaultMap.put(ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageDefaultMap.put(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageDefaultMap.put(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageDefaultMap.put(ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), "Supported internships for learners with an education, health and"); //todo title not complete
        schemesHomePageDefaultMap.put(ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageDefaultMap.put(ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
    }
    public static Map<String, String> schemesHomePagePopularityMap = new LinkedHashMap<>();
    static {
        //Popularity ordered list
        schemesHomePagePopularityMap.put(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePagePopularityMap.put(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePagePopularityMap.put(ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePagePopularityMap.put(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePagePopularityMap.put(ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePagePopularityMap.put(ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePagePopularityMap.put(ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), "Supported internships for learners with an education, health and"); //todo title not complete
        schemesHomePagePopularityMap.put(ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePagePopularityMap.put(ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePagePopularityMap.put(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
    }
    public static Map<String, String> schemesHomePageDurationMap = new LinkedHashMap<>();
    static {
        //Duration ordered list
        schemesHomePageDurationMap.put(ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageDurationMap.put(ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageDurationMap.put(ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageDurationMap.put(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageDurationMap.put(ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), "Supported internships for learners with an education, health and"); //todo title not complete
        schemesHomePageDurationMap.put(ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageDurationMap.put(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageDurationMap.put(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageDurationMap.put(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageDurationMap.put(ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
    }
    public static Map<String, String> schemesHomePageCostMap = new LinkedHashMap<>();
    static {
        //Cost ordered list
        schemesHomePageCostMap.put(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageCostMap.put(ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageCostMap.put(ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageCostMap.put(ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageCostMap.put(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageCostMap.put(ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageCostMap.put(ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), "Supported internships for learners with an education, health and"); //todo title not complete
        schemesHomePageCostMap.put(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageCostMap.put(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesHomePageCostMap.put(ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
    }

    public static Map<String, String> schemesComparisonPageMap = new LinkedHashMap<>();
    static {
        //Comparison ordered list
        schemesComparisonPageMap.put(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesComparisonPageMap.put(ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesComparisonPageMap.put(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesComparisonPageMap.put(ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesComparisonPageMap.put(ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesComparisonPageMap.put(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesComparisonPageMap.put(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesComparisonPageMap.put(ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE), "Supported internships for learners with an education, health and"); //todo title not complete
        schemesComparisonPageMap.put(ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
        schemesComparisonPageMap.put(ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION));
    }


    public static Map<String, String> homePageToComparePageSchemeMap = new HashMap<>();
    static {
        homePageToComparePageSchemeMap.put(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE));
        homePageToComparePageSchemeMap.put(ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE));
        homePageToComparePageSchemeMap.put(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE));
        homePageToComparePageSchemeMap.put(ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE));
        homePageToComparePageSchemeMap.put(ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE));
        homePageToComparePageSchemeMap.put(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE));
        homePageToComparePageSchemeMap.put(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE));
        homePageToComparePageSchemeMap.put(ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE));
        homePageToComparePageSchemeMap.put(ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE));
        homePageToComparePageSchemeMap.put(ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_COMPARISON_PAGE));
    }

    public static  Map<String, String> comparisonPageMap = new HashMap<>();
    static {
        comparisonPageMap.put(ANCHOR_COMPARISON_PAGE_CLEAR_FILTERS, "Find training and employment schemes for your business");
    }

    public static  Map<String, String> backMap = new LinkedHashMap<>();
    static {
        backMap.put(ANCHOR_BACK, "Find training and employment schemes for your business");
    }
    public static Map<String, String> apprenticeshipsMap = new LinkedHashMap<>();
    static {
        apprenticeshipsMap.put(ANCHOR_APPRENTICESHIP_THE_MINIMUM_WAGE, "https://www.gov.uk/national-minimum-wage-rates");
        apprenticeshipsMap.put(ANCHOR_APPRENTICESHIP_HOW_APPRENTICESHIPS_CAN_BENEFIT_YOUR_BUSINESS, "https://www.apprenticeships.gov.uk/employers/benefits-of-hiring-apprentice");
        apprenticeshipsMap.put(ANCHOR_APPRENTICESHIP_HIRE_AN_APPRENTICE, "https://www.apprenticeships.gov.uk/employers/hiring-an-apprentice");
        apprenticeshipsMap.put(ANCHOR_APPRENTICESHIP_TELEPHONE, "tel:" + ANCHOR_APPRENTICESHIP_TELEPHONE.replace(" ", "")); //todo opens facetime
    }
    public static Map<String, String> tLevels = new LinkedHashMap<>();
    static {
        tLevels.put(ANCHOR_TLEVEL_ACCELERATE_THEIR_APPRENTICESHIPS, "https://www.gov.uk/guidance/how-can-apprenticeships-be-delivered-for-your-business#accelerated-apprenticeships");
        tLevels.put(ANCHOR_TLEVEL_GET_MORE_INFORMATION_ABOUT_T_LEVELS_AND_INDUSTRY_PLACEMENTS, "https://employers.tlevels.gov.uk/hc/en-gb");
    }

    public static Map<String, String> bootcamps = new LinkedHashMap<>();
    static {
        bootcamps.put(ANCHOR_BOOTCAMP_ACCELERATE_THEIR_APPRENTICESHIPS, "How can apprenticeships be delivered for your business? - GOV.UK");
        bootcamps.put(ANCHOR_SWAP_FINDING_TRAINING_PROVIDERS_WHO_ARE_CURRENTLY_BEING_FUNDED_TO_DELIVER_SKILLS_BOOTCAMPS, "Skills Bootcamps training providers - GOV.UK");
    }
    public static Map<String, String> multiply = new LinkedHashMap<>();
    static {
        multiply.put(ANCHOR_MULTIPLY_FIND_A_COURSE, "Results | Find a course | National Careers Service");
        multiply.put(ANCHOR_MULTIPLY_EMAIL, "mailto:" + ANCHOR_MULTIPLY_EMAIL);
        multiply.put(ANCHOR_MULTIPLY_READ_MORE_ABOUT_MULTIPLY_SKILLS_FOR_LIFE, "Multiply - Skills for Life");
    }

    public static Map<String, String> htq = new LinkedHashMap<>();
    static {
        htq.put(ANCHOR_HTQ_LEARN_MORE_AND_GET_STARTED_WITH_HTQS, "Providers delivering Higher Technical Qualifications - GOV.UK");
    }

    public static Map<String, String> freeCourses = new LinkedHashMap<>();
    static {
        freeCourses.put(ANCHOR_FREECOURSES_FOR_JOBS, "Free courses for jobs - GOV.UK");
        freeCourses.put(ANCHOR_FREECOURSES_THE_NATIONAL_CAREERS_SERVICE_AND_HOW_TO_CONTACT_THEM, "Careers advice - job profiles, information and resources | National Careers Service");
    }

    public static Map<String, String> careLeaverCovenant = new LinkedHashMap<>();
    static {
        careLeaverCovenant.put(ANCHOR_CARERLEAVERCOVENANT_FIND_OUT_HOW_TO_JOIN_THE_CARE_LEAVERS_COVENANT, "Companies & Charities - Care Leaver Covenant");
    }

    public static Map<String, String> internships = new LinkedHashMap<>();
    static {
        internships.put(ANCHOR_INTERNSHIPS_EDUCATION_HEALTH_AND_CARE_EHC_PLAN, "Children with special educational needs and disabilities (SEND): Extra help - GOV.UK");
        internships.put(ANCHOR_INTERNSHIPS_GUIDANCE_ON_SUPPORTED_INTERNSHIPS, "Providing supported internships for young people with an EHC plan - GOV.UK");
    }

    public static Map<String, String> swap = new LinkedHashMap<>();
    static {
        swap.put(ANCHOR_SWAP_HOW_SWAP_COULD_BENEFIT_YOUR_BUSINESS, "Sector-based work academy programme: employer guide - GOV.UK");
        swap.put(ANCHOR_SWAP_HOW_EMPLOYERS_ARE_USING_SECTOR_BASED_WORK_ACADEMY_PROGRAMMES, "How employers are benefitting from sector-based work academies - Case study - GOV.UK");
        swap.put(ANCHOR_SWAP_TELEPHONE, "tel:" + ANCHOR_SWAP_TELEPHONE.replace(" ", ""));
    }
    public static Map<String, String> prisoners = new LinkedHashMap<>();
    static {
        prisoners.put(ANCHOR_PRISONERS_THE_MINIMUM_WAGE, "National Minimum Wage and National Living Wage rates - GOV.UK");
        prisoners.put(ANCHOR_PRISONERS_HOW_BUSINESSES_ARE_WORKING_WITH_SERVING_PRISONERS_AND_HIRING_PRISON_LEAVERS, "https://newfuturesnetwork.gov.uk/case-studies/#"); //todo link doesn't work
        prisoners.put(ANCHOR_PRISONERS_REGISTER_YOUR_INTEREST_ON_THE_NEW_FUTURES_NETWORK_WEBSITE, "https://newfuturesnetwork.gov.uk/register/"); //todo link doesn't work
    }
    Map<String, String> contacts = new HashMap<>();

    @Before(order = 1)
    public void setup(Scenario scenario) {
        if (driver == null) {
            var webdriver = System.getProperty("browser", "htmlunit").toLowerCase();
            try {
                driver = DriverFactory.getBaseDriver(DriverFactory.DriverType.value(webdriver));
                //need more time for videos to load
                driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
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
        anchorsToRemove.add(ANCHOR_HOME);
        anchorsToRemove.addAll(schemesExploreSectionMap.keySet());

        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove, new DefaultHomePageSchemesComparator());
    }

    @Then("all SWAP anchors link to the correct pages")
    public void allSWAPAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(swap);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_HOME);
        anchorsToRemove.addAll(schemesExploreSectionMap.keySet());
        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove,new DefaultHomePageSchemesComparator());
    }

    @Then("all BOOTCAMPS anchors link to the correct pages")
    public void allBOOTCAMPSAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(bootcamps);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_HOME);
        anchorsToRemove.addAll(schemesExploreSectionMap.keySet());
        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove, new DefaultHomePageSchemesComparator());
    }

    @Then("all MULTIPLY anchors link to the correct pages")
    public void allMULTIPLYAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(multiply);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_HOME);
        anchorsToRemove.addAll(schemesExploreSectionMap.keySet());
        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove, new DefaultHomePageSchemesComparator());
    }

    @Then("all HTQ anchors link to the correct pages")
    public void allHTQAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(htq);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_HOME);
        anchorsToRemove.addAll(schemesExploreSectionMap.keySet());
        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove, new DefaultHomePageSchemesComparator());
    }

    @Then("all INTERNSHIPS anchors link to the correct pages")
    public void allINTERNSHIPSAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(internships);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_HOME);
        anchorsToRemove.addAll(schemesExploreSectionMap.keySet());
        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove, new DefaultHomePageSchemesComparator());
    }

    @Then("all CARE_LEAVER_COVENANT anchors link to the correct pages")
    public void allCARE_LEAVER_COVENANTAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(careLeaverCovenant);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_HOME);
        anchorsToRemove.addAll(schemesExploreSectionMap.keySet());
        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove, new DefaultHomePageSchemesComparator());
    }

    @Then("all PRISONERS anchors link to the correct pages")
    public void allPRISONERSAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(prisoners);

        List<String> anchorsToRemove = new ArrayList<>();//stays on same page
        anchorsToRemove.add(ANCHOR_HOME);
        anchorsToRemove.addAll(schemesExploreSectionMap.keySet());
        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove, new DefaultHomePageSchemesComparator());
    }

    @Then("all FREE_COURSES anchors link to the correct pages and all explore section")
    public void allFREE_COURSESAnchorsLinkToTheCorrectPageAndAllExploreSection() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(backMap);
        expectedAnchorsMap.putAll(freeCourses);
        expectedAnchorsMap.putAll(schemesExploreSectionMap);

        List<String> anchorsToRemove = new ArrayList<>();
        anchorsToRemove.add(ANCHOR_HOME); //stays on same page
        anchorsToRemove.add(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_EXPLORE_SECTION)); //this is the selected scheme
        confirmPageAnchorsLiteIncludeExploreSection(expectedAnchorsMap, anchorsToRemove);
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
        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove, new ContactPageComparator());

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

        anchorsToRemove.add(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE));
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
        anchorsToRemove.add(ANCHOR_HOME);
        anchorsToRemove.addAll(schemesExploreSectionMap.keySet());
        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove, new DefaultHomePageSchemesComparator());
    }

    private void confirmPageHeaderAndFooterAnchors(Map<String, String> expectedAnchorsMap, List<String> anchorsToRemove) throws InterruptedException {
        expectedAnchorsMap.putAll(headersMap);
        expectedAnchorsMap.putAll(footerMap);

        anchorsToRemove.add(ANCHOR_HEADER_SKIP_TO_MAIN_CONTENT); //stays on same page
        compareAndClickAnchors(expectedAnchorsMap, anchorsToRemove, new DefaultHomePageSchemesComparator());
    }

    private void confirmPageAnchorsLiteIncludeExploreSection(Map<String, String> expectedAnchorsMap, List<String> anchorsToRemove) throws InterruptedException {
        anchorsToRemove.addAll(headersMap.keySet());
        anchorsToRemove.addAll(footerMap.keySet());
        anchorsToRemove.add(ANCHOR_HEADER_SKIP_TO_MAIN_CONTENT); //stays on same page
        compareAndClickAnchors(expectedAnchorsMap, anchorsToRemove, new DefaultExploreSchemesComparator());
    }


    private void confirmPageAnchorsLite(Map<String, String> expectedAnchorsMap, List<String> anchorsToRemove, Comparator comparator) throws InterruptedException {
        anchorsToRemove.addAll(headersMap.keySet());
        anchorsToRemove.addAll(footerMap.keySet());
        anchorsToRemove.add(ANCHOR_HEADER_SKIP_TO_MAIN_CONTENT); //stays on same page
        compareAndClickAnchors(expectedAnchorsMap, anchorsToRemove, comparator);
    }

    private void compareAndClickAnchors(Map<String, String> expectedAnchorsMap, List<String> anchorsToRemove, Comparator comparator) throws InterruptedException {
        List<String> mutableNonEmptyActualAnchors = confirmActualAnchors(new ArrayList<>(expectedAnchorsMap.keySet()), anchorsToRemove, comparator);

        for (String anchorText : mutableNonEmptyActualAnchors) {
            log.info("link " + anchorText);

            WebElement anchorElement = getAnchor(anchorText);
            int retryCount = 3;
            boolean previous_page_using_forward = false;
            try {
                if (expectedAnchorsMap.get(anchorText).startsWith("http") || (expectedAnchorsMap.get(anchorText).startsWith("mailto")) || expectedAnchorsMap.get(anchorText).startsWith("tel:"))
                {
                    String actualHref = anchorElement.getAttribute("href").trim();

                    if (actualHref.contains("%")){
                        try {
                            Assert.assertEquals("Href not as expected " + anchorText, expectedAnchorsMap.get(anchorText).replace(CURRENT_PAGE_URL, URLEncoder.encode(driver.getCurrentUrl(), "UTF-8").toLowerCase()), actualHref);
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }

                     } else {
                        Assert.assertEquals("Href not as expected " + anchorText, expectedAnchorsMap.get(anchorText).replace(CURRENT_PAGE_URL, driver.getCurrentUrl()), actualHref);
                    }

                } else {

                    if (anchorElement.getAttribute("href").equals("javascript:void(0);")) {
                        previous_page_using_forward = true;
                    } else {
                        previous_page_using_forward = false;
                    }
                    anchorElement.click();
                    Assert.assertEquals("Wrong title for anchor " + anchorText, expectedAnchorsMap.get(anchorText), driver.getTitle());

                    if (previous_page_using_forward) {
                        driver.navigate().forward();
                    } else {
                        if (previous_page_using_forward) {
                            driver.navigate().forward();
                        } else {
                            driver.navigate().back();
                        }
                    }

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
                    if (expectedAnchorsMap.get(anchorText).startsWith("http") || expectedAnchorsMap.get(anchorText).startsWith("mailto") || expectedAnchorsMap.get(anchorText).startsWith("tel:")) {
                        String actualHref = anchorElement.getAttribute("href").trim();

                        if (actualHref.contains("%")){
                            try {
                                Assert.assertEquals("Href not as expected " + anchorText, expectedAnchorsMap.get(anchorText).replace(CURRENT_PAGE_URL, URLEncoder.encode(driver.getCurrentUrl(), "UTF-8").toLowerCase()), actualHref);
                            } catch (UnsupportedEncodingException uee) {
                                uee.printStackTrace();
                            }

                        } else {
                            Assert.assertEquals("Href not as expected " + anchorText, expectedAnchorsMap.get(anchorText).replace(CURRENT_PAGE_URL, driver.getCurrentUrl()), actualHref);
                        }
                    } else {
                        Assert.assertEquals("Wrong title for anchor " + anchorText, expectedAnchorsMap.get(anchorText), driver.getTitle());
                        if (previous_page_using_forward) {
                            driver.navigate().forward();
                        } else {
                            driver.navigate().back();
                        }
                    }
                }
            }
        }
    }

    @NotNull
    private List<String> confirmActualAnchors(List<String> expectedAnchors, List<String> anchorsToRemove, Comparator comparator) throws InterruptedException {
        List<String> actualAnchors = new ArrayList<>();

        Thread.sleep(2000);
        List<WebElement> anchors = driver.findElements(By.tagName("a"));

        for (WebElement anchor : anchors) {
            String anchorText = anchor.getText();
            actualAnchors.add(anchorText);
        }

        for (String anchor : anchorsToRemove) {
            removeAnchorToCompare(actualAnchors, expectedAnchors, anchor); 
        }

        List<String> nonEmptyActualAnchors = actualAnchors.stream().filter(anchor -> !anchor.isEmpty()).toList();
        Collections.sort(expectedAnchors,  comparator);
        List<String> mutableNonEmptyActualAnchors = new ArrayList<>(nonEmptyActualAnchors);
      //  Collections.sort(mutableNonEmptyActualAnchors);

//        log.info("mutableNonEmptyActualAnchors.toString()");
//        log.info(mutableNonEmptyActualAnchors.toString()
//                .replace(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), "APPRENTICESHIPS")
//                .replace(ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), "T_LEVELS")
//                .replace(ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), "SWAP")
//                .replace(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), "BOOTCAMPS")
//                .replace(ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), "MULTIPLY")
//                .replace(ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), "HTQ")
//                .replace(ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), "INTERNSHIPS")
//                .replace(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), "CARE_LEAVER_COVENANT")
//                .replace(ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), "PRISONERS")
//                .replace(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), "FREE_COURSES")
 //       );

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
        anchorsToRemove.addAll(schemesHomePageDefaultMap.keySet());

        confirmPageAnchorsLite(expectedAnchorsMap, anchorsToRemove, new DefaultHomePageSchemesComparator());
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
                getAnchor(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)).click();
                Assert.assertEquals(schemesHomePageDefaultMap.get(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)), driver.getTitle());
            }
            case "T_LEVELS" -> {
                getAnchor(ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)).click();
                Assert.assertEquals(schemesHomePageDefaultMap.get(ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)), driver.getTitle());
            }
            case "SWAP" -> {
                getAnchor(ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)).click();
                Assert.assertEquals(schemesHomePageDefaultMap.get(ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)), driver.getTitle());
            }
            case "BOOTCAMPS" -> {
                getAnchor(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)).click();
                Assert.assertEquals(schemesHomePageDefaultMap.get(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)), driver.getTitle());
            }
            case "MULTIPLY" -> {
                getAnchor(ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)).click();
                Assert.assertEquals(schemesHomePageDefaultMap.get(ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)), driver.getTitle());
            }
            case "HTQ" -> {
                getAnchor(ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)).click();
                Assert.assertEquals(schemesHomePageDefaultMap.get(ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)), driver.getTitle());
            }
            case "INTERNSHIPS" -> {
                getAnchor(ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)).click();
                Assert.assertEquals(schemesHomePageDefaultMap.get(ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)), driver.getTitle());
            }
            case "CARE_LEAVER_COVENANT" -> {
                getAnchor(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE)).click();
                Assert.assertEquals(schemesHomePageDefaultMap.get(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE)), driver.getTitle());
            }
            case "PRISONERS" -> {
                getAnchor(ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)).click();
                Assert.assertEquals(schemesHomePageDefaultMap.get(ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)), driver.getTitle());
            }
            case "FREE_COURSES" -> {
                getAnchor(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE)).click();
                WebElement button = driver.findElement(By.xpath("//*[text()='Show all sections']"));
                button.click();
                Assert.assertEquals(schemesHomePageDefaultMap.get(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE)), driver.getTitle());
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
  //tdo          scenario.log(pageSource);
            log.error("++++ Scenario '{}': {} ++++", scenario.getName(), scenario.getStatus());

        } else {
            log.info("++++ Scenario '{}': {} ++++", scenario.getName(), scenario.getStatus());
        }
        driver.quit();
    }

    @Then("filter reports the correct data")
    public void filterReportsTheCorrectData() throws InterruptedException {
        filterSchemesClicked();

        WebElement numberOfSchemes = driver.findElement(By.id("schemes"));
        log.info("numberOfSchemes : " + numberOfSchemes.getText());

        Assert.assertTrue("When nothing is filtered, scheme count is wrong ", numberOfSchemes.getText().contains("Number of schemes: 10"));
        confirmHomePageSchemes(new ArrayList<>(schemesHomePageDefaultMap.keySet()), new DefaultHomePageSchemesComparator());
        checkboxCombo();
    }

    private void confirmHomePageSchemes(List list, Comparator comparator) throws InterruptedException {
        List<String> anchorsToRemove = new ArrayList<>();
        removeAllHomePageAnchorsExpectSchemes(anchorsToRemove);
        confirmActualAnchors(list, anchorsToRemove, comparator);
    }

    private void filterSchemesClicked() {
        WebElement button = driver.findElement(By.xpath("//button[normalize-space(text())='Filter schemes']"));
        button.click();
    }

    public void checkboxCombo() throws InterruptedException {
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

        removeAllHomePageAnchorsExpectSchemes(anchorsToRemove);

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
            confirmActualAnchors(combinationsMap.get(combination), anchorsToRemove, new DefaultHomePageSchemesComparator());

            if (combinationsMap.get(combination).equals(Arrays.asList(ANCHOR_HOME_PAGE_NO_SCHEMES_PRESENT_CLEAR_FILTERS))) {

                Assert.assertTrue("When there no schemes returned the sort dropdown should not be present",
                        driver.findElements(By.id(SCHEME_SORT)).isEmpty());

            } else {
                WebElement selectElement = driver.findElement(By.id(SCHEME_SORT));
                Select select = new Select(selectElement);
                WebElement selectedOption = select.getFirstSelectedOption();
                Assert.assertEquals("Default sort should be selected", "No sort selected", selectedOption.getText());

            }

        }
    }

    private void removeAllHomePageAnchorsExpectSchemes(List<String> anchorsToRemove) {
        anchorsToRemove.addAll(headersMap.keySet());
        anchorsToRemove.addAll(footerMap.keySet());
        anchorsToRemove.add(ANCHOR_HOME_PAGE_CLEAR_FILTERS);
        anchorsToRemove.add(ANCHOR_HOME);
        anchorsToRemove.add(ANCHOR_HOME_SKILLS_FOR_CAREERS);
    }

    static void populateCombinationsMap(Map<List<Boolean>, List<String>> combinationsMap) {

        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, true, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, true, false, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, false, false, true)), Arrays.asList(ANCHOR_HOME_PAGE_NO_SCHEMES_PRESENT_CLEAR_FILTERS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, true, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, false, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, true, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, true, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, true, false, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, false, false, true)), Arrays.asList(ANCHOR_HOME_PAGE_NO_SCHEMES_PRESENT_CLEAR_FILTERS));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, true, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, false, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, true, false, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, true, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, true, false, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, false, false, true)), Arrays.asList(ANCHOR_HOME_PAGE_NO_SCHEMES_PRESENT_CLEAR_FILTERS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, true, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, false, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, true, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, true, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, true, false, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, false, false, true)), Arrays.asList(ANCHOR_HOME_PAGE_NO_SCHEMES_PRESENT_CLEAR_FILTERS));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, true, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, false, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(true, false, false, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, true, true, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, false, true, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, true, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, true, true, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, false, true, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, true, false, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, true, true, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, false, true, true)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, false, true, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, false, false, true)), Arrays.asList(ANCHOR_HOME_PAGE_NO_SCHEMES_PRESENT_CLEAR_FILTERS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, true, false, false, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, true, true, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, false, true, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, false, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, true, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, true, true, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, false, true, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, true, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, true, true, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, false, true, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, true, false, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, true, true, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, false, true, true)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, false, true, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, false, false, true)), Arrays.asList(ANCHOR_HOME_PAGE_NO_SCHEMES_PRESENT_CLEAR_FILTERS));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, true, false, false, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, true, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, true, true, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, true, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, true, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, false, true, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, false, true, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, false, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, true, false, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, true, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, true, true, false)), Arrays.asList(ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, true, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, true, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, false, true, false)), Arrays.asList(ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, true, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, true, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, true, true, false)), Arrays.asList(ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, true, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, true, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, false, true, false)), Arrays.asList(ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, true, false, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, true, true, true)), Arrays.asList(ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, true, true, false)), Arrays.asList(ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, true, false, true)), Arrays.asList(ANCHOR_HOME_PAGE_NO_SCHEMES_PRESENT_CLEAR_FILTERS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, true, false, false)), Arrays.asList(ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, false, true, true)), Arrays.asList(ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, false, true, false)), Arrays.asList(ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, false, false, true)), Arrays.asList(ANCHOR_HOME_PAGE_NO_SCHEMES_PRESENT_CLEAR_FILTERS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, true, false, false, false)), Arrays.asList(ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, true, true, true)), Arrays.asList(ANCHOR_HOME_PAGE_NO_SCHEMES_PRESENT_CLEAR_FILTERS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, true, true, false)), Arrays.asList(ANCHOR_HOME_PAGE_NO_SCHEMES_PRESENT_CLEAR_FILTERS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, true, false, true)), Arrays.asList(ANCHOR_HOME_PAGE_NO_SCHEMES_PRESENT_CLEAR_FILTERS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, true, false, false)), Arrays.asList(ANCHOR_HOME_PAGE_NO_SCHEMES_PRESENT_CLEAR_FILTERS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, false, true, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, false, true, false)), Arrays.asList(ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, true, false, false, false, false, false)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, true, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, true, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, true, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, true, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, true, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, true, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, true, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, false, false, true)), Arrays.asList(ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, true, false, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, true, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, true, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, true, false, true)), Arrays.asList(ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, true, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, false, false, true)), Arrays.asList(ANCHOR_HOME_PAGE_NO_SCHEMES_PRESENT_CLEAR_FILTERS));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, true, false, false, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, true, true, true)), Arrays.asList(ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, true, true, false)), Arrays.asList(ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, true, false, true)), Arrays.asList(ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, true, false, false)), Arrays.asList(ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, false, true, true)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, false, true, false)), Arrays.asList(ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, false, false, true)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
        combinationsMap.put(new ArrayList<>(List.of(false, false, false, false, false, false, false, false)), Arrays.asList(ANCHOR_APPRENTICESHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_BOOTCAMPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_CARE_LEAVER_COVENANT.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_PRISONERS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_T_LEVELS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_SWAP.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_INTERNSHIPS.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_FREE_COURSES.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_MULTIPLY.get(SCHEME_ANCHOR_NAME_HOMEPAGE), ANCHOR_HTQ.get(SCHEME_ANCHOR_NAME_HOMEPAGE)));
    }

    @When("the user wants to compare the schemes")
    public void theUserWantsToCompareTheSchemes() {
        WebElement button = driver.findElement(By.xpath("//button[normalize-space(text())='Compare these schemes in a table']"));
        button.click();
    }

    private void theySeeGivenSchemesCompared(Map<String, String> schemesMap, boolean clickAnchor) throws InterruptedException {
        List<String> anchorsToRemove = new ArrayList<>();
        anchorsToRemove.add(ANCHOR_BACK);
        anchorsToRemove.add(ANCHOR_COMPARED_PAGE_RETURN_TO_LIST);
        anchorsToRemove.add(ANCHOR_HEADER_SKIP_TO_MAIN_CONTENT); //stays on same page
        anchorsToRemove.add(ANCHOR_HOME); //
        anchorsToRemove.addAll(footerMap.keySet());
        anchorsToRemove.addAll(headersMap.keySet());

        anchorsToRemove.add(ANCHOR_SHARE_EMAIL); //stays on same page
        anchorsToRemove.add(ANCHOR_SHARE_FACEBOOK); //stays on same page
        anchorsToRemove.add(ANCHOR_SHARE_X); //stays on same page
        anchorsToRemove.add(ANCHOR_SHARE_LINKEDIN); //stays on same page

        anchorsToRemove.addAll(comparisonPageMap.keySet()); //stays on same page

        Map<String, String> expectedAnchorsMap = new HashMap<>();
        expectedAnchorsMap.putAll(headersMap);

        expectedAnchorsMap.putAll(schemesMap);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("comparison-results-table"))));
        } catch (TimeoutException t) {
            fail("Comparison table did not appear afer " + 10 + " seconds");
        }

        if (clickAnchor) {
            compareAndClickAnchors(expectedAnchorsMap, anchorsToRemove, new ComparisonPageSchemesComparator());
        } else {
            confirmActualAnchors(new ArrayList<>(expectedAnchorsMap.keySet()), anchorsToRemove, new ComparisonPageSchemesComparator());
        }
    }

    @Then("they see all the schemes compared")
    public void theySeeAllTheSchemesCompared() throws InterruptedException {
        theySeeGivenSchemesCompared(schemesComparisonPageMap, true);
    }

    @Then("all home page header and footer anchors link to the correct pages")
    public void allHomePageHeaderAndFooterAnchorsLinkToTheCorrectPages() throws InterruptedException {
        Map<String, String> expectedAnchorsMap = new HashMap<>();

        List<String> anchorsToRemove = new ArrayList<>();
        anchorsToRemove.add(ANCHOR_HOME);
        anchorsToRemove.add(ANCHOR_HOME_PAGE_CLEAR_FILTERS);
        anchorsToRemove.addAll(homeMap.keySet());
        anchorsToRemove.addAll(schemesHomePageDefaultMap.keySet());
        confirmPageHeaderAndFooterAnchors(expectedAnchorsMap, anchorsToRemove);
    }

    @Then("schemes are correctly sorted based on the chosen sort")
    public void schemesAreCorrectlySortedBasedOnTheChosenSort() throws InterruptedException, IOException {

        WebElement selectElement = driver.findElement(By.id(SCHEME_SORT));
        Select select = new Select(selectElement);

        select.selectByVisibleText("Popularity (most popular first)");

        confirmHomePageSchemes(new ArrayList<>(schemesHomePageDefaultMap.keySet()), new PopularityHomePageSchemesComparator());

        select.selectByVisibleText("Duration (shortest first)");

        confirmHomePageSchemes(new ArrayList<>(schemesHomePageDefaultMap.keySet()), new DurationHomePageSchemesComparator());

        select.selectByVisibleText("Cost (cheapest first)");

        confirmHomePageSchemes(new ArrayList<>(schemesHomePageDefaultMap.keySet()),new CostHomePageSchemesComparator());

        //filter on 'Less than 6 months'
        Map<List<Boolean>, List<String>> combinationsMap = new LinkedHashMap<>();
        populateCombinationsMap(combinationsMap);

        driver.findElement(By.id("scheme-length--less-than-6-months")).click();
        filterSchemesClicked();

        //should be default order for 'Less than 6 months' filter
        confirmHomePageSchemes(combinationsMap.get(new ArrayList<>(List.of(false, false, false, true, false, false, false, false))),new DefaultHomePageSchemesComparator());
        selectElement = driver.findElement(By.id(SCHEME_SORT));
        select = new Select(selectElement);

        select.selectByVisibleText("Popularity (most popular first)");
        confirmHomePageSchemes(combinationsMap.get(new ArrayList<>(List.of(false, false, false, true, false, false, false, false))), new PopularityHomePageSchemesComparator());

        select.selectByVisibleText("Duration (shortest first)");
        confirmHomePageSchemes(combinationsMap.get(new ArrayList<>(List.of(false, false, false, true, false, false, false, false))), new DurationHomePageSchemesComparator());

        select.selectByVisibleText("Cost (cheapest first)");
        confirmHomePageSchemes(combinationsMap.get(new ArrayList<>(List.of(false, false, false, true, false, false, false, false))), new CostHomePageSchemesComparator());

        //compare these schemes
        theUserWantsToCompareTheSchemes();
        Map<String, String> schemesMap = new HashMap<>();
        List schemes = combinationsMap.get(new ArrayList<>(List.of(false, false, false, true, false, false, false, false)));
        for (Object scheme : schemes){
            schemesMap.put(homePageToComparePageSchemeMap.get(scheme), schemesComparisonPageMap.get(homePageToComparePageSchemeMap.get(scheme)));
        }


        theySeeGivenSchemesCompared(schemesMap, false);

        //clear filters on comparison page
        getAnchor(ANCHOR_COMPARISON_PAGE_CLEAR_FILTERS).click();
        theySeeGivenSchemesCompared(schemesComparisonPageMap, false);
    }
} 