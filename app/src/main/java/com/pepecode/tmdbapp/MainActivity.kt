package com.pepecode.tmdbapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.pepecode.tmdbapp.ui.nowPlaying.NowPlayingFragment
import com.pepecode.tmdbapp.ui.popular.PopularFragment
import com.pepecode.tmdbapp.ui.topRater.ToRaterFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    private lateinit var fragmentAdapter: MyPagerAdapter
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(tb_main)
        supportActionBar!!.title = "TMDb APP"


        fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        viewPager = findViewById(R.id.pager)
        viewPager.adapter = fragmentAdapter
        val tabLayout: TabLayout = findViewById(R.id.tab_layout)
        tabLayout.setupWithViewPager(viewPager)
        val nestedScrollView: NestedScrollView = findViewById(R.id.nested_scroll_view)
        nestedScrollView.isFillViewport = true
    }
}

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                PopularFragment()
            }
            1 -> ToRaterFragment()
            else -> {
                return NowPlayingFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Pupular"
            1 -> "Top Rater"
            else -> {
                return "Now Playing"
            }
        }
    }
}