package com.indigobell.quizlesson;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.indigobell.quizlesson.common.QuizLessonConstants;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ツールバーのセット
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // FloatingActionButtonのセット
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        // Fragmentの設定
        if (savedInstanceState == null) {
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.replace(R.id.content_container, Fragment.instantiate(MainActivity.this, QuizLessonConstants.FRAGMENT_TRUE_FALSE));
            tx.commit();
        }

        // ドロワーの設定
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
        String fragment = "";

        switch (id) {
            case R.id.nav_true_false:
                fragment = QuizLessonConstants.FRAGMENT_TRUE_FALSE;
                break;
            case R.id.nav_choice:
                fragment = QuizLessonConstants.FRAGMENT_CHOICE;
                break;
            case R.id.nav_assoc:
                fragment = QuizLessonConstants.FRAGMENT_ASSOC;
                break;
            case R.id.nav_typing:
                fragment = QuizLessonConstants.FRAGMENT_TYPING;
                break;
            case R.id.nav_effect:
                fragment = QuizLessonConstants.FRAGMENT_EFFECT;
                break;
            case R.id.nav_cube:
                fragment = QuizLessonConstants.FRAGMENT_CUBE;
                break;
            case R.id.nav_panel:
                fragment = QuizLessonConstants.FRAGMENT_PANEL;
                break;
            case R.id.nav_sort:
                fragment = QuizLessonConstants.FRAGMENT_SORT;
                break;
            case R.id.nav_slot:
                fragment = QuizLessonConstants.FRAGMENT_SLOT;
                break;
            case R.id.nav_multi:
                fragment = QuizLessonConstants.FRAGMENT_MULTI;
                break;
            case R.id.nav_line:
                fragment = QuizLessonConstants.FRAGMENT_LINE;
                break;
            case R.id.nav_order:
                fragment = QuizLessonConstants.FRAGMENT_ORDER;
                break;
        }

        // Fragmentの設定
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.content_container, Fragment.instantiate(MainActivity.this, fragment));
        tx.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
