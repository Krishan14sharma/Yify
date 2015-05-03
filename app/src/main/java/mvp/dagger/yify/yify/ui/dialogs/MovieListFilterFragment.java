package mvp.dagger.yify.yify.ui.dialogs;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import mvp.dagger.yify.yify.BaseApp;
import mvp.dagger.yify.yify.R;
import mvp.dagger.yify.yify.util.CommonUtil;

/**
 * Created by Vardan sharma on 02-05-2015.
 */
public class MovieListFilterFragment extends DialogFragment {
    private Spinner spinner;
    private Spinner ratingSpinner;

    public static MovieListFilterFragment newInstance() {
        MovieListFilterFragment f = new MovieListFilterFragment();
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Pick a style based on the num.
        int theme = (CommonUtil.isGreaterThanOrEqualToLolipop()) ?
                android.R.style.Theme_Material_Light_Dialog : android.R.style.Theme_DeviceDefault_Light_Dialog;
        int style = DialogFragment.STYLE_NO_FRAME;
        setStyle(style, theme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dialog_filter_movie_list, container, false);
        setUpSortSpinner(v);
        setUpRatingSpinner(v);
        v.findViewById(R.id.btn_apply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        v.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return v;
    }

    private void setUpRatingSpinner(View v) {
        ratingSpinner = (Spinner) v.findViewById(R.id.spinner_min_ratings);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> rating_adapter = ArrayAdapter.createFromResource(BaseApp.getContext(),
                R.array.rating_list, R.layout.spinner_item_1);
        // Specify the layout to use when the list of choices appears
        rating_adapter.setDropDownViewResource(R.layout.spinner_item);
        // Apply the adapter to the spinner
        ratingSpinner.setAdapter(rating_adapter);
    }

    private void setUpSortSpinner(View v) {
        spinner = (Spinner) v.findViewById(R.id.spinner_sort_by);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(BaseApp.getContext(),
                R.array.movie_list_sort_by_options, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.spinner_item_3);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }
}

