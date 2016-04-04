package com.arrus;

import static spark.Spark.get;

/**
 * Created by Iuliia_Pokhylova on 4/4/2016.
 */
public class PrincipalResource {

    private static final String API_CONTEXT = "/api/v1";

    private final PrincipalService principalService;

    public PrincipalResource(PrincipalService todoService) {
        this.principalService = todoService;
        setupEndpoints();
    }

    private void setupEndpoints() {
        get(API_CONTEXT + "/principals/:id", "application/json", (request, response)

                -> principalService.find(request.params(":id")), new JsonTransformer());

        get(API_CONTEXT + "/principals", "application/json", (request, response)

                -> principalService.findAll(), new JsonTransformer());

    }


}
