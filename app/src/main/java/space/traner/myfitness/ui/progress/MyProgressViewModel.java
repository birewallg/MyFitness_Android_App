package space.traner.myfitness.ui.progress;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyProgressViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyProgressViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is progress fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}