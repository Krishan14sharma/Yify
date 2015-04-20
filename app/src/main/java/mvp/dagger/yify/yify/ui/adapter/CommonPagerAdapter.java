package mvp.dagger.yify.yify.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by zapbuild on 30/12/14.
 */
public class CommonPagerAdapter extends FragmentPagerAdapter {
    ArrayList<TabData> items;

    public CommonPagerAdapter(FragmentManager supportFragmentManager, ArrayList<TabData> items) {
        super(supportFragmentManager);
        this.items = items;
    }

    @Override
    public Fragment getItem(int position) {
        return items.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return items != null ? items.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return items.get(position).getTabTitle();
    }

    public void update(ArrayList<TabData> list) {
        this.items = list;
        notifyDataSetChanged();
    }


}
