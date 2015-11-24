package kkdev.kksystem.kkcarandroid;

import android.app.Activity;
import android.content.Context;
import kkdev.kksystem.kkcarandroid.manager.InfoOperations;
import kkdev.kksystem.kkcarandroid.manager.types.ConfigurationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link frg_Info.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link frg_Info#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frg_Info extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public static frg_Info newInstance() {
        frg_Info fragment = new frg_Info();

        return fragment;
    }

    public frg_Info() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frg__info, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        RefreshInfo();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    private void RefreshInfo()
    {
        ConfigurationInfo CI= InfoOperations.GetConfInfo();
        Activity act;



        TextView txtName=(TextView)getView().findViewById(R.id.txtInfoConfName);
        txtName.setText(CI.ConfName);

        TextView txtDesc=(TextView)getView().findViewById(R.id.txtInfoConfDescription);
        txtDesc.setText(CI.ConfDescription);


        ImageView imgCarConn=(ImageView)getView().findViewById(R.id.imgInfoCarState);
        if (CI.CConnectionState == ConfigurationInfo.CarConnection.Active | CI.CConnectionState == ConfigurationInfo.CarConnection.Idle)
        {
            imgCarConn.setImageResource(R.drawable.info_carconnecton);
        }
        else if (CI.CConnectionState == ConfigurationInfo.CarConnection.Inactive)
        {
            imgCarConn.setImageResource(R.drawable.info_carnnoconnection);
        }

        ImageView imgCarState=(ImageView)getView().findViewById(R.id.imgInfoCarState);
        if (CI.CStatus == ConfigurationInfo.CarStatus.Ok)
        {
            imgCarState.setImageResource(R.drawable.info_engineok);
        }
        else if (CI.CStatus == ConfigurationInfo.CarStatus.MILError)
        {
            imgCarState.setImageResource(R.drawable.info_enginece);
        }
        else if (CI.CStatus == ConfigurationInfo.CarStatus.Inactive)
        {
            imgCarState.setImageResource(R.drawable.info_carnnoconnection);
        }



    }

}
