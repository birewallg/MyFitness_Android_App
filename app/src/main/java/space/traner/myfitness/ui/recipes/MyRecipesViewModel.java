package space.traner.myfitness.ui.recipes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyRecipesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyRecipesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is recipes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}