package co.com.sofka.diceroller;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Dado {
    private Date date;
    @Id
    private String id;

    private String initialDataList;

    private String resultThrowlist;

    public String getRandomList() {
        return resultThrowlist;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInitialDataList() {
        return initialDataList;
    }

    public void setInitialDataList(String initialDataList) {
        this.initialDataList = initialDataList;
    }

    public void setresultThrowlist(String resultThrowlist) {
        this.resultThrowlist = resultThrowlist;
    }

}
