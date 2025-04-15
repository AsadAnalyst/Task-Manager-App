package com.example.taskmanagerapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    private Switch switchNotifications;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "TaskManagerPrefs";
    private static final String KEY_NOTIFICATIONS = "notifications_enabled";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        switchNotifications = view.findViewById(R.id.switch_notifications);

        sharedPreferences = requireActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        boolean isEnabled = sharedPreferences.getBoolean(KEY_NOTIFICATIONS, true);
        switchNotifications.setChecked(isEnabled);

        return view;
    }



}
