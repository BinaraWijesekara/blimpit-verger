package org.blimpit.external.verger.inventory.service;

import org.blimpit.external.verger.inventory.controller.QcControl;
import org.blimpit.external.verger.inventory.controller.UserControl;
import org.blimpit.external.verger.inventory.model.Log;
import org.blimpit.external.verger.inventory.model.QC_PlatForm;
import org.blimpit.utils.usermanagement.Constants;
import org.blimpit.utils.usermanagement.designation.DesignationManager;
import org.blimpit.utils.usermanagement.feature.FeatureManager;
import org.blimpit.utils.usermanagement.model.*;
import org.blimpit.utils.usermanagement.user.UserManager;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("usrmgtservice")
public class UsrMgtService {
    private UserManager usrMgtController = UserManager.getInstance();
    private FeatureManager featureMgtController = FeatureManager.getInstance("config.properties");
    private DesignationManager designationManager = DesignationManager.getInstance("config.properties");
    private UserControl userControl=new UserControl();
    private QcControl qcControl =new QcControl();


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------- User Registration / User Login / ReSet Password--------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @PermitAll
    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(User user){
        System.out.println(user.getName());
        ResponseStatus status = usrMgtController.register(user);
        if(status.isSuccess()){return  Response.status(Response.Status.OK).entity(status.getMessage()).build();
        }
        else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(status.getMessage()).build();
        }
    }

    @PermitAll
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String login(Credential credential){
     ResponseStatus responseStatus = usrMgtController.authenticate(credential);
        return responseStatus.getMessage();}

    @GET
    @Path("getpassword/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User getPaasword(@PathParam("username") String value) {
        return userControl.getPassword(value); }

    @GET
    @Path("/logcount")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Log> getLogCount(){
        return userControl.getLogCount();
    }

    @POST
    @Path("/logupdate")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseStatus logUpdate(Log log){
        return userControl.updateLogCount(log);
    }

    @POST
    @Path("/passwordreset")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseStatus passwordReset(User user){
         return userControl.passwordReset(user);
    }

    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //-------------------------------------------------------------------- ADD / Delete Features to Users ------------------------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @GET
    @Path("/features")
    @Produces(MediaType.APPLICATION_JSON)
    public Feature[] features( ){
        return featureMgtController.getFeatures();
    }

    @POST
    @Path("/addfeatures")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addfeatures(User user){
        ResponseStatus status = featureMgtController.addUserFeatureMapping(user);
        if (status.isSuccess()){ return Response.status(Response.Status.OK).entity(status.getMessage()).build(); }
        else {  return  Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(status.getMessage()).build();}
    }

    @GET
    @Path("/getusersfeatures/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Feature[] getSpecificFeatures(@PathParam("username")String user){
        return userControl.getusersFeatures(user);
    }

    @DELETE
    @Path("/removeusersfeatures/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUserFeatures(@PathParam("username") String user){
        // System.out.println(" User Name = "+user);
        return userControl.removeUserFeatures(user);
    }



//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//------------------------------------------------------------Update Users / Select Users / Remover Users / Search Users------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseStatus update(User user){
        System.out.println(user.getUsername()+" is "+user.getRegistrationStatus());
        return usrMgtController.updateUserInfo(user);
    }


    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User[] users(@QueryParam(Constants.STATUS) final String status, @QueryParam(Constants.USERNAME) final String username){

       if (username != null) {
           return usrMgtController.getUsers(Constants.USERNAME, username);

        }else if(status != null){
           return usrMgtController.getUsers(Constants.STATUS, status);
        }else{
           return usrMgtController.getUsers();
       }

    }

    @DELETE
    @Path("/removeUsers/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("username") String user){
       // System.out.println(" User Name = "+user);
        return userControl.removeUsers(user);
    }



    @GET
    @Path("/searchusers/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public User[] searchUsers(@PathParam("username") String user){
        System.out.println(user);
        return userControl.searchUsers(user);
    }

    @GET
    @Path("/designations")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Designation[] designations(){
        return designationManager.getDesignations();
    }


//    @GET
//    @Path("/getqcdata")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public QC_PlatForm[] getQCdata(){
//        return qcControl.getQC_data();
//    }
//
//
//    @POST
//    @Path("/adddesignation")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public ResponseStatus addDesignation(Designation designation){
//        return designationManager.add(designation);
//    }
//
//
//    @DELETE
//    @Path("/removedesignation")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public ResponseStatus removeDesignation(Designation designation){
//        return designationManager.remove(designation);
//    }


}
