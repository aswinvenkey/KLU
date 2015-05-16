package com.racingwheels.aswinvenkat.klu;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment implements com.racingwheels.aswinvenkat.klu.Adapter.ClickListner {

    private RecyclerView recyclerView;
    private com.racingwheels.aswinvenkat.klu.Adapter adapter;
    public static final String PREF_FILE_NAME = "testpref";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private boolean mUserLearnedDrawer;
    private boolean mFromSavedInstanceState;
    private View containerView;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mFromSavedInstanceState = true;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawerList);
        adapter = new com.racingwheels.aswinvenkat.klu.Adapter(getActivity(), getData());
        adapter.setClickListner(this);
        recyclerView.setAdapter(adapter);
        RelativeLayout root=(RelativeLayout)layout.findViewById(R.id.fragment_navigation_drawer);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }

    public static List<Manager> getData() {
        List<Manager> data = new ArrayList<>();
        int[] icons = {R.drawable.icon_abtus,R.drawable.icon_admission,R.drawable.icon_sis,R.drawable.icon_paco,R.drawable.icon_easy,R.drawable.icon_rss,R.drawable.icon_thesis,R.drawable.icon_cus,R.drawable.icon_close};
        String[] titles = {"About The University","KLU-Admissions","KLU-SIS","KLU-PACO","KLU-EASY","Events & News","Thesis Status","Contact Us","Exit"};
        for (int i = 0; i < titles.length && i < icons.length; i++) {
            Manager current = new Manager();
            current.iconId = icons[i];
            current.title = titles[i];
            data.add(current);
        }
        return data;
    }


    public void setUp(int Fragment_id, DrawerLayout drawerLayout, final Toolbar toolbar) {
        containerView = getActivity().findViewById(Fragment_id);
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getActivity().invalidateOptionsMenu();

            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });


    }



    @Override
    public void itemClicked(View view, int position) {
        if (position == 0) {
            startActivity(new Intent(getActivity(), AboutUniv.class));
        }
        else if (position == 1){
            startActivity(new Intent(getActivity(),Admissions.class));
        }
        else if (position == 2){
            startActivity(new Intent(getActivity(),Sis.class));

        }
        else if(position == 3){
            startActivity(new Intent(getActivity(),Paco.class));
        }
        else if(position == 4){
            startActivity(new Intent(getActivity(),Easy.class));

        }
        else if (position == 5){
            startActivity(new Intent(getActivity(),Rss.class));

        }
        else if (position == 6){
            startActivity(new Intent(getActivity(),Thesis.class));

        }
        else if (position == 7){
            startActivity(new Intent(getActivity(),ContactUs.class));
        }
        else if (position == 8){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    public void open(){
        mDrawerLayout.openDrawer(Gravity.LEFT);
    }
    public void close(){
        mDrawerLayout.closeDrawers();
    }
}
