import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Rabinovich on 4/16/2018.
 */
@Database(entities = {Form.class, Answer.class, Question.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract DaoAccess daoAccess();
}
