package murach.entity;

public class DownloadLink {
    private String id;
    private String songName;
    private String link;

    public DownloadLink(String id, String songName, String link) {
        this.id = id;
        this.songName = songName;
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}