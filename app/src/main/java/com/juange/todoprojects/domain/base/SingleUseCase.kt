package com.juange.todoprojects.domain.base

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

abstract class SingleUseCase<T> {

    private var disposable: Disposable? = null

    protected abstract fun buildUseCaseObservable(): Single<T>

    fun execute(observer: DisposableSingleObserver<T>) {
        disposable = this.buildUseCaseObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer)
    }

    fun disposeStreams() {
        if (disposable?.isDisposed == false) {
            disposable!!.dispose()
        }
    }
}
