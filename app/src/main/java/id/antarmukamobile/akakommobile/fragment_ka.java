package id.antarmukamobile.akakommobile;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ASUS on 04/12/2017.
 */

public class fragment_ka extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        //layout untuk fragment
        return inflater.inflate(R.layout.fragment_ka, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        //mengubah judul  pada toolbar
        getActivity().setTitle("Komputerisasi Akuntansi");
    }
    public interface OnFragmentInteractionListener{
        //TODO: Update argumenr type and name
        void onFragmentInteraction(Uri uri);
    }
}