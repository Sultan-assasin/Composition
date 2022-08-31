package com.sultan.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sultan.composition.databinding.FragmentGameBinding
import com.sultan.composition.databinding.FragmentGameFinishedBinding
import java.lang.RuntimeException

private var _binding: FragmentGameBinding? = null
private val binding: FragmentGameBinding
    get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")

class GameFragment : Fragment() {

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
}