package rest.model;

/**
 * Created by timothy on 2018-02-09, rest.model.
 */
public class Image {
    private String url;
    private String uuid;

    public Image(String url, String uuid) {
        this.url = url;
        this.uuid = uuid;
    }

    public String getUrl() {
        return url;
    }

    public String getUuid() {
        return uuid;
    }
}
