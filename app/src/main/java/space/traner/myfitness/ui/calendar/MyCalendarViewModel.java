package space.traner.myfitness.ui.calendar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyCalendarViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyCalendarViewModel() {
       /* mText = new MutableLiveData<>();
        mText.setValue("This is calendar fragment");*/
    }

    public LiveData<String> getText() {
        return mText;
    }
}