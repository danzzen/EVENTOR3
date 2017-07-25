package com.eventor.eventor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Layout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.eventor.eventor.Behavior.CollapseAppBh;
import com.eventor.eventor.tabfragments.CalanderFragment;
import com.eventor.eventor.tabfragments.CollageFragment;
import com.eventor.eventor.tabfragments.HomeFragments;
import com.eventor.eventor.tabfragments.UserFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    FloatingActionButton fab;
    AppBarLayout appBarLayout;
    CollapsingToolbarLayout c;
    Toolbar toolbar;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        appBarLayout=(AppBarLayout)findViewById(R.id.app_bar);
        c=(CollapsingToolbarLayout)findViewById(R.id.toolbar_layout);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.content, new HomeFragments()).commit();
        disableCollapse();
        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if (tabId == R.id.tab_favorites) {
                    mFragmentManager = getSupportFragmentManager();
                    mFragmentTransaction = mFragmentManager.beginTransaction();
                //  mFragmentTransaction.replace(R.id.content, new CalanderFragment()).commit();
                    mFragmentTransaction.replace(R.id.content2, new CalanderFragment()).commit();
                    enableCollapse();
                }
                if (tabId == R.id.tab_recents) {
                    mFragmentManager = getSupportFragmentManager();
                    mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.replace(R.id.content, new HomeFragments()).commit();
                    appBarLayout.setExpanded(false,false);
disableCollapse();
                }
                if (tabId == R.id.tab_nearby) {
                    mFragmentManager = getSupportFragmentManager();
                    mFragmentTransaction = mFragmentManager.beginTransaction();

                    mFragmentTransaction.replace(R.id.content, new CollageFragment()).commit();
                    disableCollapse();
                }
                if (tabId == R.id.tab_friends) {
                    Intent intent=new Intent(getApplication(),Profile.class);
                    startActivity(intent);
                    disableCollapse();

                }
            }
        });

        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                Toast.makeText(getApplicationContext(), TabMessage.get(tabId, true), Toast.LENGTH_LONG).show();
            }
        });
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void disableCollapse() {
        appBarLayout.setActivated(false);
        //you will need to hide also all content inside CollapsingToolbarLayout
        //plus you will need to hide title of it
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.x);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
           child.setVisibility(View.GONE);
        }
        c.setTitleEnabled(false);

        AppBarLayout.LayoutParams p = (AppBarLayout.LayoutParams) c.getLayoutParams();
        p.setScrollFlags(0);
        c.setLayoutParams(p);
        c.setActivated(false);

        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
        lp.height = getResources().getDimensionPixelSize(R.dimen.toolbar_height);
        appBarLayout.requestLayout();

        //you also have to setTitle for toolbar
        // or getSupportActionBar().setTitle(title);
        toolbar.setTitle("eVentor");
    }
    public void enableCollapse() {
        appBarLayout.setActivated(true);
        c.setActivated(true);

        //you will need to show now all content inside CollapsingToolbarLayout
        //plus you will need to show title of it
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.x);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            child.setVisibility(View.VISIBLE);
        }
        c.setTitleEnabled(true);

        AppBarLayout.LayoutParams p = (AppBarLayout.LayoutParams) c.getLayoutParams();
        p.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
        c.setLayoutParams(p);

        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
        lp.height = getResources().getDimensionPixelSize(R.dimen.toolbar_expanded_height);
        appBarLayout.requestLayout();

        //you also have to setTitle for toolbar
        toolbar.setTitle(""); // or getSupportActionBar().setTitle(title);
    }
}
