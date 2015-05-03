package mvp.dagger.yify.yify.bus;

import android.graphics.Bitmap;

import java.io.File;

/**
 * Created by vardaan sharma on 1/5/15.
 */
public class ImageRecievedEvent {
    private Bitmap bitmap;
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public ImageRecievedEvent(Bitmap bitmap, File file) {
        this.bitmap = bitmap;
        this.file = file;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap onImageRecieved() {
        return bitmap;
    }
}
