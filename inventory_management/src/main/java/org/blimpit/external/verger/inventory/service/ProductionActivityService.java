package org.blimpit.external.verger.inventory.service;

import org.blimpit.external.verger.inventory.controller.ProductionControl;
import org.blimpit.external.verger.inventory.model.ProductionActivity;
import org.blimpit.external.verger.inventory.model.ResponseStatus;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("production")
public class ProductionActivityService {

        ProductionControl productionControl = new ProductionControl();
    @POST
    @Path("/addProductionActivity")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProductionActivity(ProductionActivity productionActivity){
        ResponseStatus status = productionControl.addProductionActivity(productionActivity);
        if(status.isSuccess()){return  Response.status(Response.Status.OK).entity(status.getMessage()).build();
        }
        else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(status.getMessage()).build();
        }
    }

    @GET
    @Path("/getProductionActivities/{year}/{month}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProductionActivity[] getProduct(@PathParam("year")int year,@PathParam("month") int month){
        System.out.println(year+" "+month);
        return productionControl.getProductionActivity(year, month);
    }

}
