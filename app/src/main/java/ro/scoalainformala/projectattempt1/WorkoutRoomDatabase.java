package ro.scoalainformala.projectattempt1;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {WorkoutItem.class}, version = 1, exportSchema = false)

abstract class WorkoutRoomDatabase extends RoomDatabase {

    abstract WorkoutDao workoutDao();

    private static volatile WorkoutRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static WorkoutRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WorkoutRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WorkoutRoomDatabase.class, "workout_items_db")
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
                WorkoutDao dao = INSTANCE.workoutDao();
                dao.deleteAllWorkouts();

                WorkoutItem workoutItem = new WorkoutItem("Crunches","3","15","70");
                dao.insertWorkout(workoutItem);
                workoutItem = new WorkoutItem("Lunges","4","10","80");
                dao.insertWorkout(workoutItem);
            });
        }
    };
}
