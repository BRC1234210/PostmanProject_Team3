package api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class movies {

    private String mediaType;
    private Integer mediaId;
    private String favorite;
    private String watchlist;


    public movies() {
    }

    public movies(String mediaType, Integer mediaId, String favorite) {
        this.mediaType = mediaType;
        this.mediaId = mediaId;
        this.favorite = favorite;
    }

    public movies(String mediaType, Integer mediaId, String watchlist, String favorite) {
        this.mediaType = mediaType;
        this.mediaId = mediaId;
        this.watchlist = watchlist;
        this.favorite = favorite;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String getWatchlist() {
        return watchlist;
    }

    public void setWatchlist(String watchlist) {
        this.watchlist = watchlist;
    }

    @Override
    public String toString() {
        return "movies{" +
                "mediaType='" + mediaType + '\'' +
                ", mediaId=" + mediaId +
                ", favorite='" + favorite + '\'' +
                ", watchlist='" + watchlist + '\'' +
                '}';
    }
}
