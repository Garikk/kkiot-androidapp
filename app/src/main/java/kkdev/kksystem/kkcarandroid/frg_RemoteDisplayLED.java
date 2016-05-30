package kkdev.kksystem.kkcarandroid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import kkdev.kksystem.base.classes.controls.PinControlData;
import kkdev.kksystem.kkcarandroid.manager.DiagOperations;
import kkdev.kksystem.kkcarandroid.manager.LedDisplayDiag;
import kkdev.kksystem.kkcarandroid.manager.callback.ILedDebugUI;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link frg_RemoteDisplayLED.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link frg_RemoteDisplayLED#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frg_RemoteDisplayLED extends Fragment implements ILedDebugUI {

    TextView[] DisplayROWS;
    View MainView;

    private OnFragmentInteractionListener mListener;

    public static frg_RemoteDisplayLED newInstance() {
        frg_RemoteDisplayLED fragment = new frg_RemoteDisplayLED();

        return fragment;
    }

    public frg_RemoteDisplayLED() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainView = inflater.inflate(R.layout.fragment_frg__remote_display_led, container, false);


        Button btn_UP = (Button) MainView.findViewById(R.id.btn_LedDiag_UP);
        Button btn_DOWN = (Button) MainView.findViewById(R.id.btn_LedDiag_DOWN);
        Button btn_ENTER = (Button) MainView.findViewById(R.id.btn_LedDiag_ENTER);
        Button btn_BACK = (Button) MainView.findViewById(R.id.btn_LedDiag_BACK);



        btn_UP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LedDisplayDiag.ProcessControlButton(PinControlData.DEF_BTN_UP);
            }
        });
        btn_DOWN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LedDisplayDiag.ProcessControlButton(PinControlData.DEF_BTN_DOWN);
            }
        });

        btn_ENTER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LedDisplayDiag.ProcessControlButton(PinControlData.DEF_BTN_ENTER);
            }
        });

        btn_BACK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LedDisplayDiag.ProcessControlButton(PinControlData.DEF_BTN_BACK);
            }
        });
        // Inflate the layout for this fragment
        return MainView;
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
        LedDisplayDiag.RegisterCallback(this);
    }

    @Override
    public void onDetach() {
        DiagOperations.UnRegisterCallback();
        super.onDetach();
        mListener = null;
    }

    @Override
    public void SetRowText(int RowString, String Dat) {
        Message MS=new Message();
        Bundle BD=new Bundle();
        BD.putInt("POS",RowString);
        BD.putString("DAT",Dat);
        MS.setData(BD);

        ExecRefreshInfo.sendMessage(MS);
    }

    @Override
    public void SetRowCount(int ROW) {
        DisplayROWS=new TextView[ROW];
        TableLayout TLA=(TableLayout) MainView.findViewById(R.id.tla_DebugDisplay);


        for (int i=1;i<ROW;i++)
        {
            DisplayROWS[i]= new TextView(MainView.getContext());
            TLA.addView(DisplayROWS[i]);
        }

    }

    Handler ExecRefreshInfo = new Handler() {

        public void handleMessage(android.os.Message msg) {

                DisplayROWS[msg.getData().getInt("POS")].setText(msg.getData().getString("DAT"));
               }
    };



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
