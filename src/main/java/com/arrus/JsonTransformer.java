package com.arrus;

import com.google.gson.Gson;
import spark.ResponseTransformer;


/**
 * Created by Iuliia_Pokhylova on 4/4/2016.
 */
public class JsonTransformer implements ResponseTransformer {

    private Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }

}