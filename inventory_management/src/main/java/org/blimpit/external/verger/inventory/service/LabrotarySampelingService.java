package org.blimpit.external.verger.inventory.service;

import org.blimpit.external.verger.inventory.controller.LabrotarySampelingControl;
import org.blimpit.external.verger.inventory.model.LabrotarySampeling;
import org.blimpit.external.verger.inventory.model.ResponseStatus;

import javax.annotation.PreDestroy;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("LabSampling")
public class LabrotarySampelingService {

    private LabrotarySampelingControl labSampling = new LabrotarySampelingControl() ;

    @POST
    @Path("/addNewLabData")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseStatus addNewLabData(LabrotarySampeling labrotarySampeling){
        ResponseStatus status = labSampling.addNewLabRecords(labrotarySampeling);
        return status;
    }

    @GET
    @Path("/getLabData")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<LabrotarySampeling> getData(){
        return labSampling.getLabSamplingData();
    }

    @PUT
    @Path("/updateLabSample")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseStatus updateLab(LabrotarySampeling labrotarySampeling){
        System.out.println(labrotarySampeling.getLotNumber());
        System.out.println(labrotarySampeling.getStatus());
        return labSampling.updateLabSample(labrotarySampeling);
    }

    @GET
    @Path("/getMaxValue")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public LabrotarySampeling getMax(){
        return labSampling.getMaxValue();
    }
}
