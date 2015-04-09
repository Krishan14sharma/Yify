
package mvp.dagger.yify.yify.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Torrent {

    @Expose
    private String url;
    @Expose
    private String hash;
    @Expose
    private String quality;
    @Expose
    private int seeds;
    @Expose
    private int peers;
    @Expose
    private String size;
    @SerializedName("size_bytes")
    @Expose
    private int sizeBytes;
    @SerializedName("date_uploaded")
    @Expose
    private String dateUploaded;
    @SerializedName("date_uploaded_unix")
    @Expose
    private int dateUploadedUnix;

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * 
     * @param hash
     *     The hash
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * 
     * @return
     *     The quality
     */
    public String getQuality() {
        return quality;
    }

    /**
     * 
     * @param quality
     *     The quality
     */
    public void setQuality(String quality) {
        this.quality = quality;
    }

    /**
     * 
     * @return
     *     The seeds
     */
    public int getSeeds() {
        return seeds;
    }

    /**
     * 
     * @param seeds
     *     The seeds
     */
    public void setSeeds(int seeds) {
        this.seeds = seeds;
    }

    /**
     * 
     * @return
     *     The peers
     */
    public int getPeers() {
        return peers;
    }

    /**
     * 
     * @param peers
     *     The peers
     */
    public void setPeers(int peers) {
        this.peers = peers;
    }

    /**
     * 
     * @return
     *     The size
     */
    public String getSize() {
        return size;
    }

    /**
     * 
     * @param size
     *     The size
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * 
     * @return
     *     The sizeBytes
     */
    public int getSizeBytes() {
        return sizeBytes;
    }

    /**
     * 
     * @param sizeBytes
     *     The size_bytes
     */
    public void setSizeBytes(int sizeBytes) {
        this.sizeBytes = sizeBytes;
    }

    /**
     * 
     * @return
     *     The dateUploaded
     */
    public String getDateUploaded() {
        return dateUploaded;
    }

    /**
     * 
     * @param dateUploaded
     *     The date_uploaded
     */
    public void setDateUploaded(String dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    /**
     * 
     * @return
     *     The dateUploadedUnix
     */
    public int getDateUploadedUnix() {
        return dateUploadedUnix;
    }

    /**
     * 
     * @param dateUploadedUnix
     *     The date_uploaded_unix
     */
    public void setDateUploadedUnix(int dateUploadedUnix) {
        this.dateUploadedUnix = dateUploadedUnix;
    }

}
