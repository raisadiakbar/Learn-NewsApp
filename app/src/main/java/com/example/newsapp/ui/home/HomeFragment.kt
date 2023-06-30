package com.example.newsapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.databinding.FragmentHomeBinding
import com.example.newsapp.ui.adapter.NewsAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory: ViewModelFactory = ViewModelFactory.getInstance(requireContext())
        val viewModel: HomeViewModel by viewModels {
            factory
        }

        newsAdapter = NewsAdapter {news ->
            if (news.isBookmarked) {
                viewModel.delete(news)
            } else {
                viewModel.saveNews(news)
            }
        }

        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = newsAdapter
        }

        viewModel.getHeadlineNews().observe(viewLifecycleOwner) {result ->
            when (result) {
                is com.example.newsapp.data.Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is com.example.newsapp.data.Result.Success -> {
                    binding.progressBar.visibility = View.GONE
                    val newsData = result.data
                    newsAdapter.submitList(newsData)
                }
                is com.example.newsapp.data.Result.Error -> {
                    binding.progressBar.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}