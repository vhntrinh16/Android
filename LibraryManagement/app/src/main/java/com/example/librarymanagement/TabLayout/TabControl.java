package com.example.librarymanagement.TabLayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.librarymanagement.Fragment.BooksFragment;
import com.example.librarymanagement.Fragment.VotesFragment;
import com.example.librarymanagement.PaperStateAdapter;
import com.example.librarymanagement.R;

public class TabControl extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_control);

        Init();
        tabLayout.setupWithViewPager(viewPager);
        PaperStateAdapter adapter = new PaperStateAdapter(getSupportFragmentManager());
        adapter.addFragment(new BooksFragment(), "Sách");
        adapter.addFragment(new VotesFragment(), "Phiếu mượn");
        viewPager.setAdapter(adapter);
    }

    void Init(){
        tabLayout = findViewById(R.id.demo_mTabLayout);
        viewPager = findViewById(R.id.demo_mViewPaper);
    }
}
