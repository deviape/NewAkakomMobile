package id.antarmukamobile.akakommobile;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

public class ProfilVisiMisi extends Activity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabAdaptor tabAdaptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_visi_misi);
        tabLayout= (TabLayout) findViewById(R.id.tabbaru);
        viewPager= (ViewPager) findViewById(R.id.viewpager);

//        tabAdaptor = new TabAdaptor(getFragmentManager());

    }

}
