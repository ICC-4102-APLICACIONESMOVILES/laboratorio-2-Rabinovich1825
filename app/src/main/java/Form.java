import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Rabinovich on 4/3/2018.
 */

@Entity
public class Form {

    @NonNull
    @ColumnInfo(name = "id")
    @PrimaryKey (autoGenerate = true)
    private Integer id;

    private String name;
    private String date;
    private String comentary;
    private String category;

    public Form(){
    }

    public Integer getId(){return id;}
    public void setId(Integer id){this.id = id;}

    public String getCategory(){return category;}
    public void setCategory(String category){this.category = category;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getDate(){return date;}
    public void setDate(String date){this.date = date;}

    public String getComentary(){return comentary;}
    public void setComentary(String comentary){this.comentary = comentary;}
}
