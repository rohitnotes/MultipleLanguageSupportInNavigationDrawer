package multiple.language.support.in.navigation.drawer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MultipleLanguageSupportNavigationDrawerActivity extends BaseActivity  implements NavigationView.OnNavigationItemSelectedListener {

    //******* tool bar variable**********
    private Toolbar toolbar;

    //******* drawer other variable *******
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    //******* drawer header variable *********
    private View navigationDrawerHeaderView;
    public TextView userName,userEmail;
    public ImageView userImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_language_support_navigation_drawer);

        setupToolbar();     //***** call setupToolbar Function ********
        setupDrawer();      //***** call setupDrawer Function ********
        setupHeader();      //***** call setupHeader Function ********

        //********* Floating Button *********
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floating_action_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Welcome To First Navigation Drawer", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    //************* setup toolbar ****************
    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
    }
    //************* end ****************

    //************* setup drawer ****************
    private void setupDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close){
            @Override
            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
    //************* end ****************

    //************* setup header ****************
    private void setupHeader() {
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationDrawerHeaderView = navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);

        userImage    = navigationDrawerHeaderView.findViewById(R.id.userProfileImage);
        userName     = navigationDrawerHeaderView.findViewById(R.id.userName);
        userEmail    =navigationDrawerHeaderView.findViewById(R.id.userEmail);

        navigationDrawerHeaderView.findViewById(R.id.header).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Header Click", Toast.LENGTH_LONG).show();
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }
    //************* end ****************

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.nav_camera:
                Toast.makeText(getApplicationContext(), "Click", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_gallery:
                Toast.makeText(getApplicationContext(), "Click", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_slideshow:
                Toast.makeText(getApplicationContext(), "Click", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_manage:
                Toast.makeText(getApplicationContext(), "Click", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_share:
                Toast.makeText(getApplicationContext(), "Click", Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_send:
                Toast.makeText(getApplicationContext(), "Click", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    //******* menu bar created **********
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.languages_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_english:
                LocaleManager.setNewLocale(this, LocaleManager.LANGUAGE_KEY_ENGLISH);
                recreate();
                break;
            case R.id.action_hindi:
                LocaleManager.setNewLocale(this, LocaleManager.LANGUAGE_KEY_HINDI);
                recreate();
                break;
            case R.id.action_spanish:
                LocaleManager.setNewLocale(this, LocaleManager.LANGUAGE_KEY_SPANISH);
                recreate();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //******* menu bar end **********

    //*************** if all fragment is finish ****************
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    //****** end ****************
}