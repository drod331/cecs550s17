package com.cecs.cecs550.horoscopeandroid;

import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.*;
import core.SunSign;
import util.JSONFormatUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            final TextView textview1 = (TextView) rootView.findViewById(R.id.sunSign);

            Spinner spinner;
            spinner = (Spinner) rootView.findViewById(R.id.spinner);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                {
                    String string = parent.getSelectedItem().toString();
                    textview1.setText(string);
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            spinner.setAdapter(new ArrayAdapter<SunSign>(rootView.getContext(), android.R.layout.simple_spinner_item, SunSign.values()));

            Button button = (Button) rootView.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        RetrieveHoroscopeTask.onPostExecute(new RetrieveHoroscopeTask().execute("http://sandipbgt.com/theastrologer/api/horoscope/"
                                + textview1.getText().toString() + "/today/").get(), rootView);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    //getHoroscope((SunSign) spinner.getSelectedItem(), rootView);
                }
            });

            return rootView;
        }
    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Horoscope";
                case 1:
                    return "Sign Info";
                case 2:
                    return "Determine Sign";
            }
            return null;
        }
    }

    /*public static void getHoroscope(SunSign sunSign, View view)
    {
        String temp = null;
        try {
            ConnectivityManager check = (ConnectivityManager)
                    view.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = check.getActiveNetworkInfo();
            if (info.getState() == NetworkInfo.State.CONNECTED){
                Toast.makeText(view.getContext(), "Internet is connected",
                        Toast.LENGTH_SHORT).show();
            }
            /*for (int i = 0; i<info.length; i++){
                if (info[i].getState() == NetworkInfo.State.CONNECTED){
                    Toast.makeText(context, "Internet is connected
                            Toast.LENGTH_SHORT).show();
                }
            }*/

        /*} catch (IOException e) {
            e.printStackTrace();
        }
        String horoscope = cleanUp(temp);
        //TextView textView = (TextView) findViewById(R.id.textView);
        //textView.setText(horoscope);
    }*/

    //button.setText("Don't know your sign? Click Here!");

    //Text text = new Text("Enter your birth date month and day: ");

    private static class RetrieveHoroscopeTask extends AsyncTask<String, Void, String>
    {
        class Result {
            private String mResultValue;
            private Exception mException;
            public Result(String resultValue) {
                mResultValue = resultValue;
            }
            public Result(Exception exception) {
                mException = exception;
            }
        }

        private Exception exception;

        protected String doInBackground(String... urls)
        {
            String horoscope;
            try {
                URL url = new URL(urls[0]);
                String temp = httpGet(url.toString());
                horoscope = JSONFormatUtils.cleanUp(temp, "horoscope", "\\(c\\) Kelli Fox, The Astrologer, http://new.theastrologer.com");
            } catch (Exception e) {
                this.exception = e;

                return null;
            }

            return horoscope;
        }

        private static void onPostExecute(String string, View view)
        {
            // TODO: check this.exception
            TextView textView = (TextView) view.findViewById(R.id.textView);
            textView.setText(string);
        }

        private String httpGet(String urlStr) throws IOException {
            URL url = null;
            try {
                url = new URL(urlStr);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            if (conn.getResponseCode() != 200) {
                throw new IOException(conn.getResponseMessage());
            }

            // Buffer the result into a string
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            rd.close();

            conn.disconnect();
            return sb.toString();
        }
    }
}
