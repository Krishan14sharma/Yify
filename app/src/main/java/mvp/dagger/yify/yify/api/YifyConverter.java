package mvp.dagger.yify.yify.api;

import com.google.gson.Gson;

import retrofit.converter.Converter;
import retrofit.converter.GsonConverter;

/**
 * Created by vardaan sharma on 10/4/15.
 */
public class YifyConverter extends GsonConverter implements Converter {
    public YifyConverter(ApiClientTypes types) {
        super(new Gson());
        if (types == ApiClientTypes.WITHSTRINGCONVERTER)
            new StringConverter();
        else
            new GsonConverter(new Gson());
    }
}
