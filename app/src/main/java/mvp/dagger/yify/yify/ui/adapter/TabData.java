package mvp.dagger.yify.yify.ui.adapter;

import android.support.v4.app.Fragment;

public class TabData {
        String tabTitle;
        Fragment fragment;

        public TabData(String tabTitle, Fragment fragment) {
            this.tabTitle = tabTitle;
            this.fragment = fragment;
        }

        public String getTabTitle() {
            return tabTitle;
        }

        public void setTabTitle(String tabTitle) {
            this.tabTitle = tabTitle;
        }

        public Fragment getFragment() {
            return fragment;
        }

        public void setFragment(Fragment fragment) {
            this.fragment = fragment;
        }
    }