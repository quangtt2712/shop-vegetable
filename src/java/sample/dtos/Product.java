/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

import lombok.Builder;
import lombok.Data;
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
public class Product {
    private int productID;
    private String productName;
    private String image;
    private double price;
    private int quantity;//số lượng trong kho
    private int catagoryID;
//    private String imporDate;
//    private String usingDate;

}