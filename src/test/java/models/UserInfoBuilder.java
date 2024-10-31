package models;

import com.github.javafaker.Faker;

public class UserInfoBuilder {
    static Faker faker = new Faker();
    public static UserInfo get(){
        return UserInfo
                .builder()
                .name(faker.name().firstName())
                .patronymic(faker.funnyName().name())
                .lastname(faker.name().lastName())
                .phone("+37529" + faker.phoneNumber().subscriberNumber(7))
                .position(faker.beer().hop())
                .customer("Розничный покупатель")
                .build();
    }


}
