package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Product {

  private UUID id;

  private String name;
  private int portion;
  private double price;

  private double fats;
  private double saturatedFats;
  private double carbs;
  private double sugar;
  private double protein;
  private double fiber;
}
