import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Rabinovich on 4/16/2018.
 */
@Entity(foreignKeys = @ForeignKey(entity = Form.class, parentColumns = "id", childColumns = "formId"))
public class Question {

    @NonNull
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private Integer id;

    @ColumnInfo(name = "formId")
    private Integer formId;
    private String questionText;
    private String type;

    public Question(){}

    public Integer getId(){return id;}
    public void setId(Integer id){this.id = id;}

    public Integer getFormId(){return formId;}
    public void setFormId(Integer formId){this.formId = formId;}

    public String getQuestionText(){return questionText;}
    public void setQuestionText(String questionText){this.questionText = questionText;}

    public String getType(){return type;}
    public void setType(String type){this.type = type;}
}
