package kkdev.kksystem.kkcarandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import kkdev.kksystem.kkcarandroid.manager.ConnectionManager;
import kkdev.kksystem.kkcarandroid.manager.SettingsManager;
import kkdev.kksystem.kkcarandroid.manager.callback.IConnectionState;

import static kkdev.kksystem.kkcarandroid.manager.callback.IConnectionState.ConnectionStates.*;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    final int KK_ACTIVITY_REQUEST_BLUETOOTH=1;
    final int KK_ACTIVITY_REQUEST_DINGOCLOUD=2;

    final int KK_ACTIVITY_REQUEST_RESULT_OK=1;
    final int KK_ACTIVITY_REQUEST_RESULT_CANCEL=5;

    TextView txtDingoConnectionState;
    TextView txtBTConnectionState;

    public MainActivity() {
        ConnectionState = new IConnectionState(){

            @Override
            public void connectionStateInfo(ConnectionStates ConnectionState, ConnectorType Connector) {
                if (Connector==ConnectorType.BluetoothEXA) {
                    switch (ConnectionState) {
                        case CONNECTION_ACTIVE:
                            txtBTConnectionState.setText(R.string.str_drawer_connect_bluetooth_ok);
                            break;
                        case CONNECTION_INACTIVE:
                            txtBTConnectionState.setText(R.string.str_drawer_connect_bluetooth_wait);
                            break;
                        case CONNECTION_DISABLED:
                            txtBTConnectionState.setText(R.string.str_drawer_connect_bluetooth_disable);
                            break;
                        case CONNECTION_ERROR:
                            txtBTConnectionState.setText(R.string.str_drawer_connect_bluetooth_error);
                            break;

                    }
                }
                else if (Connector==ConnectorType.DingoCloud) {
                    switch (ConnectionState) {
                        case CONNECTION_ACTIVE:
                            txtDingoConnectionState.setText(R.string.str_drawer_connect_dingocloud_ok);
                            break;
                        case CONNECTION_INACTIVE:
                            txtDingoConnectionState.setText(R.string.str_drawer_connect_dingocloud_wait);
                            break;
                        case CONNECTION_DISABLED:
                            txtDingoConnectionState.setText(R.string.str_drawer_connect_dingocloud_disable);
                            break;
                        case CONNECTION_ERROR:
                            txtDingoConnectionState.setText(R.string.str_drawer_connect_dingocloud_error);
                            break;

                    }
                }

            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==KK_ACTIVITY_REQUEST_RESULT_CANCEL)
            return;

        switch (requestCode)
        {
            case KK_ACTIVITY_REQUEST_BLUETOOTH:
                ConnectionManager.CheckConnect(false);
                break;
            case KK_ACTIVITY_REQUEST_DINGOCLOUD:
                break;


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        SettingsManager.initSettings(this);
        //
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //
        txtDingoConnectionState=(TextView)findViewById(R.id.txt_MainInfo_DingoConnectionState);
        txtBTConnectionState=(TextView)findViewById(R.id.txt_MainInfo_BTConnectionState);
        //
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    IConnectionState ConnectionState;

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Info) {
            fragmentManager.beginTransaction()
                    .replace(R.id.main_layout, frg_Info.newInstance())
                    .commit();
        } else if (id == R.id.nav_diag_ce) {
            fragmentManager.beginTransaction()
                    .replace(R.id.main_layout, frg_Diag.newInstance())
                    .commit();
        } else if (id == R.id.nav_diag_full) {
            fragmentManager.beginTransaction()
                    .replace(R.id.main_layout, frg_Diag.newInstance())
                    .commit();
        } else if (id == R.id.nav_media) {
            fragmentManager.beginTransaction()
                    .replace(R.id.main_layout, frg_Media.newInstance())
                    .commit();

        } else if (id == R.id.nav_infodisplay) {
            fragmentManager.beginTransaction()
                    .replace(R.id.main_layout, frg_RemoteDisplayAndr.newInstance())
                    .commit();

        } else if (id == R.id.nav_leddebug) {
            fragmentManager.beginTransaction()
                    .replace(R.id.main_layout, frg_RemoteDisplayLED.newInstance())
                    .commit();

        } else if (id == R.id.nav_settings) {
            fragmentManager.beginTransaction()
                    .replace(R.id.main_layout, frg_Settings.newInstance())
                    .commit();
        } else if (id == R.id.nav_connect_bluetooth) {
            Intent intent = new Intent(this, act_bluetoothconnect.class);
            startActivityForResult(intent,KK_ACTIVITY_REQUEST_BLUETOOTH);
        } else if (id == R.id.nav_connect_dingocloud) {
            Intent intent = new Intent(this, act_dingocloud_connect.class);
            startActivityForResult(intent,KK_ACTIVITY_REQUEST_DINGOCLOUD);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
