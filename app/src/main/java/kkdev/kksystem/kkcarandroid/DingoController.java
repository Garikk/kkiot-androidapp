package kkdev.kksystem.kkcarandroid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import kkdev.kksystem.kkcarandroid.constants.SysConstants;
import kkdev.kksystem.kkcontroller.main.KKController;

public class DingoController extends Service {
    KKController controller;
    public DingoController() {
        controller = new KKController();
        controller.InitSystem(SysConstants.SystemProfiles());
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
