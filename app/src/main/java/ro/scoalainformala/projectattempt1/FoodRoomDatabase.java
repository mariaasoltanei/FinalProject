package ro.scoalainformala.projectattempt1;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {FoodItem.class}, version = 1, exportSchema = false)

abstract class FoodRoomDatabase extends RoomDatabase {
    abstract FoodDao foodDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile FoodRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static FoodRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FoodRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FoodRoomDatabase.class, "food_items_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                FoodDao dao = INSTANCE.foodDao();
                dao.deleteAll();

                FoodItem foodItem = new FoodItem("Apple","Generic","52","100");
                dao.insertFood(foodItem);
                foodItem= new FoodItem("Banana","Generic","90","100");
                dao.insertFood(foodItem);
            });
        }
    };
}