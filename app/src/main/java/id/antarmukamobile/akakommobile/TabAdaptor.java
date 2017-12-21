package id.antarmukamobile.akakommobile;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Yudis on 12/15/2017.
 */

public class TabAdaptor extends FragmentPagerAdapter{


    public TabAdaptor(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0 :
            return new ProfilFragment();
            case 1:
                return new VisiMisi();

        }
        return null;
    }

    @Override
    public int getCount() {

        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0 :
                return "Profil";
            case 1 :
                return "VisiMisi";
        }
        return super.getPageTitle(position);

    }
}
