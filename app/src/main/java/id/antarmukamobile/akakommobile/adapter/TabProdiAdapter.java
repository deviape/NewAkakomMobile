package id.antarmukamobile.akakommobile.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import id.antarmukamobile.akakommobile.ui.fragment.KaFragment;
import id.antarmukamobile.akakommobile.ui.fragment.MiFragment;
import id.antarmukamobile.akakommobile.ui.fragment.SiFragment;
import id.antarmukamobile.akakommobile.ui.fragment.TIFragment;
import id.antarmukamobile.akakommobile.ui.fragment.TKFragment;

/**
 * Created by Yudis on 12/26/2017.
 */

public class TabProdiAdapter extends FragmentPagerAdapter {

    private String title[] =new String[]{"TI","SI","KA","TK","MI"};
    public TabProdiAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new TIFragment();
            case 1: return new SiFragment();
            case 2:return new KaFragment();
            case 3: return new TKFragment();
            case 4:return new MiFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return title.length;
    }
    @Override
    public CharSequence getPageTitle(
            int position) {
        return title[position];
    }
}
