package org.blimpit.external.verger.inventry.service;

import org.blimpit.utils.usermanagement.Constants;
import org.blimpit.utils.usermanagement.designation.DesignationManager;
import org.blimpit.utils.usermanagement.feature.FeatureManager;
import org.blimpit.utils.usermanagement.model.*;
import org.blimpit.utils.usermanagement.user.UserManager;

import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;


@Path("usrmgtservice")
public class UsrMgtService {
    private UserManager usrMgtController = UserManager.getInstance();
    private FeatureManager featureMgtController = FeatureManager.getInstance("config.properties");
    private DesignationManager designationManager = DesignationManager.getInstance("config.properties");



    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseStatus login(Credential credential){
     return usrMgtController.login(credential);
    }


    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseStatus register(User user){
        return usrMgtController.register(user);
    }



    @GET
    @Path("/features")
    @Produces(MediaType.APPLICATION_JSON)
    public Feature[] features( ){
        return featureMgtController.getFeatures();
    }


    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseStatus update(User user ){
        return usrMgtController.updateUserInfo(user);
    }



    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User[] users(@QueryParam(Constants.STATUS) final String status,@QueryParam(Constants.USERNAME) final String username){

       if (username != null) {
           return usrMgtController.getUsers(Constants.USERNAME, username);

        }else if(status != null){
           return usrMgtController.getUsers(Constants.STATUS, status);
        }else{
           return usrMgtController.getUsers();
       }

    }


    @GET
    @Path("/designations")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Designation[] designations(){
        return designationManager.getDesignations();
    }


    @POST
    @Path("/adddesignation")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseStatus addDesignation(Designation designation){
        return designationManager.add(designation);
    }


    @POST
    @Path("/removedesignation")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseStatus removeDesignation(Designation designation){
        return designationManager.remove(designation);
    }

}
