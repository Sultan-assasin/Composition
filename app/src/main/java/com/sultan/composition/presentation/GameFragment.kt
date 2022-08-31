package com.sultan.composition.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sultan.composition.databinding.FragmentGameBinding
import com.sultan.composition.domain.entity.Level

private lateinit var level: Level
private var _binding: FragmentGameBinding? = null
private val binding: FragmentGameBinding
    get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")

class GameFragment : Fragment() {


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
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun parseArgs() {
        level = requireArguments().getSerializable(KEY_LEVEL) as Level
    }




    fun newInstance(level : Level) : GameFragment{
        return GameFragment().apply {
            arguments= Bundle().apply {
                putSerializable(KEY_LEVEL , level)
            }
        }
    }
    companion object{
        private const val KEY_LEVEL = "level"
    }
}