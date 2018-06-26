package org.blimpit.external.verger.inventry.config;


import org.blimpit.utils.connectors.ConnectorException;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import java.util.Map;

@ApplicationPath("verger")
public class InvMgtServiceConfig extends ResourceConfig{

    public InvMgtServiceConfig(){
        packages("org.blimpit.external.verger.inventry");


    }


}
