package com.javier1nc.developer.preferenciasusuario;

import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvNombre;
    TextView tvPaterno;
    TextView tvMaterno;
    public static final String NOMBRE = "name";
    public static final String PATERNO = "apPaterno";
    public static final String MATERNO = "apMaterno";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        // Register listener for SharedPreferences changes.
        PreferenceManager.getDefaultSharedPreferences(this).
                registerOnSharedPreferenceChangeListener(preferencesChangeListener);

        // Leer el nombre, apellido paterno y apellido materno.
        /*
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String strValor = preferences.getString("name", null);
        TextView txtViewNombreUsuario = findViewById(R.id.txtViewUserName);
        txtViewNombreUsuario.setText(strValor);
        */

        UpdateValues();

    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Get the device's current orientation.
        int orientation = getResources().getConfiguration().orientation;

        // Display the app's menu only in portrait orientation.
        if(orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main_menu, menu);
            return true;
        }else
            return false;
    }

        @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {

        android.content.Intent preferencesIntent =
            new android.content.Intent(this, SettingsActivity.class);
        startActivity(preferencesIntent);

        return super.onOptionsItemSelected(item);
    }


    // Listener for changes to the app's SharedPreferences.
    private SharedPreferences.OnSharedPreferenceChangeListener preferencesChangeListener =
            new SharedPreferences.OnSharedPreferenceChangeListener() {
                // Called when the user changes the app's preferences.
                @Override
                public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

                    // Leer el nombre, apellido paterno y apellido materno.
                    UpdateValues();
                }
            };

    private void UpdateValues() {
        // Leer el nombre, apellido paterno y apellido materno.
        // Forma simplicada para asignar el valor de una preferencia.
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvPaterno = (TextView) findViewById(R.id.tvPaterno);
        tvMaterno = (TextView) findViewById(R.id.tvMaterno);


        tvNombre.setText(
                preferences.getString(NOMBRE, null));
        tvPaterno.setText(
                preferences.getString(PATERNO, null));
        tvMaterno.setText(
                preferences.getString(MATERNO, null));
    }


}
