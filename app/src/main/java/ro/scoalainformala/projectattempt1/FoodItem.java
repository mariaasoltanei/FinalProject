package ro.scoalainformala.projectattempt1;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "food_items_table")
public class FoodItem {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "food_name")
    private String foodName;

    @ColumnInfo(name = "food_brand")
    private String foodBrand;

    @ColumnInfo(name = "food_calories")
    private String foodCalories;

    @ColumnInfo(name = "food_quantity")
    private String foodQuantity;

    public FoodItem(@NonNull String foodName, String foodBrand, String foodCalories, String foodQuantity) {
        this.foodName = foodName;
        this.foodBrand = foodBrand;
        this.foodCalories = foodCalories;
        this.foodQuantity = foodQuantity;
    }

    @NonNull
    public String getFoodName() {
        return foodName;
    }

    public String getFoodBrand() {
        return foodBrand;
    }

    public String getFoodCalories() {
        return foodCalories;
    }

    public String getFoodQuantity() {
        return foodQuantity;
    }
}