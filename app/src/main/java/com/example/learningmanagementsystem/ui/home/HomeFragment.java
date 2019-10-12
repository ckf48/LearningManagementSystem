package com.example.learningmanagementsystem.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.learningmanagementsystem.R;
import com.example.learningmanagementsystem.ui.home.Fragments.CoursesFragment;
import com.example.learningmanagementsystem.ui.home.Fragments.MessageFragment;
import com.example.learningmanagementsystem.ui.home.Fragments.NewsFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        init(root);
        return root;
    }

    private void init(View root){
        tabLayout = root.findViewById(R.id.home_tab_layout);
        viewPager = root.findViewById(R.id.home_view_pager);

        fragments.add(new CoursesFragment());
        fragments.add(new NewsFragment());
        fragments.add(new MessageFragment());

        Adpter adpter = new Adpter(getChildFragmentManager());
        viewPager.setAdapter(adpter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adpter);

        viewPager.setCurrentItem(2);



    }

    private class Adpter extends FragmentPagerAdapter {
        private String [] title = {"COURSES","NEWS","MESSAGE"};
        public Adpter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }

}





