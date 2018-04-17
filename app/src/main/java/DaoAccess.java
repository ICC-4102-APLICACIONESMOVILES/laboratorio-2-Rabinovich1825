import android.arch.persistence.room.Database;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Rabinovich on 4/16/2018.
 */
@Dao
public interface DaoAccess {

    @Query("SELECT * FROM form")
    List<Form> getAllForms();

    @Query("SELECT * FROM question")
    List<Question> getAllQuestions();

    @Query("SELECT * FROM answer")
    List<Answer> getAllAnswers();

    @Insert
    void insertAllForms(Form... forms);

    @Insert
    void insertAllQuestions(Question... questions);

    @Insert
    void insertAllAnswers(Answer... answers);

    @Delete
    void deleteForm(Form form);

    @Delete
    void deleteQuestion(Question question);

    @Delete
    void deleteAnswer(Answer answer);
}
