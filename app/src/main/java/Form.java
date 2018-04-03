import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Rabinovich on 4/3/2018.
 */

@Entity
public class Form {

    @NonNull
    @PrimaryKey (autoGenerate = true)
    private Integer formId;

    private String category;

    public Form(){
    }

    public Integer getFormId(){return formId;}
    public void setFormId(Integer formId){this.formId = formId;}

    public String getCategory(){return category;}
    public void setCategory(String category){this.category = category;}
}
