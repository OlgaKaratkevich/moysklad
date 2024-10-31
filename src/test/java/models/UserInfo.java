package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class UserInfo extends UserInfoBuilder {

    private String name;
    private String patronymic;
    private String lastname;
    private String phone;
    private String position;
    private String customer;
}
