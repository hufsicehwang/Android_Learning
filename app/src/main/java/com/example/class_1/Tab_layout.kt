package com.example.class_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_tab_layout.*

class Tab_layout_viewPager : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)
        val fragment1 = test_fragment()
        val adapter = pagerAdapter(supportFragmentManager)
        adapter.list.add(fragment1)
        ViewPager1.adapter = adapter
        TabLayout1.setupWithViewPager(ViewPager1)
        TabLayout1.getTabAt(0)?.setText("First")
    }
}

class pagerAdapter(fragmentManager: FragmentManager):FragmentStatePagerAdapter(fragmentManager){
    val list : ArrayList<Fragment> = ArrayList()
    override fun getItem(position: Int): Fragment {
        return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }
    fun addItems(item : Fragment){
        list.add(item)
    }
}