package com.example.class_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_customtab.*
import kotlinx.android.synthetic.main.activity_customtab.view.*
import kotlinx.android.synthetic.main.tabview.view.*

class customtab : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customtab)
        initView()
    }
    fun initView() {
        val fragment1 = fragment1()
        val fragment2 = fragment2()
        val fragment3 = fragment3()
        val adapter = pagerAdapter(supportFragmentManager)
        adapter.addItems(fragment1)    // adapter는 지원
        adapter.addItems(fragment2)
        adapter.addItems(fragment3)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        tabLayout.getTabAt(0)?.setCustomView(createView("마이페이지"))
        tabLayout.getTabAt(1)?.setCustomView(createView("게시판"))
        tabLayout.getTabAt(2)?.setCustomView(createView("환경설정"))
    }

    // 프레그 먼트를 결합합
   class pagerAdapter(fragmentmanager : FragmentManager): FragmentStatePagerAdapter(fragmentmanager) {
        private val fragments : ArrayList<Fragment> = ArrayList()
        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }
        fun addItems(item: Fragment){
            fragments.add(item)
        }
    }

    fun createView(tabName:String): View {    // 매개
        val tabView  = LayoutInflater.from(this).inflate(R.layout.tabview,null)
        tabView.tab_text.text = tabName
        when(tabName) {
            "마이페이지" -> {
                tabView.tab_image.setImageResource(R.drawable.ic_baseline_accessibility_new_24)
            }
            "게시판" -> {
                tabView.tab_image.setImageResource(R.drawable.ic_baseline_assignment_24)
            }
            else -> {
                return tabView
            }
        }
        return tabView
    }

}