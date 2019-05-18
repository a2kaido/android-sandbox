package io.github.a2kaido.sandbox.base.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import io.github.a2kaido.sandbox.R
import io.github.a2kaido.sandbox.base.ui.adapter.WalkThroughAdapter
import kotlinx.android.synthetic.main.fragment_walk_through.*

class WalkThroughFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_walk_through, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        walk_through.adapter = WalkThroughAdapter(requireFragmentManager())
        walk_through.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                page_indicator_view.setSelected(position)
            }
        })

        start_button.setOnClickListener {
            startActivity(Intent(requireContext(), HomeActivity::class.java))
        }
    }
}
