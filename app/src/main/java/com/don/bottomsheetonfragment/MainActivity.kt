package com.don.bottomsheetonfragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import com.don.bottomsheetonfragment.fragment.LeftFragment
import com.don.bottomsheetonfragment.fragment.RightFragment

class MainActivity : AppCompatActivity() {


    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tabLayout = findViewById(R.id.tabs_example)
        viewPager = findViewById(R.id.viewpager_example)

        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)


//        viewPager.setCurrentItem(0)


    }


    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(LeftFragment(), "LEFT")
        adapter.addFragment(RightFragment(), "RIGHT")
        viewPager.adapter = adapter
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList.get(position)
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence {
            return mFragmentTitleList.get(position)
        }
    }

}
