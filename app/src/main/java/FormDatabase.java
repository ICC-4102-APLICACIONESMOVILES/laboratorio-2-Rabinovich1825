import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Rabinovich on 4/3/2018.
 */

@Database(entities = {Form.class}, version = 1, exportSchema = false)
public abstract class FormDatabase extends RoomDatabase{
    public abstract DaoAccess daoAccess();
}
