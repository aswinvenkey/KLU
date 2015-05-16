package com.racingwheels.aswinvenkat.klu;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;


public class HomeScreen extends ActionBarActivity {
    private String title;
    private int c=0;
    private Toolbar toolbar;
    private Boolean toggleBool;
    private ImageView imageView;
    private ImageView buttonImageView;
    private float slideOffset;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private RelativeLayout container;
    private View drawer;
    private NavigationDrawerFragment drawerFragment = new NavigationDrawerFragment();
    public HomeScreen() {
        toggleBool = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        container = (RelativeLayout) findViewById(R.id.contain);
        imageView = (ImageView) findViewById(R.id.imageView25);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.dlay);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        final NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.dlay), toolbar);
        getSupportActionBar().setTitle("");
        dialogShow();

    }
    public void dialogShow(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert");
        builder.setMessage("Please ensure that you have a working internet connection.");
        builder.setPositiveButton("OK", null);
        builder.show();
    }
    public void open(){
        mDrawerLayout.openDrawer(Gravity.LEFT);
    }
    public void close(){
        mDrawerLayout.closeDrawers();
    }
    public void setUp(){
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                if(slideOffset<1){
                    buttonImageView.setImageResource(R.drawable.ic_menu);
                }
                else {
                    buttonImageView.setImageResource(R.drawable.ic_arrow);

                }
            }
        };
    }
}
