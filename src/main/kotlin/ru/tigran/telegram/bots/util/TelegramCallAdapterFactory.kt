package ru.tigran.telegram.bots.util

import io.github.oshai.kotlinlogging.KotlinLogging
import retrofit2.*
import ru.tigran.telegram.bots.api.model.TelegramException
import java.lang.reflect.Type

private val log = KotlinLogging.logger {  }

class TelegramCallAdapterFactory : CallAdapter.Factory() {
    override fun get(type: Type, annotations: Array<out Annotation>, retrofit: Retrofit): CallAdapter<*, *> {
        return TelegramCallAdapter(retrofit.nextCallAdapter(this, type, annotations))
    }

    internal class TelegramCallAdapter<R, T>(
        private val delegateCallAdapter: CallAdapter<R, T>
    ) : CallAdapter<R, T> {

        override fun responseType() = delegateCallAdapter.responseType()

        override fun adapt(call: Call<R>) = delegateCallAdapter.adapt(TelegramCall(call))
    }

    internal class TelegramCall<T>(
        private val delegateCall: Call<T>
    ) : Call<T> {
        override fun clone() = delegateCall.clone()

        override fun execute()  = delegateCall.execute()

        override fun isExecuted()  = delegateCall.isExecuted

        override fun cancel() = delegateCall.cancel()

        override fun isCanceled() = delegateCall.isCanceled

        override fun request() = delegateCall.request()

        override fun timeout() = delegateCall.timeout()

        override fun enqueue(callback: Callback<T>) = delegateCall.enqueue(object: Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (!response.isSuccessful) {
                    callback.onFailure(call, TelegramException.of(response))
                } else {
                    callback.onResponse(call, response)
                }
            }

            override fun onFailure(call: Call<T>, exception: Throwable) {
                if (exception is HttpException) {
                    callback.onFailure(call, TelegramException.of(exception))
                } else {
                    callback.onFailure(call, exception)
                }
            }
        })
    }
}
