package com.sultan.composition.presentation

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sultan.composition.R
import com.sultan.composition.databinding.FragmentGameBinding
import com.sultan.composition.domain.entity.GameResult
import com.sultan.composition.domain.entity.GameSettings
import com.sultan.composition.domain.entity.Level


class GameFragment : Fragment() {

    private lateinit var level: Level

    private var timer: CountDownTimer? = null


    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseArgs()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvOption1.setOnClickListener {
            launchGameFinishedFragment(
                GameResult(
                    true,
                    0,
                    0,
                    GameSettings(0, 0, 0, 0)
                )
            )
        }
        binding.tvOption2.setOnClickListener{
            startCountDownTimer(20000)
        }

    }
private fun startCountDownTimer(timeMills: Long){
    timer?.cancel()
    timer = object : CountDownTimer(timeMills , 1){
        override fun onTick(timeM: Long) {
            binding.tvTimer.text =  timeM.toString()
        }

        override fun onFinish() {
            binding.tvTimer.text = R.string.game_over.toString()
        }

    }.start()
}



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun parseArgs() {
        requireArguments().getParcelable<Level>(KEY_LEVEL)?.let {
            level = it
        }
    }

    private fun launchGameFinishedFragment(gameResult: GameResult) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, GameFinishedFragment.newInstance(gameResult))
            .addToBackStack(null)
            .commit()
    }

    companion object {

        const val NAME = "GameFragment"
        private const val KEY_LEVEL = "level"

        fun newInstance(level: Level): GameFragment {
            return GameFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_LEVEL, level)
                }
            }
        }
    }
}