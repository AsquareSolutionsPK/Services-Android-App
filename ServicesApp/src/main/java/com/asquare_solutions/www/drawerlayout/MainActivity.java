package com.asquare_solutions.www.drawerlayout;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CardView cardView;
    GridLayout mainGrid;

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    private GridLayout singleEvent;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);

        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, R.string.open, R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // When swiping between pages, select the
                        // corresponding tab.
                        getActionBar().setSelectedNavigationItem(position);
                    }
                });
    }

    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(MainActivity.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(MainActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (  int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int index=i;
            final int finalI = index;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (index){
                        case 0:
                            Intent intentServices = new Intent(MainActivity.this, ServicesActivity.class);
                            startActivity(intentServices);
                            break;
                        case 1:
                            Intent intentBookingForm = new Intent(MainActivity.this, BookingFormActivity.class);
                            startActivity(intentBookingForm);
                            break;
                        case 2:
                            Intent intentPrices = new Intent(MainActivity.this, PricesActivity.class);
                            startActivity(intentPrices);
                            break;
                        case 3:
                            Intent intentWorkGallery = new Intent(MainActivity.this, WorkGalleryActivity.class);
                            startActivity(intentWorkGallery);
                            break;
                        case 4:
                            Intent intentAboutUs = new Intent(MainActivity.this, AboutUsActivity.class);
                            startActivity(intentAboutUs);
                            break;
                        case 5:
                            Intent intentOurPartners = new Intent(MainActivity.this, OurPartnersActivity.class);
                            startActivity(intentOurPartners);
                            break;
                        case 6:
                            Intent intentContactUs = new Intent(MainActivity.this, ContactUsActivity.class);
                            startActivity(intentContactUs);
                            break;

                    }

                }
            });
        }
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.item1) {
            Intent activity_main = new Intent(this, MainActivity.class);
            startActivity(activity_main);

        } else if (id == R.id.item2) {
            Intent activity_about_us = new Intent(this, AboutUsActivity.class);
            startActivity(activity_about_us);

        } else if (id == R.id.item3) {
            Intent activity_search = new Intent(this, SearchActivity.class);
            startActivity(activity_search);

        } else if (id == R.id.item4) {
            Intent activity_work_gallery = new Intent(this, WorkGalleryActivity.class);
            startActivity(activity_work_gallery);

        } else if (id == R.id.item5) {
            Intent activity_our_partners = new Intent(this, OurPartnersActivity.class);
            startActivity(activity_our_partners);

        } else if (id == R.id.item6) {
            Intent activity_main = new Intent(this, ClientsActivity.class);
            startActivity(activity_main);

        }else if (id == R.id.item7) {
            Intent activity_testimonial = new Intent(this, TestimonialActivity.class);
            startActivity(activity_testimonial);

        }else if (id == R.id.item8) {
            Intent activity_methodology = new Intent(this, MethodologyActivity.class);
            startActivity(activity_methodology);

        }else if (id == R.id.item9) {
            Intent activity_social = new Intent(this, SocialActivity.class);
            startActivity(activity_social);

        }else if (id == R.id.item10) {
            Intent activity_faq = new Intent(this, FAQActivity.class);
            startActivity(activity_faq);

        }else if (id == R.id.item11) {
            Intent activity_ratethis_app = new Intent(this, RatethisAppActivity.class);
            startActivity(activity_ratethis_app);

        }else if (id == R.id.item12) {
            Intent activity_sign_in_sign_up = new Intent(this, SignInSignUpActivity.class);
            startActivity(activity_sign_in_sign_up);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
