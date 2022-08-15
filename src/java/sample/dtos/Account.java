/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author 2
 */
@Builder
@Getter
@Setter
@ToString
public class Account {
    private int userID;
    private String fullName;
    private String password;
    private String roleID;
    private String address;
    private String date;
    private String phone;
    private String email;
    private Boolean status;
}
