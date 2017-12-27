package id.antarmukamobile.akakommobile.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import id.antarmukamobile.akakommobile.ui.fragment.KaFragment;
import id.antarmukamobile.akakommobile.ui.fragment.MiFragment;
import id.antarmukamobile.akakommobile.ui.fragment.ProfilFragment;
import id.antarmukamobile.akakommobile.ui.fragment.SiFragment;
import id.antarmukamobile.akakommobile.ui.fragment.TIFragment;
import id.antarmukamobile.akakommobile.ui.fragment.TKFragment;
import id.antarmukamobile.akakommobile.ui.fragment.VisiMisi;

/**
 * Created by Yudis on 12/15/2017.
 */

public class TabAdaptor extends FragmentPagerAdapter{



    private String title[] =new String[]{"Profile","Visi Misi"};

    public TabAdaptor(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return new ProfilFragment();
            case 1: return new VisiMisi();
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
