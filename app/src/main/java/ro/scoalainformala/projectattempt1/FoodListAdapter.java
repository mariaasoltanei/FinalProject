package ro.scoalainformala.projectattempt1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodViewHolder> {

    class FoodViewHolder extends RecyclerView.ViewHolder {
        private final TextView foodNameTV;
        private final TextView foodBrandTV;
        private final TextView foodCaloriesTV;
        private final TextView foodQuantityTV;

        private FoodViewHolder(View itemView) {
            super(itemView);
            foodNameTV = itemView.findViewById(R.id.food_name);
            foodBrandTV = itemView.findViewById(R.id.food_brand);
            foodQuantityTV = itemView.findViewById(R.id.food_quantity);
            foodCaloriesTV = itemView.findViewById(R.id.food_calories);
        }
    }

    private final LayoutInflater mFoodInflater;
    private List<FoodItem> mFoodItems; // Cached copy of words

    FoodListAdapter(Context context) {
        mFoodInflater = LayoutInflater.from(context);

    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mFoodInflater.inflate(R.layout.food_item, parent, false);
        return new FoodViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        if (mFoodItems != null) {
            FoodItem current = mFoodItems.get(position);
            holder.foodNameTV.setText(current.getFoodName());
            holder.foodBrandTV.setText(current.getFoodBrand());
            holder.foodQuantityTV.setText(current.getFoodQuantity());
            holder.foodCaloriesTV.setText(current.getFoodCalories());
        } else {
            // Covers the case of data not being ready yet.
            holder.foodNameTV.setText("No Word");
            holder.foodBrandTV.setText("No Word");
            holder.foodCaloriesTV.setText("No Word");
            holder.foodQuantityTV.setText("No Word");
        }
    }

    void setFoodItems(List<FoodItem> foods){
        mFoodItems = foods;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mFoodItems != null)
            return mFoodItems.size();
        else return 0;
    }
}
