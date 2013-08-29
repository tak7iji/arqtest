package test;

import java.io.File;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.ArchivePaths;

public class Deployments {
 
   public static WebArchive createDeployment() {
 
        WebArchive war = ShrinkWrap.create(WebArchive.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, ArchivePaths.create("beans.xml"))
                .addAsWebResource(new File("src/main/webapp/index.html"))
                .addAsWebResource(new File("src/main/webapp/loggedin.html"))
                .addAsWebResource(new File("src/main/webapp/loggedout.html"))
                .setWebXML(new File("src/main/webapp/web.xml"));

        System.out.println(war.toString(true));
        return war;
    }
}
