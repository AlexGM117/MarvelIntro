package com.example.fintonictest.characters


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentStatePagerAdapter
import com.bumptech.glide.Glide
import com.example.fintonictest.R
import com.example.fintonictest.characters.adapters.TabAdapter
import com.example.fintonictest.domain.client.model.Superhero
import kotlinx.android.synthetic.main.fragment_character_info.*

/**
 * A simple [Fragment] subclass.
 */
class CharacterInfoFragment(var data: Superhero) : Fragment() {

    private lateinit var adapter: TabAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide
            .with(this)
            .load(data.photo)
            .into(imageView)

        adapter = TabAdapter(
            fragmentManager!!,
            FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
            data
        )
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
