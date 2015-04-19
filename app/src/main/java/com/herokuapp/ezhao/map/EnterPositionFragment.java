package com.herokuapp.ezhao.map;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.gms.maps.model.LatLng;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class EnterPositionFragment extends Fragment {
    @InjectView(R.id.etLat) EditText etLat;
    @InjectView(R.id.etLong) EditText etLong;
    private OnLocationListener listener;

    public interface OnLocationListener {
        public void onLocationSet(LatLng latLng);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (OnLocationListener) activity; // TODO(emily) class cast exception
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enter_position, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @OnClick(R.id.btnSubmit)
    public void onSubmit(View view) {
        double lat = Double.parseDouble(etLat.getText().toString());
        double lng = Double.parseDouble(etLong.getText().toString());
        LatLng latLng = new LatLng(lat, lng);
        listener.onLocationSet(latLng);
    }
}
