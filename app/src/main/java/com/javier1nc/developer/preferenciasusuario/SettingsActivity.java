package com.javier1nc.developer.preferenciasusuario;

import android.os.Bundle;
import android.preference.PreferenceManager;

public class SettingsActivity extends android.preference.PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_settings);
        addPreferencesFromResource(R.xml.preferences);
    }
}
