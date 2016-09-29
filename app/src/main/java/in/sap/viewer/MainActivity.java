package in.sap.viewer;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import Fragments.MyFav;
import loadimage.ImageLoader_Big;
import util.AppController;
import util.Typefaces;


public class MainActivity extends ActionBarActivity implements FragmentDrawer.FragmentDrawerListener, FragmentManager.OnBackStackChangedListener, SearchView.OnQueryTextListener {

    private static String TAG = MainActivity.class.getSimpleName();

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private FragmentManager fragmentManager;
    public static Activity activity;
    float mActionBarHeight;
    private int mToolbarHeight;
    private SearchView mSearchView;
    boolean showhide = false;
    public static String Actionbartitle = "Home";
    DrawerLayout mDrawerLayout;
    DrawerLayout mDrawerLayoutRight;





    ImageLoader_Big imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        activity = MainActivity.this;
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayoutRight=(DrawerLayout) findViewById(R.id.drawer_layout);




        imageLoader=new ImageLoader_Big(MainActivity.this);

//        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//        params.width =AppController.DrawerWidth;
//        params.height =RelativeLayout.LayoutParams.MATCH_PARENT;
//        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
//        mDrawerList_Right.setLayoutParams(params);



        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        drawer();

        TypedValue tv = new TypedValue();
        if (MainActivity.this.getTheme().resolveAttribute(R.attr.actionBarSize, tv, true)) {
            mToolbarHeight = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
        }


        final TypedArray styledAttributes = getTheme().obtainStyledAttributes(
                new int[]{android.R.attr.actionBarSize});
        mActionBarHeight = styledAttributes.getDimension(0, 0);
        // display the first navigation drawer view on app launch

        // System.out.println("heig@@@@@@@@@@@@@@@@@@@@@@@@@@ht="+AppController.Height);

        //first screen
        showhide = true;

        String title = "Home";
        //getSupportActionBar().setTitle(title);
        setActionBarTitle(MainActivity.this, title, getSupportActionBar());




        displayView(0);
    }


    public void Disabledrawer(boolean lock){
        if(!lock) {
            mDrawerLayoutRight.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }else{
            mDrawerLayoutRight.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        }
    }
    //antonioleiva.com/actionbarcompat-action-views/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

//


        //search
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchItem.setVisible(true);
        mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        mSearchView.setOnQueryTextListener(this);
        return true;
    }

    public void changetobackbutton() {
        setSupportActionBar(mToolbar);
        // getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationIcon(R.drawable.btn_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        MainActivity.this.invalidateOptionsMenu();
        supportInvalidateOptionsMenu();
    }

    public void drawer() {
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // set width near about 80 % of screen width
        ViewGroup.LayoutParams params = drawerFragment.getView().getLayoutParams();
        params.width = AppController.DrawerWidth;
        drawerFragment.getView().setLayoutParams(params);
        supportInvalidateOptionsMenu();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_search:
                mSearchView.setIconified(false);
                return true;


            case android.R.id.home:
                // Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_LONG).show();
                onBackPressed();
                return true;
        }

        return false;
    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        //Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        return true;
    }


    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    //write data method of main activity
    public void HideActionBar(boolean hideVisible, Float y) {
//        if(hideVisible) {
//            if(getSupportActionBar().isShowing()) {
//                getSupportActionBar().hide();
//            }
//        }else{
//            if(!getSupportActionBar().isShowing()) {
//                getSupportActionBar().show();
//            }
//        }


        if (y >= mActionBarHeight && getSupportActionBar().isShowing()) {
            getSupportActionBar().hide();
        } else if (y == 0 && !getSupportActionBar().isShowing()) {
            getSupportActionBar().show();
        }
    }



    private void displayView(int position) {
        Fragment fragment = null;
        String title = "Home";
        switch (position) {

           // https://s3-us-west-2.amazonaws.com/99laundryusers/tn_ios_20160115041229.jpg/storage/emulated/0/DCIM/Camera/IMG_20160226_050151588.jpg
            case 0:
                Disabledrawer(true);

                showhide = true;
                fragment = new MyFav();
                replaceFragment(fragment, "");
                title ="Home";
                //Disabledrawer(true);
                break;
            case 1:
//                Disabledrawer(false);
//                showhide = false;
//                fragment = new MyDeals();
//                replaceFragment(fragment, "");
//                title = getString(R.string.mydeals);
                Disabledrawer(false);
                showhide = false;
                fragment = new MyFav();
                replaceFragment(fragment, "");
                title ="Home";

                break;
            case 2:
                Disabledrawer(false);
                showhide = false;
                fragment = new MyFav();
                replaceFragment(fragment, "");
                title ="Home";
                break;
            case 3:
                Disabledrawer(false);
                showhide = false;
                fragment = new MyFav();
                Actionbartitle = title;
                replaceFragment(fragment, "");

                break;

            case 4:
                Disabledrawer(false);
                showhide = false;
                fragment = new MyFav();
                Actionbartitle = title;
                replaceFragment(fragment, "");


                break;
            case 5:

                Disabledrawer(false);
                showhide = false;
                fragment = new MyFav();

                replaceFragment(fragment, "");
                title ="Home";







                break;
            case 6:
                Disabledrawer(false);
                showhide = false;
                fragment = new MyFav();
                Actionbartitle = title;
                replaceFragment(fragment, "");
//                fragment = new AboutMother();
//                fragment = new VolListFragment();
//                title = getString(R.string.the_mother);
//                replaceFragment(fragment, Constant.MOTHER_COLLECTED_WORK);



                showhide = false;
//                fragment = new VolListFragment();
//                title = getString(R.string.the_mother);
//                replaceFragment(fragment, Constant.MOTHER_AGENDA);

                break;
            case 7:
                showhide = false;
//                fragment = new Dictionary();
//                title = getString(R.string.dictionary);
//                replaceFragment(fragment,"");
                break;
            case 8:
                showhide = true;
//                fragment = new Dictionary();
//                title = getString(R.string.dictionary);
//                replaceFragment(fragment, "");
                break;
            default:
                break;
        }

        if (fragment != null) {
           setActionBarTitle(MainActivity.this, title, getSupportActionBar());
            // getSupportActionBar().setTitle(title);
        }
    }


    //set status of connection using UI Thread
    public void replaceFragment(final Fragment targetFragment, final String msg) {
        //clear fragment
        clearFragmentBackStack();
        //start thread here for 1 sec
        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 1 seconds
                    sleep(1 * 500);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //  mTextHeader.setText(headerText);
                            if (targetFragment != null) {
                                fragmentManager = getSupportFragmentManager();
                                fragmentManager.addOnBackStackChangedListener(MainActivity.this);
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                                String packageNameAsTag = ((Object) targetFragment).getClass().getCanonicalName();
                                // System.out.println("package name is :: " + packageNameAsTag);

                                if (fragmentManager.findFragmentByTag(packageNameAsTag) == null) {
                                    fragmentTransaction.add(R.id.container_body, targetFragment, packageNameAsTag);
                                    fragmentTransaction.addToBackStack(packageNameAsTag);
                                    Bundle bundle = new Bundle();
//                                    bundle.putString(Constant.EXTRAS_DEVICE_NAME, mDeviceName);
//                                    bundle.putString(Constant.EXTRAS_DEVICE_ADDRESS, mDeviceAddress);
                                    bundle.putString("STRING", msg);
                                    targetFragment.setArguments(bundle);
                                    // System.out.println(((Object) targetFragment).getClass().getSimpleName() + " added to backstack");
                                    fragmentTransaction.commit();
                                } else {
                                    // System.out.println("this fragment is already in the backstack");
                                }
                            } else {
//            ToastUtil.displayToast(this, this.getString(R.string.toast_working));

                            }

                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        background.start();
        // start thread

    }


    //change fragment
    public void changeFragment(Fragment targetFragment, String msg, String filename) {

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        System.out.println("Count==================" + fragmentManager.getBackStackEntryCount());
        if (targetFragment != null) {
            fragmentManager = getSupportFragmentManager();
            fragmentManager.addOnBackStackChangedListener(this);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            String packageNameAsTag = ((Object) targetFragment).getClass().getCanonicalName();
            // System.out.println("package name is :: " + packageNameAsTag);

            if (fragmentManager.findFragmentByTag(packageNameAsTag) == null) {
                fragmentTransaction.add(R.id.container_body, targetFragment, packageNameAsTag);
                fragmentTransaction.addToBackStack(packageNameAsTag);
                Bundle bundle = new Bundle();
                bundle.putString("STRING", msg);
                bundle.putString("FILENAME", filename);
                targetFragment.setArguments(bundle);
                //System.out.println(((Object) targetFragment).getClass().getSimpleName() + " added to backstack");
                fragmentTransaction.commit();
            } else {
                // System.out.println("this fragment is already in the backstack");
            }
        } else {
//            ToastUtil.displayToast(this, this.getString(R.string.toast_working));

        }

    }



    //method to clear fragment
    public void clearFragmentBackStack() {
        try {
            FragmentManager fragmentManager = getSupportFragmentManager();
            if (fragmentManager.getBackStackEntryCount() > 0) {
                int i = fragmentManager.getBackStackEntryCount();
                for (int j = 0; j < i; j++) {
                    fragmentManager.popBackStackImmediate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onBackStackChanged() {
    }

    //
    public void OnBackclick() {

        try {
            Fragment f = getSupportFragmentManager().findFragmentById(R.id.container_body);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeActionbarTitleFromActivity(String title) {

        setActionBarTitle(MainActivity.this, title, getSupportActionBar());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        OnBackclick();

        // Toast.makeText(getApplicationContext(), "On backpressed called", Toast.LENGTH_LONG).show();
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() == 1) {
            drawer();
        }
        if (fragmentManager.getBackStackEntryCount() == 0) {

            }
            try {
                clearFragmentBackStack();
            } catch (Exception e) {

            }
            SharedPreferences settings = MainActivity.this.getSharedPreferences("99LaundryCart", Context.MODE_PRIVATE);
            settings.edit().remove("Cart").commit();
            MainActivity.this.finish();
        }



    public void changeActionbarTitle(String title) {
        //getSupportActionBar().setTitle(title);
        setActionBarTitle(MainActivity.this, title, getSupportActionBar());
    }

    @Override
    public void onResume() {
        super.onResume();

    }



    public void setActionBarTitle(Context context, String title, ActionBar actionBar) {
        try {
            if (Typefaces.get(context, "DroidSans") != null) {
                SpannableString SpanString = new SpannableString(title);
                SpanString.setSpan(new util.TypefaceSpan(context, Typeface.createFromAsset(getAssets(), "fonts/DroidSans.ttf").toString()), 0, SpanString.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                actionBar.setTitle(SpanString);
            } else {
                actionBar.setTitle(title);
            }
        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    public void ShowKeyboard(EditText editText) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(),
                InputMethodManager.SHOW_IMPLICIT);
    }
//send refresh token and get access token






}

