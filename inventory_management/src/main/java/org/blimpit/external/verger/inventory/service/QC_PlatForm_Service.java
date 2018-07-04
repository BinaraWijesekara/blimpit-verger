package org.blimpit.external.verger.inventory.service;

import org.blimpit.external.verger.inventory.controller.QcControl;
import org.blimpit.external.verger.inventory.model.Products;
import org.blimpit.external.verger.inventory.model.QC_PlatForm;
import org.blimpit.external.verger.inventory.model.*;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("qcplatform")
public class QC_PlatForm_Service {

    private QcControl qcControl = new QcControl();
    private LabrotarySampelingService labSampling = new LabrotarySampelingService();


    @PermitAll
    @GET
    @Path("/getqcdata")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<QC_PlatForm> getQCdata(){
        return qcControl.getQC_data();
    }

    @GET
    @Path("/proid")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Products[] designations(){
        return qcControl.getProducts();
    }

    @GET
    @Path("/searchbyid/{product_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<QC_PlatForm> searchUsers(@PathParam("product_id") String pid){
      //  System.out.println(pid);
        return qcControl.searchByProductID(pid);
    }

    @POST
    @Path("/addnewEntry")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(QC_PlatForm qc_platForm){
        ResponseStatus status = qcControl.addNewEntry(qc_platForm);
        if(status.isSuccess()){return  Response.status(Response.Status.OK).entity(status.getMessage()).build();
        }
        else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(status.getMessage()).build();
        }
    }

    @GET
    @Path("/getid/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Products getid (@PathParam("name") String products){
        return qcControl.getID(products);
    }

//    @POST
//    @Path("/addNewLabData")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response addNewLabData(LabrotarySampeling labrotarySampeling){
//        Response status = labSampling.addNewLabData(labrotarySampeling);
//        return status;
//    }

//    @POST
//    @Path("/updateusedfor")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response updateUsedFor(QC_PlatForm qc_platForm){
//
//    }
}
