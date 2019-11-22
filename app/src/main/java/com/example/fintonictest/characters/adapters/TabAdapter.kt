package com.example.fintonictest.characters.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.fintonictest.characters.Fragment1
import com.example.fintonictest.characters.Fragment2
import com.example.fintonictest.characters.Fragment3
import com.example.fintonictest.characters.Fragment4
import com.example.fintonictest.domain.client.model.Superhero

class TabAdapter(fm: FragmentManager, behavior: Int, val marvelData: Superhero) : FragmentStatePagerAdapter(fm, behavior) {
    private val mFragmentTitleList = arrayOf("Personal Info", "Power", "Abilities", "Groups")

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> Fragment1(marvelData)
            1 -> Fragment2(marvelData.power)
            2 -> Fragment3(marvelData.abilities)
            3 -> Fragment4(marvelData.groups)
            else -> Fragment1(marvelData)
        }
    }

    override fun getCount(): Int {
        return mFragmentTitleList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList.get(position)
    }
}