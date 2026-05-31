package com.pritamworld.mvvm_examples.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.pritamworld.mvvm_examples.ui.viewmodels.PostViewModel
import com.pritamworld.mvvm_examples.core.common.Result
import com.pritamworld.mvvm_examples.domain.model.Post

@Composable
fun PostScreen(
    viewModel: PostViewModel = hiltViewModel()
) {

    val state by viewModel.posts.collectAsState()

    when (state) {

        is Result.Loading -> {
            CircularProgressIndicator()
        }

        is Result.Error -> {

            Text(
                text = (state as Result.Error).message
            )
        }

        is Result.Success -> {

            val posts =
                (state as Result.Success<List<Post>>).data

            LazyColumn {

                items(posts) { post ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text = post.title,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                text = post.body
                            )
                        }
                    }
                }
            }
        }
    }
}