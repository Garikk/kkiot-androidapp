package kkdev.kksystem.kkcarandroid.manager.callback;

import kkdev.kksystem.kkcarandroid.manager.types.KKDiagInfo;

/**
 * Created by blinov_is on 29.01.2016.
 */
public interface IDiagUI {
    public void UpdateErrorsList(KKDiagInfo DiagInfo);
    public void UpdateMonitorInfo(KKDiagInfo DiagInfo);

}
