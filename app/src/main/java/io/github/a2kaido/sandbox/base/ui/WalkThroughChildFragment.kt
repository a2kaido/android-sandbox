package io.github.a2kaido.sandbox.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import io.github.a2kaido.sandbox.R
import kotlinx.android.synthetic.main.fragment_walk_through_child.*

private const val BUNDLE_KEY_DRAWABLE = "drawable"

class WalkThroughChildFragment : Fragment() {

    companion object {

        fun newInstance(@DrawableRes drawable: Int) = WalkThroughChildFragment().apply {
            arguments = Bundle().apply {
                putInt(BUNDLE_KEY_DRAWABLE, drawable)
            }
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_walk_through_child, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val drawableRes = requireNotNull(arguments?.getInt(BUNDLE_KEY_DRAWABLE))
        walk_through_image_view.setImageResource(drawableRes)
    }
}
