package com.arrus;

import com.google.gson.Gson;
import com.mongodb.*;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iuliia_Pokhylova on 4/4/2016.
 */
public class PrincipalService {

    private final DB db;
    private final DBCollection collection;

    public PrincipalService(DB db) {
        this.db = db;
        this.collection = db.getCollection("import");
    }

    public List<Principal> findAll() {
        List<Principal> principals = new ArrayList<>();
        DBCursor dbObjects = collection.find();
        while (dbObjects.hasNext()) {
            DBObject dbObject = dbObjects.next();
            principals.add(new Principal((BasicDBObject) dbObject));
        }
        return principals;
    }

    public Principal find(String id) {
        return new Principal((BasicDBObject) collection.findOne(new BasicDBObject("_id", new ObjectId(id))));
    }


}
