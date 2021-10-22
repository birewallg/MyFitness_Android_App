package space.traner.myfitness.ui.progress;

import static space.traner.myfitness.ui.config.Config.APP_PREFERENCES;
import static space.traner.myfitness.ui.config.Config.APP_PREFERENCES_CHECK_1_VACUUM;
import static space.traner.myfitness.ui.config.Config.APP_PREFERENCES_CHECK_2_WATER;
import static space.traner.myfitness.ui.config.Config.APP_PREFERENCES_CHECK_3_FOOT;
import static space.traner.myfitness.ui.config.Config.APP_PREFERENCES_CHECK_4_WORKOUT;
import static space.traner.myfitness.ui.config.Config.APP_PREFERENCES_CHECK_5_MASSAGE;
import static space.traner.myfitness.ui.config.Config.APP_PREFERENCES_CHECK_6_STEPS;
import static space.traner.myfitness.ui.config.Config.APP_PREFERENCES_CHECK_7_SLEEP;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import space.traner.myfitness.databinding.FragmentProgressBinding;

public class MyProgressFragment extends Fragment {

    private MyProgressViewModel myProgressViewModel;
    private FragmentProgressBinding binding;

    // settings
    private SharedPreferences preferences;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        myProgressViewModel =
                new ViewModelProvider(this).get(MyProgressViewModel.class);

        binding = FragmentProgressBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        preferences = requireContext().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        // save preferences and set checkboxes
        final CheckBox checkBox1Vacuum = binding.checkbox1Vacuum;
        if (preferences.contains(APP_PREFERENCES_CHECK_1_VACUUM)) {
            checkBox1Vacuum.setChecked(preferences.getBoolean(APP_PREFERENCES_CHECK_1_VACUUM, false));
        }
        checkBox1Vacuum.setOnClickListener(view -> {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(APP_PREFERENCES_CHECK_1_VACUUM, checkBox1Vacuum.isChecked());
            editor.apply();
        });
        // =========================================================================================
        final CheckBox checkbox2Water = binding.checkbox2Water;
        if (preferences.contains(APP_PREFERENCES_CHECK_2_WATER)) {
            checkbox2Water.setChecked(preferences.getBoolean(APP_PREFERENCES_CHECK_2_WATER, false));
        }
        checkbox2Water.setOnClickListener(view -> {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(APP_PREFERENCES_CHECK_2_WATER, checkbox2Water.isChecked());
            editor.apply();
        });
        // =========================================================================================
        final CheckBox checkbox3Foot = binding.checkbox3Foot;
        if (preferences.contains(APP_PREFERENCES_CHECK_3_FOOT)) {
            checkbox3Foot.setChecked(preferences.getBoolean(APP_PREFERENCES_CHECK_3_FOOT, false));
        }
        checkbox3Foot.setOnClickListener(view -> {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(APP_PREFERENCES_CHECK_3_FOOT, checkbox3Foot.isChecked());
            editor.apply();
        });
        // =========================================================================================
        final CheckBox checkbox4Workout = binding.checkbox4Workout;
        if (preferences.contains(APP_PREFERENCES_CHECK_4_WORKOUT)) {
            checkbox4Workout.setChecked(preferences.getBoolean(APP_PREFERENCES_CHECK_4_WORKOUT, false));
        }
        checkbox4Workout.setOnClickListener(view -> {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(APP_PREFERENCES_CHECK_4_WORKOUT, checkbox4Workout.isChecked());
            editor.apply();
        });
        // =========================================================================================
        final CheckBox checkbox5Massage = binding.checkbox5Massage;
        if (preferences.contains(APP_PREFERENCES_CHECK_5_MASSAGE)) {
            checkbox5Massage.setChecked(preferences.getBoolean(APP_PREFERENCES_CHECK_5_MASSAGE, false));
        }
        checkbox5Massage.setOnClickListener(view -> {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(APP_PREFERENCES_CHECK_5_MASSAGE, checkbox5Massage.isChecked());
            editor.apply();
        });
        // =========================================================================================
        final CheckBox checkbox6Steps = binding.checkbox6Steps;
        if (preferences.contains(APP_PREFERENCES_CHECK_6_STEPS)) {
            checkbox6Steps.setChecked(preferences.getBoolean(APP_PREFERENCES_CHECK_6_STEPS, false));
        }
        checkbox6Steps.setOnClickListener(view -> {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(APP_PREFERENCES_CHECK_6_STEPS, checkbox6Steps.isChecked());
            editor.apply();
        });
        // =========================================================================================
        final CheckBox checkbox7Sleep = binding.checkbox7Sleep;
        if (preferences.contains(APP_PREFERENCES_CHECK_7_SLEEP)) {
            checkbox7Sleep.setChecked(preferences.getBoolean(APP_PREFERENCES_CHECK_7_SLEEP, false));
        }
        checkbox7Sleep.setOnClickListener(view -> {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(APP_PREFERENCES_CHECK_7_SLEEP, checkbox7Sleep.isChecked());
            editor.apply();
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}