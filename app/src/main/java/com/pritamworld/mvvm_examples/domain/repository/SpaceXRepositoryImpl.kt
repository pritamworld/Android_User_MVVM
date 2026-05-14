package com.pritamworld.mvvm_examples.domain.repository

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.exception.ApolloException
import com.pritamworld.mvvm_examples.LaunchesQuery
import com.pritamworld.mvvm_examples.core.common.Result
import com.pritamworld.mvvm_examples.domain.model.Launch
import javax.inject.Inject

class SpaceXRepositoryImpl @Inject constructor(
    private val apolloClient: ApolloClient
) : SpaceXRepository {

    override suspend fun getLaunches(): Result<List<Launch>> {

        return try {

            val response =
                apolloClient.query(
                    LaunchesQuery()
                ).execute()

            val launches =
                response.data?.launchesPast?.mapNotNull {

                    it?.let { launch ->

                        Launch(

                            missionName =
                                launch.mission_name ?: "",

                            launchDate =
                                launch.launch_date_local ?: "",

                            siteName =
                                launch.launch_site?.site_name_long ?: "",

                            patchImage =
                                launch.links?.mission_patch_small,

                            articleLink =
                                launch.links?.article_link,

                            videoLink =
                                launch.links?.video_link,

                            rocketName =
                                launch.rocket?.rocket_name ?: ""
                        )
                    }

                } ?: emptyList()

            Result.Success(launches)

        } catch (e: ApolloException) {

            Result.Error(
                e.message ?: "Apollo Error"
            )
        }
    }
}