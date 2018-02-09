package rest.resources;

import com.google.gson.Gson;
import model.Database;
import model.ImageGrabber;
import rest.model.Image;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by timothy on 2018-02-09, rest.resources.
 */
@Path("/database")
public class DatabaseService {

    private static Gson gson = new Gson();

    @POST
    @Path("/image/upload")
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadImage(@QueryParam("URL") String url, @QueryParam("UUID") String uuid) {
        // Rewrite this to save on {root}/web/images/{uuid}.jpg
        String destinationUrl = "/Users/timothy/IdeaProjects/DatabaseServer/web/images/" + uuid + ".jpg";
        try {
            ImageGrabber.saveImage(url, destinationUrl);
            Database database = new Database();
            int id = database.insertImagePath(destinationUrl);
            Image image = new Image(database.getImagePath(id), uuid);
            String json = gson.toJson(image);

            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (IOException e) {
            // TODO return correct response
            return Response.status(Response.Status.EXPECTATION_FAILED)
                    .entity("Failed to save image").build();
            //e.printStackTrace();
        } catch (SQLException e) {
            // TODO rollback?
            return Response.status(Response.Status.EXPECTATION_FAILED)
                    .entity("Failed to save image on database").build();
            //e.printStackTrace();
        } catch (Exception e) {
            // TODO image not found error
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("URL not found").build();
            //e.printStackTrace();
        }
    }
}
