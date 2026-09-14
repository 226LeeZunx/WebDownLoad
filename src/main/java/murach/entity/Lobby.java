package murach.entity;

import java.util.ArrayList;
import java.util.List;

public class Lobby {
    private List<Product> lobbyNow;

    public Lobby() {
        this.lobbyNow = new ArrayList<>(List.of(
            new Product("vn171", "Trịnh Công Sơn", new ArrayList<>(List.of(
                new DownloadLink("s01", "Hạ Trắng", "anh1.png"), 
                new DownloadLink("s02", "Một cõi đi về", "anh2.png")
            ))),
            new Product("vn808", "Tuấn Ngọc", new ArrayList<>(List.of(
                new DownloadLink("s03", "Thành Phố Sương", "anh3.png"), 
                new DownloadLink("s04", "Bây Giờ Tháng Mấy", "anh4.png")
            ))),
            new Product("vn801", "Jimmy Ngủ yên", new ArrayList<>(List.of(
                new DownloadLink("s05", "Thành Phố Sương", "anh5.png"), 
                new DownloadLink("s06", "Bây Giờ Tháng Mấy", "anh4.png")
            ))),
            new Product("vn888", "Shinasty", new ArrayList<>(List.of(
                new DownloadLink("s07", "Cây Thời Gian", "anh7.png"), 
                new DownloadLink("s08", "Có Những Mùa Thu", "anh4.png")
            )))
        ));
    }

    public List<Product> getLobbyNow() {
        return lobbyNow;
    }

    public void setLobbyNow(List<Product> lobbyNow) {
        this.lobbyNow = lobbyNow;
    }

    public Product getProductById(String id) {
        return lobbyNow.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}