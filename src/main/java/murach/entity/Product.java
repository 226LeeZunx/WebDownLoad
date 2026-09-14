package murach.entity;

import java.util.List;

public class Product {
    private String id;
    private String description;
    private List<DownloadLink> downloadLinks;

    public Product(String id, String description, List<DownloadLink> downloadLinks) {
        this.id = id;
        this.description = description;
        this.downloadLinks = downloadLinks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DownloadLink> getDownloadLinks() {
        return downloadLinks;
    }

    public void setDownloadLinks(List<DownloadLink> downloadLinks) {
        this.downloadLinks = downloadLinks;
    }
}