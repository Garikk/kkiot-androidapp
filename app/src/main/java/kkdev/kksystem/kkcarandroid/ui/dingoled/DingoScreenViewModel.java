package kkdev.kksystem.kkcarandroid.ui.dingoled;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DingoScreenViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DingoScreenViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}