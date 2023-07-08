package com.example.userlistdemo.utils

import okhttp3.Interceptor
import okhttp3.Response

class CustomInterceptor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.run {
            proceed(
                request()
                    .newBuilder()
                    .addHeader("Darshan", "Dangar")
                    .build()
            )

        }
    }

}

