package io.github.a2kaido.sandbox.base.ui

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import io.github.a2kaido.sandbox.R
import io.github.a2kaido.sandbox.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        card_view.viewTreeObserver.addOnGlobalLayoutListener {
            card_view.pivotX = card_view.width.toFloat() / 2
            card_view.pivotY = card_view.height.toFloat() + 60
        }

        card_view.setOnTouchListener(TouchListener())

        viewModel.next()

        viewModel.profile.observe(this, Observer {
            it?.let { profile ->
                println(profile.name)
            }
        })
    }

    inner class TouchListener : View.OnTouchListener {
        private var x: Float = 0.0f

        override fun onTouch(v: View?, event: MotionEvent?): Boolean {
            v?.performClick()

            when (event?.action) {
                MotionEvent.ACTION_DOWN -> {
                    x = event.rawX
                    return true
                }
                MotionEvent.ACTION_MOVE -> {
                    card_view.rotation += (event.rawX - x) / 10
                    x = event.rawX
                    return true
                }
                MotionEvent.ACTION_UP -> {
                    if (card_view.rotation < -30 || 30 < card_view.rotation) {
                        val anim = if (card_view.rotation < -30) {
                            AnimationUtils.loadAnimation(requireContext(), R.anim.fade_left)
                        } else {
                            AnimationUtils.loadAnimation(requireContext(), R.anim.fade_right)
                        }
                        anim.setAnimationListener(object : Animation.AnimationListener {
                            override fun onAnimationRepeat(animation: Animation?) {
                            }

                            override fun onAnimationEnd(animation: Animation?) {
                                card_view.cardElevation = 8f
                                card_view.rotation = 0f
                                card_view.alpha = 1.0f
                                val anim2 = ValueAnimator.ofFloat(8f, 32f).apply {
                                    duration = 100
                                }
                                anim2.addUpdateListener {
                                    card_view.cardElevation = it.animatedValue as Float
                                    card_view.alpha = 1.0f
                                }
                                anim2.start()
                            }

                            override fun onAnimationStart(animation: Animation?) {
                            }
                        })
                        card_view.startAnimation(anim)
                    } else {
                        val anim = ValueAnimator.ofFloat(card_view.rotation, 0f).apply {
                            duration = 100
                            interpolator = DecelerateInterpolator()
                        }
                        anim.addUpdateListener {
                            card_view.rotation = (it.animatedValue as Float)
                        }
                        anim.start()
                    }
                    return true
                }
            }

            return false
        }
    }
}
