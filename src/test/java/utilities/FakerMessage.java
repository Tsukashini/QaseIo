package utilities;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerMessage {

    public static String getProjectName() {
        Faker faker = new Faker();
        return faker.elderScrolls().dragon();
    }

    public static String getCode() {
        Faker faker = new Faker();
        return faker.app().name().toUpperCase(Locale.ROOT);
    }

    public static String getFax() {
        Faker faker = new Faker();
        return faker.phoneNumber().phoneNumber();
    }

    public static String getWebsite() {
        Faker faker = new Faker();
        return faker.internet().domainName();
    }

    public static String getRevenue() {
        Faker faker = new Faker();
        return Long.toString(faker.number().randomNumber());
    }

    public static String getDescription() {
        Faker faker = new Faker();
        return faker.chuckNorris().fact();
    }

    public static String getPrecondition() {
        Faker faker = new Faker();
        return faker.internet().domainName();
    }

    public static String getAPITitle() {
        Faker faker = new Faker();
        return faker.ancient().god();
    }

    public static int getType() {
        Faker faker = new Faker();
        return faker.number().numberBetween(1, 2);
    }

    public static int getIndustry() {
        Faker faker = new Faker();
        return faker.number().numberBetween(1, 32);
    }

    public static String getBillingCity() {
        Faker faker = new Faker();
        return faker.address().city();
    }
}
