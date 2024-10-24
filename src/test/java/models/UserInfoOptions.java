package models;

import com.github.javafaker.Faker;

public class UserInfoOptions {
    Faker faker = new Faker();

    protected String name = faker.name().firstName();
    protected String lastName = faker.name().lastName();
    protected String patronymic = faker.funnyName().name();
    protected String phone = faker.phoneNumber().phoneNumber();
    protected String position = faker.beer().hop();


}
