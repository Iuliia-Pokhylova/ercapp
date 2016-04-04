package com.arrus;

import com.mongodb.BasicDBObject;
import org.bson.types.ObjectId;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Iuliia_Pokhylova on 4/4/2016.
 */
public class Principal {

    private String id;
    private int abcount;
    private String fio;
    private int n_house;
    private int n_room;
    private String data_d;
    private Double summ_month;
    private Double summ_dolg;

    public Principal(BasicDBObject dbObject) {

        this.id = ((ObjectId) dbObject.get("_id")).toString();
        this.abcount = dbObject.getInt("ABCOUNT");
        this.fio = dbObject.getString("FIO");
        this.data_d = dbObject.getString("DATA_D");
        this.n_house = dbObject.getInt("N_HOUSE");
        this.n_room = dbObject.getInt("N_ROOM");
        this.summ_month = dbObject.getDouble("SUMM_MONTH");
        this.summ_dolg = dbObject.getDouble("SUMM_DOLG");
    }

    public int getAbcount() {
        return abcount;
    }

    public String getFio() {
        return fio;
    }

    public int getN_house() {
        return n_house;
    }

    public int getN_room() {
        return n_room;
    }

    public String getData_d() {
        return data_d;
    }

    public Double getSumm_month() {
        return summ_month;
    }

    public Double getSumm_dolg() {
        return summ_dolg;
    }
}
