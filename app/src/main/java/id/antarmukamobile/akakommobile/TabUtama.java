package id.antarmukamobile.akakommobile;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ASUS on 04/12/2017.
 */

public class TabUtama extends Fragment {
    //TODO: Rename parameter arguments, choose names that match
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    //TODO Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 5;

    private OnFragmentInteractionListener mListener;

    public TabUtama() {

    }

    //TODO: Rename and change types and number of parameters
    public static TabUtama newInstance(String param1, String param2) {
        TabUtama fragment = new TabUtama();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.tab_layout, null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabbaru);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        return x;
    }

    class MyAdapter extends FragmentPagerAdapter
    {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem (int position)
        {
            switch (position) {
                case 0:
                    return new fragment_ti();
                case 1:
                    return new fragment_si();
                case 2:
                    return new fragment_ka();
                case 3:
                    return new fragment_tk();
                case 4:
                    return new fragment_mi();

            }
            return null;
        }
        @Override
        public int getCount() {
            return int_items;


        }
        @Override
        public CharSequence getPageTitle (int position){
            switch (position) {
                case 0:
                    return "Teknik Informatika";
                case 1:
                    return "Sistem Informasi";
                case 2:
                    return "Komputerisasi Akuntansi";
                case 3:
                    return "Teknik Komputer";
                case 4:
                    return "Manajemen Informatika";

            }
            return null;
        }
    }

    // TODO: 03/12/2017 rename methide, update arguments
    public void onButtonPressed(Uri uri){
        if(mListener != null){
            mListener.onFragmentInteraction(uri);
        }
    }
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener)
        {
            mListener= (OnFragmentInteractionListener) context;

        }else{
            throw new RuntimeException(context.toString()
                    + "must implement OnFragmentInteractionListener");

        }
    }
    @Override
    public void onDetach(){
        super.onDetach();
        mListener=null;
    }
    public interface OnFragmentInteractionListener{
        //TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
