import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Rabinovich on 4/3/2018.
 */

@Dao
public interface DaoAccess {

    @Insert
    void insertOnlySingleForm(Form form);
    @Insert
    void insertMultipleForms(List<Form> formList);
    @Query ("SELECT * FROM Form WHERE formId = :formId")
    Form fetchOneMoviesbyMovieId (int formId);
    @Update
    void updateMovie (Form form);
    @Delete
    void deleteMovie (Form form);
}