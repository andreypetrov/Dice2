package com.petrodevelopment.dice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.petrodevelopment.dice.navigation.Util;
import com.petrodevelopment.dice.rest.OmdbApi;
import com.petrodevelopment.dice.rest.model.Movie;
import com.petrodevelopment.dice.rest.model.Result;
import com.petrodevelopment.dice.shuffle.ShuffleFragment;
import com.petrodevelopment.dice.shuffle.model.Card;
import com.petrodevelopment.dice.shuffle.model.RandomList;
import com.petrodevelopment.dice.util.U;

import retrofit.Callback;
import retrofit.RetrofitError;


public class HomeActivity extends BaseActivity {
    private BaseFragment currentFragment;
    private Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initToolbar();
        openFragment(0, "start");
    }
    @Override
    public void initModel() {

    }
    private void initDrawer(Toolbar toolbar) {
        AccountHeader accountHeader = initAccountHeader();
        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(accountHeader)
                .withDrawerItems(Util.createNavigationDrawerItems())
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        if (drawerItem.getTag()!= null) openFragment(position, (String) drawerItem.getTag());
                        // do something with the clicked item :D
                        U.log(this, "position: " + position);
                        U.log(this, "id: " + id);
                        return false;
                    }
                })
                .build();

    }

    private void openFragment(int id, String tag) {
        currentFragment = ShuffleFragment.newInstance(id, tag);
        replaceFragment(R.id.container, currentFragment);
    }

    private AccountHeader initAccountHeader() {
        AccountHeader accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.black2)
                .addProfiles(
                        new ProfileDrawerItem().withName("Mike Penz").withEmail("mikepenz@gmail.com").withIcon(getResources().getDrawable(R.drawable.photo))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();
        return accountHeader;
    }


    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("hello");
        initDrawer(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
          makeAnApiCall();
        }

        return super.onOptionsItemSelected(item);
    }

    private void makeAnApiCall() {
        OmdbApi.getInstance().getOmdbSearch().getMovies("lord", new Callback<Result>() {
            @Override
            public void success(Result result, retrofit.client.Response response) {
                for (Movie movie : result.getSearch()) {
                    U.log(this, movie.getTitle());
                }
            }

            @Override
            public void failure(RetrofitError error) {
                    U.log(this, error.getMessage());
            }
        });
    }


}
