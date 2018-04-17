import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Rabinovich on 4/16/2018.
 */
@Entity(foreignKeys = @ForeignKey(entity = Question.class, parentColumns = "id", childColumns = "questionId"))
public class Answer {

    @NonNull
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "questionId")
    private Integer questionId;
    private String answerText;

    public Integer getId(){return id;}
    public void setId(Integer id){this.id = id;}

    public Integer getQuestionId(){return questionId;}
    public void setQuestionId(Integer questionId){this.questionId = questionId;}

    public String getAnswerText(){return answerText;}
    public void setAnswerText(String answerText){this.answerText = answerText;}

}
