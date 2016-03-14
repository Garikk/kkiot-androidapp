package kkdev.kksystem.kkcarandroid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import kkdev.kksystem.kkcarandroid.manager.DiagOperations;
import kkdev.kksystem.kkcarandroid.manager.callback.IDiagUI;
import kkdev.kksystem.kkcarandroid.manager.types.KKDiagInfo;


public class frg_Diag_Full extends Fragment implements IDiagUI{
    private OnFragmentInteractionListener mListener;
    private KKDiagInfo CurrDI;
    private SimpleAdapter DiagAdapter;

    public frg_Diag_Full() {
        // Required empty public constructor
    }

    public static frg_Diag_Full newInstance(String param1, String param2) {
        frg_Diag_Full fragment = new frg_Diag_Full();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frg__diag_full, container, false);
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        DiagOperations.RegisterCallback(this);
        DiagOperations.RequestDiagParams();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        DiagOperations.UnRegisterCallback();
        DiagOperations.RequestDiagParams_Stop();
    }

    @Override
    public void UpdateErrorsList(KKDiagInfo DiagInfo) {
        //not used by now
    }

    @Override
    public void UpdateMonitorInfo(KKDiagInfo DiagInfo) {
        CurrDI=DiagInfo;
        ExecRefreshInfo.sendEmptyMessage(1);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    Handler ExecRefreshInfo = new Handler() {

        public void handleMessage(android.os.Message msg) {
            RefreshInfo(CurrDI);
        }

        private void RefreshInfo( KKDiagInfo DI)
        {
            //
            if (DiagAdapter==null) {
                //
                // находим список
                ListView lvMain = (ListView) getView().findViewById(R.id.lst_Diag_DTC);
                //
                DiagAdapter = new SimpleAdapter(getView().getContext(), DI.GetDiagArray(), android.R.layout.simple_list_item_2,
                        new String[]{"Parameter", "Value"},
                        new int[]{android.R.id.text1, android.R.id.text2});

                lvMain.setAdapter(DiagAdapter);
            }
            else
            {
                DiagAdapter.notifyDataSetChanged();
            }

        }
    };
}
